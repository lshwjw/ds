package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2020-04-22 13:04
 * @Description: 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Practice53 {

    /**
     * 暴力解法（n*n）
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int tmp = 0;
            for (int j = i; j < length; j++) {
                tmp += nums[j];
                result = Math.max(result, tmp);
            }
        }
        return result;
    }

    public int maxSubArray2(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
            result = Math.max(result, nums[i]);
        }
        return result;
    }

    public int maxSubArray3(int[] nums) {
        int result = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Practice53 practice = new Practice53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(practice.maxSubArray(nums));
//        System.out.println(practice.maxSubArray2(nums));
        System.out.println(practice.maxSubArray3(nums));
    }
}
