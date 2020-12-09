package leetcode.medium;

import java.util.*;
import leetcode.util.*;

public class UniqueBinarySearchTreesII {
	private TreeNode root;
	private int count;
	private boolean countEnd;

	/**
	 * 返回一个copy的tree的root
	 * 
	 * @return
	 */
	public TreeNode copyTree() {
		TreeNode newRoot = new TreeNode(root.val);
		copyTree(newRoot, root);
		return newRoot;
	}

	/**
	 * 
	 * @param newNode
	 * @param oldNode
	 */
	public void copyTree(TreeNode newNode, TreeNode oldNode) {
		if (oldNode == null) {
			return;
		}
		if (oldNode.left != null) {
			newNode.left = new TreeNode(oldNode.left.val);
			copyTree(newNode.left, oldNode.left);
		}
		if (oldNode.right != null) {
			newNode.right = new TreeNode(oldNode.right.val);
			copyTree(newNode.right, oldNode.right);
		}
	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		for (int i = 1; i <= n; i++) {
			System.out.println(i + "=======");
			count = 1;
			countEnd = false;
			root = new TreeNode(i);
			generateTrees(i, 1, n, result, root, n, 1);
		}
		return result;
	}

	public void generateTrees(int last, int min, int max, List<TreeNode> result, TreeNode node, int n, int level) {
		countEnd = false;
		System.out.println("last:" + last + " min:" + min + " max:" + max + " level:" + (level + 1));
		if (min == max) {
			System.out.println("done min:" + min + " max:" + max);
			countEnd = true;
			// count = 1;
			System.out.println(root);
			result.add(copyTree());
			return;
		}
		for (int i = min; i <= max; i++) {
			System.out.println("========i:" + i + " level:" + (level + 1));
			// 左树
			if (i < last) {
				System.out.println("left last:" + last);
				node.left = new TreeNode(i);
				count++;
				generateTrees(i, min, last - 1, result, node.left, n, level + 1);
				if( countEnd == true ){
					count--;
				}
			} else if (i > last) { // 右树
				System.out.println("right last:" + last);
				node.right = new TreeNode(i);
				count++;
				generateTrees(i, last + 1, max, result, node.right, n, level + 1);
				if( countEnd == true ){
					count--;
				}				
			}
		}
	}

	public void print(List<TreeNode> result) {
		for (int i = 0; i < result.size(); i++) {
			// printInOrder(result.get(i));
			System.out.println(result.get(i));
		}
	}

	public void printInOrder(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		printInOrder(node.left, list);
		list.add(node.val);
		printInOrder(node.right, list);
	}

	public void printInOrder(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		printInOrder(root, list);
		System.out.println(list);
	}

	public void test() {
		TreeNode testRoot = new TreeNode(3);
		testRoot.left = new TreeNode(0);
		testRoot.right = new TreeNode(4);
		testRoot.right.left = new TreeNode(1);
		testRoot.right.right = new TreeNode(5);
		List<Integer> list = new ArrayList<Integer>();
		printInOrder(testRoot, list);
		System.out.println(list);
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesII s = new UniqueBinarySearchTreesII();
		int n = 4;
		List<TreeNode> result = s.generateTrees(n);
		s.print(result);
		// s.test();
	}

}
