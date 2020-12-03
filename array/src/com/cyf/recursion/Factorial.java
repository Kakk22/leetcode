package com.cyf.recursion;

/**
 * n的阶乘
 *
 * @author by cyf
 * @date 2020/11/30.
 */
public class Factorial {
    private static final long TOW = 2L;

    private static long factorial(long n) {
        if (n < 0) {
            throw new RuntimeException("n参数不能为负数");
        }
        if (n <= TOW) {
            return n;
        }
        return factorial(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(factorial(20L));
    }
}
