package leetcode.medium;

public class RotateImage {
//	class Index {
//		// 行
//		int row;
//		// 列
//		int col;
//
//		Index(int row, int col) {
//			this.row = row;
//			this.col = col;
//		}
//
//	}

	public void rotate(int[][] matrix) {
		int len = matrix.length;
		int end = len / 2;
		for (int i = 1; i <= end; i++) {
			for (int j = 1; j <= end; j++) {
				rotateIndex(matrix, i, j, 0, 0);
			}
		}
		// 如果是奇数，需要再旋转水平轴
		if (len % 2 != 0) {
			for (int i = 1; i <= end; i++) {
				rotateIndex(matrix, end + 1, i, 0, 0);
			}
		}
	}

	public void rotateIndex(int[][] matrix, int row, int col, int count, int lostValue) {
		if (count == 4) {
			return;
		}
		int len = matrix.length;
		int rotateRow = col;
		int rotateCol = len - row + 1;
		int temp = lostValue;
		// 保留会遗失的值
		lostValue = matrix[rotateRow - 1][rotateCol - 1];
		// 赋值，第一次循环时没有值遗失
		if (count == 0) {
			matrix[rotateRow - 1][rotateCol - 1] = matrix[row - 1][col - 1];
		} else {
			matrix[rotateRow - 1][rotateCol - 1] = temp;
		}
		rotateIndex(matrix, rotateRow, rotateCol, count + 1, lostValue);
	}

//	public void rotateIndex(int[][] matrix, Index index, int count, int lostValue) {
//		// System.out.println("lostValue:" + lostValue);
//		if (count == 4) {
//			return;
//		}
//		int len = matrix.length;
//		int rotateRow = index.col;
//		int rotateCol = len - index.row + 1;
//		// System.out.println(rotateRow + " " + rotateCol);
//		int temp = lostValue;
//		// 保留会遗失的值
//		lostValue = matrix[rotateRow - 1][rotateCol - 1];
//		// 赋值，第一次循环时没有值遗失
//		if (count == 0) {
//			matrix[rotateRow - 1][rotateCol - 1] = matrix[index.row - 1][index.col - 1];
//		} else {
//			matrix[rotateRow - 1][rotateCol - 1] = temp;
//		}
//		index.row = rotateRow;
//		index.col = rotateCol;
//		rotateIndex(matrix, index, count + 1, lostValue);
//	}

//	public Index getNextRoateIndex(int row, int col, int matrixLength) {
//		return new Index(col, matrixLength - row + 1);
//	}

	public void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			String str = "";
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10) {
					str += (" " + matrix[i][j] + " ");
				} else {
					str += (matrix[i][j] + " ");
				}
			}
			System.out.println(str);
		}
	}

	public void test(int[][] matrix) {
		int row = 1;
		int col = 2;
		// rotateIndex(matrix, new Index(row, col), 0, 0);
		rotateIndex(matrix, row, col, 0, 0);
	}

	public static void main(String[] args) {
		RotateImage s = new RotateImage();
		// int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12,
		// 13, 14, 15 }, { 16, 17, 18, 19, 20 },
		// { 21, 22, 23, 24, 25 } };
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		s.rotate(matrix);
		// s.test(matrix);
		s.print(matrix);
	}
}
