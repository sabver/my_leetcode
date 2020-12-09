package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
	class Data {
		int rowIndex;
		int colIndex;

		Data(int rowIndex, int colIndex) {
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
		}
	}

	int totalRow;
	int totalCol;

	public void setZeroes(int[][] matrix) {
//		print(matrix);
		totalRow = matrix.length;
		totalCol = matrix[0].length;
		List<Data> list = new ArrayList<Data>();
		for (int i = 0; i < totalRow; i++) {
			for (int j = 0; j < totalCol; j++) {
				if (matrix[i][j] == 0) {
					list.add(new Data(i, j));
				}
			}
		}
		int len = list.size();
		Data cur = null;
		for (int i = 0; i < len; i++) {
			cur = list.get(i);
			setZeroes(matrix, cur.rowIndex, cur.colIndex);
		}
//		System.out.println();
//		print(matrix);
	}

	public void setZeroes(int[][] matrix, int rowIndex, int colIndex) {
		for (int i = 0; i < totalCol; i++) {
			matrix[rowIndex][i] = 0;
		}
		for (int i = 0; i < totalRow; i++) {
			matrix[i][colIndex] = 0;
		}
	}

	public void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			String str = "";
			for (int j = 0; j < matrix[i].length; j++) {
				str += (matrix[i][j] + " ");
			}
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		SetMatrixZeroes s = new SetMatrixZeroes();
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		s.setZeroes(matrix);
	}
}
