package com.cyf.array;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 729 👎 0

import java.util.Arrays;

/**
 * @author by cyf
 * @date 2020/9/11.
 */
public class MoveZeroes {

    /**
     * 解题思路 快慢指针
     * 当遇到0时，则快指针继续往下走，直到遇到0 则把交换快慢指针所指向的值，慢指针会一直指向0
     * 这样就会把所有的0往数组后面挪
     * @param arr
     * @return
     */
    public static int[] moveZeroes(int[] arr){
        if (arr.length == 0){
            throw  new RuntimeException("数组长度必须大于0");
        }
        int zero = 0;
        int j = 0 ;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == zero){
                continue;
            }
            //如果不等于0 则交换
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j++;
        }
        return  arr;
    }

    public static void main(String[] args) {
        int [] arr = {0,1,0,3,0,0,0,2,3,12};
        int[] ints = MoveZeroes.moveZeroes(arr);
        System.out.println(Arrays.toString(ints));
    }
}
