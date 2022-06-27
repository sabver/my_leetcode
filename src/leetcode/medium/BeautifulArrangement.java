package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class BeautifulArrangement {
	boolean used[];
	int res;
//	List<List<Integer>> list = new ArrayList<>();

	public int countArrangement(int n) {
		used = new boolean[n + 1];
		backtrack(n, 0);
//		Util.printList(list);
		return res;
	}

	public void backtrack(int n, int count) {
		if (count == n) {
			res++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (used[i]) {
				continue;
			}
			int index = count + 1;
			if (index % i == 0 || i % index == 0) {
				used[i] = true;
				backtrack(n, index);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		BeautifulArrangement b = new BeautifulArrangement();
		int n = 3;
		Util.p(b.countArrangement(n));
	}

}
