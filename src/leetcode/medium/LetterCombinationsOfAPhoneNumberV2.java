package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumberV2 {
	List<String> res = new ArrayList<>();
	StringBuffer track = new StringBuffer();
	Map<Character, String> map = new HashMap<>();

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return res;
		}
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		backtrack(digits, 0);
		return res;
	}

	public void backtrack(String digits, int level) {
		if( level >= digits.length() ) {
			// save
			res.add(track.toString());
			return ;
		}
		char c = digits.charAt(level);
		String str = map.get(c);
		for (int i = 0; i < str.length(); i++) {
			track.append(str.charAt(i));
			backtrack(digits, level + 1);
			track.deleteCharAt(track.length() - 1);
		}
	}
	
	public static void main(String args[]) {
		LetterCombinationsOfAPhoneNumberV2 l = new LetterCombinationsOfAPhoneNumberV2();
		String digits = "23";
		List<String> result = l.letterCombinations(digits);
		System.out.println(result);
	}

}
