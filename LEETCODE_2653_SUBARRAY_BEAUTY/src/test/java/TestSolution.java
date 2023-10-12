import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class TestSolution {
    public static void main(String[] args) {
        int[] original = new int[] {1, 10, 11, 9, 4, 1};
        Integer[] boxed = Arrays.stream(original).boxed().toArray(Integer[]::new);
        Integer[] powered = Arrays.stream(original).map(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return (int) Math.pow(operand, 2);
            }
        }).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(boxed));
        System.out.println(Arrays.toString(powered));
    }
}
