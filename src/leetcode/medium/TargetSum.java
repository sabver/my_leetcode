package leetcode.medium;

public class TargetSum {
	int res;

	public int findTargetSumWays(int[] nums, int target) {
		backtrack(nums, target, 0, 0);
		return res;
	}

	public void backtrack(int[] nums, int target, int start, int sum) {
		if (start == nums.length) {
			if (target == sum) {
				res++;
			}
			return;
		}
		sum += nums[start];
		backtrack(nums, target, start + 1, sum);
		sum -= nums[start];
		
		sum -= nums[start];
		backtrack(nums, target, start + 1, sum);
		sum += nums[start];
	}

}
