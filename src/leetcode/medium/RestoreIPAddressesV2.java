package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.Util;

public class RestoreIPAddressesV2 {
	String DOT = ".";
	List<List<Integer>> res = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		backtrack(s, 0, new LinkedList<>());
		List<String> result = new ArrayList<>();
		for (List<Integer> list : res) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
				if (i != list.size() - 1) {
					sb.append(DOT);
				}
			}
			result.add(sb.toString());
		}
		return result;
	}

	public void backtrack(String s, int start, LinkedList<Integer> track) {
		if (track.size() == 4 && start == s.length()) {
			res.add(new LinkedList<>(track));
		}
		if (start > s.length()) {
			return;
		}
		// length = 1
		int withOne = getNum(s, start, 1);
		if (withOne != -1 && withOne <= 255) {
			track.add(withOne);
			backtrack(s, start + 1, track);
			track.removeLast();
		}
		// length = 2
		int withTwo = getNum(s, start, 2);
		if (withTwo != -1 && withTwo <= 255) {
			track.add(withTwo);
			backtrack(s, start + 2, track);
			track.removeLast();
		}
		// length = 3
		int withThree = getNum(s, start, 3);
		if (withThree != -1 && withThree <= 255) {
			track.add(withThree);
			backtrack(s, start + 3, track);
			track.removeLast();
		}
	}

	public int getNum(String s, int start, int length) {
		int end = start + length - 1;
		if (end > s.length() - 1) {
			return -1;
		}
		if (s.charAt(start) - '0' == 0 && length > 1) {
			return -1;
		}
		return Integer.valueOf(s.substring(start, end + 1));
	}

	public static void main(String[] args) {
		RestoreIPAddressesV2 r = new RestoreIPAddressesV2();
		String s = "101023";
		List<String> res = r.restoreIpAddresses(s);
		Util.p(res);
	}

}
