package com.cyf.array;

import java.util.Arrays;

/**
 * Given an array of ints = [6, 4, -3, 5, -2, -1, 0, 1, -9], implement a function
 * to move all positive numbers to the left, and move all negative numbers to the right.
 * Try your best to make its time complexity to O(n), and space complexity to O(1).
 *
 * 给定数组 正数移动到最左边 负数移动到最右边
 *
 * @author by cyf
 * @date 2020/11/9.
 */
public class RemoveLeft {
    public static int[] moveLeft(int[] ints) {
        if (ints == null) {
            throw new IllegalArgumentException("数组长度不能为空");
        }
        int j = ints.length - 1;
        for (int i = ints.length - 1; i > 0; i--) {
            if (ints[i] >= 0) {
                continue;
            }
            //小于零则交换
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
            j--;

        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = {6, 4, -3, 5, -2, -1, 0, 1, -9};
        int[] result = moveLeft(ints);
        System.out.println(Arrays.toString(result));
    }
}
