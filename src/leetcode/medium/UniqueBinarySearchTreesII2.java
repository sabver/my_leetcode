package leetcode.medium;

import java.util.*;
import leetcode.util.*;

public class UniqueBinarySearchTreesII2 {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> result = null;
		result = generateTrees(1, n);
		return result;
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			return result;
		}
		if (start == end) {
			result.add(new TreeNode(start));
			return result;
		}
		List<TreeNode> left, right;
		TreeNode root;
		for (int i = start; i <= end; i++) {
			left = generateTrees(start, i - 1);
			right = generateTrees(i + 1, end);
			// 组合情况
			if (left.size() == 0) {
				for (int k = 0; k < right.size(); k++) {
					root = new TreeNode(i);
					root.right = right.get(k);
					result.add(root);
				}
			} else if (right.size() == 0) {
				for (int j = 0; j < left.size(); j++) {
					root = new TreeNode(i);
					root.left = left.get(j);
					result.add(root);
				}
			} else {
				for (int j = 0; j < left.size(); j++) {
					for (int k = 0; k < right.size(); k++) {
						root = new TreeNode(i);
						root.left = left.get(j);
						root.right = right.get(k);
						result.add(root);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesII2 s = new UniqueBinarySearchTreesII2();
		int n = 2;
		List<TreeNode> result = s.generateTrees(n);
		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
