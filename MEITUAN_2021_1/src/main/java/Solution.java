import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            String[] n_m_a_b = new String[0];
            if (s.hasNextLine()) {
                n_m_a_b = s.nextLine().split(" ");
            }
            String[] m_cake_weight = new String[0];
            if (s.hasNextLine()) {
                m_cake_weight = s.nextLine().split(" ");
            }
            int n = Integer.parseInt(n_m_a_b[0]);
            int m = Integer.parseInt(n_m_a_b[1]);
            int a = Integer.parseInt(n_m_a_b[2]);
            int b = Integer.parseInt(n_m_a_b[3]);
            if (a > b) {
                // 使a < b
                int temp = b;
                b = a;
                a = temp;
            }
            // 首先要保证所有已经烤好的面包的重量在a和b之间
            // 其次要统计重量等于a和b的面包
            boolean isInRange = true;
            boolean hasWeightA = false;
            boolean hasWeightB = false;
            for (int i = 0; i < m; ++i) {
                int temp = Integer.parseInt(m_cake_weight[i]);
                if (temp < a || temp > b) {
                    isInRange = false;
                    break;
                }
                if (temp == a) {
                    hasWeightA = true;
                }
                else if (temp == b) {
                    hasWeightB = true;
                }
            }
            if (!isInRange) {
                // 如果存在重量不在a和b之间的面包，那一定不能满足条件
                System.out.println("NO");
            }
            else if (hasWeightA && hasWeightB) {
                // 如果已经存在重量a和b的面包，那一定满足条件
                System.out.println("YES");
            }
            else if (hasWeightA || hasWeightB) {
                // 如果已经存在重量a或b的面包，如果还能再烤一个，那一定能满足条件，反之一定不能满足条件
                if (n - m > 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            else {
                // 如果不存在重量a和b的面包，如果还能再烤两个，那一定能满足条件，反之一定不能满足
                if (n - m > 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
