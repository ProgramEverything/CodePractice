import org.example.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
        bfs.basicBfs(root);
        System.out.println(Arrays.toString(bfs.resultArray.toArray()));
    }
}
