import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        /*682一个号码位置正确
        614一个号码正确但是位置不正确
        206两个号码正确但是位置都不正确
        738没有一个号码正确
        870一个号码正确但是位置不正确
         */
        List<String> results = new ArrayList<>();
        for (int i = 0; i < 1000; ++i) {
            String num = format(i);
            System.out.print(num);
            if (checkCondOne(num) && checkCondTwo(num)
            && checkCondThree(num) && checkCondFour(num)
            && checkCondFive(num)) {
                results.add(num);
            }
            System.out.println();
        }
        System.out.println("符合条件的数字是" + Arrays.toString(results.toArray()));
    }
    public static String format(int num) {
        String format = Integer.toString(num);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3 - format.length(); ++i) {
            sb.append('0');
        }
        format = sb.append(format).toString();
        return format;
    }
    public static boolean checkCondOne(String num) {
        int digiCheck = 0;
        char[] target = "682".toCharArray();
        for (int i = 0; i < 3; ++i) {
            if (num.charAt(i) == target[i]) {
                digiCheck++;
            }
        }
        if (digiCheck == 1) {
            System.out.print("，符合条件一");
            return true;
        }
        System.out.print("，不符合条件一");
        return false;
    }
    public static boolean checkCondTwo(String num) {
        int digiCheck = 0;
        char[] target = "614".toCharArray();
        for (int i = 0; i < 3; ++i) {
            if (num.charAt(i) == target[i]) {
                digiCheck++;
            }
        }
        if (digiCheck != 0) {
            System.out.print("，不符合条件二");
            return false;
        }
        digiCheck = 0;
        for (int i = 0; i < 3; ++i) {
            if (num.contains(String.valueOf(target[i]))) {
                digiCheck++;
            }
        }
        if (digiCheck == 1) {
            System.out.print("，符合条件二");
            return true;
        }
        System.out.print("，不符合条件二");
        return false;
    }
    public static boolean checkCondThree(String num) {
        int digiCheck = 0;
        char[] target = "206".toCharArray();
        for (int i = 0; i < 3; ++i) {
            if (num.charAt(i) == target[i]) {
                digiCheck++;
            }
        }
        if (digiCheck != 0) {
            System.out.print("，不符合条件三");
            return false;
        }
        digiCheck = 0;
        for (int i = 0; i < 3; ++i) {
            if (num.contains(String.valueOf(target[i]))) {
                digiCheck++;
            }
        }
        if (digiCheck == 2) {
            System.out.print("，符合条件三");
            return true;
        }
        System.out.print("，不符合条件三");
        return false;
    }
    public static boolean checkCondFour(String num) {
        int digiCheck = 0;
        char[] target = "738".toCharArray();
        for (int i = 0; i < 3; ++i) {
            if (num.contains(String.valueOf(target[i]))) {
                digiCheck++;
            }
        }
        if (digiCheck == 0) {
            System.out.print("，符合条件四");
            return true;
        }
        System.out.print("，不符合条件四");
        return false;
    }
    public static boolean checkCondFive(String num) {
        int digiCheck = 0;
        char[] target = "870".toCharArray();
        for (int i = 0; i < 3; ++i) {
            if (num.charAt(i) == target[i]) {
                digiCheck++;
            }
        }
        if (digiCheck != 0) {
            System.out.print("，不符合条件五");
            return false;
        }
        digiCheck = 0;
        for (int i = 0; i < 3; ++i) {
            if (num.contains(String.valueOf(target[i]))) {
                digiCheck++;
            }
        }
        if (digiCheck == 1) {
            System.out.print("，符合条件五");
            return true;
        }
        System.out.print("，不符合条件五");
        return false;
    }
}
