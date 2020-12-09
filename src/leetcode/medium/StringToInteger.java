package leetcode.medium;

import java.util.HashMap;

public class StringToInteger {
	public int myAtoi(String str) {
		int length = str.length();
		char[] chars = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('0', 0);
		map.put('1', 1);
		map.put('2', 2);
		map.put('3', 3);
		map.put('4', 4);
		map.put('5', 5);
		map.put('6', 6);
		map.put('7', 7);
		map.put('8', 8);
		map.put('9', 9);
		int beginIndex = -1;
		// 默认是正
		int signal = 1;
		boolean isHit = false;
		char curChar = ' ';
		// 判断是否非法字符串
		for (int i = 0; i < length; i++) {
			curChar = chars[i];
			// 检测第一个合法字符的位置
			if (map.containsKey(curChar)) {
				isHit = true;
				beginIndex = i;
				break;
			}			
			// 一开始包含了+-符号
			if (curChar == '-') {
				signal = -1;
				isHit = true;
				beginIndex = i + 1;
				break;
			}
			if (curChar == '+') {
				signal = 1;
				isHit = true;
				beginIndex = i + 1;
				break;
			}
			// 一开始包含了非空格的非法字符，直接结束
			if (map.containsKey(curChar) == false && curChar != ' ') {
				return 0;
			}
		}
		if (isHit == false) {
			return 0;
		}
		int result = 0, lastResult = 0;
		for (int i = beginIndex; i < length; i++) {
			curChar = chars[i];
			// if( curChar == '.' || curChar == '-' || curChar == '+' ){
			// break;
			// }
			// 如果后续的字符里面还包含了非数字的字符，就直接忽略
			if (map.containsKey(curChar) == false) {
				// System.out.println("跳过："+curChar);
				break;
			}
			lastResult = result;
			result = result * 10 + map.get(curChar);
			// System.out.println("result:" + result);
			// 判断溢出，无法还原上次的结果就是溢出了
			if ((result - map.get(curChar)) / 10 != lastResult || result < 0) {
				// System.out.println("溢出");
				if (signal == 1) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}

		}
		// System.out.println("beginIndex:" + beginIndex + " value:" +
		// str.charAt(beginIndex));
		// System.out.println("signal:" + signal);
		return result * signal;
	}

	public static void main(String[] args) {
		System.out.println("MAX:" + Integer.MAX_VALUE);
		System.out.println("MIN:" + Integer.MIN_VALUE);
		StringToInteger s = new StringToInteger();
		String str = "2147483648";
		System.out.println(s.myAtoi(str));
	}
}
