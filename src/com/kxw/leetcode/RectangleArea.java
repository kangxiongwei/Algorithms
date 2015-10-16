package com.kxw.leetcode;

/**
 * leetcode 223
 * 给定两个矩形的坐标，求出两个矩形占据的总空间大小
 * @author kangxiongwei
 * @date 2015年10月8日
 */
public class RectangleArea {

	public static void main(String[] args) {
		//int result = computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
		//int result = computeArea(0,0,0,0,-1,-1,1,1);
		//int result = computeArea(-2, -2, 2, 2, 3, 3, 4, 4);
		int result = computeArea(-2, -2, 2, 2, -4, 3, -3, 4);
		System.out.println(result);
	}
	
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area1 = Math.abs((C-A)*(D-B));
		int area2 = Math.abs((G-E)*(H-F));
		int left = Math.max(A, E);
		int right = Math.min(G, C);
		int bottom = Math.max(F, B);
		int top = Math.min(D, H);
		int overlap = 0;
		if(right > left && top > bottom)
			overlap = (right - left) * (top - bottom);
		return area1+area2-overlap;
	}
	
	public static int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area1 = Math.abs((C-A)*(D-B));
		int area2 = Math.abs((G-E)*(H-F));
		int result = 0;
		//判断两个矩形的位置关系
		//A中顶点(A,B),(C,B),(C,D),(A,D)是否在B中
		boolean flagA1 = A > E && A < G && B > F && B < H;
		boolean flagA2 = C > E && C < G && B > F && B < H;
		boolean flagA3 = C > E && C < G && D > F && D < H;
		boolean flagA4 = A > E && A < G && D > F && D < H;
		//B中顶点(E,F),(G,F),(G,H),(E,H)是否在A中
		boolean flagB1 = E > A && E < C && F > B && F < D;
		boolean flagB2 = G > A && G < C && F > B && F < D;
		boolean flagB3 = G > A && G < C && H > B && H < D;
		boolean flagB4 = E > A && E < C && H > B && H < D;
		if((flagA1 && flagA2 && flagA3 && flagA4) || (flagB1 && flagB2 && flagB3 && flagB4)){
			//说明A在B中或者B在A中
			result = Math.max(area1, area2);
		}
		else if((!flagA1 && !flagA2 && !flagA3 && !flagA4) || (!flagB1 && !flagB2 && !flagB3 && !flagB4)){
			//说明A在B外，或者B在A外
			result = area1+area2;
		}
		else {
			int x = Math.abs(E-A)*Math.abs(D-B);
			int y = Math.abs(G-C)*Math.abs(H-F);
			int z = Math.abs(C-E)*Math.abs(H-D);
			int w = Math.abs(C-E)*Math.abs(F-B);
			result = (area1+area2+x+y+z+w)/2;
		}
		return result;
	}
	
}
