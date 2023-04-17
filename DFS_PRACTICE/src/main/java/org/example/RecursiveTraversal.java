package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecursiveTraversal {
    // 前序遍历的顺序：中、左、右
    // 中序遍历的顺序：左、中、右
    // 后序遍历的顺序：左、右、中
    public static List<Integer> traversalResult = new ArrayList<>();
    public static void call_dfs_mlr(TreeNode root) {
        traversalResult.clear();
        dfs_mlr(root);
    }
    public static void call_dfs_lmr(TreeNode root) {
        traversalResult.clear();
        dfs_lmr(root);
    }
    public static void call_dfs_lrm(TreeNode root) {
        traversalResult.clear();
        dfs_lrm(root);
    }
    public static void dfs_mlr(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        traversalResult.add(treeNode.val);
        dfs_mlr(treeNode.leftNode);
        dfs_mlr(treeNode.rightNode);
    }
    public static void dfs_lmr(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs_lmr(treeNode.leftNode);
        traversalResult.add(treeNode.val);
        dfs_lmr(treeNode.rightNode);
    }
    public static void dfs_lrm(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs_lrm(treeNode.leftNode);
        dfs_lrm(treeNode.rightNode);
        traversalResult.add(treeNode.val);
    }
}
