package leetcode.medium;

/**
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/
 * 
 * @author yejianfeng
 *
 */
public class UniqueBinarySearchTreesV2 {
	public int numTrees(int n) {
		int[][] memo = new int[n + 1][n + 1];
		return helper(1, n, memo);
	}
	
	public int helper(int low, int high, int[][] memo) {
		// 探索完毕
		if (low > high) {
			return 1;
		}
		if( memo[low][high] != 0 ) {
			return memo[low][high];
		}
		int sum = 0;
		for (int i = low; i <= high; i++) {
			int leftNum = helper(low, i - 1, memo);
			int rightNum = helper(i + 1, high, memo);
			sum += leftNum * rightNum;
		}
		memo[low][high]= sum;
		return sum;
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTreesV2 s = new UniqueBinarySearchTreesV2();
		s.numTrees(3);
	}
}
