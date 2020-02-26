package com.example.ds.practice;

import java.util.ArrayList;
import java.util.List;

/**
 39. 组合总和
 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。

 说明：

 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。 
 示例 1:

 输入: candidates = [2,3,6,7], target = 7,
 所求解集为:
 [
 [7],
 [2,2,3]
 ]
 示例 2:

 输入: candidates = [2,3,5], target = 8,
 所求解集为:
 [
   [2,2,2,2],
   [2,3,3],
   [3,5]
 ]
 */
public class Practice39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            while (true) {
                sum += candidate;
                if (sum == target) {
                    tmp.add(candidate);
                    result.add(tmp);
                    break;
                } else if (sum > target) {
                    break;
                } else {
                    tmp.add(candidate);
                }
            }
        }
        return null;
    }

    private void sum(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int layer, int sum, int target) {
        if (layer >= candidates.length) {
            return;
        }
        int candidate = candidates[layer];
        sum = sum + candidate;
        if (sum == target) {
            tmp.add(candidate);
            result.add(tmp);
        } else if (sum < target) {
            tmp.add(candidate);

        }
    }
}
