package leetcode.easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
    	Arrays.sort(g);
    	Arrays.sort(s);
    	int child = 0,candy = 0;
    	while( child < g.length && candy < s.length ){
    		//糖果可以满足小孩
    		if( g[child] <= s[candy] ){
    			child++;
    			candy++;
    		}else{
    			candy++;
    		}
    	}
        return child;
    }
}
