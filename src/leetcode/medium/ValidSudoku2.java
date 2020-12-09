package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidSudoku2 {
	class Index {
		int i;
		int j;

		Index(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public boolean isValidSudoku(char[][] board) {
		HashMap<Character, List<Index>> map = new HashMap<Character, List<Index>>(81);
		List<Index> list = null;
		int curBoxIndex = 0;
		for (int i = 0; i <= 8; i++) {
			for (int j = 0; j <= 8; j++) {
				if (map.containsKey(board[i][j])) {
					list = map.get(board[i][j]);
					curBoxIndex = getBoxIndex(i, j);
					for (int k = list.size() - 1; k >= 0; k--) {
						// 判断同一个格子是否相同,横竖是否有相同
						if (curBoxIndex == getBoxIndex(list.get(k).i, list.get(k).j) || list.get(k).i == i
								|| list.get(k).j == j) {
							return false;
						}
					}
					map.get(board[i][j]).add(new Index(i, j));
				} else if (board[i][j] != '.') {
					map.put(board[i][j], new ArrayList<Index>());
					map.get(board[i][j]).add(new Index(i, j));
				}
			}
		}
		return true;
	}

	/**
	 * 通过i和j获取当前所在的box号码
	 * 
	 * @param i
	 * @param j
	 * @return box number range in [0..8]
	 */
	public int getBoxIndex(int i, int j) {
		int row = i / 3, column = j / 3;
		return row * 3 + column;
	}

	public static void main(String[] args) {
		ValidSudoku2 s = new ValidSudoku2();
		char[][] board = ValidSudokuData.board2;
		System.out.println(s.isValidSudoku(board));
	}
}
