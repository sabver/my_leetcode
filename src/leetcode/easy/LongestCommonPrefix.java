package leetcode.easy;

public class LongestCommonPrefix {
	/**
	 * Runtime: 12 ms
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		int length = strs.length;
		if (length == 0) {
			return "";
		}
		if (length == 1) {
			return strs[0];
		}
		int[] lengths = new int[length];
		String result = "";
		for (int i = 0; i < length; i++) {
			lengths[i] = strs[i].length();
		}
		int minIndex = 0;
		for (int i = 1; i < length; i++) {
			if (strs[i].length() < strs[minIndex].length()) {
				minIndex = i;
			}
		}
		int minLength = strs[minIndex].length();
		char cur = 'a';
		for (int j = 0; j < minLength; j++) {
			cur = strs[minIndex].charAt(j);
			for (int i = 0; i < length; i++) {
				if( cur != strs[i].charAt(j) ){
					return result;
				}
			}
			result += (""+cur);
		}
		return result;
	}

	public static void main(String[] args) {
		LongestCommonPrefix instance = new LongestCommonPrefix();
		String[] strs = { "aaxgdhdfh", "aa", "aaaaaa", "aa" };
		System.out.println(instance.longestCommonPrefix(strs));
	}
}
