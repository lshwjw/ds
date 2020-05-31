package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2020-05-27 22:23
 * @Description: 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class Practice437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum, new int[1000], 0);
    }

    private int dfs(TreeNode root, int sum, int[] tmp, int layer) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum - root.val;
        int result = leftSum == 0 ? 1 : 0;
        for (int i = layer - 1; i >= 0; i--) {
            leftSum -= tmp[i];
            if (leftSum == 0) {
                result++;
            }
        }
        tmp[layer] = root.val;
        return result + dfs(root.left, sum, tmp, layer + 1) + dfs(root.right, sum, tmp, layer + 1);
    }

    /*public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int result = sum == 0 ? 1 : 0;
        return result + dfs(root.left, sum) + dfs(root.right, sum);
    }*/

    /*private int result = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }

    private void dfs(TreeNode root, int sum, int tmp) {
        if (root == null) {
            return;
        }
        tmp += root.val;
        if (tmp == sum) {
            result++;
        }
        dfs(root.left, sum, tmp);
        dfs(root.right, sum, tmp);
    }*/

    public static void main(String[] args) {
        Practice437 practice = new Practice437();
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);*/
        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);*/
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        System.out.println(practice.pathSum(root, 3));
    }
}
