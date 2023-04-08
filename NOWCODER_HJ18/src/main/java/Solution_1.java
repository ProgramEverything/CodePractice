import java.util.Arrays;
import java.util.Scanner;

public class Solution_1 {
    public static boolean goodMask(String mask) {
        StringBuffer sb = new StringBuffer();
        String[] maskSplit = mask.split("\\.");
        try {
            for (int i = 0; i < 4; ++i) {
                int oneMask = Integer.parseInt(maskSplit[i]);
                for (int j = 7; j > -1; --j) {
                    sb.append(((oneMask >> j) & 0x01) == 0x01 ? "1" : "0");
                }
            }
        }
        catch (Exception e) {
            return false;
        }
        if (!sb.toString().matches("^1+0+$")) {
            return false;
        }
        return true;
    }

    public static int ipClass(String ipString) {
        int[] ip = new int[4];
        String[] ipSplit = ipString.split("\\.");
        try {
            for (int i = 0; i < 4; ++i) {
                ip[i] = Integer.parseInt(ipSplit[i]);
            }
        }
        catch (Exception e) {
            // 错误的
            return 5;
        }
        if (ip[0] >= 1 && ip[0] <= 126) {
            // A类地址
            if (ip[0] == 10) {
                // 既是A类地址，也是私有地址
                return 7;
            }
            return 0;
        }
        else if (ip[0] >= 128 && ip[0] <= 191) {
            if (ip[0] == 172 && ip[1] >= 16 && ip[1] <= 31) {
                return 8;
            }
            // B类地址
            return 1;
        }
        else if (ip[0] >= 192 && ip[0] <= 223) {
            // C类地址
            if (ip[0] == 192 && ip[1] == 168) {
                return 9;
            }
            return 2;
        }
        else if (ip[0] >= 224 && ip[0] <= 239) {
            // D类地址
            return 3;
        }
        else if (ip[0] >= 240 && ip[0] <= 255) {
            // E类地址
            return 4;
        }
        else if (ip[0] == 0 || ip[0] == 127) {
            // 啥也不是
            return -1;
        }
        else {
            return 5;
        }
    }

    public static void main(String[] args) {
        // 有正确性问题
        Scanner scanner = new Scanner(System.in);
        int[] statistic = new int[7];   // 0: A类地址, 1: B类地址, 2: C类地址, 3: D类地址, 4: E类地址, 5: 错误IP或子网掩码, 6: 私有IP
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] ip_mask = input.split("~");
            // 判断掩码
            boolean isGoodMask = goodMask(ip_mask[1]);
            // 分类ip地址
            int ipClass = ipClass(ip_mask[0]);
            if (isGoodMask) {
                switch (ipClass) {
                    case 0:
                        statistic[0]++;
                        break;
                    case 1:
                        statistic[1]++;
                        break;
                    case 2:
                        statistic[2]++;
                        break;
                    case 3:
                        statistic[3]++;
                        break;
                    case 4:
                        statistic[4]++;
                        break;
                    case 5:
                        statistic[5]++;
                        break;
                    case 7:
                        statistic[0]++;
                        statistic[6]++;
                        break;
                    case 8:
                        statistic[1]++;
                        statistic[6]++;
                        break;
                    case 9:
                        statistic[2]++;
                        statistic[6]++;
                        break;
                }
            }
            else {
                if (ipClass == -1) {
                    // 不计数
                }
                else {
                    statistic[5]++;
                }
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
