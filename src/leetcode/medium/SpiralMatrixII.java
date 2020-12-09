package leetcode.medium;


public class SpiralMatrixII {
	private int count = 1;
	private int n;

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		this.n = n;
		// 循环次数
		int circulCount = n / 2;
		for (int i = 1; i <= circulCount; i++) {
			up(matrix, i);
			right(matrix, n - i + 1);
			down(matrix, n - i + 1);
			left(matrix, i);
		}
		if (n % 2 != 0) {
			up(matrix, circulCount + 1);
		}
		return matrix;
	}

	public void up(int[][] matrix, int row) {
		int beginCol = row;
		int endCol = n - row + 1;
		for (int i = beginCol; i <= endCol; i++) {
			matrix[row - 1][i - 1] = count++;
		}
	}

	public void right(int[][] matrix, int col) {
		int beginRow = n - col + 2;
		int endRow = n - (n - col) - 1;
		for (int i = beginRow; i <= endRow; i++) {
			matrix[i - 1][col - 1] = count++;
		}
	}

	public void down(int[][] matrix, int row) {
		int beginCol = n - (n - row);
		int endCol = n - row + 1;
		for (int i = beginCol; i >= endCol; i--) {
			matrix[row - 1][i - 1] = count++;
		}
	}

	public void left(int[][] matrix, int col) {
		int beginRow = n - col;
		int endRow = col + 1;
		for (int i = beginRow; i >= endRow; i--) {
			matrix[i - 1][col - 1] = count++;
		}
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
	public static void main(String[] args) {
		SpiralMatrixII s = new SpiralMatrixII();
		s.printMatrix(s.generateMatrix(1));
	}
}
