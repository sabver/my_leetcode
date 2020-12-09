package leetcode.medium;

import java.util.*;

public class CombinationSumII {
	class Data {
		public int index;
		public int value;

		Data() {
			this.index = -1;
			this.value = -1;
		}

		Data(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	class Stack {
		// 栈顶的下标
		private int top;
		private List<Data> array;
		// array里面元素的sum
		private int sum = 0;
		private Data dump = new Data();

		Stack() {
			array = new ArrayList<Data>();
			top = -1;
			sum = 0;
		}

		/**
		 * 压入 要判断栈上溢(top超过了栈长度)
		 * 
		 * @param x
		 */
		public void push(Data x) {
			// 如果是最后一个元素了，直接访问会越界
			if (top == array.size() - 1) {
				array.add(x);
				top++;
			} else {
				array.set(++top, x);
			}
			sum += x.value;
//			System.out.println("push");
//			print();
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
		public Data pop() {
			// 栈下溢，在这里应该认为不会出现这种情况
			if (stackEmpty()) {
				return dump;
			}
			top--;
			Data popItem = array.get(top + 1);
			sum -= popItem.value;
//			System.out.println("pop");
//			print();
			return popItem;
		}

		public String toString() {
			return array.toString();
		}

		public int getSum() {
			return sum;
		}

		/**
		 * 获取一份array的copy
		 * 
		 * @return
		 */
		public List<Integer> getArrayCopy() {
			List<Integer> list = new ArrayList<Integer>(array.size());
			for (int i = 0; i <= top; i++) {
				list.add(array.get(i).value);
			}
			return list;
		}

		public void print() {
			String result = "[";
			for (int i = 0; i <= top; i++) {
				result += (array.get(i).value + " ");
			}
			System.out.println(result + "]" + " sum:" + sum);
		}

		public Data getNewValue() {
			if (stackEmpty()) {
				return dump;
			}
			return array.get(top);
		}
	}

	private Stack stack;
	private int target;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		if (candidates[0] > target) {
			return result;
		}
//		printNums(candidates);
		candidates = prehandle(candidates, target);
//		printNums(candidates);
		this.stack = new Stack();
		this.target = target;
		combination(result, candidates);
		return result;
	}

	public int[] prehandle(int[] nums, int target) {
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int item = 0;
		for (int i = 0; i < nums.length; i++) {
			item = nums[i];
			if (item > target) {
				break;
			}
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
				int allowNums = target / item;
				if (allowNums >= map.get(item)) {
					list.add(item);
				}
			} else {
				map.put(item, 1);
				list.add(item);
			}
		}
		int result[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public void combination(List<List<Integer>> result, int[] nums) {
		int index = 0;
		boolean isEnd = false;
		Data data = null;
		Data pop = null;
		Set<String> set = new HashSet<String>();
		List<Integer> stackResult = null;
		String stackResultStr = null;
		while (isEnd == false) {
			data = new Data(index, nums[index]);
			stack.push(data);
			if (stack.getSum() < target) {
				index++;
				// 如果接下来要爆了，那就是当前的选择需要退栈
				if (index == nums.length) {
					stack.pop();
					pop = stack.pop();
					if (pop.index != -1) {
						index = pop.index + 1;
					} else {
						isEnd = true;
					}
				}
			} else {
				if (stack.getSum() == target) {
					stackResult = stack.getArrayCopy();
					stackResultStr = stackResult.toString();
					if( set.contains(stackResultStr) == false ){
						result.add(stackResult);
						set.add(stackResultStr);
					}
//					if (isHaveSame(result, stack) == false) {
//						result.add(stack.getArrayCopy());
//					}
				}
				stack.pop();
				pop = stack.pop();
				if (pop.index != -1) {
					index = pop.index + 1;
				} else {
					isEnd = true;
				}
			}
		}
	}

	public boolean isHaveSame(List<List<Integer>> result, Stack stack) {
		if (result.size() == 0) {
			return false;
		}
		List<Integer> compareOne = stack.getArrayCopy();
		for (int i = result.size() - 1; i >= 0; i--) {
			if (compareOne.toString().equals(result.get(i).toString())) {
				return true;
			}
		}
		return false;
	}

	public void print(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public void printNums(int[] nums) {
		String str = "";
		for (int i = 0; i < nums.length; i++) {
			str += (nums[i] + ",");
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		CombinationSumII s = new CombinationSumII();
		int[] candidates = { 1,2 };
		int target = 1;
		s.print(s.combinationSum2(candidates, target));
	}
}
