package leetcode.medium;

public class WordSearch2 {
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
		if (isFindOne) {
			for (int i = 0; i < totalRow; i++) {
				for (int j = 0; j < totalCol; j++) {
					if (board[i][j] == words[0]) {
						return true;
					}
				}
			}
		} else {
			boolean[][] records = new boolean[totalRow][totalCol];
			// find sources
			for (int i = 0; i < totalRow; i++) {
				for (int j = 0; j < totalCol; j++) {
					if (board[i][j] == words[0]) {
						records[i][j] = true;
						if (exist(board, words, 1, i, j, records)) {
							return true;
						}
						records[i][j] = false;
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
	 * @param records
	 *            防止访问重复的路径
	 * @return
	 */
	public boolean exist(char[][] board, char[] words, int top, int rowIndex, int colIndex, boolean[][] records) {
		if (top == words.length) {
			return true;
		}
		// up
		if (rowIndex != 0) {
			if (judge(board, words, top, rowIndex - 1, colIndex, records)) {
				return true;
			}
		}
		// right
		if (colIndex != totalCol - 1) {
			if (judge(board, words, top, rowIndex, colIndex + 1, records)) {
				return true;
			}
		}
		// down
		if (rowIndex != totalRow - 1) {
			if (judge(board, words, top, rowIndex + 1, colIndex, records)) {
				return true;
			}
		}
		// left
		if (colIndex != 0) {
			if (judge(board, words, top, rowIndex, colIndex - 1, records)) {
				return true;
			}
		}
		return false;
	}

	public boolean judge(char[][] board, char[] words, int top, int rowIndex, int colIndex, boolean[][] records) {
		if (words[top] == board[rowIndex][colIndex] && records[rowIndex][colIndex] == false) {
			records[rowIndex][colIndex] = true;
			boolean result = exist(board, words, top + 1, rowIndex, colIndex, records);
			records[rowIndex][colIndex] = result;
			return result;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		WordSearch2 s = new WordSearch2();
		char[][] board = { { 'A', 'B', 'C' }, { 'B', 'F', 'F' }, { 'C', 'D', 'R' } };
		String word = "ABCD";
		System.out.println(s.exist(board, word));
	}
}
