import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodeNum = 0;
        if (scanner.hasNextInt()) {
            nodeNum = scanner.nextInt();
        }
        scanner.nextLine();
        int[] nodeRelation = new int[nodeNum];
        nodeRelation[0] = -1;   // 编号为0的节点是根节点
        int edgeNum = 0;
        if (scanner.hasNextInt()) {
            edgeNum = scanner.nextInt();
        }
        scanner.nextLine();
        int cnt = 0;
        boolean[] notLeaf = new boolean[nodeNum];
        while (cnt < edgeNum) {
            if (scanner.hasNextLine()) {
                String[] inputSplit = scanner.nextLine().split(" ");
                int index = Integer.parseInt(inputSplit[1]);
                int parentIndex = Integer.parseInt(inputSplit[0]);
                nodeRelation[index] = parentIndex;
                notLeaf[parentIndex] = true; // 父节点就肯定不是叶子节点
                cnt++;
            }
        }

        int blockNum = 0;
        if (scanner.hasNextInt()) {
            blockNum = scanner.nextInt();
        }
        scanner.nextLine();
        cnt = 0;
        boolean[] nodeBlocked = new boolean[nodeNum];
        while (cnt < blockNum) {
            if (scanner.hasNextInt()) {
                nodeBlocked[scanner.nextInt()] = true;
                scanner.nextLine();
                cnt++;
            }
        }

        // 第一步：计算到每个节点的路径
        for (int i = 0; i < nodeNum; ++i) {
            LinkedList<Integer> path = new LinkedList<>();
            path.add(i);
            dfs(nodeBlocked, nodeRelation, i, path);
        }

        // 判断是叶子节点
        int minLength = Integer.MAX_VALUE;
        int pathIndex = -1;
        cnt = 0;
        for (List<Integer> path : paths) {
            if (!notLeaf[path.get(0)]) {
                // 是到叶节点的路径
                if (path.size() < minLength) {
                    minLength = path.size();
                    pathIndex = cnt;
                }
            }
            cnt++;
        }
        if (pathIndex == -1) {
            System.out.println("NULL");
        }
        else {
            StringBuffer sb = new StringBuffer();
            for (int i = paths.get(pathIndex).size() - 1; i > -1; --i) {
                sb.append(paths.get(pathIndex).get(i));
                sb.append("->");
            }
            sb.delete(sb.length() - 2, sb.length());
            System.out.println(sb.toString());
        }
    }

    public static List<List> paths = new LinkedList<>();

    public static void dfs(boolean[] nodeBlocked, int[] nodeRelation, int curNode, LinkedList<Integer> path) {
        if (nodeBlocked[curNode]) {
            return;
        }
        if (curNode == 0) {
            paths.add(path);
            return;
        }
        // 还没有到底
        curNode = nodeRelation[curNode];
        path.add(curNode);
        dfs(nodeBlocked, nodeRelation, curNode, path);
    }
}
