package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;
import leetcode.util.Util;

public class BinaryTreeZigzagLevelOrderTraversalV2 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		// 控制层次
		int level = 1;
		while (queue.size() > 0) {
			List<Integer> levelResult = new ArrayList<>();
			// 控制当层节点输出
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode cur = queue.poll();
				if (cur == null) {
					continue;
				}
				levelResult.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			if (levelResult.size() > 0) {
				if (level % 2 == 0) {
					List<Integer> temp = new ArrayList<>();
					int size = levelResult.size();
					for (int j = size - 1; j >= 0; j--) {
						temp.add(levelResult.get(j));
					}
					result.add(temp);
				} else {
					result.add(levelResult);
				}
			}
			level++;
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversalV2 s = new BinaryTreeZigzagLevelOrderTraversalV2();
		int array[] = { 1, 2, 3, 4, -1, -1, 5 };
		TreeNode root = TreeNode.createTreeByArray(array);
		System.out.println(root);
		Util.printList(s.zigzagLevelOrder(root));
	}

}
