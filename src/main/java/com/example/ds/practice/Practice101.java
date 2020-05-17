package com.example.ds.practice;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: weijianwei
 * @Date: 2020-05-17 11:09
 * @Description: 101. 对称二叉树
 * \给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Practice101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        Deque<TreeNode> s1 = new LinkedList<>();
        s1.push(leftRoot);
        Deque<TreeNode> s2 = new LinkedList<>();
        s2.push(rightRoot);
        TreeNode cur1;
        TreeNode cur2;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            cur1 = s1.pop();
            cur2 = s2.pop();
            if (cur1 == null && cur2 == null) {
                continue;
            }
            if (cur1 == null || cur2 == null || cur1.val != cur2.val) {
                return false;
            }
            s1.push(cur1.right);
            s1.push(cur1.left);
            s2.push(cur2.left);
            s2.push(cur2.right);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return judge(root.left, root.right);
    }

    private boolean judge(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null || leftRoot.val != rightRoot.val) {
            return false;
        }
        boolean flag = judge(leftRoot.left, rightRoot.right);
        if (flag) {
            return judge(leftRoot.right, rightRoot.left);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Practice101 practice = new Practice101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(practice.isSymmetric(root));
    }

}
