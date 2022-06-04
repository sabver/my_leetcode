package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.TreeNode;

public class FindModeInBinarySearchTree {
	Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
	int maxCount = Integer.MIN_VALUE;

	public int[] findMode(TreeNode root) {
		helper(root);
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

	public void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		int val = root.val;
		if (countMap.containsKey(val)) {
			countMap.put(val, countMap.get(val) + 1);
		} else {
			countMap.put(val, 1);
		}
		int count = countMap.get(val);
		maxCount = Math.max(count, maxCount);
		helper(root.left);
		helper(root.right);
	}
}
