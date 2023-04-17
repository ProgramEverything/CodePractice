package org.example;

import java.util.Arrays;

public class RunTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
        RecursiveTraversal.call_dfs_mlr(root);
        System.out.println("[迭代]DFS前序遍历：" + Arrays.toString(RecursiveTraversal.traversalResult.toArray()));
        RecursiveTraversal.call_dfs_lmr(root);
        System.out.println("[迭代]DFS中序遍历：" + Arrays.toString(RecursiveTraversal.traversalResult.toArray()));
        RecursiveTraversal.call_dfs_lrm(root);
        System.out.println("[迭代]DFS后序遍历：" + Arrays.toString(RecursiveTraversal.traversalResult.toArray()));

        LoopTraversal.dfs_mlr(root);
        System.out.println("[循环]DFS前序遍历：" + Arrays.toString(LoopTraversal.resultArray.toArray()));
        LoopTraversal.dfs_lmr(root);
        System.out.println("[循环]DFS中序遍历：" + Arrays.toString(LoopTraversal.resultArray.toArray()));
        LoopTraversal.dfs_lrm(root);
        System.out.println("[循环]DFS后序遍历：" + Arrays.toString(LoopTraversal.resultArray.toArray()));
    }
}
