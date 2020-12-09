package leetcode.hard;

import leetcode.util.Util;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
    	int len = nums.length;
    	if( len == 0 || k > len ){
    		return null;
    	}
    	double[] result = new double[ len - k + 1 ];
    	
    	return  result;
    }
    public static void main(String[] args) {
    	SlidingWindowMedian s  = new SlidingWindowMedian();
    	int [] nums = {1,3,-1,-3,5,3,6,7};
    	int k = 3;
    	double [] result = s.medianSlidingWindow(nums, k);
    	Util.printArray(result);
    }
}
