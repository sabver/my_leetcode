package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class PathSumII {
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    	helper(root, targetSum, new ArrayList<Integer>());
        return res;
    }
    
    public void helper(TreeNode root, int targetSum, List<Integer> trace) {
    	if( root == null ) {
    		return ;
    	}
    	trace.add(root.val);
    	if( root.left == null && root.right == null && targetSum == root.val ) {
    		res.add(new ArrayList<>(trace));
    	}    	
    	helper(root.left, targetSum - root.val, trace);
    	helper(root.right, targetSum - root.val, trace);
    	trace.remove(trace.size() - 1);
    }
}
