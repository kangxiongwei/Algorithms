package com.kxw.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string of numbers and operators, 
 * return all possible results from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * for example:
 * 1. input "2-1-1"
 *	((2-1)-1) = 0
 *	(2-(1-1)) = 2
 *	Output: [0, 2]
 * 2. input "2*3-4*5"
 *  (2*(3-(4*5))) = -34
 *	((2*3)-(4*5)) = -14
 *	((2*(3-4))*5) = -10
 *	(2*((3-4)*5)) = -10
 *	(((2*3)-4)*5) = 10
 *	Output: [-34, -14, -10, -10, 10]
 * @author kangxiongwei
 * @date 2015年8月23日
 */
public class DifferentWaysToAddParentheses {
	
	public static void main(String[] args) {
		DifferentWaysToAddParentheses dw = new DifferentWaysToAddParentheses();
		String input = "2*3-4*5";
		/*List<Integer> result = dw.diffWaysToCompute(input);
		System.out.println(result);*/
		List<String> result = dw.test(input);
		System.out.println(result);
	}
	
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
        	char oper = input.charAt(i);
        	//当前字符是*，+，-的一个
            if ("*+-".indexOf(oper) != -1) {
                String part1 = input.substring(0,i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1: part1Ret) {
                    for (Integer p2: part2Ret) {
                        ret.add(this.calTwoInteger(p1, p2, oper));
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
	}
	
	/**
	 * a和b通过操作符oper计算的值
	 * @param a
	 * @param b
	 * @param oper
	 * @return
	 */
	public Integer calTwoInteger(Integer a,Integer b,char oper){
		Integer result = null;
		switch (oper) 
		{
			case '*':
				result = a*b; break;
			case '+':
				result = a+b; break;
			case '-':
				result = a-b; break;
			default: break;
		}
		return result;
	}
	
	public List<String> test(String input){
		List<String> result = new ArrayList<String>();
		for(int i=0; i<input.length(); i++){
			char oper = input.charAt(i);
			if("*+-".indexOf(oper) != -1){
				int index = 0;
				String temp = input.substring(i+1);
				while(index < temp.length()){
					char nextOper = temp.charAt(index);
					if("*+-".indexOf(nextOper) != -1){
						break;
					} else {
						index++;
					}
				}
				String part1 = input.substring(0,i)+oper+input.substring(i+1,i+index+1);
				String part2 = input.substring(i+index+1);
				result.add("("+part1+")"+part2);
				List<String> subPart = test(part2);
				for(String sub: subPart){
					System.out.println("sub: "+sub);
					result.add(part1+oper+sub);
				}
			}
		}
		return result;
	}
	
}
