package leetcode.medium;

public class SimplifyPath {
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
			if( top == -1 ){
				return "/";
			}
			String result = "";
			for (int i = 0; i <= top; i++) {
				result += ("/" + array[i]);
			}
			return result;
		}

	}

	public String simplifyPath(String path) {
		String[] paths = path.split("/");
		Stack<String> stack = new Stack<String>(paths.length);
		for (int i = 0; i < paths.length; i++) {
			if (paths[i].equals(".")) {
				continue;
			}
			if (paths[i].equals("..")) {
				stack.pop();
			} else if (paths[i].equals("") == false) {
				stack.push(paths[i]);
			}
		}
		return stack.toString();
	}

	public void print(String[] paths) {
		String str = "";
		for (int i = 0; i < paths.length; i++) {
			str += (paths[i] + "");
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		String path = "/a//./b/../../c/";
		System.out.println(s.simplifyPath(path));
	}
}
