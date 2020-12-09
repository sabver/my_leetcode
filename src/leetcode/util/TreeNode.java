package leetcode.util;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public String toString() {
		if (val == -1) {
			return "null";
		}
		return "{val:" + val + " left:" + left + " right:" + right + "}";
	}

	/**
	 * 通过数组来创建tree
	 * 
	 * @param array
	 *            不存在的节点用-1表示 左节点：2*i+1 右节点2*i+2
	 * @return
	 */
	public static TreeNode createTreeByArray(int[] array) {
		if( array.length == 0 ){
			return null;
		}
		TreeNode root = new TreeNode(array[0]);
		createTreeByArray(array,root,1);
		createTreeByArray(array,root,2);
		return root;
	}
	
	public static void createTreeByArray(int[] array, TreeNode parent, int curIndex) {
		if (curIndex > array.length - 1) {
			return;
		}
		//左节点
		if( curIndex%2 == 1 ){
			parent.left = new TreeNode(array[curIndex]);
			//生成左节点
			createTreeByArray(array,parent.left,curIndex*2+1);
			//生成右节点
			createTreeByArray(array,parent.left,curIndex*2+2);
		}else{
			//右节点
			parent.right = new TreeNode(array[curIndex]);
			//生成左节点
			createTreeByArray(array,parent.right,curIndex*2+1);
			//生成右节点
			createTreeByArray(array,parent.right,curIndex*2+2);			
		}
	}

}
