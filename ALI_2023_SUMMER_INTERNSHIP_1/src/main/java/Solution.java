import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    /**
     * 权值不小于k的连续子数组数量
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n_k = "";
        if (scanner.hasNextLine()) {
            n_k = scanner.nextLine();
        }
        int n = Integer.parseInt(n_k.split(" ")[0]);
        int k = Integer.parseInt(n_k.split(" ")[1]);
        int[] arrayn = new int[n];
        String[] arrayString = new String[n];
        if (scanner.hasNextLine()) {
            arrayString = scanner.nextLine().split(" ");
        }
        if (arrayString.length != n) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            arrayn[i] = Integer.parseInt(arrayString[i]);
        }

        int result = 0;
        // 定义一个[p1, p2)的区间，p2不断向右扩展，找到第一个在该区间内权值大于k的
        int p1 = 0;
        int p2 = 1;
        boolean find = true;
        while (p1 != n) {
            int weight = GetWeight(Arrays.copyOfRange(arrayn, p1, p2));
            while (weight < k) {
                p2++;
                if (p2 == n + 1) {
                    find = false;
                    break;
                }
                weight = GetWeight(Arrays.copyOfRange(arrayn, p1, p2));
            }
            if (find)
            {
                result += n - p2 + 1;
                p1++;
                p2 = p1 + 1;
            }
            else {
                break;
            }
        }
        System.out.println(result);
    }

    /**
     * 计算数组的权值
     * @param array
     * @return
     */
    public static int GetWeight(int[] array) {
        int chengJi = 1;
        for (int i : array) {
            chengJi *= i;
        }
        int weight = 0;
        for (int i = 1; i <= chengJi; ++i) {
            if (chengJi % i == 0) {
                weight++;
            }
        }
        return weight;
    }
}
