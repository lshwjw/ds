package com.example.ds.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 */
public class Practice100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        TreeNode cur1;
        TreeNode cur2;
        while (!queue.isEmpty()) {
            cur1 = queue.poll();
            cur2 = queue.poll();
            if (cur1 == null && cur2 == null) {
                continue;
            }
            if (cur1 == null || cur2 == null || cur1.val != cur2.val) {
                return false;
            }
            queue.offer(cur1.left);
            queue.offer(cur2.left);
            queue.offer(cur1.right);
            queue.offer(cur2.right);
        }
        return true;
    }

    public static void main(String[] args) {
        Practice100 practice = new Practice100();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(practice.isSameTree(p, q));
    }
}
