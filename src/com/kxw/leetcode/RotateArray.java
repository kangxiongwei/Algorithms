package com.kxw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Rotate an array of n elements to the right by k steps.
 * @author kangxiongwei
 * @date 2015年8月26日
 */
@SuppressWarnings("unused")
public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {1,2};
		RotateArray ra = new RotateArray();
		ra.rotate(nums, 3);
		//ra.myResult1(nums,3);
	}
	
	public void rotate(int[] nums, int k) {
        
    }

	private void test(int[] nums, int k) {
		int step = (nums.length%k==0)?(nums.length/k):(nums.length/k+1);
        int[] temp = new int[nums.length];
        int cusor = 0;
        for(int i=1; i<=step; i++){
        	int index = nums.length-i*k;
        	for(int j=index; j<index+k;j++){
        		if(j >= 0){
        			temp[cusor++]=nums[j];
        		}
        	}
        }
	}
	/**
	 * 这种方法可以，给数组整体后移k位，前面补充被替换的值
	 * O(n+k)
	 * @param nums
	 * @param k
	 */
	private void myResult1(int[] nums,int k){
		//因为旋转nums.length次，相当于没有旋转，所以去掉这种情况，保证k<nums.length
		while(nums.length < k) k = k-nums.length;
        int index = nums.length - k;
        int[] tempArray = new int[k];
        for(int i=0; i<k; i++){
        	tempArray[i] = nums[index+i];
        }
        for(int i=nums.length-k-1; i>=0; i--){
        	nums[i+k] = nums[i];
        }
        for(int i=0; i<tempArray.length; i++){
        	nums[i] = tempArray[i];
        }
	}
	/**
	 * 每次移动一位，循环移动
	 * 时间复杂度较高，超时
	 * @param nums
	 * @param k
	 */
	private void myResult2(int[] nums,int k){
		for(int i=0; i<k; i++){
        	int temp = nums[nums.length-1];
        	for(int j=nums.length-1; j>0; j--){
        		nums[j] = nums[j-1];
        	}
        	nums[0] = temp;
        }
	}
}
