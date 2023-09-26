import java.math.BigDecimal;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        if (n == 1) {
            System.out.println(s.nextLine());
        }

        String[] a_i = s.nextLine().split(" ");
        BigDecimal sum = BigDecimal.valueOf(0);
        int[] magic = new int[2];
        for (int i = 0; i < n; ++i) {
            int current = Integer.parseInt(a_i[i]);
            sum = sum.add(BigDecimal.valueOf(current));
            if (i == 0) {
                magic[1] = current;
                continue;
            }
            BigDecimal temp = BigDecimal.valueOf(magic[0]).multiply(BigDecimal.valueOf(magic[1]));
            temp = temp.subtract(BigDecimal.valueOf(magic[1]).multiply(BigDecimal.valueOf(current)));
            if (temp.compareTo(BigDecimal.valueOf(0)) > 0) {
                magic[0] = magic[1];
                magic[1] = current;
            }
        }
        if (magic[0] == 1 || magic[1] == 1) {
            System.out.println(sum);
        } else {
            sum = sum.subtract(BigDecimal.valueOf(magic[0]));
            sum = sum.subtract(BigDecimal.valueOf(magic[1]));
            sum = sum.add(BigDecimal.valueOf(magic[0]).multiply(BigDecimal.valueOf(magic[1])));
            System.out.println(sum);
        }
    }
}
