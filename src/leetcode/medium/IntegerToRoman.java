package leetcode.medium;

import java.util.HashMap;

public class IntegerToRoman {
	HashMap<Integer, String> map = new HashMap<Integer, String>();

	public String intToRoman(int num) {
		StringBuffer result = new StringBuffer();
		initMap();
		int divide = 0, mul = 1000;
		while (num != 0) {
			divide = num / mul;
			createRomanNum(result, divide, mul);
			num %= mul;
			mul /= 10;
		}
		return result.toString();
	}

	public void initMap() {
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
	}

	public void createRomanNum(StringBuffer result, int divide, int mul) {
		if (mul == 1000) {
			for (int i = 1; i <= divide; i++) {
				result.append(map.get(mul));
			}
		} else {
			if (divide != 4 && divide != 9) {
				if (divide >= 5) {
					result.append(map.get(mul * 5));
					for (int i = 6; i <= divide; i++) {
						result.append(map.get(mul));
					}
				} else {
					for (int i = 1; i <= divide; i++) {
						result.append(map.get(mul));
					}
				}
			} else {
				result.append(map.get(mul * divide));
			}
		}
	}

	public static void main(String[] args) {
		IntegerToRoman s = new IntegerToRoman();
		System.out.println(s.intToRoman(1994));
	}
}
