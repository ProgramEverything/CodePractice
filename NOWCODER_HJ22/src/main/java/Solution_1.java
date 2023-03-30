import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> output = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 0) {
                // 输出output
                for (int i : output) {
                    System.out.println(i);
                }
                break;
            }
            output.add(changeBottleOneTime(input, 0));
        }
    }
    public static int changeBottleOneTime(int i, int cnt) {
        // 返回i个空瓶在一次兑换后，剩下的空瓶数量
        // 如果要向老板借瓶子，那么返回值应该扣掉借来的瓶子数
        if (i < 2) {
            return cnt;
        }
        if (i % 3 == 0) {
            return changeBottleOneTime(i / 3, cnt + (i / 3));
        }
        else {
            int changedNum = (i + 3) / 3;
            int borrowNum = 3 - (i % 3);
            return changeBottleOneTime(changedNum - borrowNum, cnt + changedNum);
        }
    }
}
