package com.kxw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 202
 * 判断一个数字是否是“happy”
 * happy数字的规定：
 * 1.将数字的十进制每一位数的平方和替换原来的数字
 * 2.如此反复迭代，如果结果为1，则为happy
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @author kangxiongwei
 * @date 2015年10月16日
 */
public class HappyNumber {

	public static void main(String[] args) {
		boolean result = isHappy(102);
		System.out.println(result);
		for(Integer item: list){
			System.out.print(item+" ");
		}
		System.out.println();
	}
	
	static List<Integer> list = new ArrayList<Integer>();
	public static boolean isHappy(int n){
		list.add(n);
		int sum = 0;
		while(n > 0){
			int temp = n%10;
			sum += temp*temp;
			n = n/10;
		}
		if(sum == 1){
			return true;
		}
		else if(list.contains(sum)){
			return false;
		}
		else {
			return isHappy(sum);
		}
	}
}
