import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        String[] split = input.split(" ");

        String target = split[split.length - 2];
        String[] dictionary = getDictionary(input, target);
        int index = Integer.parseInt(split[split.length - 1]) - 1;

        Arrays.sort(dictionary);
        System.out.println(dictionary.length);
        if (index >= dictionary.length) {
            return;
        }
        System.out.println(dictionary[index]);
    }
    public static String[] getDictionary(String input, String target) {
        String[] split = input.split(" ");
        int length = Integer.parseInt(split[0]);
        List<String> dictionary = new ArrayList<>();
        char[] tempTarget = target.toCharArray();
        Arrays.sort(tempTarget);
        String sortedTarget = String.copyValueOf(tempTarget);
        for (int i = 0; i < length; ++i) {
            // split从1到length是原始字典，但是要进行判断，是兄弟字符串的才能放进过滤后字典
            String word = split[i + 1];
            if (word.equals(target)) {
                continue;
            }
            char[] temp = word.toCharArray();
            Arrays.sort(temp);
            String sortedWord = String.copyValueOf(temp);
            if (sortedWord.equals(sortedTarget)) {
                dictionary.add(word);
            }
        }
        String[] array = new String[dictionary.size()];
        dictionary.toArray(array);
        return array;
    }
}
