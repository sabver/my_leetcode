package leetcode.medium;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.length() >= num2.length()) {
			if( num2.equals("0") ){
				return "0";
			}
			return multiply(num1.toCharArray(), num2.toCharArray()).toString();
		} else {
			if( num1.equals("0") ){
				return "0";
			}			
			return multiply(num2.toCharArray(), num1.toCharArray()).toString();
		}
	}

	public StringBuffer multiply(char[] longNum, char[] shortNum) {
		int shortLen = shortNum.length;
		StringBuffer curResult = null;
		for (int i = 0; i < shortLen; i++) {
			if (curResult != null) {
				curResult = add(curResult.append(0), multiplyOne(longNum, shortNum[i]));
			} else {
				curResult = multiplyOne(longNum, shortNum[i]);
			}
		}
		return curResult;
	}

	/**
	 * 
	 * @param num1
	 * @param one
	 *            num2的某一位数字
	 * @return
	 */
	public StringBuffer multiplyOne(char[] num1, char one) {
		StringBuffer result = new StringBuffer();
		int length = num1.length;
		// carry进位 item当前乘值 oneNumber对应one的数字,curResult每次循环得出的结果
		int carry = 0, item = 0, oneNumber = one - 48, curResult = 0;
		for (int i = length - 1; i >= 0; i--) {
			item = num1[i] - 48;
			curResult = item * oneNumber + carry;
			carry = curResult / 10;
			result.append(curResult % 10);
		}
		if (carry != 0) {
			result.append(carry);
		}
		return result.reverse();
	}

	public StringBuffer add(StringBuffer num1, StringBuffer num2) {
		if (num1.length() >= num2.length()) {
			return add(num1.toString().toCharArray(), num2.toString().toCharArray());
		}
		return add(num2.toString().toCharArray(), num1.toString().toCharArray());
	}

	/**
	 * 这里控制longNum.length() >= shortNum.length()
	 * 
	 * @param longNum
	 * @param shortNum
	 * @return
	 */
	public StringBuffer add(char[] longNum, char[] shortNum) {
		StringBuffer result = new StringBuffer();
		int longLen = longNum.length;
		int shortLen = shortNum.length;
		boolean isCarry = false;
		int curResult = 0;
		while (shortLen != 0) {
			if (isCarry) {
				curResult = (longNum[longLen - 1] - 48) + (shortNum[shortLen - 1] - 48) + 1;
			} else {
				curResult = (longNum[longLen - 1] - 48) + (shortNum[shortLen - 1] - 48);
			}
			if (curResult >= 10) {
				isCarry = true;
			} else {
				isCarry = false;
			}
			result.append(curResult % 10);
			longLen--;
			shortLen--;
		}
		if (isCarry) {
			if (longLen != 0) {
				while (isCarry && longLen != 0) {
					curResult = (longNum[longLen - 1] - 48) + 1;
					if (curResult >= 10) {
						isCarry = true;
					} else {
						isCarry = false;
					}
					result.append(curResult % 10);
					longLen--;
				}
				if (isCarry == true && longLen == 0) {
					result.append(1);
				} else if (isCarry == false && longLen != 0) {
					for (int i = longLen; i >= 1; i--) {
						result.append((longNum[i - 1] - 48));
					}
				}
			} else {
				result.append(1);
			}
		} else {
			if (longLen != 0) {
				for (int i = longLen; i >= 1; i--) {
					result.append((longNum[i - 1] - 48));
				}
			}
		}
		return result.reverse();
	}

	public static void main(String[] args) {
		MultiplyStrings s = new MultiplyStrings();
		StringBuffer num1 = new StringBuffer("9133");
		StringBuffer num2 = new StringBuffer("0");
		// System.out.println(s.add(num1, num2).toString());
		System.out.println(s.multiply(num1.toString(), num2.toString()));
		// System.out.println(s.multiplyOne(num1.toString().toCharArray(),'3'));

	}
}
