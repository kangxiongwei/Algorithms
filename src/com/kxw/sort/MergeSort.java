package com.kxw.sort;

import com.kxw.util.ArrayUtil;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums = {5,2,4,7,1,3,2,6};
		//merge(nums, 0, 3, nums.length-1);
		mergeSort(nums, 0, nums.length-1);
		ArrayUtil.printIntArray(nums);
	}
	
	
	public static void mergeSort(int[] nums,int p,int r){
		if(p < r){
			int q = (p+r)/2;
			mergeSort(nums, p, q);
			mergeSort(nums, q+1, r);
			merge(nums,p,q,r);
		}
	}

	//进行合并
	private static void merge(int[] nums, int p, int q, int r) {
		//System.out.println("p: "+p+", q: "+q+",r: "+r);
		int n1 = q-p+1;
		int n2 = r-q;
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		for(int i=0; i<n1; i++){
			left[i] = nums[i+p];
		}
		for(int i=0; i<n2; i++){
			right[i] = nums[i+q+1];
		}
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for(int k=p; k<=r; k++){
			if(left[i] <= right[j]){
				nums[k] = left[i];
				i++;
			}
			else {
				nums[k] = right[j];
				j++;
			}
		}
	}
	
}
