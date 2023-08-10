import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] array1_s = new String[0];
        if (s.hasNextLine()) {
            array1_s = s.nextLine().split(" ");
        }
        int[] array1 = new int[array1_s.length];
        for (int i = 0; i < array1_s.length; ++i) {
            array1[i] = Integer.parseInt(array1_s[i]);
        }
        String[] array2_s = new String[0];
        if (s.hasNextLine()) {
            array2_s = s.nextLine().split(" ");
        }
        int[] array2 = new int[array2_s.length];
        for (int i = 0; i < array2_s.length; ++i) {
            array2[i] = Integer.parseInt(array2_s[i]);
        }
        int N = array1.length;
        int[] concatArray = new int[N * 2];
        for (int i = 0; i < N; ++i) {
            concatArray[i] = array1[i];
        }
        for (int i = 0; i < N; ++i) {
            concatArray[i + N] = array2[i];
        }
        Arrays.sort(concatArray);
        for (int i = 0; i < N; ++i) {
            array1[i] = concatArray[i * 2];
        }
        for (int i = 0; i < N; ++i) {
            array2[i] = concatArray[i * 2 + 1];
        }
        System.out.println(Arrays.toString(array1) + ", " + Arrays.toString(array2));
    }
}
