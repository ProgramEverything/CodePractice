import java.util.Arrays;
import java.util.Scanner;

public class Solution_2 {
    public static void main(String[] args) {
        // 用贪心算法+二分查找解决最长上升子序列问题
        // 在这个问题中，贪心就是要让子序列的最后一个数尽量小，也就是在遍历过程中找到比最后一个数小的数，就进行替换
        // 要找到第一个大于该数的数进行替换，但是替换并不删除后续元素，尽管此时子序列中可能各元素的顺序并不符合原序列，但是此时子序列的长度仍然代表当前最长上升子序列的长度
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
    public static int longestAscendSequence(int[] in) {
        int[] currentLongestAscendSequence = new int[in.length];
        int ptr = -1;   // ptr指向当前最长子序列的结尾
        for (int i = 0; i < in.length; ++i) {
            if (ptr == -1) {
                currentLongestAscendSequence[0] = in[i];
                ptr = 0;
            }
            else if (in[i] > currentLongestAscendSequence[ptr]){
                currentLongestAscendSequence[++ptr] = in[i];
            }
            else if (in[i] == currentLongestAscendSequence[ptr]){
                // 什么也不做
            }
            else {
                // 进行二分查找，找到第一个大于in[i]的数进行替换
                // 注意！因为并不删除后续元素，所以指针位置不变
                int temp = binarySearch(Arrays.copyOf(currentLongestAscendSequence, ptr + 1), in[i]);
                if (temp == -1) {
                    // 如果存在相同的数那么不变
                    continue;
                }
                currentLongestAscendSequence[temp] = in[i];
            }
        }
        return ptr + 1;
    }
    public static int binarySearch(int[] array, int target) {
        // 找到第一个大于target的数的索引，或者是否存在等于target的数，是则返回-1
        // 搜索范围是[start, end)
        int start = 0;
        int end = array.length;
        while (start != end) {
            int middle = array[(end - start) / 2 + start];
            if (target == middle) {
                return -1;
            }
            if (middle < target) {
                start = (end - start) / 2 + start + 1;
            }
            else {
                end = (end - start) / 2 + start;
            }
        }
        return start;
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
}
