package leetcode.medium;

import java.util.*;

public class Permutations2 {
	class Stack {
		// 栈顶的下标
		private int top;
		private int[] array;
		// 补集
		private Set<Integer> supplementarySet;

		Stack(int[] nums) {
			array = new int[nums.length];
			top = -1;
			supplementarySet = new HashSet<Integer>(nums.length);
			for (int i = 0; i < nums.length; i++) {
				supplementarySet.add(nums[i]);
			}
		}

		/**
		 * 压入 要判断栈上溢(top超过了栈长度)
		 * 
		 * @param x
		 */
		public void push(int x) {
			top++;
			array[top] = x;
			supplementarySet.remove(x);
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
			supplementarySet.add(pop);
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

		public Set<Integer> getSupplementarySet() {
			return this.supplementarySet;
		}

	}

	private int[] nums;

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return result;
		}
		this.nums = nums;
		permute(new Stack(nums), result);
		return result;
	}

	public void permute(Stack stack, List<List<Integer>> result) {
		// System.out.println(stack);
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
		Set<Integer> supplementarySet = stack.getSupplementarySet();
		Iterator<Integer> it = supplementarySet.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public void print(List<List<Integer>> result) {
		System.out.println("size:" + result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	/**
	 * 打印第n个答案，n从1开始
	 * 
	 * @param result
	 * @param n
	 */
	public void printNth(List<List<Integer>> result, int n) {
		System.out.println("--------------------第" + n + "个元素--------------------");
		System.out.println(result.get(n - 1));
	}

	public static void main(String[] args) {
		Permutations2 s = new Permutations2();
		int[] nums = { 1, 2, 3, 4, 5 };
		List<List<Integer>> result = s.permute(nums);
		s.print(result);
		s.printNth(result, 96);
		s.printNth(result, 97);
		s.printNth(result, 98);
		s.printNth(result, 99);
		s.printNth(result, 100);
	}
}
