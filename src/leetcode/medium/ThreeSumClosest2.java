package leetcode.medium;

import java.util.Arrays;

public class ThreeSumClosest2 {

	public int threeSumClosest(int[] nums, int target) {
		int sum = 0;
		if (nums.length <= 3) {
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
			}
			return sum;
		} else {
			sum = nums[0] + nums[1] + nums[2];
		}
		Arrays.sort(nums);
		int left, right, subSum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				subSum = nums[i] + nums[left] + nums[right];
				if (Math.abs(target - subSum) < Math.abs(target - sum)) {
					sum = subSum;
				}
				if (subSum == target) {
					return target;
				} else if (subSum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		ThreeSumClosest2 s = new ThreeSumClosest2();
		int[] nums = { -1, 0, 1, 1, 55 };
		int target = 3;
		System.out.println(s.threeSumClosest(nums, target));
		// s.test();
	}
}
