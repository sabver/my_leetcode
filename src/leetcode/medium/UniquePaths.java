package leetcode.medium;

public class UniquePaths {

	/**
	 * 将问题转化为排列组合问题，right的次数为m-1,down的次数为n-1，求两者可以组成的唯一排列的数量
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		m--;
		n--;
		// 求 (m+n)!/(m!n!)
		// 即((m+n)...m+1)/n!
		if (m >= n) {
			return cal(m, n);
		} else {
			return cal(n, m);
		}
	}

	/**
	 * 求((m+n)...m+1)/n! 这里为了减少循环次数，要求n<m
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int cal(int m, int n) {
		long result = 1;
		for (int i = m + 1; i <= m + n; i++) {
			result *= i;
		}
		Long answer = result / factorial(n);
		return answer.intValue();
	}

	/**
	 * 求n的阶乘F
	 * 用long防越界
	 * @param n
	 * @return
	 */
	public long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		UniquePaths s = new UniquePaths();
		int m = 10;
		int n = 9;
		System.out.println(s.uniquePaths(m, n));
	}
}
