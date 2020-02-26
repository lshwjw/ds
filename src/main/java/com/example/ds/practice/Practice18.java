package com.example.ds.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 18. 四数之和
 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

 注意：

 答案中不可以包含重复的四元组。

 示例：

 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

 满足要求的四元组集合为：
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class Practice18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 判断最小值
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                break;
            }
            // 判断最大值
            int max = nums[i] + nums[length- 3] + nums[length - 2] + nums[length - 1];
            if (max < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int p = j + 1;
                int q = nums.length - 1;
                // 判断最小值
                min = nums[i] + nums[j] + nums[p] + nums[p + 1];
                if (min > target) {
                    continue;
                }
                // 判断最大值
                max = nums[i] + nums[j] + nums[q] + nums[q - 1];
                if (max < target) {
                    continue;
                }
                while (p < q) {
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        while (p < q && nums[p] == nums[p + 1]) {
                            p++;
                        }
                        while (p < q && nums[q] == nums[q - 1]) {
                            q--;
                        }
                        p++;
                        q--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        Practice18 practice = new Practice18();
        System.out.println(practice.fourSum(nums, -9));
    }
}
