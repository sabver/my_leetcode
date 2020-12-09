package leetcode.easy;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 * 
 * @author yejianfeng
 *
 */
public class Palindrome {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int tenMap = 1000000000;
		int frontNum = 0;
		int lastNum = 0;
		boolean isBeginCount = false;
		while (tenMap != 0) {
			frontNum = x / tenMap;
			if (frontNum != 0) {
				isBeginCount = true;
			}
			if (isBeginCount) {
				lastNum = x % 10;
				if (frontNum != lastNum) {
					return false;
				}
				// 去头去尾
				x = (x - lastNum - frontNum * tenMap) / 10;
				tenMap /= 100;
			} else {
				tenMap /= 10;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Palindrome pd = new Palindrome();
		System.out.println(pd.isPalindrome(100030001));
	}
}
