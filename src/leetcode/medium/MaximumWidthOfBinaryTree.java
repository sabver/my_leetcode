package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;
import leetcode.util.Util;

public class MaximumWidthOfBinaryTree {
	int dummy = 101;

	class Pair {
		TreeNode node;
		int id;

		public Pair(TreeNode node, int id) {
			this.node = node;
			this.id = id;
		}

	}

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = 0;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(root, 1));
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			int start = 0, end = 0;
			for (int i = 0; i < sz; i++) {
				Pair pair = queue.poll();
				if (i == 0) {
					start = pair.id;
				}
				if (i == sz - 1) {
					end = pair.id;
				}
				if (pair.node.left != null) {
					queue.offer(new Pair(pair.node.left, pair.id * 2));
				}
				if (pair.node.right != null) {
					queue.offer(new Pair(pair.node.right, pair.id * 2 + 1));
				}
			}
			res = Math.max(res, end - start + 1);
		}
		return res;
	}

	// 超时
	public int widthOfBinaryTree2(TreeNode root) {
		if (root == null || root.val == Integer.MIN_VALUE) {
			return 0;
		}
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			boolean isAllDummy = true;
			boolean isHave = false;
			int start = 0, end = 0;
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.val != dummy) {
					isAllDummy = false;
					if (isHave == false) {
						start = i;
						isHave = true;
					}
					end = i;
				}
				if (node.left != null) {
					queue.offer(node.left);
				} else {
					// dummy
					queue.offer(new TreeNode(dummy));
				}
				if (node.right != null) {
					queue.offer(node.right);
				} else {
					queue.offer(new TreeNode(dummy));
				}
			}
			if (isAllDummy) {
				break;
			} else {
				// update width
				res = Math.max(res, end - start + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MaximumWidthOfBinaryTree m = new MaximumWidthOfBinaryTree();
		int[] nums = new int[] { 1, 1, 1, 1, 1, 1, 1, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 1,
				Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 2, 2, 2, 2, 2, 2, 2,
				Integer.MIN_VALUE, 2, Integer.MIN_VALUE, Integer.MIN_VALUE, 2, Integer.MIN_VALUE, 2 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		Util.printBinaryTree(root);
		System.out.println("res:" + m.widthOfBinaryTree(root));
	}
}
