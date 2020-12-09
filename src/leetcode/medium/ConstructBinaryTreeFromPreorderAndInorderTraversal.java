package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import leetcode.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public void preorder(TreeNode node, List<Integer> result) {
		if (node == null) {
			return;
		}
		result.add(node.val);
		preorder(node.left, result);
		preorder(node.right, result);
	}

	public void inorder(TreeNode node, List<Integer> result) {
		if (node == null) {
			return;
		}
		inorder(node.left, result);
		result.add(node.val);
		inorder(node.right, result);
	}

	public void test() {
		int[] array = { 1, 2, 5, 3, 4, 6, 7, 8 };
		TreeNode root = TreeNode.createTreeByArray(array);
		System.out.println(root);
		List<Integer> preorderList = new ArrayList<Integer>();
		List<Integer> inorderList = new ArrayList<Integer>();
		preorder(root, preorderList);
		inorder(root, inorderList);
		System.out.println("preorder:" + preorderList);
		System.out.println("inorder:" + inorderList);
	}

	/**
	 * 
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>(inorder.length);
		HashMap<Integer, Integer> preorderMap = new HashMap<Integer, Integer>(preorder.length);
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
			preorderMap.put(preorder[i], i);
		}

		TreeNode root = new TreeNode(preorder[0]);
		buildTree(preorder, inorder, 0, preorder.length - 1, 0, root, inorderMap, preorderMap);
		return root;
	}

	/**
	 * 
	 * @param preorder
	 *            前序数组
	 * @param inorder
	 *            中序数组
	 * @param start
	 *            中序数组的开始位置
	 * @param end
	 *            中序数组的结束位置
	 * @param preindex
	 *            父节点对应的前序数组位置
	 * @param node
	 *            父节点
	 * @param inorderMap
	 *            中序数组的值与下标的映射
	 * @param preorderMap
	 *            前序数组的值与下标的映射
	 */
	public void buildTree(int[] preorder, int[] inorder, int start, int end, int preindex, TreeNode node,
			HashMap<Integer, Integer> inorderMap, HashMap<Integer, Integer> preorderMap) {
		// 获取父节点在中序数组的位置，作为判断材料
		int parentIndexInInorder = inorderMap.get(node.val);
		// 找左节点
		if (preindex + 1 <= preorder.length - 1) {
			// 判断index+1的前序数组元素是不是左节点
			int leftIndexInInOrder = inorderMap.get(preorder[preindex + 1]);
			// 如果leftIndexInInOrder的位置是在parentIndexInInorder的左边，那么就是左节点
			if (leftIndexInInOrder < parentIndexInInorder && leftIndexInInOrder >= start) {
				node.left = new TreeNode(preorder[preindex + 1]);
				// 缩小左树的范围
				buildTree(preorder, inorder, start, parentIndexInInorder - 1, preindex + 1, node.left, inorderMap,
						preorderMap);
			}
		}
		// 找右节点 左节点只能在中序数组的[parentIndexInInorder + 1...end]的范围内，
		int preRightMinIndex = preorder.length;
		int curIndex = -1;
		for (int i = parentIndexInInorder + 1; i <= end; i++) {
			// 找出前序对应元素位置的最小值，那个值就是右节点
			curIndex = preorderMap.get(inorder[i]);
			if (curIndex < preRightMinIndex) {
				preRightMinIndex = curIndex;
			}
		}
		if (preRightMinIndex != preorder.length) {
			node.right = new TreeNode(preorder[preRightMinIndex]);
			// 缩小右树的范围
			buildTree(preorder, inorder, parentIndexInInorder + 1, end, preRightMinIndex, node.right, inorderMap,
					preorderMap);
		}
	}

	private int inIndex = 0, preIndex = 0;

	public TreeNode buildTreeLeetcode(int[] preorder, int[] inorder) {
		return helper(preorder, inorder, Integer.MAX_VALUE);
	}

	private TreeNode helper(int[] preorder, int[] inorder, int target) {
		if (inIndex <= inorder.length - 1) {
			System.out.println("preIndex:" + preIndex + " inIndex:" + inIndex + " target:" + target
					+ " inorder[inIndex]:" + inorder[inIndex]);
		} else {
			System.out.println("preIndex:" + preIndex + " inIndex:" + inIndex + " target:" + target);
		}

		if (inIndex >= inorder.length || inorder[inIndex] == target) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preIndex]);
		preIndex++;
		root.left = helper(preorder, inorder, root.val);
		inIndex++;
		root.right = helper(preorder, inorder, target);
		return root;
	}

	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal s = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		// int[] preorder = { 3, 9, 20, 15, 7 };
		int[] preorder = { 1, 2, 3, 8, 4, 5, 6, 7 };
		// int[] inorder = { 9, 3, 15, 20, 7 };
		int[] inorder = { 8, 3, 2, 4, 1, 6, 5, 7 };
		// TreeNode result = s.buildTree(preorder, inorder);
		TreeNode result = s.buildTreeLeetcode(preorder, inorder);
		System.out.println(result);
		// s.test();
	}
}
