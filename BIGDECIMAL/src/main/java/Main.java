import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        double a = 1234567890987654321d;
        double r = 1.524157877457705E36;
        BigDecimal b = BigDecimal.valueOf(a);
        System.out.println(Math.pow(a, 2));
        System.out.println(Math.pow(a, 2) - r);
        System.out.println(b.pow(2));
        System.out.println(b.pow(2).subtract(BigDecimal.valueOf(r)));
    }
}
