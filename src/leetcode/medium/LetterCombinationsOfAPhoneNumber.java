package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
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

	// public static int COUNT = 0;

//	private char alphabets[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
//			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		int length = digits.length();
		if (length == 0) {
			return result;
		}
		int nums[] = new int[length];
		for (int i = 0; i < length; i++) {
			nums[i] = digits.charAt(i) - 48;
		}
		combine(new Stack(length), 0, result, nums);
		// System.out.println("函数调用次数："+COUNT);
		// System.out.println("size:" + result.size());
		return result;
	}

	public void combine(Stack stack, int curColumn, List<String> result, int nums[]) {
		// COUNT++;
		// 最后的一个数字需要添加到result那里
		if (curColumn == nums.length - 1 && nums[curColumn] > 1) {
			char chars[] = getAlphabetByNumber(nums[curColumn]);
			for (int i = 0; i < chars.length; i++) {
				stack.push(chars[i]);
				result.add(stack.toString());
				stack.pop();
			}
		} else {
			if (nums[curColumn] <= 1) {
				combine(stack, curColumn + 1, result, nums);
			} else {
				char chars[] = getAlphabetByNumber(nums[curColumn]);
				for (int curRow = 0; curRow < chars.length; curRow++) {
					stack.push(chars[curRow]);
					combine(stack, curColumn + 1, result, nums);
					stack.pop();
				}
			}
		}
	}

	/**
	 * 根据number获取对应的字母数组
	 * 
	 * @param number
	 * @return
	 */
	public char[] getAlphabetByNumber(int number) {
		char[] result = null;
		if (number == 7 || number == 9) {
			result = new char[4];
		} else {
			result = new char[3];
		}
		switch (number) {
		case 2:
			result[0] = 'a';
			result[1] = 'b';
			result[2] = 'c';
			break;
		case 3:
			result[0] = 'd';
			result[1] = 'e';
			result[2] = 'f';
			break;
		case 4:
			result[0] = 'g';
			result[1] = 'h';
			result[2] = 'i';
			break;
		case 5:
			result[0] = 'j';
			result[1] = 'k';
			result[2] = 'l';
			break;
		case 6:
			result[0] = 'm';
			result[1] = 'n';
			result[2] = 'o';
			break;
		case 7:
			result[0] = 'p';
			result[1] = 'q';
			result[2] = 'r';
			result[3] = 's';
			break;
		case 8:
			result[0] = 't';
			result[1] = 'u';
			result[2] = 'v';
			break;
		case 9:
			result[0] = 'w';
			result[1] = 'x';
			result[2] = 'y';
			result[3] = 'z';
			break;
		}
		return result;
	}

	/**
	 * 根据索引来逆推出number
	 * 
	 * @param index
	 * @return
	 */
	// public int getNumberByIndex(int index) {
	// int module = index % 3, number = 0;
	// if (module == 0) {
	// number = index / 3 + 2;
	// } else if (module == 1) {
	// number = (index - 1) / 3 + 2;
	// } else {
	// number = (index - 2) / 3 + 2;
	// }
	// return number;
	// }

	/**
	 * 根据number获取对应的开始索引
	 * 
	 * @param number
	 * @return
	 */
	// public int getBeginIndexByNumber(int number) {
	// return 3 * (number - 2);
	// }

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber s = new LetterCombinationsOfAPhoneNumber();
		String digits = "27";
		System.out.println(s.letterCombinations(digits));
	}
}
