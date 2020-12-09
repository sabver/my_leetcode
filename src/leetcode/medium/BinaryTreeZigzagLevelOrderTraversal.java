package leetcode.medium;

import java.util.*;
import leetcode.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> lastLevel = new Stack<TreeNode>();
		lastLevel.push(root);
		List<Integer> rootResult = new ArrayList<Integer>();
		rootResult.add(root.val);
		result.add(rootResult);
		zigzagLevelOrder(lastLevel, result, false);

		return result;
	}

	/**
	 * 
	 * @param lastStack
	 *            上一层所有的Stack
	 * @param result
	 * @param isLeftToRight
	 *            是否从左到右遍历
	 */
	public void zigzagLevelOrder(Stack<TreeNode> lastStack, List<List<Integer>> result, boolean isLeftToRight) {
		List<Integer> curLevelResult = new ArrayList<Integer>();
		Stack<TreeNode> curStack = new Stack<TreeNode>();
		TreeNode cur = null;
		while (lastStack.isEmpty() == false) {
			cur = lastStack.pop();
			if (isLeftToRight) {
				if (cur.left != null) {
					curStack.push(cur.left);
					curLevelResult.add(cur.left.val);
				}
				if (cur.right != null) {
					curStack.push(cur.right);
					curLevelResult.add(cur.right.val);
				}
			} else {
				if (cur.right != null) {
					curStack.push(cur.right);
					curLevelResult.add(cur.right.val);
				}
				if (cur.left != null) {
					curStack.push(cur.left);
					curLevelResult.add(cur.left.val);
				}
			}
		}
		if (curLevelResult.size() != 0) {
			result.add(curLevelResult);
			zigzagLevelOrder(curStack, result, !isLeftToRight);
		}
	}

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
		int array[] = new int[15];
		for (int i = 1; i <= array.length; i++) {
			array[i - 1] = i;
		}
		TreeNode root = TreeNode.createTreeByArray(array);
		System.out.println(root);
		Util.printList(s.zigzagLevelOrder(root));
	}
}
