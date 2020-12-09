package leetcode.medium;

import java.util.*;

public class Permutations {
	class Stack {
		// 栈顶的下标
		private int top;
		private int[] array;
		private Set<Integer> set;

		Stack(int size) {
			array = new int[size];
			top = -1;
			set = new HashSet<Integer>(size);
		}

		/**
		 * 压入 要判断栈上溢(top超过了栈长度)
		 * 
		 * @param x
		 */
		public void push(int x) {
			top++;
			array[top] = x;
			set.add(x);
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
		 */
		public int pop() {
			top--;
			int pop = array[(top + 1)];
			set.remove(pop);
			return pop;
		}

		public String toString() {
			StringBuffer result = new StringBuffer();
			for (int i = 0; i <= top; i++) {
				result.append(array[i] + " ");
			}
			return result.toString();
		}

		public List<Integer> getCopyArray() {
			List<Integer> result = new ArrayList<Integer>(array.length);
			for (int i = 0; i < array.length; i++) {
				result.add(array[i]);
			}

			return result;
		}

		public int getSize() {
			return this.top + 1;
		}

		public Set<Integer> getSet() {
			return this.set;
		}

	}

	// private Set<Integer> set;

	private int[] nums;

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return result;
		}
		this.nums = nums;
		// set = new HashSet<Integer>();
		// for (int i = 0; i < nums.length; i++) {
		// set.add(nums[i]);
		// }
		permute(new Stack(nums.length), result);
		return result;
	}

	public void permute(Stack stack, List<List<Integer>> result) {
		System.out.println(stack);
		if (stack.getSize() == nums.length) {
			result.add(stack.getCopyArray());
		} else {
			List<Integer> list = getRemainList(stack);
			// System.out.println(list);
			// System.out.println("--");
			for (int i = 0; i < list.size(); i++) {
				stack.push(list.get(i));
				permute(stack, result);
				stack.pop();
			}
		}
	}

	public List<Integer> getRemainList(Stack stack) {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> stackSet = stack.getSet();
		for (int i = 0; i < nums.length; i++) {
			if (stackSet.contains(nums[i]) == false) {
				list.add(nums[i]);
			}
		}
		return list;
	}

	public void print(List<List<Integer>> result) {
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	public static void main(String[] args) {
		Permutations s = new Permutations();
		int[] nums = { 1, 3, 2 };
		s.print(s.permute(nums));
	}
}
