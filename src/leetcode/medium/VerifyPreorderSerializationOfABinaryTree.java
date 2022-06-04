package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class VerifyPreorderSerializationOfABinaryTree {
	String SEP = "#";
	String COMMA = ",";

	public boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.length() == 0) {
			return true;
		}
		String[] strs = preorder.split(COMMA);
		LinkedList<String> list = new LinkedList<>(Arrays.asList(strs));
		System.out.println("list size: " + list.size());
		return preorder(list) && list.isEmpty();
	}

	public boolean preorder(LinkedList<String> list) {
		System.out.println("2 list size: " + list.size());
		if (list.isEmpty()) {
			return false;
		}
		String nodeStr = list.pollFirst();
		System.out.println("node: " + nodeStr);
		if (SEP.equals(nodeStr)) {
			return true;
		}
		return preorder(list) && preorder(list);
	}

	public static void main(String args[]) {
		VerifyPreorderSerializationOfABinaryTree v = new VerifyPreorderSerializationOfABinaryTree();
		String preorder = "9,#,#,1";
		boolean res = v.isValidSerialization(preorder);
		System.out.println("res:" + res);
	}

}
