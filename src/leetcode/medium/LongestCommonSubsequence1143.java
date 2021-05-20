package leetcode.medium;

public class LongestCommonSubsequence1143 {
	public int longestCommonSubsequence(String text1, String text2) {
		int l1 = text1.length(), l2 = text2.length();
		int[][] dp = new int[l1][l2];
		boolean flag = false;
		// base case
		for (int i = 0; i < l1; i++) {
			if (text2.charAt(0) == text1.charAt(i)) {
				// dp[i+1...l1-1][0]都应该是1
				dp[i][0] = 1;
				flag = true;
			} else {
				if (flag) {
					dp[i][0] = 1;
				} else {
					dp[i][0] = 0;
				}
			}
		}
		flag = false;
		for (int j = 0; j < l2; j++) {
			if (text1.charAt(0) == text2.charAt(j)) {
				// dp[0][j+1...l2-1]都应该是1
				dp[0][j] = 1;
				flag = true;
			} else {
				if (flag) {
					dp[0][j] = 1;
				} else {
					dp[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < l1; i++) {
			for (int j = 1; j < l2; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					// in text1
					int d1 = dp[i][j - 1];
					// in text2
					int d2 = dp[i - 1][j];
					// not in text1 and text2
					int d3 = dp[i - 1][j - 1];
					dp[i][j] = Math.max(d1, Math.max(d2, d3));
				}
			}
		}
//		for (int i = 0; i < l1; i++) {
//			for (int j = 0; j < l2; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		return dp[l1 - 1][l2 - 1];
	}

	/**
	 * 尝试状态压缩 i和j分别对应为长度位置，不是下标 dp[i][j]的定义是text1[0...i-1]和text2[0...j-1]的最长公共子序列
	 * 失败了，后面要重新尝试
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int dp2(String text1, String text2) {
		int l1 = text1.length(), l2 = text2.length();
		if (l1 == 0 || l2 == 0) {
			return 0;
		}
		// dp[i - 1][j - 1]和dp[i - 1][j]被压缩
		int[] dp = new int[l2 + 1];
		// base case
		dp[0] = 0;		
		//i和j分别对应为长度位置
		for (int i = 1; i <= l1; i++) {
			int dpTemp = 0;
			// dpTemp = dp[i][j] 因为dp[i][j-1]是上个j循环得到的值，所以这里dp3和dp[i][j-1]复用
			for (int j = 1; j <= l2; j++) {
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					// dp[i][j] = dp[i - 1][j - 1] + 1;
					dp[j] = dp[j - 1] + 1;
				} else {
					// in text1
					// int d1 = dp[i][j - 1];
					int d1 = dpTemp;
					// in text2
					// int d2 = dp[i - 1][j];
					int d2 = dp[j];
					// not in text1 and text2
					// int d3 = dp[i - 1][j - 1];
					int d3 = dp[j - 1];
					// dp[i][j] = Math.max(d1, Math.max(d2, d3));
					dp[j] = Math.max(d1, Math.max(d2, d3));
				}
				dpTemp = dp[j];
			}

		}
		return dp[l2];
	}

	/**
	 * dp[i][j]的定义，text1[0...i]和text2[0...j]的最长公共子序列 result => dp(text1, text2,
	 * text1.length()-1, text2.length()-1)
	 * 
	 * @param text1
	 * @param text2
	 * @param i
	 * @param j
	 * @return
	 */
	public int dp(String text1, String text2, int i, int j) {
		// base case
		if (i == -1 || j == -1) {
			return 0;
		}
		if (text1.charAt(i) == text2.charAt(j)) {
			return dp(text1, text2, i - 1, j - 1) + 1;
		} else {
			// in text1
			int d1 = dp(text1, text2, i, j - 1);
			// in text2
			int d2 = dp(text1, text2, i - 1, j);
			// not in text1 and text2
			int d3 = dp(text1, text2, i - 1, j - 1);
			return Math.max(d1, Math.max(d2, d3));
		}
	}

	public static void main(String[] args) {
		LongestCommonSubsequence1143 d = new LongestCommonSubsequence1143();
		String text1 = "ezupkr";
		String text2 = "ubmrapg";
		int result = d.dp2(text1, text2);
		System.out.print(result);
	}
}
