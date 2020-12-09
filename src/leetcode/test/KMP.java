package leetcode.test;

import leetcode.util.Util;

public class KMP {
	private String pat;
	private int[][] dfa;

	public KMP(String pat) {
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for (int X = 0, j = 1; j < M; j++) {
			System.out.println("X:" + X);
			for (int c = 0; c < R; c++) {
				dfa[c][j] = dfa[c][X];
			}
			dfa[pat.charAt(j)][j] = j + 1;
			X = dfa[pat.charAt(j)][X];
		}
		Util.printArray(dfa);
	}

	public static void main(String[] args) {
		String pat = "ABCDDBCAG";
		KMP k = new KMP(pat);
		
	}

}
