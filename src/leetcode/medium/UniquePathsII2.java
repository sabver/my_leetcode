package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class UniquePathsII2 {
	class Point {
		public int row;
		public int col;

		Point() {

		}

		Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private int totalRow;
	private int totalCol;

	/**
	 * 将问题转化为排列组合问题，right的次数为m-1,down的次数为n-1，求两者可以组成的唯一排列的数量
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		m--;
		n--;
		// 求 (m+n)!/(m!n!)
		// 即((m+n)...m+1)/n!
		if (m >= n) {
			return cal(m, n);
		} else {
			return cal(n, m);
		}
	}

	/**
	 * 求((m+n)...m+1)/n! 这里为了减少循环次数，要求n<m
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int cal(int m, int n) {
		long result = 1;
		for (int i = m + 1; i <= m + n; i++) {
			result *= i;
		}
		Long answer = result / factorial(n);
		return answer.intValue();
	}

	/**
	 * 求n的阶乘F 用long防越界
	 * 
	 * @param n
	 * @return
	 */
	public long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0) {
			return 0;
		}
		totalRow = obstacleGrid.length;
		totalCol = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[totalRow - 1][totalCol - 1] == 1) {
			return 0;
		}
		int lossPath = 0;
		List<Point> obstacleList = new ArrayList<Point>();
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[i].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					lossPath += (uniquePaths(i + 1, j + 1) * uniquePaths(totalRow - i, totalCol - j));
					obstacleList.add(new Point(i + 1, j + 1));
				}
			}
		}
		for (int i = 0; i < obstacleList.size(); i++) {
			for (int j = 0; j < obstacleList.size(); j++) {
				if (i != j) {
					lossPath -= calSharePath(obstacleList.get(i), obstacleList.get(j));
				}
			}
		}
		return uniquePaths(totalRow, totalCol) - lossPath;
	}

	public int calSharePath(Point point1, Point point2) {
		if ((point1.col > point2.col && point1.row > point2.row)
				|| point1.col < point2.col && point1.row < point2.row) {
			return uniquePaths(point1.row, point1.col)
					* uniquePaths(point2.row - point1.row + 1, point2.col - point1.col + 1);
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		UniquePathsII2 s = new UniquePathsII2();
		int[][] obstacleGrid = { { 0, 0 }, { 1, 1 }, { 0, 0 } };
		System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
	}
}
