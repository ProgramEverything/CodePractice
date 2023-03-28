package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1 {
    /**
     * 输入的第一个数是数组长度
     * 后续输入是数组元素
     * 将结果数组用System.out.println()输出
     * @param args
     */
    public static void main(String[] args) {
        // 读数组
        Scanner in = new Scanner(System.in);
        int length = 0;
        if (in.hasNextInt()) {
            length = in.nextInt();
        }
        // 特殊情况一：数组长度为0
        if (length == 0) {
            return;
        }
        int[] array = new int[length];
        for (int i = 0; i < length; ++i) {
            if (in.hasNextInt()) {
                array[i] = in.nextInt();
            }
        }
        // 特殊情况二：数组长度为1
        if (length == 1) {
            System.out.println(array[0]);
        }
        // 排序
        Arrays.sort(array);
        // 去重
        // 我想到的去重方法：双指针去重
        int behind = 0;
        int ahead = 1;
        while (ahead != length) {
            if (array[behind] == array[ahead]) {
                ahead ++;
            }
            else {
                array[behind + 1] = array[ahead];
                behind ++;
                ahead ++;
            }
        }
        for (int i = 0; i < behind + 1; ++i) {
            System.out.println(array[i]);
        }
    }
}