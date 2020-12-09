package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	class Stack {
		// 栈顶的下标
		private int top;
		private char[] array;

		Stack(int size) {
			array = new char[size];
			top = -1;
		}

		/**
		 * 压入 要判断栈上溢(top超过了栈长度)
		 * 
		 * @param x
		 */
		public void push(char x) {
			// 栈上溢，在这里应该认为不会出现这种情况
			// if ((top + 1) > array.length - 1) {
			// return;
			// }
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
		public char pop() {
			// 栈下溢，在这里应该认为不会出现这种情况
			// if (stackEmpty()) {
			// return 'A';
			// }
			top--;
			return array[(top + 1)];
		}

		public String toString() {
			StringBuffer result = new StringBuffer();
			for (int i = 0; i <= top; i++) {
				result.append(array[i]);
			}
			return result.toString();
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		generate(new Stack(n * 2), result, n, 0, 1);
		return result;
	}

	/**
	 * 生成
	 * 
	 * @param stack
	 * @param result
	 * @param n
	 * @param curLeftNums
	 *            当前的左括号的数量（上次调用结束时的数量）
	 * @param position
	 *            当前处理的字符位置，如果n=3，那么要处理的位置就有6个（当场处理的时候的位置）
	 */
	public void generate(Stack stack, List<String> result, int n, int curLeftNums, int position) {
		if (position == n * 2) {
			stack.push(')');
			result.add(stack.toString());
			stack.pop();
		} else {
			// 这种情况下有两种路要走
			if (curLeftNums < n) {
				stack.push('(');
				generate(stack, result, n, curLeftNums + 1, position + 1);
				stack.pop();
				// 如果右括号还可以拓展
				if (curLeftNums > position - curLeftNums-1) {
					stack.push(')');
					generate(stack, result, n, curLeftNums, position + 1);
					stack.pop();
				}
			} else {
				stack.push(')');
				generate(stack, result, n, curLeftNums, position + 1);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		GenerateParentheses s = new GenerateParentheses();
		System.out.println(s.generateParenthesis(3));
	}
}
