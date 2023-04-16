import java.util.Scanner;

public class Solution {
    public static String[] oneNum = new String[] {
            "zero", // 占个位
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };
    public static String[] tenNum = new String[] {
            "zero", //同理
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety",
    };
    public static String[] higher = new String[] {
            "hundred",
            "thousand",
            "million",
            "billion",
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
        }
        scanner.nextLine();
        // 每3个十进制位送入convertAUnit进行转换
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; ++i) {
            int temp = input / (int) Math.pow(1000, 2 - i) % 1000;
            if (temp != 0) {
                sb.append(convertAUnit(temp));
                sb.append(" ");
                if (i != 2) {
                    sb.append(higher[2 - i]);
                    sb.append(" ");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
    public static String convertAUnit(int input) {
        // input的范围是0-999，也就是把3位十进制数视为一个单位
        // 前后没有空格，需要在外部判断前后需不需要空格
        StringBuffer sb = new StringBuffer();
        boolean andFlag = false;
        boolean spaceFlag = false;
        for (int i = 0; i < 3; ++i) {
            int digit = input / (int) Math.pow(10, 2 - i) % 10;
            if (digit == 0) {
                // 某一位是0的话，就跳过，因为不会去读
                continue;
            }
            if (i == 0) {
                sb.append(oneNum[digit]);
                sb.append(" ");
                sb.append(higher[0]);
                andFlag = true; // 如果百位上有数不为0，那么就需要读and
                spaceFlag = true;
            }
            else if (i == 1) {
                if (spaceFlag) {
                    sb.append(" ");
                }
                spaceFlag = true;
                if (andFlag) {
                    sb.append("and ");
                }
                // 加个补丁，如果十位是1，那么是特例
                if (digit == 1) {
                    sb.append(oneNum[input % 100]);
                    break;
                }
                andFlag = false;    // and已经在十位被读了
                sb.append(tenNum[digit]);
            }
            else {
                if (spaceFlag) {
                    sb.append(" ");
                }
                if (andFlag) {
                    sb.append("and ");
                }
                sb.append(oneNum[digit]);
            }
        }
        return sb.toString();
    }
}
