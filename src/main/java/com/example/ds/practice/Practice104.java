package com.example.ds.practice;

import java.util.LinkedList;
import java.util.List;

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

    public int maxDepth(TreeNode root) {
        int len = 0;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            queue.remove(root);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
            len++;
        }
        return len;
    }

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

    public static void main(String[] args) {
        Practice104 practice = new Practice104();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(practice.maxDepth(root));
    }
}
