import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int inputRadix = 0;
        int outputRadix = 16;
        BigInteger num = new BigInteger(new byte[]{0});
        System.out.println("被转换字符串数的进制");
        if (s.hasNextInt()) {
            inputRadix = s.nextInt();
        }
        System.out.println("被转换字符串数");
        if (s.hasNextBigInteger(inputRadix)) {
            num = s.nextBigInteger(inputRadix);
        }
        System.out.println(num.toString(outputRadix));
        String snum = new String();
        s.nextLine();
        System.out.println("被转换字符串数");
        if (s.hasNextLine()) {
            snum = s.nextLine();
        }
        BigDecimal bd = new BigDecimal(0);
        for (int i = snum.length() - 1; i > -1; --i) {
            bd = bd.add(BigDecimal.valueOf(Integer.parseInt(String.valueOf(snum.charAt(i)), inputRadix)).multiply(BigDecimal.valueOf(inputRadix).pow(snum.length() - 1 - i)));
        }
        System.out.println(String.format("%.0f", bd.doubleValue()));
    }
}
