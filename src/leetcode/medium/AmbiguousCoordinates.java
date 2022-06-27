package leetcode.medium;

import java.util.*;

import leetcode.util.Util;

public class AmbiguousCoordinates {
	String LEFT = "(", RIGHT = ")", COMA = ",", SPACE = " ";

	public List<String> ambiguousCoordinates(String s) {
		List<String> res = new ArrayList<>();
		s = s.substring(1, s.length() - 1);
		String str, rest;
		StringBuffer sb;
		for (int i = 0; i < s.length(); i++) {
			str = s.substring(0, i);
			rest = s.substring(i, s.length());
			List<String> list1 = generate(str);
			List<String> list2 = generate(rest);
			for (String s1 : list1) {
				for (String s2 : list2) {
					sb = new StringBuffer();
					sb.append(LEFT).append(s1).append(COMA).append(SPACE).append(s2).append(RIGHT);
					res.add(sb.toString());
				}
			}
		}
		return res;
	}

	public List<String> generate(String s) {
		List<String> list = new ArrayList<>();
		if (s == null || "".equals(s)) {
			return list;
		}
		for (int i = 1; i <= s.length(); i++) {
			StringBuffer sb = new StringBuffer();
			String str = s.substring(0, i);
			String rest = s.substring(i, s.length());
			if (str.length() > 1 && str.charAt(0) == '0') {
				break;
			}
			if (rest.length() > 0 && rest.charAt(rest.length() - 1) == '0') {
				continue;
			}
			if (i == s.length()) {
				list.add(sb.append(str).toString());
			} else {
				list.add(sb.append(str).append(".").append(rest).toString());
			}
		}
		return list;
	}

	public static void main(String[] args) {
		AmbiguousCoordinates a = new AmbiguousCoordinates();
		String s = "(00011)";
		Util.p(a.ambiguousCoordinates(s));
//		Util.p(a.generate(s));
	}

}
