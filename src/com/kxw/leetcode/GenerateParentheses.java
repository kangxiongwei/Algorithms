package com.kxw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 22
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author kangxiongwei
 * @date 2015年10月10日
 */
public class GenerateParentheses {

	public static void main(String[] args) {
		List<String> list = generateParenthesis(4);
		for(String l: list){
			System.out.println(l);
		}
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		if(n == 1){
			list.add("()");
			return list;
		}
		else {
			List<String> prev = generateParenthesis(n-1);
			//前面的所有结果
			for(String pre: prev){
				//给所有')'的左右两边可以添加()
				for(int i=0; i<pre.length(); i++){
					char curr = pre.charAt(i);
					if(curr == ')'){
						String temp1 = pre.substring(0,i)+"()"+pre.substring(i);
						if(!list.contains(temp1)) list.add(temp1);
						String temp2 = pre.substring(0,i+1)+"()"+pre.substring(i+1);
						if(!list.contains(temp2)) list.add(temp2);
					}
				}
			}
			return list;
		}
	}
	
}
