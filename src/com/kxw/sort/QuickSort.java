package com.kxw.sort;

import java.util.Random;

import com.kxw.util.ArrayUtil;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] nums = {2,5,6,1,3,8,5,4,8};
		qs.quickSort(nums, 0, nums.length-1);
		ArrayUtil.printIntArray(nums);
	}
	
	/**
	 * 递归进行所有排序
	 * @param array
	 * @param left
	 * @param right
	 */
	public void quickSort(int[] array,int left,int right){
		if(left < right) {
			int i = this.partition(array, left, right);
			quickSort(array, left, i-1);
			quickSort(array, i+1, right);
		}
	}
	
	/**
	 * 排列一次，使得比第一个数小的元素全部在它左边，其他在它右边
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private int partition(int[] array,int left,int right){
		int i = left;
		int j = right;
		int key = array[left];
		while(i < j){
			while(i<j && key<array[j]){
				j--;
			}
			if(i<j) {
				array[i] = array[j];
				i++;
			}
			while(i<j && key>array[i]){
				i++;
			}
			if(i<j){
				array[j] = array[i];
				j--;
			}
		}
		array[i] = key;
		return i;
	}
	
	/**
	 * key为随机数的partion
	 * @param array
	 * @param left
	 * @param right
	 * @return 随机key所在的元素排序后在数组中的下标
	 */
	public int randomPartition(int[] array,int left,int right){
		//生成一个left-right之间的随机数
		int random = new Random().nextInt(right-left+1)+left;
		int temp = array[random];
		array[random] = array[left];
		array[left] = temp;
		return partition(array, left, right);
	}
	
	/**
	 * 从数组中找出left到right之间的第i个最小元素
	 * @param array
	 * @param left
	 * @param right
	 * @param i
	 * @return
	 */
	public int randomSelect(int[] array,int left,int right,int i){
		if(left == right) {
			return array[left];
		}
		//从array的left到right之间，随机得到一个值，返回这个值排序后的数组下标
		int index = randomPartition(array, left, right);
		//得到index距离left的距离，即第几小的数
		int k = index-left+1;
		if(i == k){
			return array[index];
		}
		else if(i < k) {
			return randomSelect(array, left, index-1, i);
		}
		else {
			return randomSelect(array, index+1, right, i-k);
		}
	}
	
}
