package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里的row和col都是从1开始的，方便数学计算
 * 
 * @author yejianfeng
 *
 */
public class SpiralMatrix {
	private int totalRow;
	private int totalCol;

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		totalRow = matrix.length;
		if (totalRow == 0) {
			return result;
		}
		totalCol = matrix[0].length;
		// 循环次数
		int count = Math.min(totalCol, totalRow) / 2;
		for (int i = 1; i <= count; i++) {
			result.addAll(up(matrix, i));
			result.addAll(right(matrix, totalCol - i + 1));
			result.addAll(down(matrix, totalRow - i + 1));
			result.addAll(left(matrix, i));
		}
		if (totalCol >= totalRow && totalRow % 2 != 0) {
			// 最后补上一个up
			result.addAll(up(matrix, count + 1));
		} else if (totalCol < totalRow && totalCol % 2 != 0) {
			// 最后补上一个up right down
			result.addAll(up(matrix, count + 1));
			result.addAll(right(matrix, totalCol - (count + 1) + 1));
			result.addAll(down(matrix, totalRow - (count + 1) + 1));
		}
		return result;
	}

	public List<Integer> up(int[][] matrix, int row) {
		List<Integer> result = new ArrayList<Integer>();
		int beginCol = row;
		int endCol = totalCol - row + 1;
		for (int i = beginCol; i <= endCol; i++) {
			result.add(matrix[row - 1][i - 1]);
		}
		return result;
	}

	public List<Integer> right(int[][] matrix, int col) {
		List<Integer> result = new ArrayList<Integer>();
		int beginRow = totalCol - col + 2;
		int endRow = totalRow - (totalCol - col) - 1;
		for (int i = beginRow; i <= endRow; i++) {
			result.add(matrix[i - 1][col - 1]);
		}
		return result;
	}

	public List<Integer> down(int[][] matrix, int row) {
		List<Integer> result = new ArrayList<Integer>();
		int beginCol = totalCol - (totalRow - row);
		int endCol = totalRow - row + 1;
		for (int i = beginCol; i >= endCol; i--) {
			result.add(matrix[row - 1][i - 1]);
		}
		return result;
	}

	public List<Integer> left(int[][] matrix, int col) {
		List<Integer> result = new ArrayList<Integer>();
		int beginRow = totalRow - col;
		int endRow = col + 1;
		for (int i = beginRow; i >= endRow; i--) {
			result.add(matrix[i - 1][col - 1]);
		}
		return result;
	}

	public int[][] getMatrix(int row, int col) {
		int[][] matrix = new int[row][col];
		int count = 10;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = count;
				count++;
			}
		}
		return matrix;
	}

	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			String str = "[";
			for (int j = 0; j < matrix[i].length; j++) {
				if (j != matrix[i].length - 1) {
					str += (matrix[i][j] + ",");
				} else {
					str += matrix[i][j];
				}
			}
			System.out.println(str + "]");
		}
	}

	public List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		totalRow = matrix.length;
		totalCol = matrix[0].length;
		// 循环次数
		int count = 0;
		if (totalCol >= totalRow) {
			count = totalRow / 2;
			for (int i = 1; i <= count; i++) {
				result.addAll(up(matrix, i));
				result.addAll(right(matrix, totalCol - i + 1));
				result.addAll(down(matrix, totalRow - i + 1));
				result.addAll(left(matrix, i));
			}
			if (totalRow % 2 != 0) {
				// 最后补上一个up
				result.addAll(up(matrix, count + 1));
			}
		} else {
			count = totalCol / 2;
			for (int i = 1; i <= count; i++) {
				result.addAll(up(matrix, i));
				result.addAll(right(matrix, totalCol - i + 1));
				result.addAll(down(matrix, totalRow - i + 1));
				result.addAll(left(matrix, i));
			}
			if (totalCol % 2 != 0) {
				// 最后补上一个up right down
				result.addAll(up(matrix, count + 1));
				result.addAll(right(matrix, totalCol - (count + 1) + 1));
				result.addAll(down(matrix, totalRow - (count + 1) + 1));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralMatrix s = new SpiralMatrix();
		// int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, };
		// int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }
		// };
		int[][] matrix = s.getMatrix(2, 3);
		s.printMatrix(matrix);
		System.out.println(s.spiralOrder(matrix));
		// s.printMatrix(s.getMatrix(10, 3));
	}
}
