package leetcode.test;

public class Permuation {
	public void record(int[] nums){
		backtrack(nums,0);
	}
	
	public void backtrack(int [] nums,int level){
		if( level == nums.length - 1 ){
			print(nums);
			return;
		}
		for(int i=level;i<nums.length;i++){
			swap(nums,i,level);
			backtrack(nums,level+1);
			swap(nums,level,i);
		}
		
	}
	
	public void swap(int[] nums,int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void print(int [] nums){
		for(int i:nums){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] nums =  new int[]{1,2,3};
		Permuation p = new Permuation();
		p.record(nums);
	}	
}
