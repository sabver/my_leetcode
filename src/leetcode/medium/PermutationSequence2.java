package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence2 {

	public String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		StringBuffer result = new StringBuffer();
		// 当前次序
		int curK = 0;
		// n-1的阶乘
		int f = 0;
		for (int i = 1; i <= n; i++) {
			f = factorial(n - i);
			if (k % f == 0) {
				curK = k / f;
			} else {
				curK = k / f + 1;
			}
			result.append(list.get(curK - 1));
			list.remove(curK - 1);
			k -= ((curK - 1) * f);
		}
		return result.toString();
	}

	/**
	 * 求n的阶乘F
	 * 
	 * @param n
	 * @return
	 */
	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		PermutationSequence2 s = new PermutationSequence2();
		int n =2;
		int k = 1;
		System.out.println(s.getPermutation(n, k));
	}
}
