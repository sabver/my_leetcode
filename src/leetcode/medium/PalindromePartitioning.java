package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
	List<List<String>> res = new ArrayList<>();

	public List<List<String>> partition(String s) {
		if (s == null || s.length() == 0) {
			return res;
		}
		backtrack(s, new LinkedList<>());
		return res;
	}

	public void backtrack(String s, LinkedList<String> track) {
		// base case
		if (s == null || s.length() == 0) {
			res.add(new ArrayList<>(track));
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String subStr = s.substring(0, i);
			if (!isPalindrome(subStr)) {
				continue;
			}
			track.add(subStr);
			backtrack(s.substring(i, s.length()), track);
			track.removeLast();
		}
	}

	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

}
