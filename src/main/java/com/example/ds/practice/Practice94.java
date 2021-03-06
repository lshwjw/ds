package com.example.ds.practice;

import java.util.*;

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

    /**
     * 莫里斯遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    result.add(cur.val);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    /**
     * 莫里斯遍历（会破坏原来树结构）
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur;
                TreeNode tmp = cur;
                cur = cur.left;
                tmp.left = null;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal4(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
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

    public List<Integer> inorderTraversal5(TreeNode root) {
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
