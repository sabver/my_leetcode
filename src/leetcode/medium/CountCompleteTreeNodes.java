package leetcode.medium;

import leetcode.util.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
    	if( root == null ) {
    		return 0;
    	}
    	int lh = 0, rh = 0;
    	TreeNode left = root.left;
    	while( left != null ) {
    		lh += 1;
    		left = left.left;
    	}
    	TreeNode right = root.right;
    	while( right != null ) {
    		rh += 1;
    		right = right.right;
    	}
    	if( lh == rh ) {
    		return (int) (Math.pow(2, lh + 1) - 1);
    	}
    	
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
