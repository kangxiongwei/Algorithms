package com.kxw.leetcode;

import com.kxw.model.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 二叉搜索树：
 * 左子树的任意一个节点x，x的左子树的最大值不大于x.key，x的右子树的最小值不小于x.key
 * 
 * @author kangxiongwei
 * @date 2015年8月28日
 */
public class ValidateBinarySearchTree {

	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		
		node5.left = node3;
		node5.right = node8;
		node3.left = node1;
		node3.right = node4;
		node1.right = node2;
		node8.left = node6;
		node8.right = node9;
		node6.right = node7;
		
		ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
		boolean result = vbst.isValidBST(node2);
		System.out.println(result);
	}
	
	
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
	
}
