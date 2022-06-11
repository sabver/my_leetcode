package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;

import leetcode.util.TreeNode;

public class SmallestStringStartingFromLeaf {
	List<String> tracks = null;
	String abc = "abcdefghijklmnopqrstuvwxyz";
	char[] dict = abc.toCharArray();

	public String smallestFromLeaf(TreeNode root) {
		if (root == null) {
			return "";
		}
		tracks = new ArrayList<>();
		Stack<Integer> track = new Stack<>();
		helper(root, track);
//		System.out.println(tracks);
		Collections.sort(tracks);
//		System.out.println(tracks);
		return tracks.get(0);
	}

	public void helper(TreeNode root, Stack<Integer> track) {
		if (root == null || root.val == Integer.MIN_VALUE) {
			return;
		}		
		track.push(root.val);
//		System.out.println("root:" + root.val + " " + track.toString());
		if (root.left == null && root.right == null) {
			StringBuffer sb = new StringBuffer();
			int sz = track.size();
			for (int i = sz - 1; i >= 0; i--) {
				sb.append(dict[track.get(i)]);
			}
			tracks.add(sb.toString());
		}
		helper(root.left, track);
		helper(root.right, track);
		track.pop();
	}

	public static void main(String[] args) {
		SmallestStringStartingFromLeaf s = new SmallestStringStartingFromLeaf();
//		int[] nums = new int[] { 0, 1, 2, 3, 4, 3, 4 };
//		int[] nums = new int[] { 25, 1, 3, 1, 3, 0, 2 };
		int[] nums = new int[] { 2, 2, 1, Integer.MIN_VALUE, 1, 0, Integer.MIN_VALUE, 0 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		s.smallestFromLeaf(root);
	}

}
