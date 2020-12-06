package com.cyf.map;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4


import java.util.HashMap;
import java.util.Map;

/**
 * @author by cyf
 * @date 2020/9/14.
 */
public class SingleNumberSolution {
    /**解题思路 用位运算解决
     *  异或解法：异或运算满足交换律，a^b^a=a^a^b=b,
     *  因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4].....
     *  然后再根据交换律把相等的合并到一块儿进行异或（结果为0），
     *  然后再与只出现过一次的元素进行异或，这样最后的结果就是，
     *  只出现过一次的元素（0^任意值=任意值）
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public  static int singleNumber_1(int [] nums){
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1)
                return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {4,1,2,1,2,4,5};
//        int i = SingleNumberSolution.singleNumber(nums);
        int i = SingleNumberSolution.singleNumber_1(nums);
        System.out.println(i);
    }
}
