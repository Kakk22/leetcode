package com.cyf.map;
//给定一个整数数组，判断是否存在重复元素。
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
//
//
//
// 示例 1:
//
// 输入: [1,2,3,1]
//输出: true
//
// 示例 2:
//
// 输入: [1,2,3,4]
//输出: false
//
// 示例 3:
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true
// Related Topics 数组 哈希表

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断存在重复数据
 *
 * @author by cyf
 * @date 2020/12/6.
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num,1);
        }
        return map.size() < nums.length;
    }

    public static boolean containsDuplicate_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,3,1,5};
        //System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate_1(nums));
    }
}
