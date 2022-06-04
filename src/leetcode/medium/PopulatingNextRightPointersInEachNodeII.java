package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.Node;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
		if (root == null) {
			return root;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			Node pre = null;
			for (int i = 0; i < sz; i++) {
				Node node = queue.poll();
				if (pre != null) {
					pre.next = node;
				}
				pre = node;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return root;
    }
}
