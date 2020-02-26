package com.example.ds.practice;

import java.util.*;

/**
 * @Author: weijianwei
 * @Date: 2019-12-23 20:15
 * @Description: 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Practice15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length < 3) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            // 第一个数大于0，三数之和必定大于0，结束循环
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q = length - 1;
            // 判断最小值
            int min = nums[i] + nums[p] + nums[p + 1];
            if (min > 0) {
                continue;
            }
            // 判断最大值
            int max = nums[i] + nums[q] + nums[q - 1];
            if (max < 0) {
                continue;
            }
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (sum < 0) {
                    p++;
                } else if (sum > 0) {
                    q--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    // 去重
                    while (p < q && nums[p] == nums[p + 1]) {
                        p++;
                    }
                    // 去重
                    while (p < q && nums[q] == nums[q - 1]) {
                        q--;
                    }
                    p++;
                    q--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {-1, 0, 1};
        Practice15 practice = new Practice15();
        System.out.println(practice.threeSum(nums));
    }
}
