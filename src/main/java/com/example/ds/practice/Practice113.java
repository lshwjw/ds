package com.example.ds.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weijianwei
 * @Date: 2020-05-27 21:35
 * @Description: 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Practice113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, sum, 0, new ArrayList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, int sum, int tmp, List<Integer> tmpResult) {
        if (root == null) {
            return;
        }
        tmp += root.val;
        tmpResult.add(root.val);
        if (tmp == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(tmpResult));
            tmpResult.remove(tmpResult.size() - 1);
            return;
        }
        dfs(result, root.left, sum, tmp, tmpResult);
        dfs(result, root.right, sum, tmp, tmpResult);
        tmpResult.remove(tmpResult.size() - 1);
    }

    public static void main(String[] args) {
        Practice113 practice = new Practice113();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);*/
        System.out.println(practice.pathSum(root, 22));
    }
}
