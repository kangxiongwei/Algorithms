package com.kxw.leetcode;

/**
 * leetcode 58
 * 找出字符串中最后一个单词的长度
 * @author kangxiongwei
 * @date 2015年10月10日
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		String[] strs = s.trim().split(" ");
		return strs.length > 0? strs[strs.length-1].length() : 0;
	}
	
}
