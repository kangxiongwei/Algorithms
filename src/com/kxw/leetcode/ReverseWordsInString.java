package com.kxw.leetcode;

import java.util.Stack;

/**
 * leetcode 151
 * Given an input string, reverse the string word by word.
 * @author kangxiongwei
 * @date 2015年8月27日
 */
public class ReverseWordsInString {
	
	public void test01(){
		String str = " 1";
		String[] args = str.split(" ");
		System.out.println(args.length);
	}
	
	public String reverseWords(String s){
		if("".equals(s.trim())) return "";
		Stack<String> stack = new Stack<>();
		String[] strs = s.split(" ");
		for(int i=0; i<strs.length; i++){
			if(!"".equals(strs[i].trim())){
				stack.push(strs[i].trim());
			}
		}
		//System.out.println(stack);
		StringBuilder sb = new StringBuilder();
		while (!stack.empty()) {
			sb.append(" ").append(stack.pop());
		}
		return sb.toString().substring(1);
	}
	
	public static void main(String[] args) {
		ReverseWordsInString rw = new ReverseWordsInString();
		String result = rw.reverseWords(" 1");
		System.out.println(result);
	}
	
}
