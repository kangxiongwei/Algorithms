package com.kxw.leetcode;

import java.util.HashMap;
import com.kxw.model.ListNode;
import com.kxw.util.ListUtil;

/**
 * leetcode 19
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 注意：n始终是合法的
 * @author kangxiongwei
 * @date 2015年8月31日
 */
public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		//ListUtil.printList(node1);
		
		ListNode head = removeNthFromEnd(node1,2);
		ListUtil.printList(head);
	}
	
	/**
	 * 空间复杂不O(1)
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;

	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
    }


	public static ListNode test01(ListNode head, int n) {
		if(head == null) return null;
		HashMap<Integer,ListNode> map = new HashMap<>();
        int count = 0;
        while(head != null){
        	map.put(count++, head);
        	head = head.next;
        }
        
        //需要删除的节点
        Integer removeIndex = map.size()-n;
        ListNode removeNode = map.get(removeIndex);
        //要删除的元素前一个元素存在
        if(removeIndex > 0){
        	map.get(removeIndex-1).next = removeNode.next;
        	return map.get(0);
        } else {
        	//要删除的元素为第一个元素
        	return map.get(1);
        }
	}
	
}
