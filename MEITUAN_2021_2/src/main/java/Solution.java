import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int epoch = 0;
        if (s.hasNextLine()) {
            epoch = Integer.parseInt(s.nextLine());
        }
        for (int e = 0; e < epoch; ++e) {
            int n = 0;
            if (s.hasNextLine()) {
                n = Integer.parseInt(s.nextLine());
            }
            String[] n_delicious_values = new String[0];
            if (s.hasNextLine()) {
                n_delicious_values = s.nextLine().split(" ");
            }
            // 打表，第0行表示每1个元素求和，第1行表示每2个元素求和，以此类推，直到第N - 1行表示每N个元素求和
            int[][] dp = new int[n][n];
            int max = 0;
            for (int i = 0; i < n; ++i) {
                dp[0][i] = Integer.parseInt(n_delicious_values[i]);
                if (dp[0][i] > max) {
                    max = dp[0][i];
                }
            }
            for (int j = 1; j < n; ++j) {
                // 填表格剩下内容
                for (int i = 0; i < n; ++i) {
                    dp[j][i] = dp[j - 1][i] + dp[0][Math.floorMod(i + j, n)];
                    if (dp[j][i] > max) {
                        max = dp[j][i];
                    }
                }
            }
            System.out.println(max);
        }
    }
}
