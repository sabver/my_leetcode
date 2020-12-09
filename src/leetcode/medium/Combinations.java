package leetcode.medium;

import java.util.*;

public class Combinations {
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

		public void init(int beginNum) {
			for (int i = 0; i < array.length; i++) {
				array[i] = i + beginNum;
			}
			top = array.length - 1;
		}

		public void moveTo(int n, int k) {
			int endTop = array.length-1;
			for (int i = top; i >= 0; i--) {
//				System.out.println("for");
//				System.out.println("i:"+i);
//				System.out.println((n - k + 1) + i);
				// n - k + 1起点的值
				// i距离
				if (array[i] != (n - k + 1) + i) {
					array[i]++;
					endTop = i;
					break;
				}
			}
//			System.out.println("endTop:"+endTop);
			int count = 1;
			for (int i = endTop+1; i <= array.length - 1; i++) {
				array[i] = array[endTop] + count++;
			}
			top = array.length - 1;
		}

	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (k >= n) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				list.add(i);
			}
			result.add(list);
			return result;
		}
		if( k == 1 ){
			List<Integer> list = null;
			for (int i = 1; i <= n; i++) {
				list = new ArrayList<Integer>();
				list.add(i);
				result.add(list);
			}
			return result;
		}
		// k<n
		Stack stack = new Stack(k);
		stack.init(1);
		while (stack.get(0) != n - k + 1) {
			// 挪动最后一位数字
			int pop = stack.pop();
			for (int i = pop; i <= n; i++) {
				stack.push(i);
				result.add(stack.getResult());
				stack.pop();
			}
			// 挪动上一位可以移动的数字
			stack.moveTo(n, k);
//			System.out.println(stack);
		}
		result.add(stack.getResult());
		return result;
	}

	public void test() {
		int n = 6;
		int k = 3;
		Stack stack = new Stack(k);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.get(0) == n - k + 1);
		System.out.println(stack);
		stack.moveTo(n, k);
		System.out.println(stack);
	}

	public void print(List<List<Integer>> list) {
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void main(String[] args) {
		Combinations s = new Combinations();
		int n = 2;
		int k = 1;
		 s.print(s.combine(n, k));
//		s.test();

	}
}
