package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class NumbersWithSameConsecutiveDifferences {
	List<Integer> res = new ArrayList<>();

	public int[] numsSameConsecDiff(int n, int k) {
		int start = 1;
		if (n == 1) {
			start = 0;
		}
		for (int i = start; i <= 9; i++) {
			LinkedList<Integer> track = new LinkedList<>();
			track.add(i);
			backtrack(n, k, track, i);
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;
	}

	public void backtrack(int n, int k, LinkedList<Integer> track, int value) {
		if (track.size() >= n) {
			if (track.size() == n) {
				res.add(value);
			}
			return;
		}
		Integer last = track.getLast();
		int minus = last - k;
		int plus = last + k;
		if (minus != plus) {
			if (minus >= 0) {
				track.offer(minus);
				backtrack(n, k, track, value * 10 + minus);
				track.removeLast();
			}

			if (plus <= 9) {
				track.offer(plus);
				backtrack(n, k, track, value * 10 + plus);
				track.removeLast();
			}
		} else {
			if (minus >= 0 && minus <= 9) {
				track.offer(minus);
				backtrack(n, k, track, value * 10 + minus);
				track.removeLast();
			}
		}

	}

	public static void main(String[] args) {
		NumbersWithSameConsecutiveDifferences d = new NumbersWithSameConsecutiveDifferences();
		int n = 3, k = 7;
		Util.printArray(d.numsSameConsecDiff(n, k));
	}

}
