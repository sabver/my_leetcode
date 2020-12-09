package leetcode.medium;

import java.util.*;

public class CombinationSum {
	class Stack {
		// 栈顶的下标
		private int top;
		private List<Integer> array;
		// array里面元素的sum
		private int sum = 0;

		Stack() {
			array = new ArrayList<Integer>();
			top = -1;
			sum = 0;
		}

		/**
		 * 压入 要判断栈上溢(top超过了栈长度)
		 * 
		 * @param x
		 */
		public void push(Integer x) {
			// 如果是最后一个元素了，直接访问会越界
			if (top == array.size() - 1) {
				array.add(x);
				top++;
			} else {
				array.set(++top, x);
			}
			sum += x;
			System.out.println("push");
			print();
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
		public Integer pop() {
			// 栈下溢，在这里应该认为不会出现这种情况
			if (stackEmpty()) {
				return -1;
			}
			top--;
			int popItem = array.get(top + 1);
			sum -= popItem;
			System.out.println("pop");
			print();
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
				list.add(array.get(i));
			}
			return list;
		}

		public void print() {
			String result = "[";
			for (int i = 0; i <= top; i++) {
				result += (array.get(i) + " ");
			}
			System.out.println(result + "]" + " sum:" + sum);
			// System.out.println("----");
			// for (int i = 0; i < array.size(); i++) {
			// result += (array.get(i) + " ");
			// }
			// System.out.println(result);
		}

		public Integer getNewValue() {
			if (stackEmpty()) {
				return -1;
			}
			return array.get(top);
		}
	}

	private Stack stack;
	private int target;
	private HashMap<Integer, Integer> map;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		this.stack = new Stack();
		this.target = target;
		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < candidates.length; i++) {
			map.put(candidates[i], i);
		}
		// combination(result, candidates, 0);
		combination(result, candidates);
		return result;
	}

	public void combination(List<List<Integer>> result, int[] nums) {
		int index = 0;
		boolean isEnd = false;
		while (isEnd == false) {
			stack.push(nums[index]);
			if (stack.getSum() < target) {
				// 继续循环
				int remains = target - stack.getSum();
				int num = remains / nums[index];
				if (remains % nums[index] == 0) {
					for (int i = 1; i <= num - 1; i++) {
						stack.push(nums[index]);
					}
				} else {
					for (int i = 1; i <= num; i++) {
						stack.push(nums[index]);
					}
				}
			} else {
				if (stack.getSum() == target) {
					result.add(stack.getArrayCopy());
				}
				stack.pop();
				int pop = stack.pop();
				if (pop != -1) {
					int popIndex = map.get(pop);
					while (popIndex == nums.length - 1) {
						pop = stack.pop();
						if (pop != -1) {
							popIndex = map.get(pop);
						} else {
							break;
						}
					}
					if (pop != -1) {
						index = popIndex + 1;
					} else {
//						System.out.println("?");
						isEnd = true;
					}
				} else {
//					System.out.println("??");
					isEnd = true;
				}
			}
		}
	}

	// public void combination(List<List<Integer>> result, int[] nums, int
	// index) {
	// if (index < nums.length) {
	// stack.push(nums[index]);
	// if (stack.getSum() < target) {
	//
	// combination(result, nums, index);
	// } else {
	// if (stack.getSum() == target) {
	// result.add(stack.getArrayCopy());
	// }
	// stack.pop();
	// int pop = stack.pop();
	// if (pop != -1) {
	// int popIndex = map.get(pop);
	// while (popIndex == nums.length - 1) {
	// pop = stack.pop();
	// if (pop != -1) {
	// popIndex = map.get(pop);
	// } else {
	// break;
	// }
	// }
	// if (pop != -1) {
	// combination(result, nums, popIndex + 1);
	// }
	// }
	// }
	// }
	// }

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
		CombinationSum s = new CombinationSum();
		// int[] candidates = {
		// 92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
		// int[] candidates = { 70, 71, 73, 74, 75, 76, 77, 80, 81, 86, 89, 91,
		// 92, 93, 94, 95, 99, 102, 104, 106, 110,
		// 111, 112, 114, 115, 116, 117, 119 };
		int[] candidates = { 2, 3, 6, 7 };
		// Arrays.sort(candidates);
		// s.printNums(candidates);
		int target = 7;
		s.print(s.combinationSum(candidates, target));
	}
}
