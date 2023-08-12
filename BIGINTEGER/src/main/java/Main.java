import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = "";
        String b = "";
        if (s.hasNextLine()) {
            a = s.nextLine();
        }
        if (s.hasNextLine()) {
            b = s.nextLine();
        }
        Main m = new Main();
        System.out.println(m.bigIntegersMultiply(a, b));
    }
    public String bigIntegersMultiply(String a, String b) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < a.length() + b.length() - 1; ++i) {
            temp.add(0);
        }
        for (int i = a.length() - 1; i > -1; --i) {
            for (int j = b.length() - 1; j > -1; --j) {
                int index = a.length() + b.length() - 2 - i - j;
                temp.set(index, temp.get(index) + (a.charAt(i) - '0') * (b.charAt(j) - '0'));
            }
        }
        // 遍历temp执行进位操作
        int carryIn = 0;
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (true) {
            if (i > temp.size() - 1) {
                if (carryIn == 0) {
                    break;
                }
                else {
                    sb.append(Math.floorMod(carryIn, 10));
                    carryIn = carryIn / 10;
                }
            }
            else {
                int digTemp = temp.get(i);
                temp.set(i, Math.floorMod(temp.get(i) + carryIn, 10));
                carryIn = (digTemp + carryIn) / 10;
                sb.append(temp.get(i));
                i++;
            }
        }
        return sb.reverse().toString();
    }
}
