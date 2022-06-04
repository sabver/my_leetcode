package leetcode.easy;

import leetcode.util.TreeNode;

public class BalancedBinaryTree {
	boolean isOk = true;
    public boolean isBalanced(TreeNode root) {
    	postorder(root);
        return isOk;
    }
    
    public int postorder(TreeNode root) {
    	if( root == null ) {
    		return 0;
    	}
    	int leftHeight = postorder(root.left);
    	int rightHeight = postorder(root.right);
    	if( Math.abs(rightHeight - leftHeight) > 1 ) {
    		isOk = false;
    	}
    	return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
    	
    }
}
