package com.cyf.array;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 👍 8937 👎 0

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author by cyf
 * @date 2020/8/19.
 */
public class TowSumSolution {

    /**
     * 用hashmap的key存储数据的值，value存数组下标
     * 每次都判断值是否有target-nums[i] 有则说明当前i为要找的下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target -nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] ints = new TowSumSolution().twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

}
