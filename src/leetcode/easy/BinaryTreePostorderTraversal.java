package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class BinaryTreePostorderTraversal {
	List<Integer> res = new ArrayList<>();

	public List<Integer> postorderTraversal(TreeNode root) {
		helper(root);
		return res;
	}

	public void helper(TreeNode root) {
		if (root == null) {
			return;
		}		
		helper(root.left);
		helper(root.right);
		res.add(root.val);
	}
}
