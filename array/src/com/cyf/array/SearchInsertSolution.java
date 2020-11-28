package com.cyf.array;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 654 👎 0

import java.util.Queue;

/**
 * @author by cyf
 * @date 2020/8/23.
 */
public class SearchInsertSolution {

    public static int searchInsert(int[] nums, int target) {
        //如果比第一位还要小或数组长度为0返回0
        if (nums[0] > target && nums.length == 0) {
            return 0;
        }
        //二分法
        int i = 0, j = nums.length;
        while (i < j) {
            int med = (i + j) / 2;
            if (nums[med] == target) {
                return med;
            } else if (nums[med] > target) {
                j = med - 1;
            } else {
                i = med + 1;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 3;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }
}
