import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int order = 0;
        if (scanner.hasNextInt()) {
            order = scanner.nextInt();
        }
        scanner.nextLine();
        int[][] matrix = new int[order][order];
        for (int i = 0; i < order; ++i) {
            // 首先确定每一行第一个数的值，
            // 上一行第一个数加i，如果是第一行那么为1
            int firstNum = i == 0 ? 1 : matrix[i - 1][0] + i;
            for (int j = 0; j < order - i; ++j) {
                // 对matrix[i][j]进行赋值，值为前一个数+i+j+1
                matrix[i][j] = j == 0 ? firstNum : matrix[i][j - 1] + i + j + 1;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < order; ++i) {
            for (int j = 0; j < order - i; ++j) {
                sb.append(matrix[i][j] + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
