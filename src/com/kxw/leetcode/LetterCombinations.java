package com.kxw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, 
 * return all possible letter combinations that the number could represent.
 * 键盘说明：
 * 1: '
 * 2: abc
 * 3: def
 * 4: ghi
 * 5: jkl
 * 6: mno
 * 7: pqrs
 * 8: tuv
 * 9: wxyz
 * @author kangxiongwei
 * @date 2015年8月22日
 */
public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations letter = new LetterCombinations();
		List<String> result = letter.letterCombinations("234");
		System.out.println(result);
	}
	
	public List<String> letterCombinations(String digits) {
	    List<String> result = new ArrayList<>();
		for(int i=0; i<digits.length(); i++) {
	    	char digit = digits.charAt(i);
	    	switch (digit) {
			case '2':
				result = modifyList(result, "abc");
				break;
			case '3':
				result = modifyList(result, "def");
				break;
			case '4':
				result = modifyList(result, "ghi");
				break;
			case '5':
				result = modifyList(result, "jkl");
				break;
			case '6':
				result = modifyList(result, "mno");
				break;
			case '7':
				result = modifyList(result, "pqrs");
				break;
			case '8':
				result = modifyList(result, "tuv");
				break;
			case '9':
				result = modifyList(result, "wxyz");
				break;
			default:
				break;
			}
	    }
		return result;
	}
	
	public List<String> modifyList(List<String> result,String str){
		List<String> list = new ArrayList<>();
		if(result.size() == 0) {
			for(int i=0; i<str.length(); i++){
				list.add(""+str.charAt(i));
			}
		} else {
			for(int i=0; i<result.size(); i++){
				for(int j=0; j<str.length(); j++) {
					String temp = result.get(i)+str.charAt(j);
					list.add(temp);
				}
			}
		}
		return list;
	}
	
}
