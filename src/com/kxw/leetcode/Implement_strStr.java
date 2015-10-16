package com.kxw.leetcode;

import com.kxw.util.ArrayUtil;

/**
 * leetcode 28
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * @author kangxiongwei
 * @date 2015年9月2日
 */
public class Implement_strStr {
	
	public static void main(String[] args) {
		Implement_strStr is = new Implement_strStr();
		/*int index = is.commonSolution("a", "");
		System.out.println(index);*/
		Integer[] next = is.getNextArray("ababac");
		ArrayUtil.printArray(next);
	}
	
	/**
	 * KMP算法
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
        return 0;
    }
	/**
	 * 根据字符串得到KMP的next数组
	 * @param needle
	 * @return
	 */
	private Integer[] getNextArray(String needle){
		int length = needle.length();
		Integer[] array = new Integer[length+1];
		int i=0, j=-1;
		array[0] = -1;
		while(i <= length){
			while(j>=0 && needle.charAt(i) != needle.charAt(j)) j=array[j];
			i++;
			j++;
			array[i] = j;
		}
		return array;
	}

	/**
	 * 朴素算法
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int commonSolution(String haystack, String needle) {
		
		if(haystack.length() < needle.length()) return -1;
		
		for(int i=0; i<=haystack.length()-needle.length(); i++)
		{
        	int j;
        	for(j=0; j<needle.length(); j++)
        	{
        		if(haystack.charAt(i+j) != needle.charAt(j)) 
        			break;
        	}
        	
        	if(j == needle.length())
        	{
        		return i;
        	}
        }
		
		return -1;
	}

	/**
	 * 第一种解决方案
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int test01(String haystack, String needle) {
		if(!haystack.contains(needle)) return -1;
        else {
        	return haystack.indexOf(needle);
        }
	}
	
}
