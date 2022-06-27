package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubsetsV2 {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		backtrack(nums, new LinkedList<Integer>(), 0);
		return res;
	}

	public void backtrack(int[] nums, LinkedList<Integer> track, int start) {
		res.add(new LinkedList<>(track));
		for (int i = start; i < nums.length; i++) {
			track.add(nums[i]);
			backtrack(nums, track, i + 1);
			track.removeLast();
		}
	}

}
