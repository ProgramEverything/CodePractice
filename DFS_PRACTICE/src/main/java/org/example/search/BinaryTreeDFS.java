package org.example.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeDFS {
    public static class BinaryTreeNode<T> {
        public BinaryTreeNode leftChild;
        public BinaryTreeNode rightChild;
        public T val;
        public BinaryTreeNode(T val) {
            this.val = val;
        }
        public BinaryTreeNode(T val, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
            this.val = val;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
    /**
     * 在二叉树中搜索目标，使用深度优先搜索
     * @param args
     */
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(
                1, new BinaryTreeNode(10, null, new BinaryTreeNode(13)),
                new BinaryTreeNode(8, new BinaryTreeNode(7, new BinaryTreeNode(11), null), new BinaryTreeNode(6))
        );
        List<BinaryTreeNode> track = new LinkedList<>();
        Search(root, 11, track);
        track.forEach(binaryTreeNode -> {
            System.out.println(binaryTreeNode.val);
        });
    }
    public static <T> boolean Search(BinaryTreeNode<T> currentNode, T target, List<BinaryTreeNode> track) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.val == target) {
            return true;
        }
        track.add(currentNode.leftChild);
        if (Search(currentNode.leftChild, target, track)) {
            return true;
        }
        track.remove(track.size() - 1);
        track.add(currentNode.rightChild);
        if (Search(currentNode.rightChild, target, track)) {
            return true;
        }
        track.remove(track.size() - 1);
        return false;
    }
}
