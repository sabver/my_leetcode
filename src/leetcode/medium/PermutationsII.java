package leetcode.medium;

import java.util.*;

public class PermutationsII {
	class Stack {
		// 栈顶的下标
		private int top;
		// 存储的是index
		private int[] array;
		// 补集
		private Set<Integer> supplementarySet;
		private int[] nums;

		Stack(int[] nums) {
			this.nums = nums;
			array = new int[nums.length];
			top = -1;
			supplementarySet = new HashSet<Integer>(nums.length);
			for (int i = 0; i < nums.length; i++) {
				supplementarySet.add(i);
			}
		}

		/**
		 * 压入 要判断栈上溢(top超过了栈长度)
		 * 
		 * @param index
		 */
		public void push(int index) {
			top++;
			array[top] = index;
			supplementarySet.remove(index);
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
				result.add(nums[array[i]]);
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
	
	private Set<String> resultSet;

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return result;
		}
		this.nums = nums;
		this.resultSet = new HashSet<String>();
		permute(new Stack(nums), result);
		return result;
	}

	public void permute(Stack stack, List<List<Integer>> result) {
		// System.out.println(stack);
		if (stack.getSize() == nums.length) {
			List<Integer> curResult = stack.getCopyArray();
			if( resultSet.contains(curResult.toString()) == false ){
				resultSet.add(curResult.toString());
				result.add(curResult);
			}
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
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	public static void main(String[] args) {
		PermutationsII s = new PermutationsII();
		int[] nums = { 1, 1, 2 };
		s.print(s.permuteUnique(nums));
	}
}
