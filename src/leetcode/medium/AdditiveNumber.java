package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class AdditiveNumber {
//	List<List<String>> res = new ArrayList<>();
	boolean res = false;

	public boolean isAdditiveNumber(String num) {
		backtrack(num, new LinkedList<>());
		return res;
	}

	public void backtrack(String num, LinkedList<String> track) {
		// base case
		if ("".equals(num)) {
			if (track.size() >= 3) {
//				res.add(new ArrayList<>(track));
				res = true;
			}
		}
		for (int i = 1; i <= num.length(); i++) {
			String subStr = num.substring(0, i);
			if (subStr.length() > 1 && subStr.charAt(0) == '0') {
				continue;
			}
			// check sum
			if (track.size() >= 2) {
				String str1 = track.get(track.size() - 2);
				String str2 = track.get(track.size() - 1);
				if (Double.valueOf(str1)/2 + Double.valueOf(str2)/2 != Double.valueOf(subStr)/2) {
					continue;
				}
			}
			track.add(subStr);
			backtrack(num.substring(i, num.length()), track);
			track.removeLast();
		}
	}

	public static void main(String[] args) {
		AdditiveNumber a = new AdditiveNumber();
		String num = "198019823962";
		boolean res = a.isAdditiveNumber(num);
		Util.p(res);
//		Util.printListStr(a.res);
	}

}
