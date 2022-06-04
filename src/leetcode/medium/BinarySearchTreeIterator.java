package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

class BSTIterator1 {

	List<TreeNode> list = new ArrayList<>();

	public void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);
		list.add(root);
		helper(root.right);
	}

	int pointer = -1;

	public BSTIterator1(TreeNode root) {
		helper(root);
	}

	public int next() {
		return list.get(++pointer).val;
	}

	public boolean hasNext() {
		return pointer < list.size() - 1;
	}
}

class BSTIterator {

	Stack<TreeNode> stack = new Stack<>();

	public BSTIterator(TreeNode root) {
		pushLeftBranch(root);
	}

	public void pushLeftBranch(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public int next() {
		TreeNode node = stack.pop();
		pushLeftBranch(node.right);
		return node.val;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}
}

public class BinarySearchTreeIterator {

}
