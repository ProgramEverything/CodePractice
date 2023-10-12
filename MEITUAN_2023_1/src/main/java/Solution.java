import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = Integer.parseInt(s.nextLine());
        for (int i = 0; i < q; ++i) {
            String[] m_x = s.nextLine().split(" ");
            int m = Integer.parseInt(m_x[0]);
            int x = Integer.parseInt(m_x[1]);
            System.out.println(x - (x - 1)/ m * m);
        }
    }
}
