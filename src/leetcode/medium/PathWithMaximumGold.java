package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class PathWithMaximumGold {
	int m, n, max = 0;
//	List<List<Integer>> res = new ArrayList<>();
//	boolean[][] used;

	public int getMaximumGold(int[][] grid) {
		m = grid.length;
		if (m == 0) {
			return 0;
		}
		n = grid[0].length;
//		used = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0) {
//					LinkedList<Integer> track = new LinkedList<>();
					dfs(grid, i, j, 0);
				}
			}
		}
		return max;
	}

	public void dfs(int[][] grid, int startM, int startN, int sum) {
		if (startM < 0 || startM > m - 1 || startN < 0 || startN > n - 1 || grid[startM][startN] == 0) {
			max = Math.max(max, sum);
			return;
		}
//		used[startM][startN] = true;
		int value = grid[startM][startN];
		sum += value;
		grid[startM][startN] = 0;
//		track.add(grid[startM][startN]);
		dfs(grid, startM - 1, startN, sum);
		dfs(grid, startM + 1, startN, sum);
		dfs(grid, startM, startN - 1, sum);
		dfs(grid, startM, startN + 1, sum);
		grid[startM][startN] = value;
//		used[startM][startN] = false;
//		track.removeLast();
		sum -= grid[startM][startN];
	}

	public static void main(String[] args) {
		PathWithMaximumGold p = new PathWithMaximumGold();
		int[][] grid = { { 1, 0, 7, 0, 0, 0 }, { 2, 0, 6, 0, 1, 0 }, { 3, 5, 6, 7, 4, 2 }, { 4, 3, 1, 0, 2, 0 },
				{ 3, 0, 5, 0, 20, 0 } };
		Util.p(p.getMaximumGold(grid));
	}

}
