package leetcode.easy;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int len = 0;
		char[] chars = s.toCharArray();
		boolean isHaveWord = false;
		for (int i = chars.length - 1; i >= 0; i--) {
			// 如果遇到空格同时之前已经遇过word那就end
			if (chars[i] == ' ') {
				if (isHaveWord) {
					return len;
				}
			} else {
				len++;
				isHaveWord = true;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		LengthOfLastWord s = new LengthOfLastWord();
		String str = "     ";
		System.out.println(s.lengthOfLastWord(str));
	}
}
