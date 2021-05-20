package leetcode.easy;

public class AddBinaryRename {
	public String addBinary(String a, String b) {
		if (a.length() >= b.length()) {
			return addBinaryRealy(a.toCharArray(), b.toCharArray());
		} else {
			return addBinaryRealy(b.toCharArray(), a.toCharArray());
		}
	}

	/**
	 * 要求的长度大于b的长度
	 * 
	 * @param longChars
	 * @param shortChars
	 * @return
	 */
	public String addBinaryRealy(char[] longStrs, char[] shortStrs) {
		StringBuffer result = new StringBuffer();
		int longLen = longStrs.length;
		int shortLen = shortStrs.length;
		int carry = 0;
		int curResult = 0;
		while (shortLen != 0) {
			curResult = longStrs[longLen - 1] - 48 + shortStrs[shortLen - 1] - 48 + carry;
			result.append(curResult % 2);
			carry = curResult / 2;
			longLen--;
			shortLen--;
		}
		//这里只剩下longStrs了
		while( longLen!=0 ){
			curResult = longStrs[longLen - 1] - 48  + carry;
			result.append(curResult % 2);
			carry = curResult / 2;			
			longLen--;
		}
		if( carry == 1 ){
			result.append(1);
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		AddBinaryRename s = new AddBinaryRename();
		String a = "1010";
		String b = "1011";
		System.out.println(s.addBinary(a, b));
	}
}
