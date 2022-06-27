package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import leetcode.util.Util;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacter {
	int res = 0;

	public int maxLength(List<String> arr) {
		List<String> arrnew = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			if (isUnique(arr.get(i))) {
				res = Math.max(res, arr.get(i).length());
				arrnew.add(arr.get(i));
			}
		}

		backtrack(new StringBuffer(), 0, 0, arrnew);
		return res;
	}

	public void backtrack(StringBuffer track, int sum, int start, List<String> arr) {
		res = Math.max(res, sum);
		if (start >= arr.size()) {
			return;
		}
		for (int i = start; i < arr.size(); i++) {
			String b = arr.get(i);
			int len = b.length();
			if (isUnique(track.toString(), b)) {
				String temp = track.toString();
				track.append(b);
				backtrack(track, sum + len, i + 1, arr);
				track = new StringBuffer(temp);
			}
		}
	}

	boolean isUnique(String s) {
		Set<Character> set = new HashSet<>();
		boolean isOk = true;
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				isOk = false;
				break;
			} else {
				set.add(s.charAt(i));
			}
		}
		return isOk;
	}

	boolean isUnique(String a, String b) {
		int aLen = a.length(), bLen = b.length();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < aLen; i++) {
			set.add(a.charAt(i));
		}
		for (int i = 0; i < bLen; i++) {
			if (set.contains(b.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MaximumLengthOfAConcatenatedStringWithUniqueCharacter m = new MaximumLengthOfAConcatenatedStringWithUniqueCharacter();
		List<String> arr = new ArrayList<>();
		arr.add("a");
		arr.add("abc");
		arr.add("d");
		arr.add("de");
		arr.add("def");
		Util.p(m.maxLength(arr));
	}

}
