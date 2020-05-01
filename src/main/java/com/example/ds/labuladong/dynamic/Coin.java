package com.example.ds.labuladong.dynamic;

/**
 * @Author: weijianwei
 * @Date: 2020-04-17 14:59
 * @Description: 凑零钱问题：给你k种面值的硬币，面值分别为c1,c2...ck,每种硬币的数量无限，问你最少需要几枚硬币凑出这个金额，
 * 11 1,2,5
 * 如果不能凑出，算法返回-1
 */
public class Coin {

    public int coinChange(int coins[], int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        Coin coin = new Coin();
        System.out.println(coin.coinChange(coins, 11));
    }
}
