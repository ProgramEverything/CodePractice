package org.ArkJiang.quick_sort;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[] {10, 9, 50, 44, 8, 99, 3, 5, 27};
        Solution s = new Solution();
        s.pointers = new int[] {0, array.length - 1};
        s.quickSort(array);
        System.out.println(array);
    }
    void moveRightToLeft(int[] array) {
        while (pointers[0] != pointers[1]) {
            if (array[pointers[1]] < array[pointers[0]]) {
                swap(array);
                return;
            }
            pointers[1] --; // 右指针向左移动
        }
    }
    void moveLeftToRight(int[] array) {
        while (pointers[0] != pointers[1]) {
            if (array[pointers[0]] > array[pointers[1]]) {
                swap(array);
                return;
            }
            pointers[0] ++; // 左指针向右移动
        }
    }
    void swap(int[] array) {
        int temp = array[pointers[1]];
        array[pointers[1]] = array[pointers[0]];
        array[pointers[0]] = temp;
    }
    int[] pointers;
    void quickSort(int[] array) {
        if (pointers[0] == pointers[1] || pointers[0] < 0 || pointers[1] > array.length - 1) {
            return;
        }
        int[] previous = Arrays.copyOf(pointers, 2);
        boolean direction = true;   // true代表右指针向左移动，false代表左指针向右移动
        while (pointers[0] != pointers[1]) {
            if (direction) {
                moveRightToLeft(array);
            } else {
                moveLeftToRight(array);
            }
            direction = !direction;
        }
        // 左右指针都指向的数是当前迭代中基准数的位置
        // 接下来递归地解决左右子数组的排序
        int middle = pointers[0];
        pointers[0] = previous[0];
        pointers[1] = middle - 1;
        quickSort(array);
        pointers[1] = previous[1];
        pointers[0] = middle + 1;
        quickSort(array);
    }
}
