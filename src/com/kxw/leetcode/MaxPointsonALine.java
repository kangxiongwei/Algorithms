package com.kxw.leetcode;

import java.util.HashMap;
import java.util.Hashtable;

import com.kxw.model.Point;

/**
 * leetcode 149
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line. 给定n个二维平面上的点，求出这n个点当中最多有多少个点在同一直线上。
 * 
 * @author kangxiongwei
 * @date 2015年8月28日
 */
public class MaxPointsonALine {

	public static void main(String[] args) {
		Point[] points = new Point[4];
		points[0] = new Point(1, 1);
		points[1] = new Point(2, 1);
		points[2] = new Point(3, 3);
		points[3] = new Point(4, 4);

		MaxPointsonALine mpa = new MaxPointsonALine();
		int max = mpa.maxPoints(points);
		System.out.println(max);
	}

	/**
	 * 
	 * @param points
	 * @return
	 */
	public int maxPoints(Point[] points) {
		if (points == null) return 0;
		int length = points.length;
		if (length < 3) return length;
		int rst = 2;
		for (int i = 0; i < points.length; i++) {
			HashMap<String, Integer> hs = new HashMap<String, Integer>();
			//重复点
			int overlap = 0;
			//本次循环得到的最大点数
			int tempMax = 1;
			for (int j = i + 1; j < points.length; j++) {
				String slp = getSlope(points[i], points[j]);
				if (slp.equals("any"))
					overlap++;
				else if (!hs.containsKey(slp)) {
					hs.put(slp, 2);
					tempMax = Math.max(tempMax, 2);
				} else {
					int num = hs.get(slp) + 1;
					hs.put(slp, num);
					tempMax = Math.max(tempMax, num);
				}
			}
			rst = Math.max(rst, tempMax + overlap);
		}
		return rst;
	}

	/**
	 * 得到两点的斜率，相等用any表示，和x轴垂直用inf表示，和y轴垂直用0表示
	 * @param p1
	 * @param p2
	 * @return
	 */
	private String getSlope(Point p1, Point p2) {
		if (p1.x == p2.x && p1.y == p2.y) return "any";
		if (p1.x == p2.x) return "inf";
		if (p1.y == p2.y) return "0";
		double temp = p2.y - p1.y;
		temp = temp / (p2.x - p1.x);
		return temp + "";
	}

	@SuppressWarnings("unused")
	private void test(Point[] points) {
		Hashtable<Point, Float> temp = new Hashtable<>();
		// key: 斜率 value: 数量
		Hashtable<Float, Integer> result = new Hashtable<>();
		for (int i = 0; i < points.length; i++) {
			Point point = points[i];
			Float radius = point.y / (float) point.x;
			temp.put(point, radius);
			if (result.get(radius) == null) {
				result.put(radius, 1);
			} else {
				result.put(radius, result.get(radius) + 1);
			}
		}
		for (Point p : temp.keySet()) {
			System.out.println(p + "-->" + temp.get(p));
		}
		System.out.println("----------------------------------------");
		for (Float f : result.keySet()) {
			System.out.println("radius: " + f + "-->count: " + result.get(f));
		}
	}
}
