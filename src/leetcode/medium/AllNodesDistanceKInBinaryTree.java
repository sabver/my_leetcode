package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import leetcode.util.TreeNode;

public class AllNodesDistanceKInBinaryTree {

	Map<Integer, Set<Integer>> graphMap = new HashMap<>();

	TreeNode target = null;
	int k = 0;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> res = new ArrayList<>();
		if (root == null || target == null) {
			return res;
		}
		this.target = target;
		this.k = k;
		buildGraphMap(root);
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> markSet = new HashSet<>();
		queue.offer(target.val);
		markSet.add(target.val);
		int level = 0;
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				Integer node = queue.poll();
				if (level == k) {
					res.add(node);
				}
				Set<Integer> subTree = graphMap.get(node);
				if (subTree != null) {
					for (Integer subNode : subTree) {
						if (markSet.contains(subNode) == false) {
							queue.offer(subNode);
							markSet.add(subNode);
						}
					}
				}
			}
			level++;
		}
		return res;
	}

	public void link(Integer key, Integer value) {
		Set<Integer> set = null;
		if (graphMap.containsKey(key)) {
			set = graphMap.get(key);
		} else {
			set = new HashSet<Integer>(3);
		}
		set.add(value);
		graphMap.put(key, set);
	}

	public void buildGraphMap(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
					link(node.val, node.left.val);
					link(node.left.val, node.val);
				}
				if (node.right != null) {
					queue.offer(node.right);
					link(node.val, node.right.val);
					link(node.right.val, node.val);
				}
			}
		}
	}

	public static void main(String[] args) {
		AllNodesDistanceKInBinaryTree a = new AllNodesDistanceKInBinaryTree();

	}

}
