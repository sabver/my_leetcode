package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
	private int totalRow;
	private int totalCol;

	public boolean exist(char[][] board, String word) {
		totalRow = board.length;
		if (totalRow == 0) {
			return false;
		}
		totalCol = board[0].length;
		if (totalCol == 0) {
			return false;
		}
		char[] words = word.toCharArray();
		if (words.length == 0) {
			return false;
		}
		if (words.length > totalRow * totalCol) {
			return false;
		}
		boolean isFindOne = words.length == 1;
		Set<String> set = null;
		if (isFindOne) {
			for (int i = 0; i < totalRow; i++) {
				for (int j = 0; j < totalCol; j++) {
					if (board[i][j] == words[0]) {
						return true;
					}
				}
			}
		} else {
			// find sources
			for (int i = 0; i < totalRow; i++) {
				for (int j = 0; j < totalCol; j++) {
					if (board[i][j] == words[0]) {
						set = new HashSet<String>();
						set.add(i + "," + j);
						if (exist(board, words, 1, i, j, set)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param board
	 * @param words
	 * @param top
	 *            当前检测的words的位置
	 * @param rowIndex
	 *            起点的rowIndex
	 * @param colIndex
	 *            起点的colIndex
	 * @param set
	 *            将所有已经检测过的元素收入set里面，防止访问重复的路径
	 * @return
	 */
	public boolean exist(char[][] board, char[] words, int top, int rowIndex, int colIndex, Set<String> set) {
//		System.out.println("top:" + top + " rowIndex:" + rowIndex + " colIndex:" + colIndex);
//		System.out.println(set);
		if (top == words.length) {
			return true;
		}
		boolean result = false;
		// up
		if (rowIndex != 0) {
			result = judge(board, words, top, rowIndex - 1, colIndex, set);
			if (result) {
				return true;
			}
		}
		// right
		if (colIndex != totalCol - 1) {
			result = judge(board, words, top, rowIndex, colIndex + 1, set);
			if (result) {
				return true;
			}
		}
		// down
		if (rowIndex != totalRow - 1) {
			result = judge(board, words, top, rowIndex + 1, colIndex, set);
			if (result) {
				return true;
			}
		}
		// left
		if (colIndex != 0) {
			result = judge(board, words, top, rowIndex, colIndex - 1, set);
			if (result) {
				return true;
			}
		}
//		System.out.println("end");
//		System.out.println(set);
		return false;
	}

	public boolean judge(char[][] board, char[] words, int top, int rowIndex, int colIndex, Set<String> set) {
		if (words[top] == board[rowIndex][colIndex] && set.contains(rowIndex + "," + colIndex) == false) {
			set.add(rowIndex + "," + colIndex);
//			System.out.println("judge:" + set);
			boolean result = exist(board, words, top + 1, rowIndex, colIndex, set);
			if (result == false) {
				set.remove(rowIndex + "," + colIndex);
			}
			return result;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		WordSearch s = new WordSearch();
		char[][] board = { { 'A', 'B', 'C' }, { 'B', 'F', 'F' }, { 'C', 'D', 'R' } };
		String word = "ABCD";
		System.out.println(s.exist(board, word));
	}
}
