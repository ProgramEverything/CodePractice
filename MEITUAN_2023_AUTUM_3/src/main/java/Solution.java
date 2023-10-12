import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        int m = 0;
        if (in.hasNextLine()) {
            String n_m = in.nextLine();
            n = Integer.parseInt(n_m.split(" ")[0]);
            m = Integer.parseInt(n_m.split(" ")[1]);
        }
        int[][] cakes = new int[n][m];
        for (int i = 0; i < n; ++i) {
            String[] rowCakes = in.nextLine().split(" ");
            for (int j = 0; j < m; ++j) {
                cakes[i][j] = Integer.parseInt(rowCakes[j]);
            }
        }
        int upper = 0;
        int allSum = 0;
        int[] rowSum = new int[n];
        for (int i = 0;i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                rowSum[i] += cakes[i][j];
                allSum += cakes[i][j];
            }
        }
        int differ = allSum;
        for (int i = 0; i < n; ++i) {
            if (Math.abs(differ - 2 * rowSum[i]) < differ) {
                differ = Math.abs(differ - 2 * rowSum[i]);
            }
            else {
                break;
            }
        }

        int[] colSum = new int[m];
        for (int i = 0;i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                colSum[j] += cakes[i][j];
            }
        }
        int differ_col = allSum;
        for (int i = 0; i < m; ++i) {
            if (Math.abs(differ_col - 2 * colSum[i]) < differ_col) {
                differ_col = Math.abs(differ_col - 2 * colSum[i]);
            }
            else {
                break;
            }
        }

        System.out.println(differ < differ_col ? differ : differ_col);
    }
}
