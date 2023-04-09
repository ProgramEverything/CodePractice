import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] inputs = new Integer[0];
        if (scanner.hasNextLine()) {
            inputs = trimInputs(scanner.nextLine());
        }
        Integer[] rules = new Integer[0];
        if (scanner.hasNextLine()) {
            rules = trimRules(scanner.nextLine());
        }
    }
    public static String getOccursString(Integer[] array, Integer target) {
        int[] occursArray = new int[array.length + 1];
        String targetString = target.toString();
        int cnt = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            if (array[i].toString().contains(targetString)) {
                sb.append(i + " " + array[i].toString() + " ");
                cnt ++;
            }
        }
        sb.insert(0, target + " " + cnt + " ");
        return sb.toString();
    }
    public static Integer[] trimInputs(String input) {
        String[] split = input.split(" ");
        int length = Integer.parseInt(split[0]);
        Integer[] trimInputs = new Integer[length];
        for (int i = 0; i < length; ++i) {
            trimInputs[i] = Integer.parseInt(split[i + 1]);
        }
        return trimInputs;
    }
    public static Integer[] trimRules(String rule) {
        String[] splits = rule.split(" ");
        Set<Integer> rules = new TreeSet<>();
        for (String split : splits) {
            rules.add(Integer.parseInt(split));
        }
        Integer[] rulesArray = new Integer[rules.size()];
        rules.toArray(rulesArray);
        return rulesArray;
    }
}
