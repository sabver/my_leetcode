package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class SubsetsIIV2 {
	List<List<Integer>> res = new ArrayList<>();
	boolean[] used;

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		used = new boolean[nums.length];
		backtrack(nums, 0, new LinkedList<Integer>());
		return res;
	}

	public void backtrack(int[] nums, int start, LinkedList<Integer> track) {
		res.add(new LinkedList<>(track));
		for (int i = start; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i != 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
				continue;
			}
			track.add(nums[i]);
			used[i] = true;
			backtrack(nums, i + 1, track);
			used[i] = false;
			track.removeLast();
		}
	}

	public static void main(String[] args) {
		SubsetsIIV2 v = new SubsetsIIV2();
		int[] nums = { 1, 2, 3 };
		Util.printList(v.subsetsWithDup(nums));
	}

}
