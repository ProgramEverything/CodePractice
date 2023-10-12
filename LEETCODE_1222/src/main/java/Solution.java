import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // 把queens数组转换成棋盘哈希表
        boolean[][] map = new boolean[8][8];
        for (int i = 0; i < queens.length; ++i) {
            map[queens[i][0]][queens[i][1]] = true;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> left = toLeft(map, king);
        List<Integer> right = toRight(map, king);
        List<Integer> top = toTop(map, king);
        List<Integer> bottom = toBottom(map, king);
        if (left != null) {
            result.add(left);
        }
        if (right != null) {
            result.add(right);
        }
        if (top != null) {
            result.add(top);
        }
        if (bottom != null) {
            result.add(bottom);
        }
        return result;
    }
    public List<Integer> toLeft(boolean[][] map, int[] king) {
        // col --
        for (int i = king[1] - 1; i > -1; --i) {
            if (map[king[0]][i]) {
                return Arrays.asList(king[0], i);
            }
        }
        return null;
    }
    public List<Integer> toRight(boolean[][] map, int[] king) {
        // col ++
        for (int i = king[1] + 1; i < 8; ++i) {
            if (map[king[0]][i]) {
                return Arrays.asList(king[0], i);
            }
        }
        return null;
    }
    public List<Integer> toTop(boolean[][] map, int[] king) {
        // row --
        for (int i = king[0] - 1; i > -1; --i) {
            if (map[i][king[1]]) {
                return Arrays.asList(i, king[1]);
            }
        }
        return null;
    }
    public List<Integer> toBottom(boolean[][] map, int[] king) {
        // row ++
        for (int i = king[0] + 1; i < 8; ++i) {
            if (map[i][king[1]]) {
                return Arrays.asList(i, king[1]);
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
