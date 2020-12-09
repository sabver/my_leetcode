package leetcode.medium;

import java.util.*;
import leetcode.util.*;

public class BinaryTreeInorderTraversal {
	class Stack<Item> {
		// 栈顶的下标
		private int top;
		private List<Item> array;

		Stack() {
			array = new ArrayList<Item>();
			top = -1;
		}

		/**
		 * 压入 要判断栈上溢(top超过了栈长度)
		 * 
		 * @param x
		 */
		public void push(Item x) {
			// 如果是最后一个元素了，直接访问会越界
			if (top == array.size() - 1) {
				array.add(x);
				top++;
			} else {
				array.set(++top, x);
			}
		}

		/**
		 * 判断栈是否为空栈
		 * 
		 * @return
		 */
		public boolean stackEmpty() {
			if (top == -1) {
				return true;
			}
			return false;
		}

		/**
		 * 弹出 要判断栈下溢(对空栈进行操作)
		 * 
		 */
		public Item pop() {
			// 栈下溢，在这里应该认为不会出现这种情况
			if (stackEmpty()) {
				return null;
			}
			top--;
			Item popItem = array.get(top + 1);
			return popItem;
		}

		public String toString() {
			return array.toString();
		}

		/**
		 * 获取一份array的copy
		 * 
		 * @return
		 */
		public List<Item> getArrayCopy() {
			List<Item> list = new ArrayList<Item>(array.size());
			for (int i = 0; i <= top; i++) {
				list.add(array.get(i));
			}
			return list;
		}

		public void print() {
			String result = "[";
			for (int i = 0; i <= top; i++) {
				result += (array.get(i) + " ");
			}
			System.out.println(result + "]");
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		inorderTraversal(root,result);
		return result;
	}

	public void inorderTraversal(TreeNode root, List<Integer> result) {
		if( root == null ){
			return ;
		}
		inorderTraversal(root.left,result);
		result.add(root.val);
		inorderTraversal(root.right,result);
	}

	/**
	 * 普通的中序遍历
	 * 
	 * @param node
	 */
	public void inorderTraversalTest(TreeNode node) {
		if (node == null) {
			return;
		}
		inorderTraversalTest(node.left);
		System.out.println(node);
		inorderTraversalTest(node.right);
	}

	/**
	 * 用循环的方式处理
	 * 
	 * @param root
	 */
	public void inorderTraversalTest2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = root;
		while (cur != null) {
			while (cur.left != null) {
				stack.push(cur.left);
				cur = cur.left;
			}
			if (stack.stackEmpty()) {
				System.out.println(cur);
				cur = cur.right;
			} else {
				cur = stack.pop();
				System.out.println(cur);
				if (cur.right == null) {
					cur = stack.pop();
				} else {
					cur = cur.right;
				}
			}
		}
	}
	
	public List<Integer> inorderTraversalLeetCode(TreeNode root) {
	    List<Integer> list = new ArrayList<Integer>();

//	    Stack<TreeNode> stack = new Stack<TreeNode>();
//	    TreeNode cur = root;
//
//	    while(cur!=null || !stack.empty()){
//	        while(cur!=null){
//	            stack.add(cur);
//	            cur = cur.left;
//	        }
//	        cur = stack.pop();
//	        list.add(cur.val);
//	        cur = cur.right;
//	    }

	    return list;
	}	

	public static void main(String[] args) {
		BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> result = s.inorderTraversal(root);
		System.out.println(result);
		s.inorderTraversalTest(root);
		System.out.println();
		s.inorderTraversalTest2(root);
	}
}
