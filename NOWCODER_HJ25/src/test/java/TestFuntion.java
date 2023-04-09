import java.util.Arrays;

public class TestFuntion {
    public static void main(String[] args) {
        Integer[] integers = new Integer[5];
        Arrays.asList(1,2,10,44,210).toArray(integers);
        Integer target = 1;
        System.out.println(Solution_1.getOccursString(integers, target));
    }
}
