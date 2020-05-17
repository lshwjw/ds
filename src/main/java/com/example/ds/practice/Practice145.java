package com.example.ds.practice;

import java.util.*;

/**
 * @Author: weijianwei
 * @Date: 2020-05-16 13:40
 * @Description: 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Practice145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.addFirst(cur.val);
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }
        return result;
    }

    /**
     * 莫里斯遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            if (cur.right == null) {
                result.addFirst(cur.val);
                cur = cur.left;
            } else {
                pre = cur.right;
                while (pre.left != null && pre.left != cur) {
                    pre = pre.left;
                }
                if (pre.left == null) {
                    result.addFirst(cur.val);
                    pre.left = cur;
                    cur = cur.right;
                } else {
                    pre.left = null;
                    cur = cur.left;
                }
            }
        }
        return result;
    }

    /**
     * 莫里斯遍历（需要额外栈空间）
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode dump = new TreeNode(0);
        dump.left = root;
        TreeNode cur = dump;
        TreeNode pre;
        while (cur != null) {
            if (cur.left == null) {
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
                    TreeNode tmp = cur.left;
                    while (tmp != pre.right) {
                        stack.push(tmp);
                        tmp = tmp.right;
                    }
                    while (!stack.isEmpty()) {
                        result.add(stack.pop().val);
                    }
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal4(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            result.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal5(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null) {
                cur = cur.right;
            } else {
                result.add(cur.val);
                stack.pop();
                TreeNode tmp = stack.peek();
                if (tmp != null && tmp.right == cur) {
                    tmp.right = null;
                }
                cur = null;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal6(TreeNode root) {
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
        if (root.right != null) {
            traversal(result, root.right);
        }
        result.add(root.val);
    }

    public List<Integer> postorderTraversal7(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        traversal1(result, root);
        return result;
    }

    private void traversal1(LinkedList<Integer> result, TreeNode root) {
        result.addFirst(root.val);
        if (root.right != null) {
            traversal1(result, root.right);
        }
        if (root.left != null) {
            traversal1(result, root.left);
        }
    }

    public static void main(String[] args) {
        Practice145 practice = new Practice145();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);*/
        System.out.println(practice.postorderTraversal(root));
    }
}
