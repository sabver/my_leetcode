package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsV2 {
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> permute(int[] nums) {
		backtrack(nums, new LinkedList<Integer>(), new HashSet<Integer>());
		return res;
	}

	public void backtrack(int[] nums, LinkedList<Integer> track, Set<Integer> set) {
		if (track.size() == nums.length) {
			res.add(new LinkedList<>(track));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				continue;
			}
			set.add(nums[i]);
			track.add(nums[i]);
			backtrack(nums, track, set);
			set.remove(nums[i]);
			track.removeLast();
		}
	}

}
