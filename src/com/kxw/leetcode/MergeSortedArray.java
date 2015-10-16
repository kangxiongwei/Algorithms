package com.kxw.leetcode;

import com.kxw.util.ArrayUtil;

/**
 * leetcode 88
 * 给定两个排好序的数组，将数组2合并到数组1中，假设数组1长度足够
 * @author kangxiongwei
 * @date 2015年10月16日
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = {1,3,5,7,9,0,0,0,0,0};
		int[] nums2 = {2,4,6};
		merge(nums1, 5, nums2, 3);
		ArrayUtil.printIntArray(nums1);
	}
	
	
	/**
	 * 将两个数组合并成一个数组temp，然后将值全部复制进去
	 * 时间复杂度：O(2(m+n))
	 * 空间复杂度：O(m+n)
	 * @param nums1
	 * @param m nums1中元素个数
	 * @param nums2
	 * @param n nums2中元素个数
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] temp = new int[m+n];
		int i = 0; 
		int j = 0;
		int k = 0;
		while(i < m && j < n){
			if(nums1[i] < nums2[j]){
				temp[k] = nums1[i];
				i++;
			}
			else{
				temp[k] = nums2[j];
				j++;
			}
			k++;
		}
		while(i < m){
			temp[k] = nums1[i];
			i++;
			k++;
		}
		while(j < n){
			temp[k] = nums2[j];
			j++;
			k++;
		}
		for(int p=0; p<temp.length; p++){
			nums1[p] = temp[p];
		}
	}
	
}
