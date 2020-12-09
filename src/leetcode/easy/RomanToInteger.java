package leetcode.easy;

import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999. There are six instances where subtraction is
 * used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900.
 * 
 * @author yejianfeng
 *
 */
public class RomanToInteger {
	private static HashMap<Character, Integer> MAP = new HashMap<Character, Integer>();

	RomanToInteger() {
		MAP.put('I', 1);
		MAP.put('V', 5);
		MAP.put('X', 10);
		MAP.put('L', 50);
		MAP.put('C', 100);
		MAP.put('D', 500);
		MAP.put('M', 1000);
	}
	/**
	 * Runtime: 104 ms
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int length = s.length();
		int result = 0;
		int lastNum = 0;
		int curNum = 0;
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				result += MAP.get(s.charAt(i));
			} else {
				lastNum = MAP.get(s.charAt(i - 1));
				curNum = MAP.get(s.charAt(i));
				if (lastNum * 5 == curNum) {
					result += (curNum - curNum / 5 * 2);
					continue;
				}
				if (lastNum * 10 == curNum) {
					result += (curNum - curNum / 10 * 2);
					continue;
				}
				result += curNum;
			}
		}
		return result;
	}

	/**
	 * Runtime: 119 ms
	 * 
	 * @param s
	 * @return
	 */
	public int romanToInt4(String s) {
		int length = s.length();
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				result += MAP.get(s.charAt(i));
			} else {
				if ((s.charAt(i) == 'V' && s.charAt(i - 1) == 'I') || (s.charAt(i) == 'X' && s.charAt(i - 1) == 'I')) {
					result += (MAP.get(s.charAt(i)) - 2);
					continue;
				}
				if ((s.charAt(i) == 'L' && s.charAt(i - 1) == 'X') || (s.charAt(i) == 'C' && s.charAt(i - 1) == 'X')) {
					result += (MAP.get(s.charAt(i)) - 20);
					continue;
				}
				if ((s.charAt(i) == 'D' && s.charAt(i - 1) == 'C') || (s.charAt(i) == 'M' && s.charAt(i - 1) == 'C')) {
					result += (MAP.get(s.charAt(i)) - 200);
					continue;
				}
				result += MAP.get(s.charAt(i));
			}
		}
		return result;
	}

	/**
	 * Runtime: 151 ms
	 * 
	 * @param s
	 * @return
	 */
	public int romanToInt3(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int length = s.length();
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				result += map.get(s.charAt(i));
			} else {
				if ((s.charAt(i) == 'V' && s.charAt(i - 1) == 'I') || (s.charAt(i) == 'X' && s.charAt(i - 1) == 'I')) {
					result += (map.get(s.charAt(i)) - 2);
					continue;
				}
				if ((s.charAt(i) == 'L' && s.charAt(i - 1) == 'X') || (s.charAt(i) == 'C' && s.charAt(i - 1) == 'X')) {
					result += (map.get(s.charAt(i)) - 20);
					continue;
				}
				if ((s.charAt(i) == 'D' && s.charAt(i - 1) == 'C') || (s.charAt(i) == 'M' && s.charAt(i - 1) == 'C')) {
					result += (map.get(s.charAt(i)) - 200);
					continue;
				}
				result += map.get(s.charAt(i));
			}
		}
		return result;
	}

	/**
	 * Runtime: 133 ms
	 * 
	 * @param s
	 * @return
	 */
	public int romanToInt2(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);
		int result = 0;
		int length = s.length();
		String frontTwoStr = "";
		for (int i = 0; i < length; i++) {
			// 判断两个字符的情况
			if (i + 1 < length) {
				frontTwoStr = s.charAt(i) + "" + s.charAt(i + 1);
				if (map.containsKey(frontTwoStr)) {
					result += map.get(frontTwoStr);
					i++;
					continue;
				}
				result += map.get(s.charAt(i) + "");
			} else {
				result += map.get(s.charAt(i) + "");
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		System.out.println(rti.romanToInt("MCDLXXVI"));
	}
}
