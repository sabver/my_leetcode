package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class SumOfAllSubsetXORTotals {
//	List<List<Integer>> res = new ArrayList<>();
	int sum = 0;
//	boolean used[];

	public int subsetXORSum(int[] nums) {
//		used = new boolean[nums.length];
		Arrays.sort(nums);
		backtrack(nums, 0, new LinkedList<Integer>(), 0);
//		Util.printList(res);
		return sum;
	}

	public void backtrack(int[] nums, int start, LinkedList<Integer> track, int xorTotal) {
		Util.p(xorTotal);
		Util.p(track);
//		res.add(new ArrayList<>(track));
		sum += xorTotal;
		for (int i = start; i < nums.length; i++) {
//			if (i != 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
//				continue;
//			}
			track.add(nums[i]);
//			used[i] = true;
			int o = xorTotal;
			xorTotal = xorTotal ^ nums[i];
			backtrack(nums, i + 1, track, xorTotal);
//			used[i] = false;
			track.removeLast();
			xorTotal = o;
		}
	}

	public static void main(String args[]) {
		SumOfAllSubsetXORTotals s = new SumOfAllSubsetXORTotals();
		int[] nums = { 1, 1, 1};
		Util.p(s.subsetXORSum(nums));;
	}

}
