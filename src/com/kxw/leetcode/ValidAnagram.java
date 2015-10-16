package com.kxw.leetcode;

import java.util.Arrays;

/**
 * Given two strings s and t, 
 * write a function to determine if t is an anagram of s.
 * 判断t是不是s的易位词
 * @author kangxiongwei
 * @date 2015年8月23日
 */
public class ValidAnagram {
	
	public static void main(String[] args) {
		ValidAnagram va = new ValidAnagram();
		va.isAnagram("aaaaaabbc","aaaaaaxxy");
	}
	
	/**
	 * 时间复杂度O(lg(n))
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		int[] temp = new int[26];
		for(int i=0; i<s.length(); i++){
			temp[s.charAt(i)-'a']++;
			temp[t.charAt(i)-'a']--;
		}
		for(int i=0; i<temp.length; i++){
			if(temp[i] != 0) return false;
		}
		return true;
	}
	
	/**
	 * 我的解决方案  但是时间复杂度为O(nlg(n))
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean mySolution(String s,String t){
		if(s.length() != t.length()) return false;
		char[] schar = s.toCharArray();
		char[] tchar = t.toCharArray();
		Arrays.sort(schar);
		Arrays.sort(tchar);
		String news = new String(schar);
		String newt = new String(tchar);
		return news.equals(newt);
	}
	
}
