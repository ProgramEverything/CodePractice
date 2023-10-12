import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int coupons = Integer.parseInt(s.nextLine());
        String[] couponsValue_s = s.nextLine().split(" ");
        List<Integer> couponsValue = new ArrayList<>();
        for (int i = 0;i < coupons; ++i) {
            couponsValue.add(Integer.parseInt(couponsValue_s[i]));
        }
        // 回溯！
        System.out.println(combine(couponsValue));
    }
    public static int combine(List<Integer> couponsValue) {
        int maxMoney = 0;
        for (int i = 0; i < couponsValue.size(); ++i) {
            if (i != couponsValue.size() - 1 && couponsValue.get(i) == couponsValue.get(i + 1)) {
                int temp = couponsValue.get(i);
                couponsValue.remove(i + 1);
                couponsValue.set(i, temp + 1);
                int money = 1 + combine(couponsValue);
                if (money > maxMoney) {
                    maxMoney = money;
                }
                couponsValue.add(i + 1, temp);
                couponsValue.set(i, temp);
            }
        }
        return maxMoney;
    }
}
