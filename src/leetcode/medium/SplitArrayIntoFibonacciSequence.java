package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class SplitArrayIntoFibonacciSequence {
	List<Integer> res = new ArrayList<>();

	public List<Integer> splitIntoFibonacci(String num) {
		backtrack(num, new LinkedList<>());
		return res;
	}

	public boolean backtrack(String num, LinkedList<Integer> track) {
//		Util.p(track);
		int len = num.length();
		if (num.length() == 0 && track.size() >= 3) {
			res = new ArrayList<>(track);
			return true;
		}
		for (int i = 1; i <= len; i++) {
			String s = num.substring(0, i);
			if (i > 1 && s.charAt(0) == '0') {
				break;
			}
			if (valid(track, s) == false) {
				continue;
			}
			track.add(Integer.valueOf(s));
			String rest = num.substring(i, len);
			if (backtrack(rest, track)) {
				return true;
			}
			track.removeLast();
		}
		return false;
	}

	public boolean valid(LinkedList<Integer> track, String s) {
		if (Double.valueOf(s) >= Integer.MAX_VALUE) {
			return false;
		}
		if (track.size() < 2) {
			return true;
		}
		Integer val = Integer.valueOf(s);
		Integer f1 = track.get(track.size() - 1);
		Integer f2 = track.get(track.size() - 2);
		return val == f1 + f2;
	}

	public static void main(String[] args) {
		String num = "1101111";
		SplitArrayIntoFibonacciSequence s = new SplitArrayIntoFibonacciSequence();
		Util.p(s.splitIntoFibonacci(num));
	}

}
