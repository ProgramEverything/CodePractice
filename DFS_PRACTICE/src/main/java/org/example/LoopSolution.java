package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LoopSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
    }
    public static Stack<TreeNode> treeNodeStack = new Stack<>();
    public static List<Integer> resultArray = new ArrayList<>();
    public static void dfs(TreeNode root) {
        // 首先把根节点入栈，然后以栈不为空为条件出栈顶部节点对其进行处理，查看这个节点有没有子节点
        treeNodeStack.push(root);
        while (treeNodeStack.peek() != null) {

        }
    }
}
