package com.kxw.leetcode;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element.
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 找到第k大的数
 * @author kangxiongwei
 * @date 2015年8月26日
 */
public class KthLargestElementInArray {

	public static void main(String[] args) {
		KthLargestElementInArray kl = new KthLargestElementInArray();
		int[] nums = {3,2,1,5,6,4};
		int result = kl.findKthLargest(nums, 1);
		System.out.println(result);
	}
	
	public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
		return nums[nums.length-k];
		/*int n = nums.length;
	    int p = quickSelect(nums, 0, n - 1, n - k + 1);
	    return nums[p];*/
    }
	
	int quickSelect(int[] a, int lo, int hi, int k) {
	    int i = lo, j = hi, pivot = a[hi];
	    while (i < j) {
	    	if (a[i++] > pivot) 
	    		swap(a, --i, --j);
	    }
	    swap(a, i, hi);
	    int m = i - lo + 1;
	    if (m == k)     
	    	return i;
	    else if (m > k) 
	    	return quickSelect(a, lo, i - 1, k);
	    else            
	    	return quickSelect(a, i + 1, hi, k - m);
	}

	void swap(int[] a, int i, int j) {
	    int tmp = a[i];
	    a[i] = a[j];
	    a[j] = tmp;
	}

	
}
