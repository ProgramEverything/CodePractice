import java.util.Scanner;

public class Solution {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int group = 0;
        group = s.nextInt();
        s.nextLine();
        for (int i = 0; i < group; ++i) {
            System.out.println(inputOneGroup());
        }
    }
    public static int inputOneGroup() {
        String[] n_m = s.nextLine().split(" ");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);
        int[][] A_xs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            String[] A_x = s.nextLine().split(" ");
            A_xs[i][0] = Integer.parseInt(A_x[0]);
            A_xs[i][1] = Integer.parseInt(A_x[1]);
        }
        boolean[] isUsedA = new boolean[n];
        hasAttacked = 0;
        minAttacksNum = -1;
        shiFangYiGeJiNeng(m, A_xs, isUsedA);
        return minAttacksNum;
    }
    static int hasAttacked;
    static int minAttacksNum;
    public static void shiFangYiGeJiNeng(int shengYuXieLiang, int[][] A_xs, boolean[] isUsedA) {
        if (shengYuXieLiang <= 0) {
            if (minAttacksNum > hasAttacked || minAttacksNum == -1) {
                minAttacksNum = hasAttacked;
            }
            return;
        }
        for (int i = 0; i < A_xs.length; ++i) {
            if (isUsedA[i]) {
                continue;
            }
            int kill = 0;
            if (shengYuXieLiang <= A_xs[i][1]) {
                kill = A_xs[i][0] * 2;
            } else {
                kill = A_xs[i][0];
            }
            shengYuXieLiang -= kill;
            hasAttacked ++;
            isUsedA[i] = true;
            shiFangYiGeJiNeng(shengYuXieLiang, A_xs, isUsedA);
            shengYuXieLiang += kill;
            hasAttacked --;
            isUsedA[i] = false;
        }
    }
}
