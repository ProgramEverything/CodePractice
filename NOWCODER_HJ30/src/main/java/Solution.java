import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        input = input.replace(" ", "");
        char[] ori;
        ori = input.toCharArray();
        char[][] evenOdd = splitEvenOdd(ori);
        Arrays.sort(evenOdd[0]);
        Arrays.sort(evenOdd[1]);
        char[] merged = mergeEvenOdd(evenOdd);
        for (int i = 0; i < merged.length; ++i) {
            merged[i] = reverseBinary(merged[i]);
        }
        System.out.println(String.copyValueOf(merged));
    }
    public static char reverseBinary(char c) {
        int temp = 0;
        if (c >= 'A' && c <= 'F') {
            temp = c - 'A' + 10;
        }
        else if (c >= 'a' && c <= 'f') {
            temp = c - 'a' + 10;
        }
        else if (c >= '0' && c <= '9') {
            temp = c - '0';
        }
        else {
            return c;
        }

        // 进行翻转相加
        int result = 0;
        for (int i = 0; i < 4; ++i) {
            result += (((temp >> i) & 0x01) == 0x01 ? Math.pow(2, 3 - i) : 0);
        }
        if (result < 10) {
            return (char) (result + '0');
        }
        else {
            return (char) (result - 10 + 'A');
        }
    }
    public static char[] mergeEvenOdd(char[][] evenOdd) {
        char[] merged = new char[evenOdd[0].length + evenOdd[1].length];
        for (int i = 0; i < merged.length; ++i) {
            if (i % 2 == 0) {
                merged[i] = evenOdd[0][i / 2];
            }
            else {
                merged[i] = evenOdd[1][i / 2];
            }
        }
        return merged;
    }
    public static char[][] splitEvenOdd(char[] ori) {
        char[] odd;
        char[] even;
        if (ori.length % 2 == 1) {
            odd = new char[ori.length / 2 + 1];
            even = new char[ori.length / 2];
        }
        else {
            odd = new char[ori.length / 2];
            even = new char[ori.length / 2];
        }
        for (int i = 0; i < ori.length; i = i + 2) {
            odd[i / 2] = ori[i];
        }
        for (int i = 1; i < ori.length; i = i + 2) {
            even[i / 2] = ori[i];
        }
        return new char[][] {odd, even};
    }
}
