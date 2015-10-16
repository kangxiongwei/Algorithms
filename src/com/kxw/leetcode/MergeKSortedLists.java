package com.kxw.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.kxw.model.ListNode;
import com.kxw.util.ListUtil;

/**
 * leetcode 23
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * @author kangxiongwei
 * @date 2015年8月31日
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		
		node1.next = node3;
		node3.next = node7;
		
		node2.next = node4;
		node4.next = node5;
		
		node6.next = node8;
		node8.next = node9;
		
		lists[0] = node1;
		lists[1] = node2;
		lists[2] = node6;
		
		ListNode head = mergeKLists(lists);
		
		ListUtil.printList(head);
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length <= 0) return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val > o2.val)  return 1;
				else if (o1.val < o2.val) return -1;
				else return 0;
			}
		});
        for(int i=0; i<lists.length; i++) {
        	if(lists[i] != null){
        		queue.add(lists[i]);
        	}
        }
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            if (tail.next != null) queue.add(tail.next);
        }
        return dummy.next;
        
        //把LinkedList中的元素拼接成单列表
        /*if(list.size() <= 0) return null;
        ListNode result = list.get(0);
        ListNode temp = result;
        for(int i=1; i<list.size(); i++){
        	temp.next = list.get(i);
        	temp = temp.next;
        }
        temp.next = null;*/
    }
	
}
