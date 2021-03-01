package com.cyf.interview;

/**
 * 面试题
 * 输出9*9乘法表
 *
 * @author 陈一锋
 * @date 2021/3/1 10:29
 **/
public class MultiplicationTable {

    public static void main(String[] args) {
        //打印9*9 乘法表
        //两层循环
        //第二层循环根据第几行决定循环的次数
        int len = 10;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
