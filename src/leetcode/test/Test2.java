package leetcode.test;

public class Test2 {

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, };
		int n = 4;
		for (int l = 1; l <= n; l++) {
			for (int i = 0; i < n - l; i++) {
				int j = l + i - 1;
				System.out.println(i+","+j);
			}
		}
	}
}
