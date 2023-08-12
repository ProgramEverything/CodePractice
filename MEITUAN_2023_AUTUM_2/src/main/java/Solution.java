import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        if (in.hasNextLine()) {
            n = Integer.parseInt(in.nextLine());
        }
        int[] a_i = new int[n];
        String[] a_i_ori = new String[0];
        if (in.hasNextLine()) {
            a_i_ori = in.nextLine().split(" ");
        }
        for (int i = 0; i < n; ++i) {
            a_i[i] = Integer.parseInt(a_i_ori[i]);
        }
        int x = 0;
        int y = 0;
        if (in.hasNextLine()) {
            String x_y = in.nextLine();
            x = Integer.parseInt(x_y.split(" ")[0]);
            y = Integer.parseInt(x_y.split(" ")[1]);
        }
        int clockwise = 0;
        for (int i = x - 1; i < y - 1; ++i) {
            clockwise += a_i[i];
        }
        int notClockwise = 0;
        for (int i = 0; i < x - 1; ++i) {
            notClockwise += a_i[i];
        }
        for (int i = y - 1; i < n; ++i) {
            notClockwise += a_i[i];
        }
        System.out.print(clockwise > notClockwise ? notClockwise : clockwise);
    }
}
