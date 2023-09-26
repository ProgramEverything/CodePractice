import java.util.*;

public class Solution {
    static class TreeNode {
        boolean isVisited;
        int[] allChildNodesColorStatistic;
        List<TreeNode> childNodes;
        public TreeNode() {
            childNodes = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        boolean[] isLeafs = new boolean[n];
        for (int i = 0; i < n; ++i) {
            isLeafs[i] = true;
        }
        int[][] connections = new int[n - 1][2];
        for (int i = 0; i < n - 1; ++i) {
            String[] connection = s.nextLine().split(" ");
            connections[i][0] = Integer.parseInt(connection[0]);
            connections[i][1] = Integer.parseInt(connection[1]);
            isLeafs[connections[i][0]] = false;
        }
        String[] applesColor_s = s.nextLine().split(" ");
        int[] applesColor = new int[n];
        for (int i = 0; i < n; ++i) {
            applesColor[i] = Integer.parseInt(applesColor_s[i]) - 1;
        }
        int q = Integer.parseInt(s.nextLine());
        int[] nodeNums = new int[q];
        for (int i = 0; i < q; ++i) {
            nodeNums[i] = Integer.parseInt(s.nextLine());
        }
        // 从叶子节点开始往上统计每个节点的子节点各种颜色的苹果总共有多少
        // 计算一下总共有多少种颜色
        Set<Integer> colorSet = new HashSet<>();
        for (int appleColor : applesColor) {
            colorSet.add(appleColor);
        }
        int kindsOfColors = colorSet.size();
        // 从叶子节点向上统计
        int[][] allChildrenColorStatistic = new int[n][kindsOfColors];
        for (int i = 0; i < n; ++i) {
            if (isLeafs[i]) {
                allChildrenColorStatistic[i][applesColor[i]] = 1;
            }
        }
    }
}
