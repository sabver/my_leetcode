package leetcode.hard;

public class EditDistance {
	/**
	 * dp数组的定义： dp[i][j]是word1[0...i-1] word2[0...j-1]两者的最短编辑距离
	 * i=0的时候，也就是word1为空，对应dp[0][j] = j，这时候最短编辑距离就是word2的长度，也就是全部删除即可
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		int l1 = word1.length(), l2 = word2.length();
		int[][] dp = new int[l1 + 1][l2 + 1];
		// base case
		for (int i = 0; i < l1 + 1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j < l2 + 1; j++) {
			dp[0][j] = j;
		}
		// 这里遍历的i和j分别是word1和word2当前的长度，所以访问的时候需要-1，对应下标
		// dp[i][j]是word1[0...i-1] word2[0...j-1]两者的最短编辑距离
		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					// skip
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					// delete word1[i]
					int delete = dp[i - 1][j] + 1;
					// insert word1[i] and skip => dp(word1, word2, i+1, j) => dp(word1, word2, i,
					// j-1)
					int insert = dp[i][j - 1] + 1;
					// replace word1[i] with word2[j]
					int replace = dp[i - 1][j - 1] + 1;
					dp[i][j] = Math.min(delete, Math.min(insert, replace));
				}
			}
		}
		// word1[0...l1] word2[0...l2]
		return dp[l1][l2];
	}

	/**
	 * dp数组定义：word1[0...i] word2[0...j]两者的最短编辑距离 这里是假定将word1变为word2
	 * 
	 * @param word1
	 * @param word2
	 * @param i
	 * @param j
	 * @return
	 */
	public int dp(String word1, String word2, int i, int j) {
		// base case
		if (i == -1 && j == -1) {
			return 0;
		}
		if (i == -1) {
			return j + 1;
		}
		if (j == -1) {
			return i + 1;
		}
		if (word1.charAt(i) == word2.charAt(j)) {
			// skip
			return dp(word1, word2, i - 1, j - 1);
		} else {
			// delete word1[i]
			int delete = dp(word1, word2, i - 1, j) + 1;
			// insert word1[i] and skip => dp(word1, word2, i+1, j) => dp(word1, word2, i,
			// j-1)
			int insert = dp(word1, word2, i, j - 1) + 1;
			// replace word1[i] with word2[j]
			int replace = dp(word1, word2, i - 1, j - 1) + 1;
			return Math.min(delete, Math.min(insert, replace));
		}
	}

	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		String word1 = "intention";
		String word2 = "execution";
		int result = ed.minDistance(word1, word2);
		System.out.print(result);
	}
}
