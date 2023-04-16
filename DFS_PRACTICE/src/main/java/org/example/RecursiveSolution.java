package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
        dfs(root);
        System.out.println(Arrays.toString(traversalResult.toArray()));
    }
    public static List<Integer> traversalResult = new ArrayList<>();
    public static void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // 前序遍历的顺序：中、左、右
        // 中序遍历的顺序：左、中、右
        // 后序遍历的顺序：左、右、中
        // 进行前序遍历
        traversalResult.add(treeNode.val);
        dfs(treeNode.leftNode);
        dfs(treeNode.rightNode);
    }
}
