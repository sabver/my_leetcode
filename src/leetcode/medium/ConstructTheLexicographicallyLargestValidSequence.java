package leetcode.medium;

import java.util.*;

import leetcode.util.Util;

public class ConstructTheLexicographicallyLargestValidSequence {
	int[] res;
	boolean[] used;
	boolean flag;
	Set<Integer> set;

	public int[] constructDistancedSequence(int n) {
		res = new int[2 * n - 1];
		used = new boolean[2 * n - 1];
		set = new HashSet<>();
		backtrack(0, n, new int[2 * n - 1]);
		return res;
	}

	public void backtrack(int start, int n, int A[]) {
		Util.printArray(A);
//		Util.p("start:" + start);
		if (flag) {
			return;
		}
		if (set.size() == n) {
			Util.p("bingo");
			Util.printArray(A);
			res = Arrays.copyOf(A, A.length);
			flag = true;
			return;
		}
		if (start == used.length) {
			return;
		}
		if (used[start]) {
			backtrack(start + 1, n, A);
			return;
		}

		for (int i = n; i >= 1; i--) {
			if (set.contains(i)) {
				continue;
			}
			if (i != 1) {
				// 无法填写好两个位置
				if (start + i >= A.length) {
					continue;
				}
				if (used[start + i]) {
					continue;
				}
				// 一次性填好两个位置
				A[start] = i;
				A[start + i] = i;
//				Util.printArray(A);
				used[start] = true;
				used[start + i] = true;
//				Util.p("start: " + start + "  xx:" + (start + i) + " i:" + i);
//				Util.printArray(used);
				set.add(i);
				backtrack(start + 1, n, A);
				A[start] = 0;
				A[start + i] = 0;
				used[start] = false;
				used[start + i] = false;
				set.remove(i);
			} else {
				A[start] = i;
				used[start] = true;
				set.add(i);
				backtrack(start + 1, n, A);
				A[start] = 0;
				used[start] = false;
				set.remove(i);
			}
		}
	}

	public static void main(String[] args) {
		ConstructTheLexicographicallyLargestValidSequence c = new ConstructTheLexicographicallyLargestValidSequence();
		int n = 5;// [4,2,3,2,4,3,1]
		Util.p("res");
		Util.printArray(c.constructDistancedSequence(n));
	}

}
