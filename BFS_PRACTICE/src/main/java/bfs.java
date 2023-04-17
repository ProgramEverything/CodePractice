import org.example.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class bfs {
    public static Queue<TreeNode> treeNodeQueue = new LinkedList<>();
    public static List<Integer> resultArray = new ArrayList<>();
    public static void basicBfs(TreeNode root) {
        resultArray.clear();
        treeNodeQueue.clear();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode head = treeNodeQueue.poll();
            resultArray.add(head.val);
            if (head.leftNode != null) {
                treeNodeQueue.offer(head.leftNode);
            }
            if (head.rightNode != null) {
                treeNodeQueue.offer(head.rightNode);
            }
        }
    }
}
