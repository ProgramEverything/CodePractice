import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputSplit = new String[2];
        if (scanner.hasNextLine()) {
            inputSplit = scanner.nextLine().split(" ");
        }
        int apples = Integer.parseInt(inputSplit[0]);
        int plates = Integer.parseInt(inputSplit[1]);
        dist(apples, new Pattern(new int[plates]));
        System.out.println(distPatterns.size());
    }

    public static Set<Pattern> distPatterns = new HashSet<>();

    public static void dist(int remainApples, Pattern curPattern) {
        if (remainApples == 0) {
            // 分完苹果了
            Pattern result = new Pattern(curPattern);
            distPatterns.add(result);
            return;
        }
        // 还没有分完苹果
        for (int i = 0; i < curPattern.patternArray.length; ++i) {
            curPattern.patternArray[i]++;
            remainApples--;
            dist(remainApples, curPattern);
            curPattern.patternArray[i]--;
            remainApples++;
        }
    }

    static class Pattern {
        public int[] patternArray;
        public Pattern(Pattern p) {
            patternArray = p.patternArray.clone();
        }
        public Pattern(int[] array) {
            patternArray = array;
        }
        @Override
        public int hashCode() {
            int sum = 0;
            int[] patternArraySort = patternArray.clone();
            Arrays.sort(patternArraySort);
            for (int i = 0; i < patternArray.length; ++i) {
                 sum += patternArraySort[i] * Math.pow(10, i);
            }
            return sum;
        }

        @Override
        public boolean equals(Object obj) {
            if (this.hashCode() == obj.hashCode()) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
