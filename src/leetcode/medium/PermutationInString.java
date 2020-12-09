package leetcode.medium;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
    	if( s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length() ){
    		return false;
    	}
    	
    	return true;
    }
    public static void main(String[] args) {
    	PermutationInString s = new PermutationInString();
    	String s1 = "",s2 = "";
    	boolean result = s.checkInclusion(s1, s2);
    	System.out.println(result);
    }
}
