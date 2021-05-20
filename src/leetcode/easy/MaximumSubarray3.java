package leetcode.easy;

public class MaximumSubarray3 {
	/**
	 * 这里只用动态规划的想法去做 dp[i]表示以nums[i]为结尾的最大子数组和
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
		int[] dp = new int[nums.length];
		// base case
		for (int i = 0; i < dp.length; i++) {
			dp[i] = nums[i];
		}
		for (int i = 1; i < dp.length; i++) {
			//怎么根据dp[i-1]的结果来计算dp[i]
			//如果dp[i-1]是有增益的，那么就合并，否则保持原来的数组
			if (dp[i-1] > 0) {
				dp[i] = dp[i-1] + nums[i];
			}
		}
		int result = dp[0];
		for (int i = 1; i < dp.length; i++) {
			result = Math.max(result, dp[i]);
		}
		return result;
	}
	
	/**
	 * dp[i]表示以nums[i]为结尾的最大子数组和
	 * 状态压缩版本
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		// dpPrev = dp[i-1]
		// dpCur = dp[i]
		int dpPrev = nums[0],dpCur = 0,result = nums[0]; 
		for (int i = 1; i < nums.length; i++) {
			//怎么根据dp[i-1]的结果来计算dp[i]
			//如果dp[i-1]是有增益的，那么就合并，否则保持原来的数组
			if (dpPrev > 0) {
				dpCur = dpPrev + nums[i];
			} else {
				dpCur = nums[i];
			}
			dpPrev = dpCur;
			result = Math.max(result, dpCur);
		}
		return result;
	}	

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		// int[] nums = { -2, -1, -5, -6, -5, 1 };
		MaximumSubarray3 s = new MaximumSubarray3();
		System.out.println(s.maxSubArray(nums));
	}
}
