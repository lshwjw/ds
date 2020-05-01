package com.example.ds.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: weijianwei
 * @Date: 2020-02-26 21:58
 * @Description: 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Practice40 {

    /**
     * TODO 未完成！
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        int sum = 0;
        List<Integer> tmp = new ArrayList<>();
        sum(result, tmp, candidates, sum, target, 0);
        return result;
    }

    private void sum(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int sum, int target, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int candidate = candidates[i];
            if (!tmp.isEmpty() && candidate < tmp.get(tmp.size() - 1)) {
                continue;
            }
            int tmpSum = sum + candidate;
            if (tmpSum == target) {
                tmp.add(candidate);
                result.add(tmp);
                break;
            } else if (tmpSum < target) {
                List<Integer> copy = new ArrayList<>();
                copy.addAll(tmp);
                copy.add(candidate);
                sum(result, copy, candidates, tmpSum, target, index + i + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Practice40 practice = new Practice40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
//        int[] candidates = {1,2};
//        int target = 4;
        List<List<Integer>> result = practice.combinationSum2(candidates, target);
        System.out.println(result);
    }
}
