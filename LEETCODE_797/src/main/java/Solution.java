import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> onePath = new ArrayList<>();
    public List<List<Integer>> allPaths = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        onePath.add(0);
        search(graph, 0);
        return allPaths;
    }
    public void search(int[][] graph, int node) {
        if (node == graph.length - 1) {
            List<Integer> result = new ArrayList<>(onePath);
            allPaths.add(result);
            return;
        }

        for (int i : graph[node]) {
            onePath.add(i);
            search(graph, i);
            onePath.remove(onePath.size() - 1);
        }
    }
}
