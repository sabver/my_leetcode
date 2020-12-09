package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersSecond {
	class SlideWindow{
		public int left = 0;
		public int length = 0;
		public int max = 0;		
	}
    public int lengthOfLongestSubstring(String s) {
    	SlideWindow sw = new SlideWindow();
    	//map管理滑动窗口里面的所有字符的个数
    	Map<Character,Integer> map = new HashMap<Character,Integer>(s.length()/2);
    	for(int i=0;i<s.length();i++){
    		if( map.containsKey(s.charAt(i)) == false ){
    			map.put(s.charAt(i), i);   
    		}else{
    			int index = map.get(s.charAt(i));
//    			System.out.print(index+"\n");
    			if( index >= sw.left ){
    				sw.left = index+1;
    			}
    			map.put(s.charAt(i), i);    			
    		}
    		sw.length = i-sw.left+1;
    		sw.max = Math.max(sw.max, sw.length);
    	}
    	return sw.max;
    }
    public static void main(String[] args) {
    	LongestSubstringWithoutRepeatingCharactersSecond obj = new LongestSubstringWithoutRepeatingCharactersSecond();
    	//"pwwkew"
    	//"abcabcbb"
    	//"bbbbb"
    	String [] ss = {"pwwkew","abcabcbb","bbbbb","aab","dvdf"};
    	int [] answers = {3,3,1,2,3};
    	for(int i=0;i<ss.length;i++){
    		int result = obj.lengthOfLongestSubstring(ss[i]);
    		if( result!=answers[i] ){
    			System.out.print(ss[i]+"的结果有误 "+" 正确结果："+answers[i]+" 实际结果："+result+" \n");
    		}
    	}
//    	String s = "aab";
//    	System.out.print(obj.lengthOfLongestSubstring(s)); 
    }
    
    
}
