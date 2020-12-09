package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
	public int[] plusOne2(int[] digits) {
		int[] result = {};
		if (digits.length == 0) {
			return new int[0];
		}
		// 进位
		int carry = 1;
		int curResult = 0;
		int count = 0;
		if (digits[0] <= 8) {
			result = new int[digits.length];
			for (int i = digits.length - 1; i >= 0; i--) {
				// 当i = digits.length - 1时，carry等于1
				curResult = digits[i] + carry;
				result[i] = curResult % 10;
				carry = curResult / 10;
			}
		} else {
			// 这里还不确定result的长度，所以用List，结果要进行反转
			List<Integer> list = new ArrayList<Integer>();
			for (int i = digits.length - 1; i >= 0; i--) {
				// 当i = digits.length - 1时，carry等于1
				curResult = digits[i] + carry;
				list.add(curResult % 10);
				carry = curResult / 10;
				count++;
			}
			if (carry == 1) {
				list.add(1);
			}
			int len = list.size();
			result = new int[len];
			count = 0;
			// copy back
			for (int i = len - 1; i >= 0; i--) {
				result[i] = list.get(count++);
			}
		}
		return result;
	}

	public int[] plusOne(int[] digits) {
		if (digits[digits.length - 1] < 9) {
			digits[digits.length - 1]++;
			return digits;
		}
		int[] result = new int[digits.length];
		int carry = 1;
		int curResult = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			// 当i = digits.length - 1时，carry等于1
			curResult = digits[i] + carry;
			result[i] = curResult % 10;
			carry = curResult / 10;
		}
		if (carry == 1) {
			int[] newResult = new int[result.length + 1];
			newResult[0] = 1;
			for (int i = 1; i <= result.length; i++) {
				newResult[i] = result[i - 1];
			}
			return newResult;
		} else {
			return result;
		}
	}

	public void print(int[] result) {
		String str = "";
		for (int i = 0; i < result.length; i++) {
			str += (result[i] + " ");
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		PlusOne s = new PlusOne();
		int[] digits = { 9, 6, 3, 5, 6 };
		s.print(s.plusOne(digits));
	}
}
