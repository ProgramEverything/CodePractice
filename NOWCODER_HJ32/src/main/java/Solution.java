import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        char[] charInput = input.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < charInput.length; ++i) {
            int temp = symmetryLength(i, charInput);
            if (temp > maxLength) {
                maxLength = temp;
            }
        }
        System.out.println(maxLength);
    }

    public static int symmetryLength(int index, char[] input) {
        if (index == 0 || index == input.length - 1) {
            return 1;
        }
        int p1 = index - 1;
        int p2 = index + 1;
        int cnt = 1;
        while (input[p1] == input[index]) {
            cnt ++;
            p1 --;
        }
        while (input[p2] == input[index]) {
            cnt ++;
            p2 ++;
        }
        while (input[p1] == input[p2]) {
            // 有两种对称模式
            cnt = cnt + 2;
            p1 --;
            p2 ++;
            if (p1 == -1 || p2 == input.length) {
                break;
            }
        }
        return cnt;
    }
}
