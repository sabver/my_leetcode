package leetcode.medium;

public class LongestPalindromicSubstring {
	/**
	 * 先来个n平方的，看看怎么样
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s) {
		int length = s.length();
		System.out.println("length:" + length);
		if (length <= 1) {
			return s;
		}
		int maxI = 0, maxJ = 0, max = 0;
		for (int i = 0; i < length; i++) {
			for (int j = length - 1; j >= i; j--) {
				if (isPalindromic(s, i, j)) {
					if (j - i + 1 > max) {
						max = j - i + 1;
						maxI = i;
						maxJ = j;
					}
				}
			}
		}
		System.out.println("max:" + max);
		return s.substring(maxI, maxJ + 1);
	}

	public boolean isPalindromic(String s, int i, int j) {
		if (i == j || i > j) {
			return true;
		}
		if (s.charAt(i) == s.charAt(j)) {
			return isPalindromic(s, ++i, --j);
		} else {
			return false;
		}
	}

	public String longestPalindrome(String s) {
		int length = s.length();
		// System.out.println("length:" + length);
		// System.out.println();
		if (length <= 1) {
			return s;
		}
		int maxI = 0, maxJ = 0, max = 1;
		int begin = 0, end = 0;
		for (int i = 1; i < length; i++) {
			// 单源点
			begin = i - 1;
			end = i + 1;
			// System.out.println("begin-:" + begin);
			// System.out.println("end-:" + end);
			while (begin >= 0 && end <= length - 1) {
				// System.out.println("begin:" + begin);
				// System.out.println("end:" + end);
				// System.out.println();
				if (s.charAt(begin) != s.charAt(end)) {
					break;
				} else {
					if (end - begin + 1 > max) {
						max = end - begin + 1;
						maxI = begin;
						maxJ = end;
					}
					if (begin == 0 || end == length - 1) {
						break;
					} else {
						begin--;
						end++;
					}
				}
			}
			// 两个源点
			begin = i - 1;
			end = i;
			// System.out.println("2begin-:" + begin);
			// System.out.println("2end-:" + end);
			while (begin >= 0 && end <= length - 1) {
				// System.out.println("2begin:" + begin);
				// System.out.println("2end:" + end);
				// System.out.println();
				if (s.charAt(begin) != s.charAt(end)) {
					break;
				} else {
					if (end - begin + 1 > max) {
						max = end - begin + 1;
						maxI = begin;
						maxJ = end;
					}
					if (begin == 0 || end == length - 1) {
						break;
					} else {
						begin--;
						end++;
					}
				}
			}
		}
		// System.out.println("maxI:" + maxI);
		// System.out.println("maxJ:" + maxJ);
		// System.out.println("-------------------");
		return s.substring(maxI, maxJ + 1);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring s = new LongestPalindromicSubstring();
		long time = System.currentTimeMillis();
		String str = "bb";
		System.out.println(s.longestPalindrome(str));
		System.out.println("time:" + (System.currentTimeMillis() - time));
	}
}
