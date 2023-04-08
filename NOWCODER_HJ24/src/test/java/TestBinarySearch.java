import java.util.Arrays;

public class TestBinarySearch {
    public static void main(String[] args) {
        int[] test = new int[]{1,3,4,10,16,82,100};
        int target = 101;
        System.out.println(Solution_2.binarySearch(test, target));
    }
}
