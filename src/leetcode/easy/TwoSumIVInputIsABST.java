package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import leetcode.util.TreeNode;

public class TwoSumIVInputIsABST {
	Set<Integer> set = new HashSet<>();
//	Set<Integer> bstVals = new HashSet<>();
	int target = 0;
	boolean res = false;

	public boolean findTarget(TreeNode root, int k) {
		target = k;
		inorder(root);
		return res;
	}

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		set.add(target - root.val);
//		bstVals.add(root.val);
		inorder(root.right);
		if (set.contains(root.val) && root.val * 2 != target) {
			res = true;
		}
	}

}
