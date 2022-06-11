package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

public class CompleteBinaryTreeInserter {
	class CBTInserter {

		TreeNode parent;
		TreeNode root;
		Queue<TreeNode> queue;

		public CBTInserter(TreeNode root) {
			this.root = root;
			queue = new LinkedList<>();
			queue.offer(root);
			updateQueue();
			parent = queue.peek();
		}
		
		public void updateQueue() {
			while (queue.isEmpty() == false) {
				int sz = queue.size();
				boolean isPoll = false;
				for (int i = 0; i < sz; i++) {
					TreeNode node = queue.peek();
					if (node.left != null && node.right != null) {
						queue.poll();
						queue.offer(node.left);
						queue.offer(node.right);
						isPoll = true;
					}
					if (node.left == null || node.right == null) {
						break;
					}
				}
				if (isPoll == false) {
					break;
				}
			}
		}

		public int insert(int val) {
			int res = parent.val;
			if( parent.left == null ) {
				parent.left = new TreeNode(val);
			} else {
				parent.right = new TreeNode(val);
				// update parent
				updateQueue();
				parent = queue.peek();
			}
			return res;
		}

		public TreeNode get_root() {
			return root;
		}
	}

}
