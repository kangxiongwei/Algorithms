package com.kxw.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author kangxiongwei
 * @date 2015年8月20日
 */
public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		String[] strs = new String[2];
		
		strs[0] = "ab";
		strs[1] = "a";
		
		String result = longestCommonPrefix(strs);
		System.out.println(result);
	}
	
	/**
	 * 遍历第一个字符串中的每个字符，
	 * 然后和其他字符串进行比较，
	 * 如果字符不匹配或者字符串结束，则得到结果
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		
		if(strs == null || strs.length <=0 ) return "";
		
		for(int i=0; i<strs[0].length(); i++) {
			char x = strs[0].charAt(i);
			for(int j=1; j<strs.length; j++) {
				//字符串结束或者对应字符不匹配
				if(strs[j].length() == i || strs[j].charAt(i) != x) {
					return strs[0].substring(0,i);
				}
			}
		}
		
		return strs[0];
	}
	
}
