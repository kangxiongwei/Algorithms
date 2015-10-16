package com.kxw.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组，找出a+b+c=0的所有组合
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 结果：(-1, 0, 1) (-1, -1, 2)
 * @author kangxiongwei
 * @date 2015年8月21日
 */
public class Sum3 {
	
	public static void main(String[] args) {
		Sum3 sum = new Sum3();
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> list = sum.threeSum(nums);
		for(List<Integer> l: list){
			for(Integer i: l){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<>();
		for(int i=0; i<nums.length-2; i++) {
			//第二个条件：当nums[i] == nums[i-1]时，可以直接跳过一次循环，因为已经找到了。
			if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
				 int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
				 while (lo < hi) {
	                if (nums[lo] + nums[hi] == sum) {
	                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
	                    //为了去除重复，如果nums[lo] == nums[lo+1]，则lo直接跳2步
	                    while (lo < hi && nums[lo] == nums[lo+1]) lo++;
	                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;
	                    lo++; 
	                    hi--;
	                } 
	                else if (nums[lo] + nums[hi] < sum)
	                	lo++;
	                else hi--;
		         }
			}
			//System.out.println("第"+i+"轮结束，此时的结果为：");
			//System.out.println(result);
		}
		return result;
	}
}
