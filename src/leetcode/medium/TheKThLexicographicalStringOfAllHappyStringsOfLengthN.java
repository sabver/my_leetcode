package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.Util;

public class TheKThLexicographicalStringOfAllHappyStringsOfLengthN {
	int curK = 0, k = 0;
	String result = "";
	String[] list = { "a", "b", "c" };

//	List<String> res = new ArrayList<>();

	public String getHappyString(int n, int k) {
		this.k = k;
		backtrack(n, new StringBuffer());
//		Util.p(res);
//		if (res.size() >= k) {
//			return res.get(k - 1);
//		}
		return result;
	}

	public void backtrack(int n, StringBuffer track) {
		if (track.length() == n) {
//			res.add(track.toString());
			curK ++;
			if( curK == k ) {
				result = track.toString();
			}
			return;
		}
		for (int i = 0; i < list.length; i++) {
			if (track.length() != 0 && track.charAt(track.length() - 1) == list[i].charAt(0)) {
				continue;
			}
			track.append(list[i]);
			backtrack(n, track);
			track.deleteCharAt(track.length() - 1);
		}
	}

	public static void main(String[] args) {
		TheKThLexicographicalStringOfAllHappyStringsOfLengthN x = new TheKThLexicographicalStringOfAllHappyStringsOfLengthN();
		int n = 3, k = 9;
		Util.p(x.getHappyString(n, k));
	}

}
