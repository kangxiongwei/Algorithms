package com.kxw.leetcode;

import java.util.Stack;

/**
 * leetcode 20
 * 给定一个字符串，只包含(),{},[],判断是否匹配，即开和合是否吻合
 * @author kangxiongwei
 * @date 2015年10月10日
 */
public class ValidParentheses {

	public static void main(String[] args) {
		String s = "(){}[]{[]})";
		s = "]";
		boolean valid = isValid(s);
		System.out.println(valid);
	}
	
	
	public static boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++){
			char curr = s.charAt(i);
			//当前符号位闭合符号
			if(curr == ')' || curr == ']' || curr == '}'){
				if(!stack.empty() && ((curr == ')' && stack.peek() == '(') || (curr == ']' 
						&& stack.peek() == '[') || (curr == '}' && stack.peek() == '{'))){
					stack.pop();
				}
				else {
					return false;
				}
			}
			else {
				stack.push(curr);
			}
		}
		if(stack.empty()){
			return true;
		}
		return false;
	}
	
}
