package leetcode.easy;

public class ImplementStrStr {
	/**
	 * Return the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr2(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		int length = haystack.length();
		int subLength = needle.length();
		if (subLength > length) {
			return -1;
		}
		boolean isHit = false;
		int subIndex = 0;
		for (int i = 0; i < length - subLength + 1; i++) {
			// System.out.println(haystack.charAt(i));
			// System.out.println(needle.charAt(0));
			if (haystack.charAt(i) == needle.charAt(0)) {
				isHit = true;
				// System.out.println("begin");
				subIndex = i;
				for (int j = 0; j < subLength; j++) {
					if (haystack.charAt(subIndex) != needle.charAt(j)) {
						isHit = false;
					}
					subIndex++;
				}
				if (isHit) {
					return i;
				}
			}
		}
		return -1;
	}

	// -------------KMP------------
	/**
	 * 
	 * @param p
	 *            pattern
	 * @return pai prefix function
	 */
	public int[] computePrefixFunction(String p) {
		int length = p.length();
		int[] result = new int[length];
		// 第一个固定为没匹配
		result[0] = -1;
		// 匹配到的字符数目，这里为了对应下标从0开始的规则，要从-1开始，0代表匹配第一位...
		int matchNum = -1;
		// 这个循环从执行code2开始，之后只要有有匹配的但是发现下一个字符无法匹配的，就不断回退
		for (int i = 1; i < length; i++) {
			// 如果p的下一个无法匹配，就回退
			// code1
			while (matchNum > -1 && p.charAt(matchNum + 1) != p.charAt(i)) {
				matchNum = result[matchNum];
			}
			// System.out.println("1:" + p.charAt(matchNum + 1));
			// System.out.println("2:" + p.charAt(i));
			// code2
			if (p.charAt(matchNum + 1) == p.charAt(i)) {
				matchNum++;
			}
			result[i] = matchNum;
			// System.out.println("matchNum:" + matchNum);
		}
		// 为了给调用者一个更加直观的结果，给每个元素修正+1，还是不用了
		// for (int i = 0; i < length; i++) {
		// result[i]++;
		// }
		return result;
	}

	/**
	 * 从KMP算法获取所有匹配到的下标
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public int[] getKMPMatcherResult(String str, String pattern) {
		int strLength = str.length();
		int length = pattern.length();
		int resultLength = (int) Math.ceil((double) strLength / (double) length);
		int result[] = new int[resultLength];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		int prefixArray[] = computePrefixFunction(pattern);
		int matchNum = -1;
		int count = 0;
		for (int i = 0; i < strLength; i++) {
			while (matchNum > -1 && pattern.charAt(matchNum + 1) != str.charAt(i)) {
				// System.out.println("code1");
				matchNum = prefixArray[matchNum];
			}
			if (pattern.charAt(matchNum + 1) == str.charAt(i)) {
				// System.out.println("code2");
				matchNum++;
			}
			// 所有都匹配到了
			if (matchNum == length - 1) {
				// System.out.println("code3");
				result[count++] = i - length + 1;
				// 匹配完整一次后要回退
				matchNum = prefixArray[matchNum];
			}
		}
		return result;
	}
	/**
	 * 这里只返回第一次匹配位置
	 * @param str
	 * @param pattern
	 * @return
	 */
	public int getKMPMatcherResultOne(String str, String pattern) {
		int strLength = str.length();
		int length = pattern.length();
		int prefixArray[] = computePrefixFunction(pattern);
		int matchNum = -1;
		for (int i = 0; i < strLength; i++) {
			while (matchNum > -1 && pattern.charAt(matchNum + 1) != str.charAt(i)) {
				matchNum = prefixArray[matchNum];
			}
			if (pattern.charAt(matchNum + 1) == str.charAt(i)) {
				matchNum++;
			}
			// 所有都匹配到了
			if (matchNum == length - 1) {
				return i - length + 1;
			}
		}
		return -1;
	}

	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		int length = haystack.length();
		int subLength = needle.length();
		if (subLength > length) {
			return -1;
		}
		return getKMPMatcherResultOne(haystack, needle);
	}

	public void print(int[] result) {
		String str = "";
		for (int i = 0; i < result.length; i++) {
			str += (result[i] + " ");
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		ImplementStrStr s = new ImplementStrStr();
		// System.out.println(s.strStr("mississippi", "mississippi"));
		s.print(s.computePrefixFunction("a"));
		s.print(s.getKMPMatcherResult("aaa", "aa"));
	}
}
