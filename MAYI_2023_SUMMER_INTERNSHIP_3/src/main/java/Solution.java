import java.lang.reflect.Array;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputSplit = new String[0];
        if (scanner.hasNextLine()) {
            inputSplit = scanner.nextLine().split(" ");
        }
        int row = Integer.parseInt(inputSplit[0]);
        int col = Integer.parseInt(inputSplit[1]);
        int xunWenCiShu = Integer.parseInt(inputSplit[2]);
        boolean[][] graph = new boolean[row][col];
        for (int i = 0; i< row;++i) {
            for (int j = 0; j < col; ++j) {
                if ((i + j)%2 != 0) {
                    graph[i][j] = true;
                }
            }
        }
        for (int i = 0; i < xunWenCiShu;++i) {
            inputSplit = scanner.nextLine().split(" ");
            int startRow = Integer.parseInt(inputSplit[0]);
            int stopRow = Integer.parseInt(inputSplit[2]);
            int startCol = Integer.parseInt(inputSplit[1]);
            int stopCol = Integer.parseInt(inputSplit[3]);
            int result = 0;
            for (int r = startRow;r<=(stopRow>=row ? row - 1 : stopRow);++r) {
                for (int c = startCol; c<=(stopCol>=col?col - 1 : stopCol);++c) {
                    if (graph[r][c]) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
