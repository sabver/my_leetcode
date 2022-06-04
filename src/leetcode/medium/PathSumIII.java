package leetcode.medium;

import java.util.HashMap;
import java.util.Set;

import leetcode.util.TreeNode;

public class PathSumIII {
	// 记录前缀和
	// 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
	HashMap<Integer, Integer> preSumCount = new HashMap<>();

	int pathSum, targetSum;
	int res = 0;

	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}
		this.pathSum = 0;
		this.targetSum = targetSum;
		this.preSumCount.put(0, 1);
		traverse(root);
		return res;
	}
	
	public void printCount() {
		System.out.println("");
		Set<Integer> set = preSumCount.keySet();
		for(Integer key : set) {
			System.out.println("k:" + key + " v:" + preSumCount.get(key));
		}
		System.out.println("");
	}
	// targetSum可以看成是一段路径，然后问题可以改为求从path[root, cur] - path[targetSum]是否存在
	void traverse(TreeNode root) {
		if (root == null || root.val == Integer.MIN_VALUE) {
			return;
		}		
		// 前序遍历位置
		pathSum += root.val;
		// 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
		// 就是路径和为 targetSum 的路径条数
		int curRes = preSumCount.getOrDefault(pathSum - targetSum, 0);
		System.out.println("前序 pathSum:" + pathSum + " val:" + root.val + " curRes:" + curRes + " dif:" + (pathSum - targetSum));
		res += curRes;
		// 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
		preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);
		printCount();
		traverse(root.left);
		traverse(root.right);

		// 后序遍历位置
		preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
		pathSum -= root.val;
	}

	public static void main(String args[]) {
		int[] nums = new int[] { 10, 5, -3, 3, 2, Integer.MIN_VALUE, 11, 3, -2, Integer.MIN_VALUE, 1 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		int targetSum = 8;
		PathSumIII p = new PathSumIII();
		int res = p.pathSum(root, targetSum);
		System.out.println("res:" + res);
	}

}
