package leetcode.medium;

public class MaximumCompatibilityScoreSum {
	int res;
	boolean[] used;

	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
		used = new boolean[mentors.length];
		backtrack(students, mentors, 0, 0);
		return res;
	}

	public void backtrack(int[][] students, int[][] mentors, int s, int sum) {
		if (s == students.length) {
			res = Math.max(res, sum);
			return;
		}
		for (int i = 0; i < mentors.length; i++) {
			if (used[i]) {
				continue;
			}
			int value = getScore(students[s], mentors[i]);
			sum += value;
			used[i] = true;
			backtrack(students, mentors, s + 1, sum);
			used[i] = false;
			sum -= value;
		}
	}

	public int getScore(int[] student, int[] mentor) {
		int sum = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i] == mentor[i]) {
				sum++;
			}
		}
		return sum;
	}
}
