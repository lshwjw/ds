package com.example.ds.practice;

import java.util.Arrays;

/**
 * @Author: weijianwei
 * @Date: 2019-12-24 20:27
 * @Description: 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Practice16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q  = length - 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (sum > target) {
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                    // 去重
                    while (p < q && nums[q] == nums[q - 1]) {
                        q--;
                    }
                    q--;
                } else if (sum < target) {
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                    // 去重
                    while (p < q && nums[p] == nums[p + 1]) {
                        p++;
                    }
                    p++;
                } else {
                    result = sum;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
//        int target = 1;
//        int[] nums = {-3, -2, -5, 3, -4};
//        int target = -1;
//        int[] nums = {0, 1, 2};
        int target = 1;
        Practice16 practice = new Practice16();
        System.out.println(practice.threeSumClosest(nums, target));
    }
}
