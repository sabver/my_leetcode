package leetcode.medium;

import leetcode.util.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
	int res;
    public int maxAncestorDiff(TreeNode root) {
    	helper(root, root.val, root.val);
    	return res;
    }
    
    public void helper(TreeNode root, int min, int max) {
    	if( root == null ) {
    		return ;
    	}
    	// update res
    	res = Math.max(res, Math.abs(max - root.val));
    	res = Math.max(res, Math.abs(min - root.val));
    	min = Math.min(min, root.val);
    	max = Math.max(max, root.val);
    	helper(root.left, min, max);
    	helper(root.right, min, max);
    }
    
}
