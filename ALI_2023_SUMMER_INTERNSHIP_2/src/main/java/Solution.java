import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // 直接在图上进行标记，‘0’代表海洋，‘1’代表陆地，‘2’代表标记过的陆地
        char[][] grid = new char[][]{
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };
        int[][] result = new int[grid.length][grid[0].length];
        int ori = count(copy(grid));
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    result[i][j] = ori;
                }
                else {
                    char[][] mod = copy(grid);
                    mod[i][j] = '1';
                    result[i][j] = count(mod);
                }
            }
        }
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static char[][] copy(char[][] ori) {
        char[][] copy = new char[ori.length][ori[0].length];
        for (int i = 0; i< ori.length; ++i) {
            for (int j = 0; j < ori[0].length; ++j) {
                copy[i][j] = ori[i][j];
            }
        }
        return copy;
    }

    public static int count(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    cnt++;
                    mark_2(grid, i, j);
                }
            }
        }
        return cnt;
    }

    /**
     * 错误例子！！！
     * 不阻止当前递归进入下一个不合法点的递归
     * 也就是当前写法！！！必须要！！！阻止当前递归进入下一个不合法点的递归
     * @param grid
     * @param curRowNum
     * @param curColNum
     */
    public static void markHasBug(char[][] grid, int curRowNum, int curColNum) {
        if (grid[curRowNum][curColNum] != '1') {
            return;
        }
        grid[curColNum][curColNum] = '2';
        if (curRowNum > 0) {
            markHasBug(grid, curRowNum - 1, curColNum);
        }
        if (curColNum > 0) {
            markHasBug(grid, curRowNum, curColNum - 1);
        }
        if (curRowNum < grid.length - 1) {
            markHasBug(grid, curRowNum + 1, curColNum);
        }
        if (curColNum < grid[0].length - 1) {
            markHasBug(grid, curRowNum, curColNum + 1);
        }
    }

    public static void mark(char[][] grid, int curRowNum, int curColNum) {
        grid[curRowNum][curColNum] = '2';
        if (curRowNum > 0) {
            if (grid[curRowNum - 1][curColNum] == '1') {
                mark(grid, curRowNum - 1, curColNum);
            }
        }
        if (curColNum > 0) {
            if (grid[curRowNum][curColNum - 1] == '1') {
                mark(grid, curRowNum, curColNum - 1);
            }
        }
        if (curRowNum < grid.length - 1) {
            if (grid[curRowNum + 1][curColNum] == '1') {
                mark(grid, curRowNum + 1, curColNum);
            }
        }
        if (curColNum < grid[0].length - 1) {
            if (grid[curRowNum][curColNum + 1] == '1') {
                mark(grid, curRowNum, curColNum + 1);
            }
        }
    }

    /**
     * 这种写法虽然不阻止不合法点进入下一层递归，但是在下一层递归的一开始就对点进行合法性判断，阻止了不合法点继续进行递归
     * @param grid
     * @param curRowNum
     * @param curColNum
     */
    public static void mark_2(char[][] grid, int curRowNum, int curColNum) {
        if (grid[curRowNum][curColNum] != '1') {
            return;
        }
        grid[curRowNum][curColNum] = '2';
        if (curRowNum > 0) {
            mark_2(grid, curRowNum - 1, curColNum);
        }
        if (curColNum > 0) {
            mark_2(grid, curRowNum, curColNum - 1);
        }
        if (curRowNum < grid.length - 1) {
            mark_2(grid, curRowNum + 1, curColNum);
        }
        if (curColNum < grid[0].length - 1) {
            mark_2(grid, curRowNum, curColNum + 1);
        }
    }
}
