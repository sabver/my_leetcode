package leetcode.test;

public class Knapsack {
	/**
	 * 01背包问题 从所有物品中进行选择，让选到的物品的总价值最大，同时不可以超过限重
	 * dp[i][j]的定义，在限重j和从物品1...i中得到的物品的最大总价值
	 * 
	 * @param N   物品数量
	 * @param W   限重
	 * @param wt  每个物品重量
	 * @param val 每个物品价值
	 * @return
	 */
	public int knapsack01(int N, int W, int[] wt, int[] val) {
		// dp[][0]也就是限重是0的时候的价值，也就是0，因为没得选
		int[][] dp = new int[N + 1][W + 1];
		// base case
		for (int i = 0; i <= N; i++) {
			dp[i][0] = 0;
		}
		// dp[0][]代表的是不选物品
		for (int j = 0; j <= W; j++) {
			dp[0][j] = 0;
		}
		// i是选择物品的范围，从第1个到第i个
		for (int i = 1; i <= N; i++) {
			// j代表是多少限重 j = [0...W]
			for (int j = 1; j <= W; j++) {
				// 防止越界
				// 这里根本无法选
				if (j - wt[i - 1] < 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(
							// 选择物品i
							dp[i - 1][j - wt[i - 1]] + val[i - 1],
							// 不选物品i
							dp[i - 1][j]);
				}
			}
		}
		return dp[N][W];
	}

	public static void main(String[] args) {
		Knapsack k = new Knapsack();
		int N = 3, W = 4;
		int[] wt = { 2, 1, 3 };
		int[] val = { 4, 2, 3 };
		int result = k.knapsack01(N, W, wt, val);
		System.out.println(result);
	}
}
