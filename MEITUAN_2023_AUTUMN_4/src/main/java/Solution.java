import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 0;
        if (s.hasNextLine()) {
            n = Integer.parseInt(s.nextLine());
        }
        String matrixEle = "";
        if (s.hasNextLine()) {
            matrixEle = s.nextLine();
        }
        int[] rows = perfectlyDivide(n);
        int leastLianTongKuai = Integer.MAX_VALUE;
        for (int row : rows) {
            char[][] matrix = toMatrix(matrixEle, row);
            int temp = countLianTongKuai(matrix);
            if (leastLianTongKuai > temp) {
                leastLianTongKuai = temp;
            }
        }
        System.out.println(leastLianTongKuai);
    }
    public static int[] perfectlyDivide(int length) {
        int[] temp = new int[length];
        int p = 0;
        for (int i = 1; i< length / 2; ++i) {
            if (Math.floorMod(length, i) == 0) {
                temp[p++] = i;
            }
        }
        temp[p++] = length;
        return Arrays.copyOf(temp, p);
    }
    public static char[][] toMatrix(String matrixEle, int n) {
        char[][] matrix = new char[Math.floorMod(matrixEle.length(), n) == 0 ? matrixEle.length() / n : matrixEle.length() / n + 1][n];
        for (int i = 0; i < matrixEle.length(); ++i) {
            int i1 = i / n;
            int i2 = Math.floorMod(i, n);
            matrix[i1][i2] = matrixEle.charAt(i);
        }
        return matrix;
    }
    static boolean[][] isVisited;
    public static int countLianTongKuai(char[][] matrix) {
        isVisited = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (!isVisited[i][j]) {
                    count++;
                    markVisited(matrix, i, j);
                }
            }
        }
        return count;
    }
    public static void markVisited(char[][] matrix, int row, int col) {
        if (isVisited[row][col]) {
            return;
        }
        isVisited[row][col] = true;
        if (row > 0 && matrix[row - 1][col] == matrix[row][col]) {
            markVisited(matrix, row - 1, col);
        }
        if (col > 0 && matrix[row][col - 1] == matrix[row][col]) {
            markVisited(matrix, row, col - 1);
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] == matrix[row][col]) {
            markVisited(matrix, row + 1, col);
        }
        if (col < matrix[0].length - 1 && matrix[row][col + 1] == matrix[row][col]) {
            markVisited(matrix, row, col + 1);
        }
    }
}
