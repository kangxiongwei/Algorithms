package com.kxw.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * leetcode 89
 * 给定一个数，计算n为格雷码
 * @author kangxiongwei
 * @date 2015年10月16日
 */
public class GrayCode {

	public static void main(String[] args) {
		List<Integer> result = grayCode(3);
		for(Integer item: result){
			System.out.println(item+" ");
		}
		System.out.println();
	}
	
	
	/**
	 * 递归  格雷码满足条件：
	 * f(n) = {
	 * 		f(n-1) n<=2^(n-1)
	 * 		2^(n-1)+f(2^(n-1)-i) i=0,1,...,2^(n-1)
	 * }
	 * @param n
	 * @return
	 */
	public static List<Integer> grayCode(int n){
		List<Integer> result = null;
		if(n == 0){
			result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}
		else {
			result = grayCode(n-1);
			List<Integer> list = new ArrayList<Integer>();
			list.addAll(result);
			for(int i=result.size()-1; i>=0; i--){
				list.add((int)Math.pow(2,n-1)+result.get(i));
			}
			return list;
		}
	}
	
}
