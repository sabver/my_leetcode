package leetcode.medium;

import java.util.Arrays;

import leetcode.util.Util;

public class MatchsticksToSquare {
	int[] sum = { 0, 0, 0, 0 };

	public boolean makesquare(int[] matchsticks) {
		int sum = 0;
		for (int i = 0; i < matchsticks.length; i++) {
			sum += matchsticks[i];
		}
		Util.p(sum);
		if (sum % 4 != 0) {
			return false;
		}
		int avg = sum / 4;
		Util.p(avg);
		Arrays.sort(matchsticks);
		int[] matchsticks2 = new int[matchsticks.length];
		int index = 0;
		for (int i = matchsticks.length - 1; i >= 0; i--) {
			matchsticks2[index++] = matchsticks[i];
		}
		Util.printArray(matchsticks);
		Util.printArray(matchsticks2);
		return backtrack(matchsticks2, 0, avg);
	}

	public boolean backtrack(int[] matchsticks, int start, int avg) {
		Util.printArray(sum);
		if (start == matchsticks.length) {
			if (sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3] && sum[0] == sum[3]) {
				return true;
			}
			return false;
		}
		for (int i = 0; i < sum.length; i++) {
			if (sum[i] + matchsticks[start] > avg) {
				continue;
			}
			sum[i] += matchsticks[start];
			if (backtrack(matchsticks, start + 1, avg)) {
				return true;
			}
			sum[i] -= matchsticks[start];
		}

		return false;
	}

	public static void main(String[] args) {
		MatchsticksToSquare m = new MatchsticksToSquare();
		// {10,6,5,5,5,3,3,3,2,2,2,2}
		// { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 102 }
		// 6 3 3, 10 2, 5 5 2, 5,3,2,2
		int[] matchsticks = { 10, 6, 5, 5, 5, 3, 3, 3, 2, 2, 2, 2 };
		Util.p(m.makesquare(matchsticks));
	}

}
