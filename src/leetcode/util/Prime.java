package leetcode.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Prime {
	/**
	 * 找出所有小于target的素数
	 * 
	 * @param target
	 * @return
	 */
	public List<Integer> findPrime(int target) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(2);
		int begin = 3;
		for (int i = begin; i <= target; i += 2) {
			if( isPrime(i) ){
				result.add(i);
			}
		}
		return result;
	}
	
	public boolean isPrime(int number){
		for(int i=3;i<=Math.sqrt(number);i++){
			if( number%i == 0 ){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Prime s = new Prime();
		int target = 400;
		System.out.println(s.findPrime(target));
		// a-97 z-122
		char c = 'z';
		int n = 'z'-'a';
		System.out.println(n);
	}
}
