package com.kxw.leetcode;

import java.util.Arrays;

/**
 * leetcode 27
 * @author kangxiongwei
 * @date 2015年10月10日
 */
public class RemoveElement {
	
	public static void main(String[] args) {
		//int[] nums = {4,5,4,4,6};
		int[] nums = {2};
		int len = removeElement(nums, 3);
		for(int i=0; i<len; i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
	
	public static int removeElement(int[] nums,int val){
		if(nums.length == 0) return 0;
		Arrays.sort(nums);
		int left = 0;
		int right = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] == val) {
				left = i;
				break;
			}
		}
		for(int i=nums.length-1; i>=0; i--){
			if(nums[i] == val) {
				right = i;
				break;
			}
		}
		int dis = 0;
		//要删除的val有多个或者只有一个元素的两个条件
		//或者可以写成  left<=right && nums[left] == val
		if(left < right || (left == right && nums[left] == val)){
			dis = right-left+1;
			for(int i=left; i<nums.length-dis; i++){
				nums[i] = nums[i+dis];
			}
		}
		//System.out.println("left: "+left+",right: "+right);
		return nums.length-dis;
	}
	
}
