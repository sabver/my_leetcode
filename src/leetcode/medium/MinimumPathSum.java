package leetcode.medium;

public class MinimumPathSum {
	/**
	 * 动态规划实现
	 * 
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		if (row == 0) {
			return 0;
		}
		int col = grid[0].length;
		if (col == 0) {
			return 0;
		}
		int[][] records = new int[row][col];
		records[0][0] = grid[0][0];
		// 优化，减少判断
		for (int i = 1; i < row; i++) {
			records[i][0] = grid[i][0] + records[i - 1][0];
		}
		for (int j = 1; j < col; j++) {
			records[0][j] = grid[0][j] + records[0][j - 1];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				int item = grid[i][j];
				records[i][j] = Math.min(records[i - 1][j], records[i][j - 1]) + item;
			}
		}
		return records[row - 1][col - 1];
	}

	public int minPathSum2(int[][] grid) {
		int row = grid.length;
		if (row == 0) {
			return 0;
		}
		int col = grid[0].length;
		if (col == 0) {
			return 0;
		}
		int[][] records = new int[row][col];
		records[0][0] = grid[0][0];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				int item = grid[i][j];
				if (i == 0) {
					records[i][j] = item + records[i][j - 1];
				} else if (j == 0) {
					records[i][j] = item + records[i - 1][j];
				} else {
					records[i][j] = Math.min(records[i - 1][j] + item, records[i][j - 1] + item);
				}
			}
		}
		return records[row - 1][col - 1];
	}

	public static void main(String[] args) {
		MinimumPathSum s = new MinimumPathSum();
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(s.minPathSum(grid));
	}
}
