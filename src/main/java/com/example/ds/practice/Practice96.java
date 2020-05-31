package com.example.ds.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weijianwei
 * @Date: 2020-05-31 13:25
 * @Description: 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Practice96 {

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int len = 2; len <= n; len++) {
            for (int root = 1; root <= len; root++) {
                dp[len] += dp[root - 1] * dp[len - root];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        List<TreeNode> pre = new ArrayList<>();
        if (n == 0) {
            return 0;
        }
        pre.add(null);
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<>();
            for (TreeNode root : pre) {
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                for (int j = 0; j <= n; j++) {
                    TreeNode copy = treeCopy(root);
                    TreeNode right = copy;
                    for (int k = 0; k < j; k++) {
                        if (right == null) {
                            break;
                        }
                        right = right.right;
                    }
                    if (right == null) {
                        break;
                    }
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert;
                    insert.left = rightTree;
                    cur.add(copy);
                }
            }
            pre = cur;
        }
        return pre.size();
    }

    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }

    public int numTrees3(int n) {
        if (n == 0) {
            return 0;
        }
        return numTrees(1, n);
    }

    private int numTrees(int start, int end) {
        if (start > end) {
            return 1;
        }
        if (start == end) {
            return 1;
        }
        int total = 0;
        for (int i = start; i <= end; i++) {
            int leftTrees = numTrees(start, i - 1);
            int rightTrees = numTrees(i + 1, end);
            total += leftTrees * rightTrees;
        }
        return total;
    }

    public static void main(String[] args) {
        Practice96 practice = new Practice96();
        int numTrees = practice.numTrees(3);
        System.out.println(numTrees);
    }
}
