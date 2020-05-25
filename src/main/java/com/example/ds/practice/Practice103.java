package com.example.ds.practice;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Practice103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(result, root, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, int level) {
        LinkedList<Integer> tmp;
        if (result.size() > level) {
            tmp = (LinkedList<Integer>) result.get(level);
        } else {
            tmp = new LinkedList<>();
            result.add(tmp);
        }
        if (level % 2 == 0) {
            tmp.add(root.val);
        } else {
            tmp.addFirst(root.val);
        }
        if (root.left != null) {
            dfs(result, root.left, level + 1);
        }
        if (root.right != null) {
            dfs(result, root.right, level + 1);
        }
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        boolean flag = true;
        TreeNode cur;
        LinkedList<Integer> tmp = new LinkedList<>();
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                result.add(tmp);
                tmp = new LinkedList<>();
                if (queue.size() > 0) {
                    queue.offer(null);
                }
                flag = !flag;
            } else {
                if (flag) {
                    tmp.add(cur.val);
                } else {
                    tmp.addFirst(cur.val);
                }
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

    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if (flag) {
                    tmp.add(poll.val);
                } else {
                    tmp.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            flag = !flag;
            result.add(tmp);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder4(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        TreeNode cur;
        TreeNode left;
        TreeNode right;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                cur = flag ? queue.pollLast() : queue.pollFirst();
                tmp.add(cur.val);
                left = cur.left;
                right = cur.right;
                if (flag) {
                    if (left != null) {
                        queue.addFirst(left);
                    }
                    if (right != null) {
                        queue.addFirst(right);
                    }
                } else {
                    if (right != null) {
                        queue.addLast(right);
                    }
                    if (left != null) {
                        queue.addLast(left);
                    }
                }
            }
            flag = !flag;
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        Practice103 practice = new Practice103();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(practice.zigzagLevelOrder(root));
    }
}
