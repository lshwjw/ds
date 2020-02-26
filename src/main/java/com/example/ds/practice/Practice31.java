package com.example.ds.practice;

import java.util.Arrays;

/**
 31. 下一个排列
 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class Practice31 {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int index  = length - 1;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }
        if (index == length - 1) {
            reverse(nums, 0);
            return;
        }
        int bigIndex = index + 1;
        for (int i = index + 1; i < length; i++) {
            if (nums[i] > nums[index]) {
                bigIndex = i;
            }
        }
        swap(nums, index, bigIndex);
        reverse(nums, index + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,2,2,2,2,1};
        Practice31 practice = new Practice31();
        practice.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
