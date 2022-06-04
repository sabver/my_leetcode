package leetcode.easy;

import leetcode.util.TreeNode;

public class DiameterOfBinaryTree {
	int max = Integer.MIN_VALUE;
	
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root) {
    	if( root == null ) {
    		return 0;
    	}
    	int left = helper(root.left);
    	int right = helper(root.right);
    	max = Math.max(left + right, max);
    	return Math.max(left, right) + 1;
    }
    
}
