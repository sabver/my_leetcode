package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import leetcode.util.Util;

public class IncreasingSubsequences {
	List<List<Integer>> res = new ArrayList<>();
	Set<String> set = new HashSet<>();
	String SEP = ",";

	public List<List<Integer>> findSubsequences(int[] nums) {
		if (nums.length <= 1) {
			return res;
		}
		boolean[] used = new boolean[nums.length];
		backtrack(nums, 0, new LinkedList<Integer>(), used);
		return res;
	}

	public void backtrack(int[] nums, int start, LinkedList<Integer> track, boolean[] used) {
		if (track.size() >= 2) {
			// 去重？
			String str = track.toString();
			if (!set.contains(str)) {
				set.add(str);
				res.add(new ArrayList<>(track));
			}
		}
		// 可以在树的横向level进行去重
		// https://leetcode.com/problems/increasing-subsequences/discuss/97147/Java-solution-beats-100
		for (int i = start; i < nums.length; i++) {
			if (i != 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
				continue;
			}
			if (track.size() > 0 && nums[i] < track.getLast()) {
				continue;
			}
			track.add(nums[i]);
			used[i] = true;
			backtrack(nums, i + 1, track, used);
			track.removeLast();
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		IncreasingSubsequences i = new IncreasingSubsequences();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1 };
		Util.printList(i.findSubsequences(nums));
	}

}
