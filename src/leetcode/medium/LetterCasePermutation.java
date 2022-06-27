package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.Util;

public class LetterCasePermutation {

	List<String> res = new ArrayList<>();

	public List<String> letterCasePermutation(String s) {
		s = s.toLowerCase();
		String[] list = s.split("");
		backtrack(list, 0, new StringBuffer());
		return res;
	}

	public void backtrack(String[] list, int start, StringBuffer track) {
		if (track.length() == list.length) {
			res.add(track.toString());
			return;
		}
		char c = list[start].charAt(0);
		if (Character.isDigit(c)) {
			track.append(c);
			backtrack(list, start + 1, track);
			track.deleteCharAt(track.length() - 1);
		} else {
			track.append(c);
			backtrack(list, start + 1, track);
			track.deleteCharAt(track.length() - 1);

			track.append(Character.toUpperCase(c));
			backtrack(list, start + 1, track);
			track.deleteCharAt(track.length() - 1);
		}
	}

	public static void main(String[] args) {
		LetterCasePermutation l = new LetterCasePermutation();
		String s = "a1b2";
		Util.p(l.letterCasePermutation(s));
	}

}
