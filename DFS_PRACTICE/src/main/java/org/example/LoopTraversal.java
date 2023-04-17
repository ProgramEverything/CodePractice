package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LoopTraversal {
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
    public static void dfs_mlr(TreeNode root) {
        // 中左右深度优先搜索的循环实现
        // 首先把根节点入栈，然后以栈不为空为条件出栈顶部节点对其进行处理，查看这个节点有没有子节点
        resultArray.clear();
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()) {
            TreeNode top = treeNodeStack.pop();
            resultArray.add(top.val);
            if (top.rightNode != null) {
                treeNodeStack.push(top.rightNode);
            }
            if (top.leftNode != null) {
                treeNodeStack.push(top.leftNode);
            }
        }
    }
    public static void dfs_lmr(TreeNode root) {
        // 左中右深度优先搜索的循环实现
        // 首先把根节点入栈，让指针指向根节点，然后以指针节点有左子节点为条件入栈，
        // 直到没有左子节点才开始出栈
        resultArray.clear();
        TreeNode p = root;
        while (!treeNodeStack.isEmpty() || p != null) {
            if (p != null) {
                treeNodeStack.push(p);
                p = p.leftNode;
            }
            else {
                // 如果没有左子节点了，那么出栈，先把val记录下来，如果有右子节点，那么入栈右子节点
                p = treeNodeStack.pop();
                resultArray.add(p.val);
                p = p.rightNode;
            }
        }
    }
    public static void dfs_lrm(TreeNode root) {
        // 把前序遍历的中左右换成中右左，然后将结果数组翻转就变成了左右中的后序遍历
        // 用Collections.reverse()实现数组翻转
        resultArray.clear();
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()) {
            TreeNode top = treeNodeStack.pop();
            resultArray.add(top.val);
            if (top.leftNode != null) {
                treeNodeStack.add(top.leftNode);
            }
            if (top.rightNode != null) {
                treeNodeStack.add(top.rightNode);
            }
        }
        Collections.reverse(resultArray);
    }
}
