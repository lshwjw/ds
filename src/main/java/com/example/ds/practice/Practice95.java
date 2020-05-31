package com.example.ds.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weijianwei
 * @Date: 2020-05-30 16:52
 * @Description: 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Practice95 {

    /**
     * 动态规划（与generateTrees3思路类似）
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<>();
            for (int root = 1; root <= len; root++) {
                int left = root - 1;
                int right = len - root;
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode newRoot = new TreeNode(root);
                        newRoot.left = leftTree;
                        newRoot.right = treeClone(rightTree, root);
                        dp[len].add(newRoot);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode treeClone(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = treeClone(root.left, offset);
        newRoot.right = treeClone(root.right, offset);
        return newRoot;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees2(int n) {
        List<TreeNode> pre = new ArrayList<>();
        if (n == 0) {
            return pre;
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
        return pre;
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

    /**
     * 递归
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees3(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
