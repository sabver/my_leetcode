package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class PermutationsIIV2 {
	List<List<Integer>> res = new ArrayList<>();
	boolean[] used;

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		used = new boolean[nums.length];
		backtrack(nums, new LinkedList<Integer>());
		return res;
	}

	public void backtrack(int[] nums, LinkedList<Integer> track) {
		if (nums.length == track.size()) {
			res.add(new LinkedList<>(track));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i] == true) {
				continue;
			}
			// 确保相同元素的相对位置一致
			if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			track.add(nums[i]);
			used[i] = true;
			backtrack(nums, track);
			track.removeLast();
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		PermutationsIIV2 p = new PermutationsIIV2();
		int[] nums = new int[] { 1, 1, 2 };
		List<List<Integer>> res = p.permuteUnique(nums);
		Util.printList(res);
	}

}
