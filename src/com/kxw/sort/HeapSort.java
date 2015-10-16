package com.kxw.sort;

import com.kxw.util.ArrayUtil;

public class HeapSort {

	public static void main(String[] args) {
		HeapSort hs = new HeapSort();
		int[] nums = {3,5,6,2,1,7,8,9};
		hs.heapSort(nums);
		System.out.println("结果是：");
		ArrayUtil.printIntArray(nums);
	}
	
	/**
	 * 堆排序
	 * @param nums
	 */
	public void heapSort(int[] nums){
		this.createHeap(nums);
		/*System.out.println("建堆结果为：");
		ArrayUtil.printIntArray(nums);*/
		int length = nums.length-1;
		//挑出一个最大的元素放在最后，再从剩余的元素中继续调
		for(int i=length; i>=1; i--){
			ArrayUtil.swap(nums, i, 0);
			maxHeap(nums, 0, --length);
		}
	}
	
	/**
	 * 建堆过程
	 * @param nums
	 */
	private void createHeap(int[] nums){
		for(int i=nums.length/2; i>=0; i--){
			this.maxHeap(nums, i, nums.length-1);
		}
	}
	
	/**
	 * 维护一个大根堆
	 * @param nums
	 * @param i
	 */
	private void maxHeap(int[] nums,int i,int length){
		int left = 2*i+1;
		int right = 2*i+2;
		//比较left，right，i谁最大，如果不是i最大，则交换i和largest所指的元素
		int largest = 0;
		if(left <= length && nums[left] > nums[i]){
			largest = left;
		}
		else {
			largest = i;
		}
		if(right <= length && nums[right] > nums[largest]){
			largest = right;
		}
		if(i != largest){
			ArrayUtil.swap(nums, i, largest);
			maxHeap(nums, largest, length);
		}
	}
	
}
