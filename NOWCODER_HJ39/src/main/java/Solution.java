import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 判断两个ip是否属于同一个子网
        Scanner scanner = new Scanner(System.in);
        String mask = "";
        if (scanner.hasNextLine()) {
            mask = scanner.nextLine();
        }
        Integer maskInt = stringToInt(mask);
        if (maskInt == null) {
            System.out.println("1");
            return;
        }
        int[] ips = new int[2];
        for (int i = 0; i < 2; ++i) {
            Integer temp = stringToInt(scanner.nextLine());
            if (temp == null) {
                System.out.println("1");
                return;
            }
            ips[i] = temp & maskInt;
        }
        System.out.println(ips[0] == ips[1] ? "0" : "2");
    }
    public static Integer stringToInt(String mask) {
        String[] maskSplit = mask.split("\\.");
        int maskInt = 0;
        for (int i = 0; i < 4; ++i) {
            int temp;
            try {
                temp = Integer.parseInt(maskSplit[i]);
            }
            catch (Exception e) {
                return null;
            }
            if (temp > 255) {
                return null;
            }
            maskInt += temp << (8 * (3 - i));
        }
        return maskInt;
    }
}
