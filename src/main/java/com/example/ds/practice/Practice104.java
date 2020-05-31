package com.example.ds.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class Practice104 {

    /**
     * 莫里斯遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode cur = root;
        TreeNode pre;
        int level = 0;
        int max = Integer.MIN_VALUE;
        while (cur != null) {
            if (cur.left == null) {
                level++;
                cur = cur.right;
            } else {
                pre = cur.left;
                int preLen = 1;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                    preLen++;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                    level++;
                } else {
                    if (pre.left == null) {
                        max = Math.max(level, max);
                    }
                    pre.right = null;
                    cur = cur.right;
                    level -= preLen;
                }
            }
        }
        int finalRight = 1;
        cur = root;
        while (cur.right != null) {
            finalRight++;
            cur = cur.right;
        }
        if (cur.left == null && cur.right == null) {
            max = Math.max(finalRight, max);
        }
        return max;
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int len) {
        if (root == null) {
            return len;
        }
        len++;
        int left = dfs(root.left, len);
        int right = dfs(root.right, len);
        return Math.max(left, right);
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int len = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            len++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Practice104 practice = new Practice104();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(practice.maxDepth(root));
        System.out.println(practice.maxDepth3(root));
    }
}
