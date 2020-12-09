package leetcode.easy;

public class MaximumSubarray {
	/**
	 * 改进idea是借鉴的
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int sum = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (sum < 0)
				sum = nums[i];
			else
				sum += nums[i];
			max = Math.max(max, sum);
		}
		return max;
	}

	/**
	 * divide and conquer
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArrayDC(int[] nums) {
		return maxSubArray(nums, 0, nums.length - 1);
	}

	public int maxSubArray(int[] nums, int low, int high) {
		if (low > high) {
			return 0;
		}
		if (low == high) {
			return nums[low];
		}
		int mid = (low + high) / 2;
		int leftMax = maxSubArray(nums, low, mid);
		int rightMax = maxSubArray(nums, mid + 1, high);
		int crossMax = maxSubArrayCross(nums, low, high);
		if (leftMax >= rightMax && leftMax >= crossMax) {
			return leftMax;
		}
		if (rightMax >= leftMax && rightMax >= crossMax) {
			return rightMax;
		}
		return crossMax;
	}

	public int maxSubArrayCross(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		int sum = nums[mid];
		int leftMax = sum;
		int rightMax = 0;
		for (int i = mid - 1; i >= low; i--) {
			sum += nums[i];
			if (sum > leftMax) {
				leftMax = sum;
			}
		}
		if (mid + 1 <= high) {
			sum = nums[mid + 1];
			rightMax = sum;
		}
		for (int i = mid + 2; i <= high; i++) {
			sum += nums[i];
			if (sum > rightMax) {
				rightMax = sum;
			}
		}
		return leftMax + rightMax;
	}

	/**
	 * 扫描记忆法
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArrayLinear(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			if (nums[0] > 0) {
				return nums[0];
			} else {
				return 0;
			}
		}
		int max = 0;
		int sum = nums[0];
		// 记录最大子数组的下标
		int maxLeft = 0;
		int maxRight = 0;
		// 记录下当前可选的下标
		int okLeft = 0;
		int okRight = 0;
		// 找出所有可选的答案，在这里面比较出max，如果是负数的，就没有必要选，如果是正数，就可以选，同时和之前的记录做比较
		for (int i = 1; i < nums.length; i++) {
			sum += nums[i];
			if (sum < 0) {
				sum = 0;
				// 当前的肯定不是可选值，要移动到下个可能的可选值
				okLeft = i + 1;
				okRight = i + 1;
			} else {
				okRight = i;
				if (sum > max) {
					max = sum;
					maxLeft = okLeft;
					maxRight = okRight;
				}
			}
		}
		String str = "";
		for (int i = maxLeft; i <= maxRight; i++) {
			if (i != maxRight) {
				str += (nums[i] + ",");
			} else {
				str += nums[i];
			}
		}
		System.out.println("maximum subarray:[" + str + "]");
		System.out.println("sum:" + max);
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		// int[] nums = { -2, -1 };
		MaximumSubarray s = new MaximumSubarray();
		System.out.println(s.maxSubArray(nums));
		// s.maxSubArrayLinear(nums);
	}
}
