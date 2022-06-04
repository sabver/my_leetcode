package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;

import leetcode.util.TreeNode;

public class SerializeAndDeserializeBST {

	String NULLMARK = "#";
	String COMA = ",";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuffer track = new StringBuffer();
		serializeHelper(root, track);
		return track.toString();
	}

	public void serializeHelper(TreeNode root, StringBuffer track) {
		// 前序
		if (root == null || root.val == Integer.MIN_VALUE) {
			track.append(NULLMARK).append(COMA);
			return;
		}
		track.append(root.val).append(COMA);
		serializeHelper(root.left, track);
		serializeHelper(root.right, track);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String array[] = data.split(COMA);
		LinkedList<String> track = new LinkedList<>(Arrays.asList(array));
		return deserializeHelper(track);
	}

	public TreeNode deserializeHelper(LinkedList<String> track) {
		if (track.isEmpty()) {
			return null;
		}
		String rootVal = track.removeFirst();
		if (NULLMARK.equals(rootVal)) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(rootVal));
		root.left = deserializeHelper(track);
		root.right = deserializeHelper(track);
		return root;
	}

	public static void main(String args[]) {
		int[] nums = new int[] { 5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2, Integer.MIN_VALUE, Integer.MIN_VALUE,
				Integer.MIN_VALUE, 1 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		SerializeAndDeserializeBST b = new SerializeAndDeserializeBST();
		String str = b.serialize(root);
		System.out.println(str);
	}
}
