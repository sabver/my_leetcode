package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumV2 {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		backtrack(candidates, target, new LinkedList<Integer>(), 0, 0);
		return res;
	}

	public void backtrack(int[] candidates, int target, LinkedList<Integer> track, int sum, int start) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			res.add(new LinkedList<>(track));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			// 做选择
			track.add(candidates[i]);
			sum += candidates[i];
			backtrack(candidates, target, track, sum, i);
			// 取消选择
			track.removeLast();
			sum -= candidates[i];
		}
	}

}
