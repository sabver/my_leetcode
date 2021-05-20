package leetcode.medium;

public class CoinChange518 {
	/**
	 * 完全背包问题 dp[i][j]的定义，使用coins[0...i-1]（前i种硬币）凑够金额为j有多少种方法
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int change(int amount, int[] coins) {
		int[][] dp = new int[coins.length + 1][amount + 1];
		// base case
		for (int i = 1; i <= coins.length; i++) {
			// 金额为0的时候，就默认只有一种可以凑，也就是不凑
			dp[i][0] = 1;
		}
		for (int j = 1; j <= amount; j++) {
			// 不用硬币可以凑出大于0的金额是不可能的
			dp[0][j] = 0;
		}
		// 不用硬币没有金额，那就不凑算是一种方法
		dp[0][0] = 1;
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if ( j - coins[i-1] >= 0 ) {
					dp[i][j] = Math.max(
							// 选择coins[i-1]
							dp[i][j - coins[i-1]] + dp[i][coins[i-1]] + 1, 
							// 不选coins[i-1]
							dp[i-1][j]);	
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[coins.length][amount];
	}

	public static void main(String[] args) {
		CoinChange518 c = new CoinChange518();
		int amount = 5;
		int[] coins = { 1, 2, 5 };
		int result = c.change(amount, coins);
		System.out.println(result);
	}
}
