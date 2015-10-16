package com.kxw.util;

public class ArrayUtil {

	/**
	 * 交换nums中i和j位置的元素
	 * @param nums
	 * @param i
	 * @param j
	 */
	public static void swap(int[] nums,int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/**
	 * 打印整形数组
	 * @param nums
	 */
	public static void printIntArray(int[] nums){
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	} 
	
	/**
	 * 打印数组到控制台
	 * @param objs
	 */
	public static void printArray(Object[] objs){
		for(int i=0; i<objs.length; i++){
			System.out.print(objs[i]+" ");
		}
		System.out.println();
	}
}
