import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 0;
        int columns = 0;
        if (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            rows = Integer.parseInt(temp.split(" ")[0]);
            columns = Integer.parseInt(temp.split(" ")[1]);
        }
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            String[] rowSplitString = scanner.nextLine().split(" ");
            for (int j = 0; j < columns; ++j) {
                matrix[i][j] = Integer.parseUnsignedInt(rowSplitString[j]);
            }
        }

        for (int i = 0; i < rows; ++i) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        // 执行搜索
        track.add(0);
        track.add(0);
        matrix[0][0] = 1;
        search(matrix, 0, 0);
        for (List<Integer> track : allTracks) {
            StringBuffer sb = new StringBuffer();
            sb.append("路径：\n");
            for (int i = 0; i < track.size() / 2; ++i) {
                sb.append("(");
                sb.append(track.get(i * 2));
                sb.append(",");
                sb.append(track.get(i * 2 + 1));
                sb.append(")");
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    public static List<Integer> track = new ArrayList<>();
    public static List<List<Integer>> allTracks = new ArrayList<>();

    public static void search(int[][] graph, int x, int y) {
        // x为行数坐标，y为列数坐标
        if (x == graph.length - 1 && y == graph[0].length - 1) {
            List<Integer> successTrack = new ArrayList<>(track);
            allTracks.add(successTrack);
        }

        if (x > 0 && graph[x - 1][y] == 0 && graph[x - 1][y] == 0) {
            // 可以向上走
            track.add(x - 1);
            track.add(y);
            graph[x - 1][y] = 1;
            search(graph, x - 1, y);
            track.remove(track.size() - 1);
            track.remove(track.size() - 1);
            graph[x - 1][y] = 0;
        }
        if (y > 0 && graph[x][y - 1] == 0 && graph[x][y - 1] == 0) {
            // 可以向左走
            track.add(x);
            track.add(y - 1);
            graph[x][y - 1] = 1;
            search(graph, x, y - 1);
            track.remove(track.size() - 1);
            track.remove(track.size() - 1);
            graph[x][y - 1] = 0;
        }
        if (x < graph.length - 1 && graph[x + 1][y] == 0 && graph[x + 1][y] == 0) {
            // 可以向下走
            track.add(x + 1);
            track.add(y);
            graph[x + 1][y] = 1;
            search(graph, x + 1, y);
            track.remove(track.size() - 1);
            track.remove(track.size() - 1);
            graph[x + 1][y] = 0;
        }
        if (y < graph[0].length - 1 && graph[x][y + 1] == 0 && graph[x][y + 1] == 0) {
            // 可以向下走
            track.add(x);
            track.add(y + 1);
            graph[x][y + 1] = 1;
            search(graph, x, y + 1);
            track.remove(track.size() - 1);
            track.remove(track.size() - 1);
            graph[x][y + 1] = 0;
        }
    }
}
