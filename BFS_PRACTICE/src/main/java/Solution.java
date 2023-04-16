import org.example.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
    }
    public static List<Integer> traversalResult = new ArrayList<>();
    public static void bfs(TreeNode treeNode) {
        traversalResult.add(treeNode.val);

    }
}
