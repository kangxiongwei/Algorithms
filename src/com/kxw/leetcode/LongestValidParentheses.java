package com.kxw.leetcode;

import java.util.Stack;

/**
 * leetcode 32
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * @author kangxiongwei
 * @date 2015年8月31日
 */
public class LongestValidParentheses {
	
	public static void main(String[] args) {
		int x = longestValidParentheses(")()(()");
		System.out.println(x);
	}
	
	/**
	 * 使用动态规划求解
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
		char[] S = s.toCharArray();
	    int[] V = new int[S.length];
	    int open = 0;
	    int max = 0;
	    for (int i=0; i<S.length; i++) {
	        if (S[i] == '(') open++;
	        if (S[i] == ')' && open > 0) {
	            // matches found
	            V[i] = 2+ V[i-1];
	            // add matches from previous
	            if(i-V[i]>0)
	                V[i] += V[i-V[i]];
	            open--;
	        }
	        if (V[i] > max) max = V[i];
	    }
	    return max;
    }
	
	/**
	 * 解法1
	 * @param s
	 * @return
	 */
	public static int test01(String s){
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		for(int i=0; i<s.length(); i++){
			Character current = s.charAt(i);
			if(current == '('){
				stack.push(i);
			} 
			else {
				//前面的不完全匹配
				if(!stack.empty()){
					if(s.charAt(stack.peek()) == '('){
						stack.pop();
					}
					else {
						stack.push(i);
					}
				} 
				else {
					stack.push(i);
				}
			}
		}
		//栈里面本来是顺序的，但是匹配的括号已经消除，所以剩下的之间的差值就是匹配的字符串之间的长度
		if (stack.empty()) 
			count = s.length();
        else {
            int a = s.length(), b = 0;
            while (!stack.empty()) {
                b = stack.pop();
                count = Math.max(count, a-b-1);
                a = b;
            }
            count = Math.max(count, a);
        }
        return count;
	}
	
}
