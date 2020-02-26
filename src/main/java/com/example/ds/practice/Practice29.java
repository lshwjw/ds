package com.example.ds.practice;

/**
 29. 两数相除
 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

 返回被除数 dividend 除以除数 divisor 得到的商。

 示例 1:

 输入: dividend = 10, divisor = 3
 输出: 3
 示例 2:

 输入: dividend = 7, divisor = -3
 输出: -2
 说明:

 被除数和除数均为 32 位有符号整数。
 除数不为 0。
 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 */
public class Practice29 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int rate = 0;
        int sum = 0;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
            while (sum <= dividend) {
                sum += divisor;
                rate--;
            }
            return rate + 1;
        } else {
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
            while (sum <= dividend) {
                sum += divisor;
                rate++;
            }
            return rate - 1;
        }
    }

    public static void main(String[] args) {
        Practice29 practice = new Practice29();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(practice.divide(-2147483647, -1));
    }
}
