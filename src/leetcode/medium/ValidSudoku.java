package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	class Index {
		int i;
		int j;

		Index(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i <= 8; i++) {
			if (isValidRow(board, i) == false) {
//				System.out.println("isValidRow:"+i);
				return false;
			}
			if (isValidColumn(board, i) == false) {
//				System.out.println("isValidColumn:"+i);
				return false;
			}
			if (isValidbox(board, i) == false) {
//				System.out.println("isValidbox:"+i);
				return false;
			}
		}
		return true;
	}

	/**
	 * row 范围是0-8
	 * 
	 * @param board
	 * @param row
	 * @return
	 */
	public boolean isValidRow(char[][] board, int row) {
		Set<Character> set = new HashSet<Character>(9);
		for (int i = 0; i <= 8; i++) {
			if (set.contains(board[row][i])) {
				return false;
			} else {
				if( board[row][i]!='.' ){
					set.add(board[row][i]);
				}
			}
		}
		set.clear();
		return true;
	}

	/**
	 * column 范围是0-8
	 * 
	 * @param board
	 * @param column
	 * @return
	 */
	public boolean isValidColumn(char[][] board, int column) {
		Set<Character> set = new HashSet<Character>(9);
		for (int i = 0; i <= 8; i++) {
			if (set.contains(board[i][column])) {
				return false;
			} else {
				if( board[i][column]!='.' ){
					set.add(board[i][column]);
				}
			}
		}
		set.clear();
		return true;
	}

	/**
	 * boxNum 范围是0-8
	 * 
	 * @param board
	 * @param boxNum
	 * @return
	 */
	public boolean isValidbox(char[][] board, int boxNum) {
		Index[] indexs = getBoxIndexs(boxNum);
		Set<Character> set = new HashSet<Character>(9);
		for (int i = 0; i < indexs.length; i++) {
			if (set.contains(board[indexs[i].i][indexs[i].j])) {
				return false;
			} else {
				if( board[indexs[i].i][indexs[i].j]!='.' ){
					set.add(board[indexs[i].i][indexs[i].j]);
				}
			}
		}
		return true;
	}

	public Index[] getBoxIndexs(int boxNum) {
		Index[] result = new Index[9];
		int beginRow = (boxNum / 3) * 3, beginColumn = (boxNum % 3 * 3);
		result[0] = new Index(beginRow, beginColumn);
		result[1] = new Index(beginRow, beginColumn + 1);
		result[2] = new Index(beginRow, beginColumn + 2);
		result[3] = new Index(beginRow + 1, beginColumn);
		result[4] = new Index(beginRow + 1, beginColumn + 1);
		result[5] = new Index(beginRow + 1, beginColumn + 2);
		result[6] = new Index(beginRow + 2, beginColumn);
		result[7] = new Index(beginRow + 2, beginColumn + 1);
		result[8] = new Index(beginRow + 2, beginColumn + 2);
		return result;
	}

	public static void main(String[] args) {
		ValidSudoku s = new ValidSudoku();
		char[][] board = ValidSudokuData.board3;
		System.out.println(s.isValidSudoku(board));
	}
}
