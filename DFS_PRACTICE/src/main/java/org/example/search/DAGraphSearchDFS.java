package org.example.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DAGraphSearchDFS {
    /**
     * 有向无环图的搜索
     * @param args
     */
    public static void main(String[] args) {
        int[][] graph = new int[][] {
                new int[] {1, 2},
                new int[] {3},
                new int[] {3},
                new int[0]
        };
        List<Integer> track = new LinkedList<>();
        SearchOne(graph, 0, 3, track);
        System.out.println(Arrays.toString(track.toArray()));


        List<List<Integer>> tracks = new LinkedList<>();
        tracks.forEach(track_n -> {
            System.out.println(Arrays.toString(track_n.toArray()));
        });
    }

    /**
     * 搜到结果就结束
     * @param graph
     * @param currentNode
     * @param target
     * @param track
     * @return
     */
    public static boolean SearchOne(int[][] graph, int currentNode, int target, List<Integer> track) {
        if (currentNode == target) {
            return true;
        }
        for (int childNodes : graph[currentNode]) {
            track.add(childNodes);
            if (SearchOne(graph, childNodes, target, track)) {
                return true;
            }
            track.remove(track.size() - 1);
        }
        return false;
    }

    public static void SearchAll(int[][] graph, int currentNode, int target, List<Integer> track, List<List<Integer>> tracks) {

    }
}
