package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * @author yejianfeng
 *
 */
public class UniqueBinarySearchTreesIIV2 {
	/**
	 * 看成是多叉树的后续遍历，在穷举了左树和右树的所有可能之后，进行一个组合
	 * 
	 * @param n
	 * @return
	 */
	public List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

//	def backtrack(路径, 选择列表):
//	    if 满足结束条件:
//	        result.add(路径)
//	        return
//	    
//	    for 选择 in 选择列表:
//	        做选择
//	        backtrack(路径, 选择列表)
//	        撤销选择

	public List<TreeNode> helper(int low, int high) {
		List<TreeNode> result = new ArrayList<>();
		// 探索完毕
		if (low > high) {
			result.add(null);
			return result;
		}
		for (int i = low; i <= high; i++) {
			List<TreeNode> leftTrees = helper(low, i - 1);
			List<TreeNode> rightTrees = helper(i + 1, high);
			for (TreeNode leftNode : leftTrees) {
				for (TreeNode rightNode : rightTrees) {
					TreeNode node = new TreeNode(i);
					node.left = leftNode;
					node.right = rightNode;
					result.add(node);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesIIV2 s = new UniqueBinarySearchTreesIIV2();
		s.generateTrees(3);
	}
}
