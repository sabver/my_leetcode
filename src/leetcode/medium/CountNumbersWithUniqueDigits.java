package leetcode.medium;

import leetcode.util.Util;

public class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		return backtrack(n);
	}

	// n>=canNum
	public int backtrack(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 10;
		}
		return coutMSB(n) + backtrack(n - 1);
	}

	public int coutMSB(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 10;
		}
		int sum = 1;
		for (int i = n; i >= 1; i--) {
			if (i == n || i == n - 1) {
				sum *= 9;
			} else {
				// 8=>n-3
				// 7=>n-4
				sum *= (i - n + 10);
			}
		}
		return sum;
	}

	public static void main(String args[]) {
		CountNumbersWithUniqueDigits c = new CountNumbersWithUniqueDigits();
		int n = 5;
		int res = c.coutMSB(n);
		Util.p(res);
		Util.p(9 * 9 * 8 * 7 * 6);
	}

}
