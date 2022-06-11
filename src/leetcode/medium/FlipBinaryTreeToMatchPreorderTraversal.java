package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

public class FlipBinaryTreeToMatchPreorderTraversal {
	List<Integer> res = new ArrayList<>();
	int cursor = 0;

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		if (root == null) {
			if (voyage.length != 0) {
				res.add(-1);
			}
			return res;
		}
//		Queue<Integer> queue = new LinkedList<>();
//		for (int i = 0; i < voyage.length; i++) {
//			queue.offer(voyage[i]);
//		}
		boolean isOk = match(root, voyage);
		if( isOk ) {
			return res;
		} else {
			res = new ArrayList<>();
			res.add(-1);
			return res;
		}
	}

	// 这里的root要控制不能出现null
	public boolean match(TreeNode root, int[] voyage) {		
		// base 要检查一下是否越界
		boolean isRootOk = voyage[cursor++] == root.val;
		if( !isRootOk ) {
			return false;
		}
		int tempCursor = cursor;
		boolean left = root.left == null ? true : match(root.left, voyage);
		boolean right = root.right == null ? true : match(root.right, voyage);
		boolean noFilp = left && right;
		if( !noFilp ) {
			cursor = tempCursor;
			boolean left2 = root.right == null ? true : match(root.right, voyage);
			boolean right2 = root.left == null ? true : match(root.left, voyage);
			boolean filp = left2 && right2;
			if( filp ) {
				res.add(root.val);
			}
			return filp;
		} else {
			return true;
		}
	}
}
