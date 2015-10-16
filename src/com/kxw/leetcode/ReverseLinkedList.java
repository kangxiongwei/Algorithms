package com.kxw.leetcode;

import java.util.Stack;

import com.kxw.model.ListNode;
import com.kxw.util.ListUtil;

/**
 * leetcode 206
 * Reverse a singly linked list.
 * @author kangxiongwei
 * @date 2015年8月27日
 */
public class ReverseLinkedList {
	
	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		
		ListNode result = rll.reverseList(null);
		ListUtil.printList(result);
	}
	
	public ListNode reverseList(ListNode head) {
		if(head == null) return head;
		Stack<ListNode> stack = new Stack<>();
		//全部入栈
		while (head != null && head.next != null) {
			stack.push(head);
			head = head.next;
		}
		stack.push(head);
		//入栈完毕，准备出栈
		//此时，head是尾节点
		ListNode result = head = stack.pop();
		while(!stack.empty()){
			head.next = stack.pop();
			head = head.next;
		}
		head.next = null;
		return result;
    }
	
}
