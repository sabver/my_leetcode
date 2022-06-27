package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		backtrack(nums, 0, k, n, new LinkedList<Integer>());
		return res;
	}

	public void backtrack(int[] nums, int start, int k, int target, LinkedList<Integer> track) {
		if (target < 0) {
			return;
		}
		if (track.size() == k && target == 0) {
			res.add(new ArrayList<>(track));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			track.add(nums[i]);
			backtrack(nums, i + 1, k, target - nums[i], track);
			track.removeLast();
		}
	}

}
