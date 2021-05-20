package leetcode.medium;

public class LongestPalindromicSubsequence516 {
	/**
	 * dp[i][j] s[i...j]之间的最长回文子序列 通过已知dp[i+1][j-1]来计算dp[i][j] if s[i] == s[j]
	 * dp[i][j] = dp[i+1][j-1] + 2
	 * 
	 * @param s
	 * @return
	 */
	public int longestPalindromeSubseq(String s) {
		int len = s.length();
		int[][] dp = new int[len][len];
		// base case
		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}
		//i从下往上，j从左往右方向遍历确保dp[i][j]的值可以正确被计算
		for(int i=len-1;i>=0;i--) {
			for(int j=i+1;j<len;j++) {
				if (s.charAt(i) != s.charAt(j)) {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}else {
					dp[i][j] = dp[i+1][j-1] + 2;
				}				
			}
		}
		return dp[0][len - 1];
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence516 d = new LongestPalindromicSubsequence516();
		String s = "";
		int result = d.longestPalindromeSubseq(s);
		System.out.print(result);
	}
}
