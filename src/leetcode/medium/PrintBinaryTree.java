package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;
import leetcode.util.Util;

public class PrintBinaryTree {
	String EMPTY = "";
	int rows = 0, columns = 0;
	List<List<String>> res = new ArrayList<>();
	int height = 0;

	public List<List<String>> printTree(TreeNode root) {
		if( root == null ) {
			return res;
		}
		height = height(root);
		// init
		rows = height + 1;
		columns = (int) (Math.pow(2, height + 1) - 1);
		for (int i = 0; i < rows; i++) {
			res.add(new ArrayList<>());
			for (int j = 0; j < columns; j++) {
				res.get(i).add(EMPTY);
			}
		}
//		Util.printListStr(res);
		helper(root, 0, (columns - 1) / 2);
		Util.printListStr(res);
		return res;
	}

	public void helper(TreeNode root, int rowsIndex, int columnIndex) {
		if (root == null || rowsIndex < 0 || rowsIndex >= rows || columnIndex < 0 || columnIndex >= columns || root.val == Integer.MIN_VALUE) {
			return;
		}
		res.get(rowsIndex).set(columnIndex, root.val + "");
		int offset = (int) Math.pow(2, height - rowsIndex - 1);
		helper(root.left, rowsIndex + 1, columnIndex - offset);
		helper(root.right, rowsIndex + 1, columnIndex + offset);
	}

	public int height(TreeNode root) {
		int height = 0;
		if (root == null || root.val == Integer.MIN_VALUE) {
			return height;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			if (queue.isEmpty() == false) {
				height++;
			}
		}
		return height;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1 };
//		int[] nums = new int[] { 1, 2, 3, Integer.MIN_VALUE, 4 };
//		int[] nums = new int[] { 1, 2 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		PrintBinaryTree p = new PrintBinaryTree();
		int height = p.height(root);
		System.out.println("height:" + height);
		p.printTree(root);
	}

}
