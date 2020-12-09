package leetcode.easy;

import leetcode.util.Util;

public class ClimbingStairs2 {
	/**
	 * climbStairs 动态规划 dp(n) = dp(n-1)+dp(n-2)
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		return climbStairs(n, dp);
	}

	public int climbStairs(int n, int dp[]) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		dp[n - 2] = climbStairs(n - 2,dp);
		dp[n - 1] = climbStairs(n - 1,dp);
		return dp[n - 1] + dp[n - 2];
	}

	public static void main(String[] args) {
		ClimbingStairs2 s = new ClimbingStairs2();
		int n = 44;
		System.out.println(s.climbStairs(n));
	}
}
