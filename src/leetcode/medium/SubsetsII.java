package leetcode.medium;

import java.util.*;

public class SubsetsII {
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
			// System.out.println(getResult());
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

		public List<Integer> getResult() {
			List<Integer> result = new ArrayList<Integer>();
			for (int i = 0; i <= top; i++) {
				result.add(array[i]);
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

		public void reset() {
			top = -1;
		}

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// 空集
		result.add(new ArrayList<Integer>());
		Stack stack = new Stack(nums.length);
		combinate(stack, nums, result, 0);
		return result;
	}

	public void combinate(Stack stack, int[] nums, List<List<Integer>> result, int curIndex) {
		for (int i = curIndex; i < nums.length; i++) {
			if (i != curIndex && nums[i] == nums[i - 1]) {
				continue;
			}
			stack.push(nums[i]);
			result.add(stack.getResult());
			combinate(stack, nums, result, i + 1);
			stack.pop();
		}
	}

	public void print(List<List<Integer>> result) {
		System.out.println();
		System.out.println("size:" + result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	public static void main(String[] args) {
		SubsetsII s = new SubsetsII();
		int[] nums = { 2, 1, 2, 1, 3 };
		s.print(s.subsetsWithDup(nums));
	}
}
