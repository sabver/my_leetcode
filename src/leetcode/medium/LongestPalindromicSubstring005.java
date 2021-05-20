package leetcode.medium;

public class LongestPalindromicSubstring005 {

	/**
	 * 返回最长回文子串
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		int len = s.length();
		String p1 = "", p2 = "", result = "", temp = "";
		for (int i = 0; i < len; i++) {
			p1 = palindrome(s, i, i);
			p2 = palindrome(s, i, i + 1);
			if (p1.length() > p2.length()) {
				temp = p1;
			} else {
				temp = p2;
			}
			if (temp.length() > result.length()) {
				result = temp;
			}
		}
		return result;
	}

	/**
	 * 返回已leftCenter和rightCenter为中心的回文子串
	 * 
	 * @param s
	 * @param leftCenter  左侧中心
	 * @param rightCenter 右侧中心
	 * @return
	 */
	public String palindrome(String s, int leftCenter, int rightCenter) {
		while (leftCenter >= 0 && rightCenter <= s.length() - 1 && s.charAt(leftCenter) == s.charAt(rightCenter)) {
			leftCenter--;
			rightCenter++;
		}
		return s.substring(leftCenter + 1, rightCenter);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring005 s = new LongestPalindromicSubstring005();
		long time = System.currentTimeMillis();
		String str = "bb";
		System.out.println(s.longestPalindrome(str));
		System.out.println("time:" + (System.currentTimeMillis() - time));
	}
}
