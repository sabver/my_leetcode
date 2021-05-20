package leetcode.medium;

public class LongestIncreasingSubsequence300 {
	/**
	 * dp[i]的定义：以nums[i]为结尾的最长增长子序列的长度
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		// base case
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		// 计算所有dp[i]
		for (int i = 0; i < dp.length; i++) {
			//根据dp[0...i-1]来计算dp[i]的值
			//这里的一个前提，就是dp[0...i-1]是已经被正确计算过的
			for(int j=0;j<i;j++) {
				if( nums[i] > nums[j] ) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		int result = 0;
		for (int i = 0; i < dp.length; i++) {
			result = Math.max(result, dp[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence300 d = new LongestIncreasingSubsequence300();
		int[] nums = { 0, 1, 0, 3, 2, 3 };
		int result = d.lengthOfLIS(nums);
		System.out.print(result);
	}
}
