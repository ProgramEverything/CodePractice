import java.util.Arrays;

public class RunSolution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = new int[][] {
                new int[] {1, 2},
                new int[] {3},
                new int[] {3},
                new int[0]
        };
        s.allPathsSourceTarget(graph);
        System.out.println(Arrays.toString(s.allPaths.toArray()));
    }
}
