package leetcode.easy;

import java.util.LinkedList;

import leetcode.util.TreeNode;

public class SumOfRootToLeafBinaryNumbers {
	int res;

	public int sumRootToLeaf(TreeNode root) {
		LinkedList<Integer> track = new LinkedList<>();
		helper(root, track);
		return res;
	}

	public void helper(TreeNode root, LinkedList<Integer> track) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			track.addLast(root.val);
			System.out.println(track);
			int sum = 0;
			int sz = track.size();
			for (int i = 0; i < sz; i++) {
				sum += track.get(i) * Math.pow(2, sz - i - 1);
			}
			System.out.println(sum);
			res += sum;
			track.removeLast();
		}
		track.addLast(root.val);
		helper(root.left, track);
		helper(root.right, track);
		track.removeLast();
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 0, 1, 0, 1, 0, 1 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		SumOfRootToLeafBinaryNumbers s = new SumOfRootToLeafBinaryNumbers();
		int res = s.sumRootToLeaf(root);
		System.out.println("result:" + res);
	}

}
