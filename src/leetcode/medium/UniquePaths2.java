package leetcode.medium;

/**
 * 用动态规划实现
 * 
 * @author yejianfeng
 *
 */
public class UniquePaths2 {

	/**
	 * 
	 * @param m
	 *            row
	 * @param n
	 *            column
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		if (m == 1 && n == 1) {
			return 1;
		}
		if (m == 1) {
			return uniquePaths(m, n - 1);
		}
		if (n == 1) {
			return uniquePaths(m - 1, n);
		}
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

	public static void main(String[] args) {
		UniquePaths2 s = new UniquePaths2();
		int m = 10;
		int n = 9;
		System.out.println(s.uniquePaths(m, n));
	}
}
