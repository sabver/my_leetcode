package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIIV2 {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		backtrack(candidates, target, new LinkedList<Integer>(), 0, 0);
		return res;
	}

	public void backtrack(int[] candidates, int target, LinkedList<Integer> track, int sum, int start) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			res.add(new LinkedList<Integer>(track));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			track.add(candidates[i]);
			sum += candidates[i];
			backtrack(candidates, target, track, sum, i + 1);
			track.removeLast();
			sum -= candidates[i];
		}
	}
}
