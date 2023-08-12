import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = "";
        String b = "";
        if (s.hasNextLine()) {
            a = s.nextLine();
        }
        if (s.hasNextLine()) {
            b = s.nextLine();
        }
        Main m = new Main();
        System.out.println(m.longestCommonSubsequence(a, b));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dpTable = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); ++i) {
            for (int j = 0; j < text2.length(); ++j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dpTable[i + 1][j + 1] = dpTable[i][j] + 1;
                }
                else {
                    dpTable[i + 1][j + 1] = Math.max(dpTable[i + 1][j], dpTable[i][j + 1]);
                }
            }
        }
        return dpTable[text1.length()][text2.length()];
    }
}
