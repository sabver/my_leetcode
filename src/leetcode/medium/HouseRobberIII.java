package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.TreeNode;

public class HouseRobberIII {

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Map<Integer, Map<Boolean, Integer>> memo = new HashMap<>();
		return Math.max(helper(root, true, memo, 0), helper(root, false, memo, 0));
	}

	public int helper(TreeNode root, boolean broken, Map<Integer, Map<Boolean, Integer>> memo, int index) {
		if (root == null || root.val == -1) {
			return 0;
		}
		if (memo.containsKey(index) && memo.get(index).containsKey(broken)) {
			return memo.get(index).get(broken);
		}
		int res = 0, left = 0, right = 0, leftIndex = 2 * index + 1, rightIndex = 2 * index + 2;
		if (broken) {
			res = root.val;
		}
		if (broken) {
			left = helper(root.left, false, memo, leftIndex);
			right = helper(root.right, false, memo, rightIndex);
		} else {
			// 这里需要选择要不要broken
			// max( helper(root.left, false), helper()
			left = Math.max(helper(root.left, false, memo, leftIndex), helper(root.left, true, memo, leftIndex));
			right = Math.max(helper(root.right, false, memo, rightIndex), helper(root.right, true, memo, rightIndex));
		}
		int max = res + left + right;
		// memo
		if (memo.containsKey(index)) {
			memo.get(index).put(broken, max);
		} else {
			Map<Boolean, Integer> map = new HashMap<Boolean, Integer>();
			map.put(broken, max);
			memo.put(index, map);
		}
		return max;
	}

	public static void main(String[] args) {
		HouseRobberIII v = new HouseRobberIII();
//		TreeNode root = TreeNode.createTreeByArray(new int[] { 3, 2, 3, -1, 3, -1, 1 });
		TreeNode root = TreeNode.createTreeByArray(new int[] { 3, 4, 5, 1, 3, -1, 1 });
		int max = v.rob(root);
		System.out.println("max:" + max);
	}

}
