package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		public String toString() {
			return "[" + start + "," + end + "]";
		}

	}

	class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			if (o1.start > o2.start) {
				return 1;
			} else if (o1.start < o2.start) {
				return -1;
			} else {
				if (o1.end > o2.end) {
					return 1;
				} else if (o1.end < o2.end) {
					return -1;
				} else {
					return 0;
				}
			}
		}

	}

	public void test() {
		List<Interval> intervals = new ArrayList<Interval>();
		int nums[] = { 1, 4, 0, 2, 3, 5 };
		for (int i = 0; i < nums.length; i = i + 2) {
			intervals.add(new Interval(nums[i], nums[i + 1]));
		}
		// intervals.add(new Interval(8, 10));
		// intervals.add(new Interval(1, 3));
		// intervals.add(new Interval(2, 7));
		// intervals.add(new Interval(15, 18));
		// intervals.add(new Interval(2, 6));
		System.out.println(intervals);
		System.out.println(merge(intervals));
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			return result;
		}
		if (intervals.size() == 1) {
			return intervals;
		}
		Collections.sort(intervals, new IntervalComparator());
		int len = intervals.size();
		// 当前要被判定是否需要合并的元素 上一个被合并或者没有合并的元素（即被比较者）
		result.add(intervals.get(0));
		Interval cur = null, lastMerget = result.get(0);
		for (int i = 1; i < len; i++) {
			cur = intervals.get(i);
			// 有交叉，需要合并，这里的合并动作只是更新一下lastMerget的end
			if (cur.start <= lastMerget.end) {
				lastMerget.end = Math.max(cur.end, lastMerget.end);
			} else {
				// 不需要合并
				result.add(cur);
				lastMerget = cur;
			}
		}
		return result;
	}

	/**
	 * error
	 * 
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge2(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			return result;
		}
		if (intervals.size() == 1) {
			return intervals;
		}
		Collections.sort(intervals, new IntervalComparator());
		System.out.println(intervals);
		Interval front = null, end = null;
		int len = intervals.size();
		int frontMaxEnd = intervals.get(0).end;
		// 标记是否已经合并过前者了
		boolean isMergeFront = false;
		for (int i = 1; i < len; i++) {
			front = intervals.get(i - 1);
			end = intervals.get(i);
			System.out.println("front:" + front);
			System.out.println("end:" + end);
			frontMaxEnd = Math.max(frontMaxEnd, front.end);
			// 有交叉，需要合并两者
			if (end.start <= frontMaxEnd) {
				if (front.end > end.end) {
					result.add(new Interval(front.start, front.end));
				} else {
					result.add(new Interval(front.start, end.end));
				}
				isMergeFront = true;
			} else {
				if (isMergeFront == false) {
					// 没有交叉同时前者没有被合并过，加入前者，后者需要在下次循环进行判定
					result.add(front);
				}
				// 如果最后一次没有交叉，那么后者也需要加入
				if (i == len - 1) {
					result.add(end);
				}
				isMergeFront = false;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MergeIntervals s = new MergeIntervals();
		s.test();
	}
}
