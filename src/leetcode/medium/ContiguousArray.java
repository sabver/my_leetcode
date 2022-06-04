package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		int presums[] = new int[nums.length + 1];
		presums[0] = 0;
		for (int i = 1; i < presums.length; i++) {
			int num = nums[i - 1] == 0 ? -1 : 1;
			presums[i] += presums[i - 1] + num;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < presums.length; i++) {
			int val = presums[i];
			if (map.containsKey(val) == false) {
				map.put(val, i);
			}
			// 这里的val会存在一样的值，map对应的index越小越好，有利于索引的距离
		}
		int res = 0;
		// presums[j] - presums[i] == 0
		for (int i = 0; i < presums.length; i++) {
			int need = presums[i];
			if (map.containsKey(need)) {
				res = Math.max(res, i - map.get(need));
			}
		}
		return res;
	}
}
