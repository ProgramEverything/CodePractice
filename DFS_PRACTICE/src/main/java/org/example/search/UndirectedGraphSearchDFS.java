package org.example.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UndirectedGraphSearchDFS {
    public static void main(String[] args) {
        int[][] graph = new int[][] {
                new int[] {1,3,4},
                new int[] {0,2,3},
                new int[] {1,3,5},
                new int[] {0,1,2,4,5},
                new int[] {0,3,5},
                new int[] {2,3,4}
        };
        List<Integer> track = new LinkedList<>();
        List<List<Integer>> tracks = new LinkedList<>();
        boolean[] visited = new boolean[6];
        track.add(0);
        visited[0] = true;
        SearchAll(graph, 0, 5, track, tracks, visited);
        tracks.forEach(track_n -> {
            System.out.println(Arrays.toString(track_n.toArray()));
        });
    }
    public static boolean SearchOne(int[][] graph, int currentNode, int target, List<Integer> track, boolean[] visited) {
        if (currentNode == target) {
            return true;
        }
        for (int childNode : graph[currentNode]) {
            if (visited[childNode]) {
                continue;
            }
            track.add(childNode);
            visited[childNode] = true;
            if (SearchOne(graph, childNode, target, track, visited))
                return true;
            track.remove(track.size() - 1);
            visited[childNode] = false;
        }
        return false;
    }
    public static void SearchAll(int[][] graph, int currentNode, int target, List<Integer> track, List<List<Integer>> tracks, boolean[] visited) {
        if (currentNode == target) {
            tracks.add(List.copyOf(track));
            return;
        }
        for (int childNode : graph[currentNode]) {
            if (visited[childNode]) {
                continue;
            }
            track.add(childNode);
            visited[childNode] = true;
            SearchAll(graph, childNode, target, track, tracks, visited);
            track.remove(track.size() - 1);
            visited[childNode] = false;
        }
    }
}
