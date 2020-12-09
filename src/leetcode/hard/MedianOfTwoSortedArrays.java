package leetcode.hard;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums2.length > nums1.length) {
			System.out.println("normal");
			return findMedianSortedArraysIndex(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1,
					(nums1.length + nums2.length) / 2);
		} else {
			System.out.println("rerves");
			return findMedianSortedArraysIndex(nums2, 0, nums2.length - 1, nums1, 0, nums1.length - 1,
					(nums1.length + nums2.length) / 2);
		}
	}

	public double findMedianSortedArraysIndex(int[] nums1, int begin1, int end1, int[] nums2, int begin2, int end2,
			int targetRank) {
		if (targetRank < 0) {
			return 0;
		}
		int mid1 = getMid(begin1, end1), mid2 = getMid(begin2, end2);
		int index1In2 = binarySearch(nums2, nums1[mid1], begin2, end2);
		int index2In1 = binarySearch(nums1, nums2[mid2], begin1, end1);
		System.out.println("mid1:" + mid1 + " value:" + nums1[mid1]);
		System.out.println("mid2:" + mid2 + " value:" + nums2[mid2]);
		System.out.println("index1In2:" + index1In2);
		System.out.println("begin1:" + begin1 + " value:" + nums1[begin1]);
		System.out.println("end1:" + end1 + " value:" + nums1[end1]);
		System.out.println("begin2:" + begin2 + " value:" + nums2[begin2]);
		System.out.println("end2:" + end2 + " value:" + nums2[end2]);
		System.out.println("targetRank:" + targetRank);
		System.out.println("");
		if (end1 - begin1 > end2 - begin2) {
			if (index2In1 > mid1) {
				return findMedianSortedArraysIndex(nums2, begin2, mid2, nums1, mid1, end1, targetRank - mid1);
			} else if (index2In1 <= mid1) {
				return findMedianSortedArraysIndex(nums2, mid2, end2, nums1, begin1, mid1, targetRank - mid2);
			}
		} else {
			if (index1In2 > mid2) {
				return findMedianSortedArraysIndex(nums1, begin1, mid1, nums2, mid2, end2, targetRank - mid2);
			} else if (index1In2 <= mid2) {
				return findMedianSortedArraysIndex(nums1, mid1, end1, nums2, begin2, mid2, targetRank - mid1);
			}
		}
		return 0;

	}

	public int getMid(int low, int high) {
		return low + (high - low) / 2;
	}

	public int binarySearch(int nums[], int value, int low, int high) {
		if (low >= high) {
			if (nums[low] == value) {
				return low;
			} else if (nums[low] > value) {
				return low;
			} else {
				return low + 1;
			}
		}
		int mid = getMid(low, high);
		System.out.println("low:" + low + " value:" + nums[low]);
		System.out.println("high:" + high + " value:" + nums[high]);
		System.out.println("mid:" + mid + "  value:" + nums[mid]);
		System.out.println("");
		if (nums[mid] > value) {
			return binarySearch(nums, value, low, mid - 1);
		} else if (nums[mid] < value) {
			return binarySearch(nums, value, mid + 1, high);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays s = new MedianOfTwoSortedArrays();
		int[] nums1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] nums2 = { 3,10,11,12 };
		System.out.println(s.findMedianSortedArrays(nums1, nums2));
		// System.out.println(s.binarySearch(nums1, 10, 0, nums1.length - 1));
	}
}
