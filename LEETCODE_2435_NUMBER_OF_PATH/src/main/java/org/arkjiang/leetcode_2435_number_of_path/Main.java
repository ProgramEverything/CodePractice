package org.arkjiang.leetcode_2435_number_of_path;

public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                new int[] {5,2,4},
                new int[] {3,0,5},
                new int[] {0,7,2}
        };
        int k = 3;
        System.out.println(new Main().numberOfPaths(grid, k));
    }

    boolean[][] walkedGrid;
    int[] position = new int[2]; // 第一项表示行数，第二项表示列数，也就是grid[position[0]][position[1]]
    int pathLength;
    int result = 0;
    int[][] grid;
    int k;

    /**
     * 输入一张地图和目标值，求地图从(0, 0)到(m - 1, n - 1)的路径中，路径和可以被目标值整除的数量
     * 数量对1e9 + 7求余
     * @param grid
     * @param k
     * @return
     */
    public int numberOfPaths(int[][] grid, int k) {
        walkedGrid = new boolean[grid.length][grid[0].length];
        walkedGrid[0][0] = true;
        this.grid = grid;
        this.k = k;
        pathLength = grid[0][0];
        walkOneStep();
        return result;
    }

    public void walkOneStep() {
        // 到终点了
        if (position[0] == grid.length - 1 && position[1] == grid[0].length - 1) {
            if (Math.floorMod(pathLength, k) == 0) {
                result = result + 1 == 1e9 + 7 ? 0 : result + 1;
            }
        }

//        if (position[0] - 1 > -1 && !walkedGrid[position[0] - 1][position[1]]) {
//            // 往上走
//            pathLength += grid[position[0] - 1][position[1]];
//            walkedGrid[position[0] - 1][position[1]] = true;
//            position[0] --;
//            walkOneStep();
//            position[0] ++;
//            pathLength -= grid[position[0] - 1][position[1]];
//            walkedGrid[position[0] - 1][position[1]] = false;
//        }
//
//        if (position[1] - 1 > -1 && !walkedGrid[position[0]][position[1] - 1]) {
//            // 往左走
//            pathLength += grid[position[0]][position[1] - 1];
//            walkedGrid[position[0]][position[1] - 1] = true;
//            position[1] --;
//            walkOneStep();
//            position[1] ++;
//            pathLength -= grid[position[0]][position[1] - 1];
//            walkedGrid[position[0]][position[1] - 1] = false;
//        }

        if (position[0] + 1 < grid.length && !walkedGrid[position[0] + 1][position[1]]) {
            // 往下走
            pathLength += grid[position[0] + 1][position[1]];
            walkedGrid[position[0] + 1][position[1]] = true;
            position[0] ++;
            walkOneStep();
            position[0] --;
            pathLength -= grid[position[0] + 1][position[1]];
            walkedGrid[position[0] + 1][position[1]] = false;
        }

        if (position[1] + 1 < grid[0].length && !walkedGrid[position[0]][position[1] + 1]) {
            // 往右走
            pathLength += grid[position[0]][position[1] + 1];
            walkedGrid[position[0]][position[1] + 1] = true;
            position[1] ++;
            walkOneStep();
            position[1] --;
            pathLength -= grid[position[0]][position[1] + 1];
            walkedGrid[position[0]][position[1] + 1] = false;
        }
    }
}
