package leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;

import leetcode.util.TreeNode;

public class SerializeAndDeserializeBinaryTree {
	// Encodes a tree to a single string.
	StringBuffer res = new StringBuffer();
	String SEP = "#";
	String COMMA = ",";

	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		preorder(root);
		// delete latest comma
		res.deleteCharAt(res.length() - 1);
		return res.toString();
	}

	public void preorder(TreeNode root) {
		if (root == null) {
			res.append(SEP);
			res.append(COMMA);
			return ;
		}
		res.append(root.val);
		res.append(COMMA);
		preorder(root.left);
		preorder(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if( data == null || data.length()  == 0) {
			return null;
		}
		String[] strs = data.split(COMMA);
		LinkedList<String> list = new LinkedList<>(Arrays.asList(strs));
		return preorderDe(list);
	}

	public TreeNode preorderDe(LinkedList<String> list) {
		String nodeStr = list.pollFirst();
		TreeNode root = null;
		if (nodeStr == null || SEP.equals(nodeStr)) {
			return root;
		} else {
			root = new TreeNode(Integer.parseInt(nodeStr));
		}
		TreeNode left = preorderDe(list);
		TreeNode right = preorderDe(list);
		root.left = left;
		root.right = right;
		return root;
	}
}
