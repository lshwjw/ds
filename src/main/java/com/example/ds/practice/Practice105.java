package com.example.ds.practice;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Practice105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode sentry = new TreeNode(-1);
        dfs(preorder, inorder, sentry, 0, preorder.length - 1, 0, true);
        return sentry.left;
    }

    private void dfs(int[] preorder, int[] inorder, TreeNode parent, int left, int right, int rootIndex, boolean leftFlag) {
        if (left > right) {
            return;
        }
        TreeNode currentRoot = new TreeNode(preorder[rootIndex]);
        if (leftFlag) {
            parent.left = currentRoot;
        } else {
            parent.right = currentRoot;
        }
        for (int i = left; i <= right; i++) {
            if (inorder[i] == preorder[rootIndex]) {
                dfs(preorder, inorder, currentRoot, left, i - 1, rootIndex + 1, true);
                dfs(preorder, inorder, currentRoot, i + 1, right, rootIndex + (i - left + 1), false);
            }
        }
    }

    public static void main(String[] args) {
        Practice105 practice = new Practice105();
        /*int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};*/
        int[] preorder = {1,2,3};
        int[] inorder = {2,3,1};
        TreeNode result = practice.buildTree(preorder, inorder);
        System.out.println(result);
    }
}
