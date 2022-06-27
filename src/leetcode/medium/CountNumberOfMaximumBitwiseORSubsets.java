package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountNumberOfMaximumBitwiseORSubsets {
	int res;
	Map<Integer, Integer> countMap = new HashMap<>();
	List<List<Integer>> list = new ArrayList<>();

	public int countMaxOrSubsets(int[] nums) {
		backtrack(nums, 0, new LinkedList<>(), 0);
		return res;
	}

	public void backtrack(int[] nums, int start, LinkedList<Integer> track, int or) {
		if (track.size() > 0) {
			list.add(new ArrayList<>(track));
			// record
			countMap.put(or, countMap.getOrDefault(or, 0) + 1);
			res = Math.max(res, countMap.get(or));
		}
		for (int i = start; i < nums.length; i++) {
			track.add(nums[i]);
			int o = or;
			or = or | nums[i];
			backtrack(nums, i + 1, track, or);
			or = o;
			track.removeLast();
		}
	}

}
