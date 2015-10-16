package com.kxw.leetcode;

import com.kxw.util.ArrayUtil;


/**
 * 给定一个只有0,1的数组，找出其中0和1的个数相等的最长字串
 * @author kangxiongwei
 * @date 2015年10月15日
 */
public class LogestCommonSubArray {

	public static void main(String[] args) {
		int[] nums = {-1,1,1,1,-1,-1,-1,1,1,1,-1,1,1};
		//记录数组中0的个数
		int count = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] == -1) count++;
		}
		//1的个数为nums.length-count，最长子数组长度<=2*Math.min(count,nums.length-count) 
		int length = 2*Math.min(count, nums.length-count);
		int[] result = getLogestSub(nums,length);
		ArrayUtil.printIntArray(result);
	}
	
	
	/**
	 * 得到nums中长度为length的符合条件的子串
	 * @param nums
	 * @param length
	 * @return
	 */
	public static int[] getLogestSub(int[] nums,int length){
		int[] result = new int[length];
		//前length个数的和
		int sum = 0;
		for(int i=0; i<length; i++){
			sum += nums[i];
		}
		//记录前面length个数的和为0的第一个数组下标
		int right = 0;
		for(int i=length; i<nums.length; i++){
			if(sum == 0){
				right = i;
				break;
			}
			else {
				sum = sum+nums[i]-nums[i-length];
			}
		}
		//找到了最长子数组
		if(right >= length){
			for(int i=right-length; i<right; i++){
				result[i-right+length] = nums[i];
			}
		}
		else {
			result = getLogestSub(nums, length-1);
		}
		return result;
	}
	
}
