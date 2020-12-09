package leetcode.medium;

import java.util.*;
import leetcode.util.*;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<TreeNode> lastLevel = new ArrayList<TreeNode>();
		lastLevel.add(root);
		List<Integer> rootResult = new ArrayList<Integer>();
		rootResult.add(root.val);
		result.add(rootResult);
		levelOrder(lastLevel, result);
		return result;
	}

	/**
	 * 
	 * @param lastLevel
	 *            上一层所有的TreeNode
	 * @param result
	 *            保留结果
	 */
	public void levelOrder(List<TreeNode> lastLevel, List<List<Integer>> result) {
		List<Integer> curLevelResult = new ArrayList<Integer>();
		List<TreeNode> curLevel = new ArrayList<TreeNode>();
		for (TreeNode node : lastLevel) {
			if (node.left != null) {
				curLevelResult.add(node.left.val);
				curLevel.add(node.left);
			}
			if (node.right != null) {
				curLevelResult.add(node.right.val);
				curLevel.add(node.right);
			}
		}
		if (curLevelResult.size() != 0) {
			result.add(curLevelResult);
			levelOrder(curLevel, result);
		}
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal s = new BinaryTreeLevelOrderTraversal();
		int array[] = { 3, 9, 20, -1, -1, 15, 7 };
		TreeNode root = TreeNode.createTreeByArray(array);
		System.out.println(root);
		Util.printList(s.levelOrder(root));
	}
}
