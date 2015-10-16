package com.kxw.leetcode;

/**
 * leetcode 172
 * Given an integer n, return the number of trailing zeroes in n!.
 * @author kangxiongwei
 * @date 2015年9月1日
 */
public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		int y = ftz.trailingZeroes(15);
		System.out.println(y);
	}
	
	
	public int trailingZeroes(int n) {
		if(n == 0) return 0; 
		else {
			return n/5+trailingZeroes(n/5);
		}
    }
	public Long factorial(int n){
		Long[] array = new Long[n+1];
		if(n == 0){
			array[0] = 1L;
		} else {
			array[1] = array[0] = 1L;
		}
		
		for(int i=2; i<n+1; i++){
			array[i] = i*array[i-1];
		}
		return array[n];
	}
}
