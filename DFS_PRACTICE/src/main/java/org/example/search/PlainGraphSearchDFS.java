package org.example.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PlainGraphSearchDFS {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                new char[]{'0', '1', '1', '1', '0'},
                new char[]{'0', '1', '0', '0', '0'},
                new char[]{'0', '1', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '0'},
                new char[]{'0', '0', '0', '0', '0'},
        };
        List<Integer[]> track = new LinkedList<>();
        track.add(new Integer[]{0, 0});
        List<List<Integer[]>> tracks = new LinkedList<>();
        PlainGraphSearchDFS s = new PlainGraphSearchDFS();
        s.searchAll(grid, 0,0,4,4,track,tracks);
        tracks.forEach(track_n -> {
            track_n.forEach(position -> {
                System.out.print(Arrays.toString(position));
            });
            System.out.println();
        });
    }

    /**
     * 规定‘0’标识没有走过的路，‘1’标识障碍物或者走过的路
     *
     * @param grid
     * @param curRowNum
     * @param curColNum
     * @param targetRowNum
     * @param targetColNum
     * @param track
     * @param tracks
     */
    public void searchAll(char[][] grid, int curRowNum, int curColNum, int targetRowNum, int targetColNum, List<Integer[]> track, List<List<Integer[]>> tracks) {
        if (curColNum == targetColNum && curRowNum == targetRowNum) {
            tracks.add(List.copyOf(track));
            return;
        }
        if (curRowNum > 0) {
            if (grid[curRowNum - 1][curColNum] == '0') {
                grid[curRowNum - 1][curColNum] = '1';
                track.add(new Integer[]{curRowNum - 1, curColNum});
                searchAll(grid, curRowNum - 1, curColNum, targetRowNum, targetColNum, track, tracks);
                track.remove(track.size() - 1);
                grid[curRowNum - 1][curColNum] = '0';
            }
        }
        if (curColNum > 0) {
            if (grid[curRowNum][curColNum - 1] == '0') {
                grid[curRowNum][curColNum - 1] = '1';
                track.add(new Integer[]{curRowNum, curColNum - 1});
                searchAll(grid, curRowNum, curColNum - 1, targetRowNum, targetColNum, track, tracks);
                track.remove(track.size() - 1);
                grid[curRowNum][curColNum - 1] = '0';
            }
        }
        if (curRowNum < grid.length - 1) {
            if (grid[curRowNum + 1][curColNum] == '0') {
                grid[curRowNum + 1][curColNum]='1';
                track.add(new Integer[]{curRowNum + 1, curColNum});
                searchAll(grid, curRowNum + 1, curColNum, targetRowNum, targetColNum, track, tracks);
                track.remove(track.size() - 1);
                grid[curRowNum + 1][curColNum]='0';
            }
        }
        if (curColNum < grid[0].length - 1) {
            if (grid[curRowNum][curColNum + 1] == '0') {
                grid[curRowNum][curColNum + 1]='1';
                track.add(new Integer[]{curRowNum, curColNum + 1});
                searchAll(grid, curRowNum, curColNum + 1, targetRowNum, targetColNum, track, tracks);
                track.remove(track.size() - 1);
                grid[curRowNum][curColNum + 1]='0';
            }
        }
    }
}
