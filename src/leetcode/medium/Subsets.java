package leetcode.medium;

import java.util.*;


public class Subsets {
	class Stack {
		// 栈顶的下标
		private int top;
		private int[] array;

		Stack(int size) {
			array = new int[size];
			top = -1;
		}

		/**
		 * 压入 要判断栈上溢(top超过了栈长度)
		 * 
		 * @param x
		 */
		public void push(int x) {
			top++;
			array[top] = x;
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
			return pop;
		}

		public String toString() {
			StringBuffer result = new StringBuffer();
			for (int i = 0; i <= top; i++) {
				result.append(array[i] + " ");
			}
			return result.toString();
		}

		public List<Integer> getResult(int[]nums) {
			List<Integer> result = new ArrayList<Integer>();
			for (int i = 0; i <= top; i++) {
				result.add(nums[array[i]-1]);
			}
			return result;
		}

		public int getSize() {
			return this.top + 1;
		}

		public int get(int index) {
			if (index > top) {
				return 0;
			} else {
				return array[index];
			}
		}

		public void init(int beginNum) {
			for (int i = 0; i < array.length; i++) {
				array[i] = i + beginNum;
			}
			top = array.length - 1;
		}

		public void moveTo(int n, int k) {
			int endTop = array.length - 1;
			for (int i = top; i >= 0; i--) {
				// n - k + 1起点的值
				// i距离
				if (array[i] != (n - k + 1) + i) {
					array[i]++;
					endTop = i;
					break;
				}
			}
			int count = 1;
			for (int i = endTop + 1; i <= array.length - 1; i++) {
				array[i] = array[endTop] + count++;
			}
			top = array.length - 1;
		}

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// 加空集
		result.add(new ArrayList<Integer>());
		if (nums.length == 0) {
			return result;
		}

		for (int i = 1; i <= nums.length; i++) {
			subsets(nums, i, result);
		}
		return result;
	}

	/**
	 * 
	 * @param nums
	 * @param k
	 *            包含的元素个数 从1到nums.length
	 * @param result
	 */
	public void subsets(int[] nums, int k, List<List<Integer>> result) {
		int n = nums.length;
		if (k == n) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				list.add(nums[i-1]);
			}
			result.add(list);
			return;
		}
		if (k == 1) {
			List<Integer> list = null;
			for (int i = 1; i <= n; i++) {
				list = new ArrayList<Integer>();
				list.add(nums[i-1]);
				result.add(list);
			}
			return;
		}
		// k<n
		Stack stack = new Stack(k);
		stack.init(1);
		while (stack.get(0) != n - k + 1) {
			// 挪动最后一位数字
			int pop = stack.pop();
			for (int i = pop; i <= n; i++) {
				stack.push(i);
				result.add(stack.getResult(nums));
				stack.pop();
			}
			// 挪动上一位可以移动的数字
			stack.moveTo(n, k);
		}
		result.add(stack.getResult(nums));
	}

	public void print(List<List<Integer>> list) {
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] nums = { 1, 2, 3 };
		s.print(s.subsets(nums));
	}
}
