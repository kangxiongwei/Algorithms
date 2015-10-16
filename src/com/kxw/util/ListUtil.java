package com.kxw.util;

import com.kxw.model.ListNode;

public class ListUtil {

	public static void printList(ListNode head){
		if(head == null) return;
		while(head != null && head.next != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.print(head.val);
		System.out.println();
	}
	
}
