package leetcode.easy;

import java.util.HashMap;

public class ValidParentheses {
	// 栈，后入先出
	class Stack<Item> {
		private Item[] array;
		private int top = -1;

		@SuppressWarnings("unchecked")
		Stack(int size) {
			array = (Item[]) new Object[size];
			top = -1;
		}

		public Item top() {
			if (isEmpty()) {
				return null;
			}
			return array[top];
		}

		public Item pop() {
			if (isEmpty()) {
				return null;
			}
			return array[top--];
		}

		public void push(Item item) {
			array[++top] = item;
		}

		public boolean isEmpty() {
			return top == -1;
		}

		public String toString() {
			System.out.println("top:"+top);
			String result = "";
			for (int i = top; i >= 0; i--) {
				result += ("" + array[i]);
			}
			return result;
		}

	}
	
	public boolean isValid(String s) {
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		Stack<Character> stack = new Stack<Character>(s.length());
		int length = s.length();
		Character lastChar = 'a', curChar = 'a';
		for (int i = 0; i < length; i++) {
			curChar = s.charAt(i);
			lastChar = stack.top();
			if (lastChar == null) {
				stack.push(curChar);
				continue;
			}
			switch(curChar){
			case '(':
			case '{':
			case '[':
				stack.push(curChar);
				break;
			case ')':
			case '}':
			case ']':
				if( map.get(curChar) == lastChar ){
					System.out.println("bingo");
					stack.pop();
				}else{
					stack.push(curChar);
				}
				break;
			}
		}
		return stack.isEmpty();		
	}

	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>(s.length());
		int length = s.length();
		Character lastChar = 'a', curChar = 'a';
		for (int i = 0; i < length; i++) {
			curChar = s.charAt(i);
			lastChar = stack.top();
//			System.out.println("curChar:" + curChar);
//			System.out.println("lastChar:" + lastChar);
			if (lastChar == null) {
				stack.push(curChar);
//				System.out.println(stack);
				continue;
			}
			if ((lastChar == '(' && curChar == ')') || (lastChar == '{' && curChar == '}')
					|| (lastChar == '[' && curChar == ']')) {
//				System.out.println("bingo");
				stack.pop();
			}else{
				stack.push(curChar);
			}
//			System.out.println(stack);
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("(])"));
	}
}
