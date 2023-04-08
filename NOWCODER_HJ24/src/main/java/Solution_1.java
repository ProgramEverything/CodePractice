import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        // 最长上升子序列问题
        Scanner scanner = new Scanner(System.in);
        int studentsNumber = 0;
        if (scanner.hasNextInt()) {
            studentsNumber = scanner.nextInt();
        }
        scanner.nextLine();
        if (scanner.hasNextLine()) {
            int[] sequence = splitAndParse(studentsNumber, scanner.nextLine());
            int[] leftLength = new int[studentsNumber];
            for (int i = 0; i < studentsNumber; ++i) {
                leftLength[i] = longestAscendSequence(Arrays.copyOf(sequence, i + 1));
            }
            System.out.println(Arrays.toString(leftLength));
        }
    }
    public static int[] splitAndParse(int studentsNumber, String in) {
        String[] split = in.split(" ");
        int[] sequence = new int[studentsNumber];
        for (int i = 0; i < studentsNumber; ++i) {
            sequence[i] = Integer.parseInt(split[i]);
        }
        return sequence;
    }
    public static int longestAscendSequence(int[] in) {
        if (in.length == 1) {
            // 如果序列里只有自己，那么最大长度为1
            return 1;
        }
        int longestLength = 0;
        for (int i = 0; i < in.length - 1; ++i) {
            if (in[i] < in[in.length - 1]) {
                int temp = longestAscendSequence(Arrays.copyOf(in, i + 1));
                if (temp > longestLength) {
                    longestLength = temp;
                }
            }
        }
        return longestLength + 1;
    }
}
