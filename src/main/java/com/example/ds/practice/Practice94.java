package com.example.ds.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Practice94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left == null) {
                result.add(cur.val);
                stack.pop();
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else {
                stack.push(cur.left);
                cur.left = null;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversal(result, root);
        return result;
    }

    private void traversal(List<Integer> result, TreeNode root) {
        if (root.left != null) {
            traversal(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            traversal(result, root.right);
        }
    }

    public static void main(String[] args) {
        Practice94 practice = new Practice94();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(practice.inorderTraversal(root));
    }
}
