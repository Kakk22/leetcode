package com.cyf.array;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
/**解题思路

 首先能想到的方法是暴力法。

 暴力的切分所有可能的子数组，求最大和的数组。

 这样做的时间复杂度是O(n2)，需要两个for循环来完成。

 对于面试题目，一般面试官希望看到的结果都不是暴力法，哪怕是一个dfs剪枝，也要比暴力法好。

 这道题目应该使用动态规划来求解，让我们再来分析一下这个问题。

 在这个问题中，我们发现，如果我们从前向后遍历数组，一个子数组的下一个元素是正数，那么加入这个元素一定是更好的方案。

 如果小于零，那么加入这个元素后的子数组一定不如之前的子数组，之前的子数组就是一个局部最优解。

 在整个过程中，我们去比较局部最优解中的最大值，就可以得到最优的子数组。

 在动态规划题目中，我们要明确四个要素。

 分别是，状态State、转移方程Fuc、初始化Init、结果Ans。

 我们先分析状态。

 我们使用一个一维数组dp[i]来记录到第i个元素的局部最大值。

 接下来是转移方程。

 我们使用

 dp[i] = max(dp[i-1] + nums[i], nums[i])

 作为转移方程。

 接下来是初始化，我们另dp[0]等于第一个元素的值，也就是nums[0]。

 最后，ans就是整个数组中最大的值。
 * @author by cyf
 * @date 2020/8/25.
 */
public class MaxSubArraySolution {
    /**
     * dp[i] 记录到第i个数字的最大序列和
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0 && nums ==null ){
            return 0;
        }
        //初始化dp和max
        int max = nums[0];
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(MaxSubArraySolution.maxSubArray(nums));
    }
}
