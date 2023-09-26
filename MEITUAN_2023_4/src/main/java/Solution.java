import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        targetLength = Integer.parseInt(s.nextLine());
        String[] a_i_n_s = s.nextLine().split(" ");
        array = new int[targetLength];
        for (int i = 0; i < targetLength; ++i) {
            array[i] = Integer.parseInt(a_i_n_s[i]);
            targetSum += array[i];
        }
        findNext(new ArrayList<>(), 0);
        System.out.println(legalCombinationNums);
    }
    public static int targetLength; // 构造的目标长度
    public static int targetSum = 0;
    public static int[] array;
    public static int legalCombinationNums = 0; // 合法的构造长度，如果值等于10e9 + 7，就清零
    public static void findNext(List<Integer> combination, int currentSum) {
        if (combination.size() == targetLength) {
            legalCombinationNums ++;
            if (legalCombinationNums == 1e9 + 7) {
                legalCombinationNums = 0;
            }
            return;
        }
        for (int i = 1; i < targetSum - currentSum + 1 - (targetLength - combination.size() - 1); ++i) {
            if (array[combination.size()] == i) {
                continue;
            }
            combination.add(i);
            currentSum += i;
            findNext(combination, currentSum);
            combination.remove(combination.size() - 1);
            currentSum -= i;
        }
    }
}
