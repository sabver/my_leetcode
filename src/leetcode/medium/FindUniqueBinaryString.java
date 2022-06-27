package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
	int n;
	String res;

	public String findDifferentBinaryString(String[] nums) {
		this.n = nums.length;
		Set<String> set = new HashSet<>();
		for (String num : nums) {
			set.add(num);
		}
		backtrack(set, new StringBuffer());
		return res;
	}

	public boolean backtrack(Set<String> set, StringBuffer track) {
		if (track.length() == n) {
			if (set.contains(track.toString())) {
				return false;
			} else {
				res = track.toString();
				return true;
			}
		}
		for (int i = 1; i <= n; i++) {
			track.append("0");
			if(backtrack(set, track)) return true;
			track.deleteCharAt(track.length()-1);
			
			track.append("1");
			if(backtrack(set, track)) return true;
			track.deleteCharAt(track.length()-1);
		}
		return false;
	}

}
