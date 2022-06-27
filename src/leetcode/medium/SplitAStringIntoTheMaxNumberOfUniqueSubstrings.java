package leetcode.medium;

import java.util.*;

import leetcode.util.Util;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
	int res = 0;

	public int maxUniqueSplit(String s) {
		backtrack(s, new HashSet<>(), new LinkedList<>());
		return res;
	}

	public void backtrack(String s, Set<String> set, LinkedList<String> track) {
		if ("".equals(s) || s == null) {
			res = Math.max(track.size(), res);
		}
		for (int i = 1; i <= s.length(); i++) {
			String next = s.substring(0, i);
			if (set.contains(next)) {
				continue;
			}
			String rest = s.substring(i, s.length());
			track.add(next);
			set.add(next);
			backtrack(rest, set, track);
			track.removeLast();
			set.remove(next);
		}
	}

	public static void main(String[] args) {
		SplitAStringIntoTheMaxNumberOfUniqueSubstrings ss = new SplitAStringIntoTheMaxNumberOfUniqueSubstrings();
		String s = "ababccc";
		Util.p(ss.maxUniqueSplit(s));
	}
}
