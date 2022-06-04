package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.TreeNode;
import leetcode.util.Util;

public class MostFrequentSubtreeSum {
	Map<Integer, Integer> countMap = new HashMap<>();
	int maxCount = Integer.MIN_VALUE;

	public int[] findFrequentTreeSum(TreeNode root) {
		sum(root);

		int len = 0;
		for (Integer count : countMap.values()) {
			if (count == maxCount) {
				len++;
			}
		}
		int[] res = new int[len];
		int index = 0;
		for (Integer ele : countMap.keySet()) {
			if (countMap.get(ele) == maxCount) {
				res[index] = ele;
				index++;
			}
		}
		return res;
	}

	public int sum(TreeNode root) {
		if (root == null || root.val == Integer.MIN_VALUE) {
			return 0;
		}

		int leftSum = sum(root.left);
		int rightSum = sum(root.right);
		int sum = root.val + leftSum + rightSum;

		countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
		maxCount = Math.max(countMap.get(sum), maxCount);

		return sum;
	}

	public void printMap() {
		for (Integer key : countMap.keySet()) {
			System.out.println("k:" + key + " v:" + countMap.get(key));
		}
	}

	public static void main(String args[]) {
		int[] nums = new int[] { 5, 14, Integer.MIN_VALUE, 1 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		MostFrequentSubtreeSum b = new MostFrequentSubtreeSum();
		int[] res = b.findFrequentTreeSum(root);
		Util.printArray(res);
		b.printMap();
	}

}
