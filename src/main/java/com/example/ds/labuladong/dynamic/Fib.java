package com.example.ds.labuladong.dynamic;

/**
 * @Author: weijianwei
 * @Date: 2020-04-08 14:14
 * @Description: 求解裴波纳契数列（1，1，2，3，5）
 */
public class Fib {

    /**
     * 暴力递归
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 自顶向下递归，备忘录去重
     * @param n
     * @return
     */
    public int fib2(int n) {
        int[] memo = new int[n];
        return cal1(memo, n);
    }

    private int cal1(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n - 1] != 0) {
            return memo[n - 1];
        }
        memo[n - 1] = cal1(memo, n - 1) + cal1(memo, n - 2);
        return memo[n - 1];
    }

    /**
     * 自底向上迭代，dp数组去重
     * @param n
     * @return
     */
    public int fib3(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib1(20));
        System.out.println(fib.fib2(20));
        System.out.println(fib.fib3(20));
    }
}
