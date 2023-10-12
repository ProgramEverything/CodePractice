import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        String[] a_i_s = s.nextLine().split(" ");
        int[] a_i = new int[N];
        for (int i = 0; i < N; ++i) {
            a_i[i] = Integer.parseInt(a_i_s[i]);
        }
        int currentBiggest = Integer.MIN_VALUE;
        int sum = 0;
        int changedTime = 0;
        for (int i = N - 1; i > -1; --i) {
            if (a_i[i] >= currentBiggest) {
                currentBiggest = a_i[i];
            } else {
                a_i[i] = currentBiggest;
                changedTime ++;
            }
            sum += a_i[i];
        }
        System.out.printf("%d %d", sum, changedTime);
    }
}
