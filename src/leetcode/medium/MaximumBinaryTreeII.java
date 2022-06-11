package leetcode.medium;

import leetcode.util.TreeNode;

public class MaximumBinaryTreeII {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    	if( root == null ) {
    		return new TreeNode(val);
    	}
    	if( root.val < val ) {
    		TreeNode res = new TreeNode(val);
    		res.left = root;
    		return res;
    	} else {
    		// root.val > val
    		root.right = insertIntoMaxTree(root.right, val);
    	}
        return root;
    }
}
