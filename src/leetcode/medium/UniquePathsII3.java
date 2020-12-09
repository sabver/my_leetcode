package leetcode.medium;

public class UniquePathsII3 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		if (row == 0) {
			return 0;
		}
		int col = obstacleGrid[0].length;
		if (col == 0) {
			return 0;
		}
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		if (obstacleGrid[row - 1][col - 1] == 1) {
			return 0;
		}
		// 采用优化版动态规划，由底至顶！
		int[][] records = new int[row][col];
		records[0][0] = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (obstacleGrid[i][j] == 1) {
					records[i][j] = 0;
				} else {
					if (i == 0) {
						records[i][j] = records[i][j - 1];
					} else if (j == 0) {
						records[i][j] = records[i - 1][j];
					} else {
						records[i][j] = records[i][j - 1] + records[i - 1][j];
					}
				}
			}
		}
		return records[row - 1][col - 1];
	}

	public static void main(String[] args) {
		UniquePathsII3 s = new UniquePathsII3();
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
	}
}
