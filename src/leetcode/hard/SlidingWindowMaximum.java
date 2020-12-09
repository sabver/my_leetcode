package leetcode.hard;

import leetcode.util.Util;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if( k == 0 || nums.length == 0 ){
    		return new int[0];
    	}
    	int len = nums.length - k + 1;
    	int[] result = new int[len];
    	int max = Integer.MIN_VALUE,maxIndex = -1,count = -1,start = 0,end = k-1;
    	while( end < nums.length ){
    		//没必要更新
    		if( !(nums[end] < max && maxIndex >=start) ){
    			if( maxIndex == start-1 ){
    				max = Integer.MIN_VALUE;
    			}
        		for(int i=start;i<=end;i++){
        			if( max <= nums[i] ){
        				max = nums[i];
        				maxIndex = i;
        			}
        		}      			
    		}  		
    		start++;
    		end++;
    		count++;
    		result[count] = max;    		
    	}
    	return result;
    }
    public static void main(String[] args) {
    	SlidingWindowMaximum s = new SlidingWindowMaximum();
    	int [] nums = {1,-1};
    	int k = 1;
//    	int [] nums = {1,3,-1,-3,5,3,6,7};
//    	int k = 3;    	
    	int [] result = s.maxSlidingWindow(nums, k);
    	Util.printArray(result);
    }
}
