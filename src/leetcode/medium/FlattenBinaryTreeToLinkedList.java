package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
    	if( root == null ) {
    		return ;
    	}
    	preorder(root);
    	TreeNode pre = null;
    	for(TreeNode node: list) {
    		if( pre != null ) {
    			pre.left = null;
    			pre.right = node;
    		}
    		pre = node;
    	}
    }
    
    public void preorder(TreeNode root) {
    	if( root == null ) {
    		return ;
    	}
    	// 前序
    	list.add(root);
    	preorder(root.left);
    	preorder(root.right);
    }
}
