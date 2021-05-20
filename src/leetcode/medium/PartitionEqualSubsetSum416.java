package leetcode.medium;

public class PartitionEqualSubsetSum416 {

	public boolean canPartition(int[] nums) {
		return dp2(nums);
	}

	/**
	 * 状态压缩版本
	 * @param nums
	 * @return
	 */
	public boolean dp2(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		// 奇数没戏
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		boolean[] dp = new boolean[target + 1];
		// base case
		// dp在还没有进入i的循环的时候，是默认i=0的，也就是没有选择物品的时候，所以都给它设置为false
		for (int j = 1; j <= target; j++) {
			dp[j] = false;
		}
		// 合计价值为0，不选就可以做到，所以true
		dp[0] = true;
		for (int i = 1; i <= nums.length; i++) {
			/**
			 * 这里的顺序不能从小到大的理由
			 * 如果是从小到大,比如d[6] = d[3] || d[2] || d[1]，这里价值为6需要用到3+2+1的价值物品，
			 * 这时候，如果问d[7]等于多少的时候，d[7] = d[6] || d[1]，这里会发现d[6]已经用过1了，然后这里又用一次1，就会不符合题意，所以错误
			 * 
			 */
			for (int j = target; j >= 1; j--) {
				// 没得选
				if (j - nums[i - 1] >= 0) {
					// 无论选不选，只要有一种方案过就行了，也就是说是or
					dp[j] = dp[j] || dp[j - nums[i - 1]];
				}
			}
		}
		return dp[target];
	}

	/**
	 * 没有状态压缩的版本 判断能不能把nums里面的数字分为两组使得两边的和相等 换成背包问题
	 * nums的总和为sum，问题变为，背包可以刚好状态价值为sum/2的物品吗？
	 * dp[i][j]的定义，注意，这里的值都是真假值,从物品0...i中选出物品能不能凑合到j的价值
	 * 
	 * @param nums
	 * @return
	 */
	public boolean dp(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		// 奇数没戏
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		boolean[][] dp = new boolean[nums.length + 1][target + 1];
		// base case
		for (int i = 0; i <= nums.length; i++) {
			// 当要求价值合计为0时，就是可以，只要都不选就可以了
			dp[i][0] = true;
		}
		for (int j = 1; j <= target; j++) {
			// 当没有物品时，要求价值合计大于0是不可能的
			dp[0][j] = false;
		}
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= target; j++) {
				// 没得选
				if (j - nums[i - 1] < 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					// 选择当前nums[i-1]
//					dp[i-1][j - nums[i-1]]
					// 不选当前nums[i-1]
//					dp[i-1][j];
					// 无论选不选，只要有一种方案过就行了，也就是说是or
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				}
			}
		}
		return dp[nums.length][target];
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum416 d = new PartitionEqualSubsetSum416();
		int[] nums = {1,5,11,5};
		boolean result = d.canPartition(nums);
		System.out.println(result);
	}
}
