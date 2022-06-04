package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class BinaryTreePaths {
	List<String> res = new ArrayList<>();
	String SYMBOL = "->";

	public List<String> binaryTreePaths(TreeNode root) {
		helper(root, new ArrayList<>());
		return res;
	}

	public String changeTrackToString(List<Integer> track) {
		StringBuffer temp = new StringBuffer();
		int len = track.size();
		for (int i = 0; i < len; i++) {
			temp.append(track.get(i));
			if (i != len - 1) {
				temp.append(SYMBOL);
			}
		}
		return temp.toString();
	}

	public void helper(TreeNode root, List<Integer> track) {
		if (root == null) {
			return;
		}
		track.add(root.val);
		if (root.left == null && root.right == null) {
			// record
			res.add(changeTrackToString(track));
		}
		helper(root.left, track);
		helper(root.right, track);
		track.remove(track.size() - 1);
	}
}
