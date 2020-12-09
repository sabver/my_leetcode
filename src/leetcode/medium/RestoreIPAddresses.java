package leetcode.medium;

import java.util.*;

public class RestoreIPAddresses {
	class Stack {
		// 栈顶的下标
		private int top;
		private String[] array;

		Stack(int size) {
			array = new String[size];
			top = -1;
		}

		/**
		 * 压入 要判断栈上溢(top超过了栈长度)
		 * 
		 * @param x
		 */
		public void push(String x) {
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
		public String pop() {
			top--;
			return array[(top + 1)];
		}

		public String toString() {
			StringBuffer result = new StringBuffer();
			for (int i = 0; i <= top; i++) {
				if (i == top) {
					result.append(array[i]);
				} else {
					result.append(array[i]);
					result.append(".");
				}
			}
			return result.toString();
		}

		public int getSize() {
			return top + 1;
		}
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		Stack stack = new Stack(4);
		restoreIpAddresses(stack, result, 0, s);
		return result;
	}

	public void restoreIpAddresses(Stack stack, List<String> result, int beginIndex, String s) {
		if (stack.getSize() == 4 && beginIndex == s.length()) {
			result.add(stack.toString());
		}
		if ((4 - stack.getSize()) * 3 < s.length() - beginIndex) {
			return;
		}
		String curStr = "";
		for (int i = 0; i < 3; i++) {
			if (beginIndex + i <= s.length() - 1) {
				curStr = s.substring(beginIndex, beginIndex + i + 1);
				if( curStr.equals("0") ){
					stack.push(curStr);
					restoreIpAddresses(stack, result, beginIndex + i + 1, s);
					stack.pop();
					break;
				}else if (Integer.parseInt(curStr) <= 255) {
					stack.push(curStr);
					restoreIpAddresses(stack, result, beginIndex + i + 1, s);
					stack.pop();
				}
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		RestoreIPAddresses s = new RestoreIPAddresses();
		String str = "010010";
		System.out.println(str.length());
		List<String> result = s.restoreIpAddresses(str);
		System.out.println(result);
	}
}
