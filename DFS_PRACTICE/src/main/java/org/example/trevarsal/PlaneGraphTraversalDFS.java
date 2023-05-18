package org.example.trevarsal;

public class PlaneGraphTraversalDFS {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };
        PlaneGraphTraversalDFS s = new PlaneGraphTraversalDFS();
        System.out.println(s.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    markAll(grid, i, j, visited);
                }
            }
        }
        return cnt;
    }

    public void markAll(char[][] grid, int curRowNum, int curColNum, boolean[][] visited) {
        if (visited[curRowNum][curColNum]) {
            return;
        }
        if (grid[curRowNum][curColNum] == '1') {
            visited[curRowNum][curColNum] = true;
        } else {
            return;
        }
        if (curRowNum > 0) {
            markAll(grid, curRowNum - 1, curColNum, visited);
        }
        if (curColNum > 0) {
            markAll(grid, curRowNum, curColNum - 1, visited);
        }
        if (curRowNum < grid.length - 1) {
            markAll(grid, curRowNum + 1, curColNum, visited);
        }
        if (curColNum < grid[0].length - 1) {
            markAll(grid, curRowNum, curColNum + 1, visited);
        }
    }
}
