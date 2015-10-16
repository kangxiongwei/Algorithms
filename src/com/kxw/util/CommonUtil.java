package com.kxw.util;

public class CommonUtil {

	public static void main(String[] args) {
		//int common = greatestCommonDivisor(12, 9);
		int low = lowestCommonMultiple(12, 9);
		System.out.println(low);
	}
	
	/**
	 * 求出m和n的最大公约数
	 * @param m
	 * @param n
	 * @return
	 */
	public static int greatestCommonDivisor(int m,int n){
		if(m%n == 0) return n;
		if(n%m == 0) return m;
		for(int i=m-1; i>0; i--){
			for(int j=n-1; j>0; j--){
				if(m%i==0 && n%j == 0 && m/i == n/j){
					return m/i;
				}
			}
		}
		return 1;
	}
	
	/**
	 * 求出两个数的最小公倍数
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lowestCommonMultiple(int m,int n){
		int max = m>n?m:n;
		for(int i=max; i<=m*n; i++){
			if(i%m == 0 && i%n == 0){
				return i;
			}
		}
		return m*n;
	}
	
}
