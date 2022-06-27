package leetcode.medium;

import java.util.LinkedList;

import leetcode.util.Util;

public class SplittingAStringIntoDescendingConsecutiveValues {

	public boolean splitString(String s) {
		return backtrack(s, Double.MAX_VALUE, new LinkedList<String>());
	}

	public boolean backtrack(String s, Double max, LinkedList<String> track) {
//		Util.p(track);
		if ("".equals(s) || s == null) {
			return track.size() > 1;
		}
		for (int i = 1; i <= s.length(); i++) {
			String next = s.substring(0, i);
			if (isOverflow(next))
				continue;
			Double nextVal = Double.valueOf(next);
			String rest = s.substring(i, s.length());
//			Util.p("nextVal:" + nextVal + " max:" + max);
			if (max == Double.MAX_VALUE || (nextVal + 1 == max)) {
				track.add(next);
				if (backtrack(rest, nextVal, track))
					return true;
				track.removeLast();
			}
		}
		return false;
	}

	public boolean isOverflow(String s) {
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		SplittingAStringIntoDescendingConsecutiveValues ss = new SplittingAStringIntoDescendingConsecutiveValues();
		String s = "99999999999999999998";
		Util.p(ss.splitString(s));
	}

}
