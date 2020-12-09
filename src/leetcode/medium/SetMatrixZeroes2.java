package leetcode.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMatrixZeroes2 {

	int totalRow;
	int totalCol;

	public void setZeroes(int[][] matrix) {
//		print(matrix);
		totalRow = matrix.length;
		totalCol = matrix[0].length;
		Set<Integer> rowSet = new HashSet<Integer>();
		Set<Integer> colSet = new HashSet<Integer>();
		for (int i = 0; i < totalRow; i++) {
			for (int j = 0; j < totalCol; j++) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
			}
		}
		Iterator<Integer> rowIt = rowSet.iterator();
		while(rowIt.hasNext()){
			setZeroesRow(matrix,rowIt.next());
		}
		Iterator<Integer> colIt = colSet.iterator();
		while( colIt.hasNext() ){
			setZeroesCol(matrix,colIt.next());
		}
//		System.out.println();
//		print(matrix);
	}

	public void setZeroesRow(int[][] matrix, int rowIndex) {
		for (int i = 0; i < totalCol; i++) {
			matrix[rowIndex][i] = 0;
		}
	}
	
	public void setZeroesCol(int[][] matrix, int colIndex) {
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
		SetMatrixZeroes2 s = new SetMatrixZeroes2();
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		s.setZeroes(matrix);
	}
}
