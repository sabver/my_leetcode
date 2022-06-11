package leetcode.medium;


import leetcode.util.TreeNode;

public class LongestUnivaluePath {
	int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }    	
    	maxLen(root, root.val);
    	return res;
    }
    /**
     * 定义为parent的val为parentVal的时候，已root为根的最长连续的length
     * @param root
     * @param parentVal
     */
    public int maxLen(TreeNode root, int parentVal) {
    	if( root == null ) {
    		return 0;
    	}
    	int leftMax = maxLen(root.left, root.val);
    	int rightMax = maxLen(root.right, root.val);
    	
    	res = Math.max(res, leftMax + rightMax);
    	// 不连续了，因为是已root为根的
    	if( root.val != parentVal ) {
    		return 0;
    	}
    	return 1 + Math.max(leftMax, rightMax);
    }
}
