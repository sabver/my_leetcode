package leetcode.medium;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[][] records = new int[n][n];
		return numTrees(1, n, records);
	}

	public int numTrees(int start, int end, int[][] records) {
		if (start > end) {
			return 0;
		}
		if (records[start - 1][end - 1] != 0) {
			return records[start-1][end-1];
		}
		if (start == end) {
			return 1;
		}
		int count = 0, leftCount = 0, rightCount = 0;
		for (int i = start; i <= end; i++) {
			leftCount = numTrees(start, i - 1, records);
			rightCount = numTrees(i + 1, end, records);
			if (leftCount == 0) {
				count += rightCount;
			} else if (rightCount == 0) {
				count += leftCount;
			} else {
				count += (leftCount * rightCount);
			}
		}
		records[start - 1][end - 1] = count;
		return count;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
		int n = 19;
		System.out.println(s.numTrees(n));
	}
}
