import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        if (scanner.hasNextInt()) {
            length = scanner.nextInt();
        }
        scanner.nextLine();
        int[][] blocks = new int[length][2];
        for (int i = 0; i < length; ++i) {
            String[] blockInfoStringSplit = new String[3];
            if (scanner.hasNextLine()) {
                blockInfoStringSplit = scanner.nextLine().split(" ");
            }
            for (int j = 0; j < 2; ++j) {
                int blockNum = Integer.parseInt(blockInfoStringSplit[0]);
                blocks[blockNum][j] = Integer.parseInt(blockInfoStringSplit[j + 1]);
            }
        }
        // 遍历每个节点，对每个节点计算其父节点到该节点最大食物数量
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; ++i) {
            int temp = searchFood(blocks, i, 0, 0);
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
    }
    public static int searchFood (int[][] blocks, int curBlock, int curSum, int max) {
        // 这样计算就不是动态规划！
        if (blocks[curBlock][0] == -1) {
            // 到根节点了
            if (curSum + blocks[curBlock][1] > max) {
                return curSum + blocks[curBlock][1];
            }
            else {
                return max;
            }
        }

        // 还没到根节点
        curSum = curSum + blocks[curBlock][1];
        curBlock = blocks[curBlock][0];
        if (curSum > max) {
            max = curSum;
        }
        return searchFood(blocks, curBlock, curSum, max);
    }
}
