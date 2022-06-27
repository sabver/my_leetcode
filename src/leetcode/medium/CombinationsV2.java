package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class CombinationsV2 {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		backtrack(n, k, new LinkedList<Integer>(), 1);
		return res;
	}

	public void backtrack(int n, int k, LinkedList<Integer> track, int start) {
		if (track.size() == k) {
			res.add(new LinkedList<>(track));
			return;
		}
		if (start > n) {
			return;
		}
		for (int i = start; i <= n; i++) {
			System.out.println("start:" + start + " i:" + i);
			track.add(i);
			backtrack(n, k, track, i + 1);
			track.removeLast();
		}
	}

	public static void main(String[] args) {
		CombinationsV2 c = new CombinationsV2();
		int n = 4, k = 2;
		List<List<Integer>> res = c.combine(n, k);
		Util.printList(res);
	}

}
