package com.example.ds.practice;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Practice102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int level = 0;
        boolean leftFlag = true;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                List<Integer> tmp;
                if (result.size() > level) {
                    tmp = result.get(level);
                } else {
                    tmp = new ArrayList<>();
                    result.add(tmp);
                }
                tmp.add(cur.val);
                stack.push(cur);
                cur = cur.left;
                level++;
                leftFlag = true;
            }
            cur = stack.pop();
            level = leftFlag ? level - 1 : level - 2;
            cur = cur.right;
            if (cur != null) {
                level++;
                leftFlag = false;
            }
        }
        return result;
    }

    /**
     * DFS完成层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(result, root, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, int level) {
        List<Integer> tmp;
        if (result.size() > level) {
            tmp = result.get(level);
        } else {
            tmp = new ArrayList<>();
            result.add(tmp);
        }
        tmp.add(root.val);
        if (root.left != null) {
            dfs(result, root.left, level + 1);
        }
        if (root.right != null) {
            dfs(result, root.right, level + 1);
        }
    }

    /**
     * BFS,使用一层循环，使用一个null空节点分隔每一层，每次遍历到空节点，表示一层遍历完了
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeNode cur;
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                result.add(tmp);
                tmp = new LinkedList<>();
                if (queue.size() > 0) {
                    queue.offer(null);
                }
            } else {
                tmp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return result;
    }

    /**
     * BFS,常规遍历，两层循环，内存循环走完，表示一层遍历完了
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                tmp.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        Practice102 practice = new Practice102();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(practice.levelOrder(root));
    }
}
