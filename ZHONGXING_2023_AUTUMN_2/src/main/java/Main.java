import java.security.Key;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1, 8};
        int[] b = new int[]{3, 10};
        int[] c = new int[]{2, 4};
        TreeMap<Integer, int[]> plants = new TreeMap<>();
        plants.put(c[0] - c[1], c);
        plants.put(a[0] - a[1], a);
        plants.put(b[0] - b[1], b);

        for (Map.Entry<Integer, int[]> entry : plants.entrySet()) {
            System.out.printf("%d, %s\n", entry.getKey(), Arrays.toString(entry.getValue()));
        }
        for (int[] entry : plants.values()) {
            ArrayList z = new ArrayList();
        }
        HashSet<Integer> y = new HashSet<>();
    }
}
