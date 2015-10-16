package com.kxw.leetcode;

import com.kxw.model.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined 
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 * @author kangxiongwei
 * @date 2015年8月20日
 */
public class BalancedBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.left.right = new TreeNode(5);
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		System.out.println(bbt.isBalanced(root));
	}
	
	private boolean flag = true;
	
	public boolean isBalanced(TreeNode root) {
		deepth(root);
		return flag;
    }
	
	/**
	 * 获取树的总高度
	 * @param root
	 * @return
	 */
	public int deepth(TreeNode root){
		if(root == null) return 0;
		int l = deepth(root.left);
		int r = deepth(root.right);
		if(Math.abs(l-r)>1) flag = false;
		return Math.max(l,r)+1;
	}
	
}
