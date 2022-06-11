package leetcode.easy;

import leetcode.util.TreeNode;

public class BinaryTreeTilt {
	int tilt = 0;
	
    public int findTilt(TreeNode root) {
    	sum(root);
        return tilt;
    }
    
    public int sum(TreeNode root) {
    	if( root == null ) {
    		return 0;
    	}
    	int leftSum = sum(root.left);
    	int rightSum = sum(root.right);
    	tilt += Math.abs(leftSum - rightSum);
    	return leftSum + rightSum + root.val;
    }
    
}
