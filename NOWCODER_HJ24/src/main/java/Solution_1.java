import java.util.*;

public class Solution_1 {
    public static void main(String[] args) {
        // 最长上升子序列问题
        // 分别求出左右最长子序列的方法时间复杂度为O(N^2)，通常情况下是不能通过测试的
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
                // 求出每个数左侧最长子序列
                leftLength[i] = longestAscendSequence(Arrays.copyOf(sequence, i + 1));
            }
            // 把数组翻转求出每个数左侧最长子序列，再翻转就得到每个数右侧最长子序列
            reversArray(sequence);
            int[] rightLength = new int[studentsNumber];
            for (int i = 0; i < studentsNumber; ++i) {
                // 求出每个数左侧最长子序列
                rightLength[i] = longestAscendSequence(Arrays.copyOf(sequence, i + 1));
            }
            reversArray(rightLength);

            int max = 0;
            for (int i = 0; i < studentsNumber; ++i) {
                if (leftLength[i] + rightLength[i] - 1 > max) {
                    max = leftLength[i] + rightLength[i] - 1;
                }
            }
            System.out.println(studentsNumber - max);
        }
    }

    public static void reversArray(int[] ori) {
        int length = ori.length;
        int half = length / 2;
        for (int i = 0; i < half; ++i) {
            int temp = ori[i];
            ori[i] = ori[length - 1 - i];
            ori[length - 1 - i] = temp;
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
