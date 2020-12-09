package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	/**
	 * 这个答案是参考了discussion的
	 * https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
	 * @param s
	 * @param k
	 * @return
	 */
    public int characterReplacement(String s, int k) {
    	if( s == null || s.length() == 0 ){
    		return 0;
    	}
    	int max = 0,start = 0,maxCount = 0,len = s.length();
    	int count[] = new int[26];
    	Character c = null;
    	for(int end = 0;end < len;end++){
    		c = s.charAt(end);
    		 //end走过的地方用++，然后start前进的时候要--，这是为了去掉[0...start-1]的数据的影响
    		maxCount = Math.max(maxCount, ++count[c-'A']);
    		//强制达到maxLength的更新条件，即end-start+1 = maxCount+k
    		while( end - start + 1 > maxCount + k ){
    			count[s.charAt(start)-'A']--;
    			start++;
    		}
    		max = Math.max(max, end - start + 1);
    	}
    	return max;
    }	
	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
		String s = "";
		int k = 0;
		int result = obj.characterReplacement(s, k);
		System.out.println(result);
	}    
}
