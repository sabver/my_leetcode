package leetcode.easy;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0,r = numbers.length-1,sum;
        while( l<r ){
        	sum = numbers[l]+numbers[r];
        	if(sum == target) break;
        	if( sum > target ){
        		r--;
        	}else{
        		l++;
        	}
        }
        return new int[]{l+1,r+1};
    }
}
