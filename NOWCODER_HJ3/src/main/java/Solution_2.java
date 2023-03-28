import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_2 {
    public static void main(String[] args) {
        // 读数组
        Scanner in = new Scanner(System.in);
        int length = 0;
        if (in.hasNextInt()) {
            length = in.nextInt();
        }
        if (length == 0) {
            return;
        }
        // 利用TreeSet的特性同时实现排序+去重
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        for (int i = 0; i < length; ++i) {
            if (in.hasNextInt()) {
                integerTreeSet.add(in.nextInt());
            }
        }
        Iterator<Integer> integerIterator = integerTreeSet.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
    }
}
