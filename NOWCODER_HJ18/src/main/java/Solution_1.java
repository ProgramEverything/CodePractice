import java.util.Arrays;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        // 有正确性问题
        Scanner scanner = new Scanner(System.in);
        int[] statistic = new int[7];
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] ip_mask = input.split("~");
            // 先判断掩码合不合法，不合法就跳过
            // int[] mask = new int[4];
            String[] maskString = ip_mask[1].split("\\.");
            StringBuffer sb = new StringBuffer();
            try {
                for (int i = 0; i < 4; ++i) {
                    int oneMask = Integer.parseInt(maskString[i]);
                    for (int j = 7; j > -1; --j) {
                        sb.append(((oneMask >> j) & 0x01) == 0x01 ? "1" : "0");
                    }
                }
            }
            catch (Exception e) {
                continue;
            }
            if (!sb.toString().matches("^1+0+")) {
                continue;
            }

            int[] ip = new int[4];
            String[] ipString = ip_mask[0].split("\\.");
            try {
                for (int i = 0; i < 4; ++i) {
                    ip[i] = Integer.parseInt(ipString[i]);
                }
            }
            catch (Exception e) {
                continue;
            }
            if (ip[0] >= 1 && ip[0] <= 126) {
                if (ip[0] == 10) {
                    statistic[5] ++;
                }
                else {
                    statistic[0] ++;
                }
            }
            else if (ip[0] >= 128 && ip[0] <= 191) {
                if (ip[0] == 172) {
                    if (ip[1] >= 16 && ip[1] <= 31) {
                        statistic[5] ++;
                    }
                }
                else {
                    statistic[1] ++;
                }
            }
            else if (ip[0] >= 192 && ip[1] <= 223) {
                if (ip[1] == 168) {
                    statistic[5] ++;
                }
                else {
                    statistic[2] ++;
                }
            }
            else if (ip[0] >= 224 && ip[0] <= 239) {
                statistic[3] ++;
            }
            else if (ip[0] >= 240 && ip[0] <= 255) {
                statistic[4] ++;
            }
        }
        showArray(statistic);
    }
    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}
