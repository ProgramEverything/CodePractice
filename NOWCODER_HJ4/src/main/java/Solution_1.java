import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        // 读取连续的字符串
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        // 空字符串不处理
        if (input == "") {
            System.out.println("");
            return;
        }
        // 拆分为长度为8的字符串，长度不足8的后面补0
        int totalLength = input.length();
        int segNum = totalLength / 8 + (totalLength % 8 == 0 ? 0 : 1);
        for (int i = 0; i < segNum; ++i) {
            String temp = "";
            if (i == segNum - 1) {
                // 是最后一段
                int inadequateLength = 8 - (totalLength - i * 8);
                temp = input.substring(i * 8);
                for (int j = 0; j < inadequateLength; ++j) {
                    temp += "0";
                }
                System.out.println(temp);
            }
            else {
                // 不是最后一段
                System.out.println(input.substring(i * 8, i * 8 + 8));
            }
        }
    }
}
