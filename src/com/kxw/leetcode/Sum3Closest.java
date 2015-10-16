package com.kxw.leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * 给定一个有n个整数的数组S，一个数字target，从S中找到3个数，使3个数的总和最接近target
 * @author kangxiongwei
 * @date 2015年8月22日
 */
public class Sum3Closest {

	public static void main(String[] args) {
		int[] nums = {0,2,1,-3};
		int target = 1;
		int result = new Sum3Closest().threeSumClosest(nums, target);
		System.out.println(result);
		
	}
	
	public int threeSumClosest(int[] nums, int target) {
		int sum = nums[0]+nums[1]+nums[nums.length-1];
		//所有数从小到大排列
		Arrays.sort(nums);
		for(int i=0; i<nums.length-2; i++) {
			int low = i+1;
			int hig = nums.length-1;
			while(low < hig){
				int temp = nums[i]+nums[low]+nums[hig];
				if(temp > target) {
					hig--;
				} else {
					low++;
				}
				if(Math.abs(temp-target) < Math.abs(sum-target)){
					sum = temp;
				}
			}
		}
		return sum;
	}
	
}
