package com.example.ds.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weijianwei
 * @Date: 2020-04-06 16:00
 * @Description: 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Practice46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        dfs(result, items, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> items, int[] nums) {
        if (items.size() == nums.length) {
            result.add(items);
            return;
        }
        for (int num : nums) {
            if (!items.contains(num)) {
                List<Integer> tmp = new ArrayList<>(items);
                tmp.add(num);
                dfs(result, tmp, nums);
            }
        }
    }

    public static void main(String[] args) {
        Practice46 practice = new Practice46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = practice.permute(nums);
        System.out.println(result);
    }
}
