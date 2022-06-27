package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesV2 {
	String LEFT = "(";
	String RIGHT = ")";
	List<String> res = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		backtrack(n * 2, 1, new StringBuffer(), 0);
		return res;
	}

	public void backtrack(int n, int start, StringBuffer track, int leftCount) {
		if (leftCount > n / 2) {
			return;
		}
		if (start == n + 1 && track.length() == n) {
			res.add(track.toString());
			return;
		}
		// 做选择 left
		track.append(LEFT);
		backtrack(n, start + 1, track, leftCount + 1);
		track.deleteCharAt(track.length() - 1);
		// 做选择 right
		int rightCount = track.length() - leftCount;
		if (leftCount > rightCount) {
			track.append(RIGHT);
			backtrack(n, start + 1, track, leftCount);
			track.deleteCharAt(track.length() - 1);
		}
	}

	public static void main(String[] args) {
		GenerateParenthesesV2 g = new GenerateParenthesesV2();
		int n = 3;
		List<String> result = g.generateParenthesis(n);
		System.out.println(result);
	}

}
