package com.example.ds.labuladong.dynamic;

/**
 * @Author: weijianwei
 * @Date: 2020-04-19 23:09
 * @Description: 背包问题
 */
public class Backpack {

    public int cal(int[] weight, int[] price, int maxWeight) {
        int[][] dp = new int[weight.length][maxWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (i - 1 >= 0) {
                    if (j - weight[i] > 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], price[i] + dp[i - 1][j - weight[i]]);
                    } else if (j - weight[i] == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], price[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j], price[i]);
                }
            }
        }
        return dp[weight.length - 1][maxWeight];
    }

    public int cal2(int[] weight, int[] price, int maxWeight) {
        int[][] dp = new int[maxWeight + 1][weight.length];
        for (int i = 1; i <= maxWeight; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (i - 1 >= 0) {
                    if (i - weight[j] > 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], price[j] + dp[i - 1][i - weight[j]]);
                    } else if (i - weight[j] == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], price[j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j], price[j]);
                }
            }
        }
        return dp[maxWeight][weight.length - 1];
    }

    public static void main(String[] args) {
        int[] weight = {1, 4, 3};
        int[] price = {1500, 3000, 2000};
        Backpack backpack = new Backpack();
        int cal = backpack.cal(weight, price, 4);
        int cal2 = backpack.cal2(weight, price, 4);
        System.out.println(cal);
        System.out.println(cal2);
    }
}
