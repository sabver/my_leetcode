package leetcode.easy;

import java.util.PriorityQueue;

class KthLargest {
	PriorityQueue<Integer> queue = new PriorityQueue<>();
	int k = 0;
	public KthLargest(int k, int[] nums) {
		for(int e: nums) {
			queue.offer(e);
			if( queue.size() > k ) {
				queue.poll();
			}
		}
		this.k = k;
	}

	public int add(int val) {
		queue.offer(val);
		if( queue.size() > k ) {
			queue.poll();
		}
		return queue.peek();
	}
}

public class KthLargestElementInAStream {

}
