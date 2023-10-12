package org.arkjiang.leetcode_2610_find_matrix;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,1,2,3,1};
        List<List<Integer>> result = new Solution().findMatrix(nums);
        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> numOccuredTime = new HashMap<>();
        for (int el : nums) {
            if (numOccuredTime.containsKey(el)) {
                numOccuredTime.put(el, numOccuredTime.get(el) + 1);
            } else {
                numOccuredTime.put(el, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> numOccuredTimeEntries = new ArrayList<>(numOccuredTime.entrySet());
        numOccuredTimeEntries.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.addAll(Arrays.asList((List<Integer>[]) new ArrayList[numOccuredTimeEntries.get(0).getValue()]));

        for (Map.Entry<Integer, Integer> numOccuredTimeEntry : numOccuredTimeEntries) {
            for (int i = 0; i < numOccuredTimeEntry.getValue(); ++i) {
                if (matrix.get(i) == null) {
                    List<Integer> row = new ArrayList<>();
                    row.add(numOccuredTimeEntry.getKey());
                    matrix.set(i, row);
                } else {
                    matrix.get(i).add(numOccuredTimeEntry.getKey());
                }
            }
        }

        return matrix;
    }
}
