package leetcode.easy;

import java.util.HashMap;

public class TwoSum {
	/**
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int testValue = 0;
		for (int i = 0; i < nums.length; i++) {
			testValue = target - nums[i];
			// 这里要排除自己和自己对比的情况
			if (map.containsKey(testValue) && map.get(testValue) != i) {
				result[0] = i;
				result[1] = map.get(testValue);
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] nums = { 3, 2, 4 };
		int target = 6;
		int[] result = ts.twoSum(nums, target);
		System.out.println(result[0] + " -- " + result[1]);
	}
}
