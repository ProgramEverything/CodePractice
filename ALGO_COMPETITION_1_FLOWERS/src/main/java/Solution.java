import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] n_k = new String[0];
        if (scanner.hasNextLine()) {
            n_k = scanner.nextLine().split(" ");
        }
        int n = Integer.parseInt(n_k[0]);
        int k = Integer.parseInt(n_k[1]);
        String[] ti_s = new String[0];
        if (scanner.hasNextLine()) {
            ti_s = scanner.nextLine().split(" ");
        }
        String[] vi_s = new String[0];
        if (scanner.hasNextLine()) {
            vi_s = scanner.nextLine().split(" ");
        }
        int[] ti = new int[n];
        int[] vi = new int[n];
        for (int i = 0;i < n; ++i) {
            ti[i] = Integer.parseInt(ti_s[i]);
            vi[i] = Integer.parseInt(vi_s[i]);
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < k + 1; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + vi[i - 1]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
