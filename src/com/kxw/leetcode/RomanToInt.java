package com.kxw.leetcode;

/**
 * 将罗马数字转为int
 * 输入范围：1~3999
 * @author kangxiongwei
 * @date 2015年8月21日
 */
public class RomanToInt {
	
	
	enum Roman{
		I(1),V(5),X(10),L(50),C(100),D(500),M(1000);
		private int value;
		private Roman(int value){
			this.setValue(value);
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		int result = new RomanToInt().romanToInt("MMMCMXCIX");
		//分析一下：
		/**
		 * 从右向左遍历每个字符
		 * 1. X --> res = 10
		 * 2. I --> res = 10-1 = 9
		 * 3. C --> res = 9+100 = 109
		 * 4. X --> res = 109-10 = 99
		 * ..........
		 */
		System.out.println(result);
	}
	
	/**
	 * 罗马数字规则
	 * I  V  X   L   C    D    M
	 * 1  5  10  50  100  500  1000
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int res = 0;
	    for (int i = s.length() - 1; i >= 0; i--) {
	    	char c = s.charAt(i);
	        switch (c) {
		        //其实就是V的右边出现I则加1，否则减1
	        	case 'I': res += (res >= 5 ? -1 : 1); break;
		        case 'V': res += 5; break;
		        case 'X': res += 10 * (res >= 50 ? -1 : 1); break;
		        case 'L': res += 50; break;
		        case 'C': res += 100 * (res >= 500 ? -1 : 1); break;
		        case 'D': res += 500; break;
		        case 'M': res += 1000; break;
	        }
	    }
	    return res;
    }
	
}
