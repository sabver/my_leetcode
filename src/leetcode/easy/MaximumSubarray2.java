package leetcode.easy;


public class MaximumSubarray2 {
	/**
	 * 这里只用动态规划的想法去做
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] A) {
		int n = A.length;
		int[] dp = new int[n];// dp[i] means the maximum subarray ending with
								// A[i];
		dp[0] = A[0];
		int max = dp[0];

		for (int i = 1; i < n; i++) {
			dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}

		return max;
	}

//	private int maxSubArray(int[] nums, int other) {
//		if (nums.length == 0) {
//			return 0;
//		}
//		if (nums.length == 1) {
//			return nums[0];
//		}
//		// nums[leftIndex,rightIndex] max
//		// nums[leftIndex,innerIndex] leftSum
//		// nums[rightIndex+1...i] rightSum
//		int leftSum, rightSum, max, leftIndex, rightIndex, innerIndex, length;
//		leftIndex = rightIndex = innerIndex = rightSum = leftSum = 0;
//		max = nums[0];
//		length = nums.length;
//		for (int i = 1; i < length; i++) {
//			// 右边有益
//			if (rightSum + nums[i] >= 0) {
//				rightIndex = i;
//				// max加上右边的增量
//				max = max + nums[i] + rightSum;
//				// 如果选取了新元素，那么右边的sum应该清空
//				rightSum = 0;
//			} else {
//				// 更新nums[rightIndex+1...hi]
//				rightSum = rightSum + nums[i];
//			}
//			// 判断需不需要左边收缩,一直收缩会和右边的rightIndex交叉
//			if (leftSum + nums[leftIndex] < 0) {
//				// 如果交叉了，就不动
//				if (leftIndex >= rightIndex) {
//
//				} else {
//					// 左边无益，收缩
//					leftIndex++;
//					leftSum = 0;
//					innerIndex = leftIndex;
//					// max拿回左边的值
//					max = max - nums[leftIndex - 1];
//				}
//			} else {
//				// 左边还是有益的
//				innerIndex++;
//				leftSum = leftSum + nums[innerIndex];
//			}
//		}
//		Util.printArray(nums, leftIndex, rightIndex);
//		System.out.println("innerIndex:" + innerIndex);
//		return max;
//	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		// int[] nums = { -2, -1, -5, -6, -5, 1 };
		MaximumSubarray2 s = new MaximumSubarray2();
		System.out.println(s.maxSubArray(nums));
	}
}
