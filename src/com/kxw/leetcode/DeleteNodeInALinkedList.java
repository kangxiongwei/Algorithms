package com.kxw.leetcode;

import com.kxw.model.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, 
 * given only access to that node.
 * @author kangxiongwei
 * @date 2015年8月26日
 */
public class DeleteNodeInALinkedList {
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		DeleteNodeInALinkedList dn = new DeleteNodeInALinkedList();
		dn.deleteNode(node3);
	}
	
	public void deleteNode(ListNode node) {
	   if(node != null && node.next != null){
		   node.val = node.next.val;
		   node.next = node.next.next;
	   }
	}
	
}
