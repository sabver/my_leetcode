package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if (nums.length == 0) {
			return false;
		}
		if (k == 0) {
			return true;
		}
		int presums[] = new int[nums.length + 1];
		presums[0] = 0;
		for (int i = 1; i < presums.length; i++) {
			presums[i] += presums[i - 1] + nums[i - 1];
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < presums.length; i++) {
			int val = presums[i] % k;
			if (map.containsKey(val) == false) {
				map.put(val, i);
			}
			// 这里的val会存在一样的值，map对应的index越小越好，有利于索引的距离大于2
		}
		for (int i = 0; i < presums.length; i++) {
			int need = presums[i] % k;
			if( map.containsKey(need) ) {
				if( i - map.get(need) >= 2 ) {
					return true;
				}
			}
		}
		return false;
	}
}
