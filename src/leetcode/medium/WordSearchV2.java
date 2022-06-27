package leetcode.medium;

public class WordSearchV2 {
	boolean[][] used;
	boolean res;
	int m, n;

	public boolean exist(char[][] board, String word) {
		int m = board.length, n = board[0].length;
		this.m = m;
		this.n = n;
		used = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				backtrack(board, word, 0, i, j);
			}
		}
		return res;
	}

	public void backtrack(char[][] board, String word, int wordStart, int mStart, int nStart) {
		if (wordStart == word.length()) {
			res = true;
			return;
		}
		if (mStart < 0 || mStart == m || nStart < 0 || nStart == n) {
			return;
		}
		char c = word.charAt(wordStart);
		if (used[mStart][nStart]) {
			return;
		}
		if (c == board[mStart][nStart]) {
			used[mStart][nStart] = true;
			// 上
			backtrack(board, word, wordStart + 1, mStart - 1, nStart);
			// 下
			backtrack(board, word, wordStart + 1, mStart + 1, nStart);
			// 左
			backtrack(board, word, wordStart + 1, mStart, nStart - 1);
			// 右
			backtrack(board, word, wordStart + 1, mStart, nStart + 1);
			used[mStart][nStart] = false;
		}
	}

	public static void main(String[] args) {
		WordSearchV2 w = new WordSearchV2();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "SEE";
		boolean res = w.exist(board, word);
		System.out.println(res);
	}

}
