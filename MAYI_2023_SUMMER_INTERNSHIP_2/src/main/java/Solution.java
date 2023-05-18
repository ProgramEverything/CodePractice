import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int xunWenCiShu = 0;
        if (scanner.hasNextInt()) {
            xunWenCiShu = scanner.nextInt();
        }
        scanner.nextLine();

        for (int cnt = 0; cnt < xunWenCiShu; ++cnt) {
            String[] inputSplit = new String[0];
            if (scanner.hasNextLine()) {
                inputSplit = scanner.nextLine().split(" ");
            }
            int row = Integer.parseInt(inputSplit[0]);
            int col = Integer.parseInt(inputSplit[1]);
            char[][] graph = new char[row][col];
            for (int i = 0; i < row; ++i) {
                String inputRow = scanner.nextLine();
                for (int j = 0; j < col; ++j) {
                    graph[i][j] = inputRow.charAt(j);
                }
            }
            if (isLegalGraph(graph)) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
    public static boolean isLegalGraph(char[][] graph) {
        boolean majorFlag = true;
        for (int i = 0; i < graph.length - 1; ++i) {
            for (int j = 0; j < graph[0].length - 1; ++j) {
                boolean flag = true;
                switch (graph[i][j]) {
                    case 'W' :
                        if (graph[i][j + 1] != 'D' && graph[i][j + 1] != '*') {
                            flag = false;
                            break;
                        }
                        if (graph[i + 1][j] != 'D' && graph[i + 1][j] != 'A' && graph[i + 1][j] != '*') {
                            flag = false;
                            break;
                        }
                        break;
                    case 'D' :
                        if (graph[i][j + 1] != 'D' && graph[i][j + 1] != '*') {
                            flag = false;
                            break;
                        }
                        if (graph[i + 1][j] != 'S' && graph[i + 1][j] != '*') {
                            flag = false;
                            break;
                        }
                        break;
                    case 'S':
                        if (graph[i][j + 1] != 'D' && graph[i][j + 1] != '*') {
                            flag = false;
                            break;
                        }
                        if (graph[i + 1][j] != 'S' && graph[i + 1][j] != '*') {
                            flag = false;
                            break;
                        }
                        break;
                    case 'A' :
                        if (graph[i][j + 1] != 'W' && graph[i][j + 1] != 'S' && graph[i][j + 1] != 'A' && graph[i][j + 1] != '*') {
                            flag = false;
                            break;
                        }
                        if (graph[i + 1][j] != 'S' && graph[i + 1][j] != '*') {
                            flag = false;
                            break;
                        }
                        break;
                    case '*' :
                        break;
                }
                if (!flag) {
                    majorFlag = false;
                    break;
                }
            }
            if (!majorFlag) {
                break;
            }
        }
        return majorFlag;
    }
}
