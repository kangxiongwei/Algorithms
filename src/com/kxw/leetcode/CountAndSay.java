package com.kxw.leetcode;

/**
 * leetcode 38
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * @author kangxiongwei
 * @date 2015年10月10日
 */
public class CountAndSay {

	public static void main(String[] args) {
		String res = countAndSay(5);
		System.out.println(res);
	}
	
	public static String countAndSay(int n){
		if(n == 1){
			return "1";
		}
		else {
			//递归
			String prev = countAndSay(n-1);
			String str = "";
			for(int i=0; i<prev.length(); i++){
				//字符串中出现几个连续的curr元素
				char curr = prev.charAt(i);
				int index = 1;
				while(i < prev.length()-1 && curr == prev.charAt(i+1)){
					i++;
					index++;
				}
				str += String.valueOf(index)+prev.charAt(i);
			}
			return str;
		}
	}
}
