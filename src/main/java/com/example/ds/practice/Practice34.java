package com.example.ds.practice;

import java.util.Arrays;

/**
 34. 在排序数组中查找元素的第一个和最后一个位置
 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: [-1,-1]
 */
public class Practice34 {

    public int[] searchRange2(int[] nums, int target) {
        int[] result = {-1, -1};
        int length = nums.length;
        int leftIndex = search(nums, target, 0, length - 1, true);
        if (leftIndex == length || nums[leftIndex] != target) {
            return result;
        }
        int rightIndex = search(nums, target, 0, length - 1, false) - 1;
        result[0] = leftIndex;
        result[1] = rightIndex;
        return result;
    }

    private int search(int[] nums, int target, int start, int end, boolean left) {
        if (start > end) {
            return start;
        }
        int mid = (end - start) / 2 + start;
        if (nums[mid] > target) {
            return search(nums, target, start, mid - 1, left);
        } else if (nums[mid] < target) {
            return search(nums, target, mid + 1, end, left);
        } else {
            if (left) {
                return search(nums, target, start, mid - 1, left);
            } else {
                return search(nums, target, mid + 1, end, left);
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        int index = binarySearch(nums, target, 0, length - 1);
        if (index == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int i = index - 1;
        while (i >= 0 && nums[i] == nums[index]) {
            i--;
        }
        result[0] = i + 1;
        int j = index + 1;
        while (j < length && nums[j] == nums[index]) {
            j++;
        }
        result[1] = j - 1;
        return result;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (end - start) / 2 + start;
        if (nums[mid] > target) {
            return binarySearch(nums, target, start, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, end);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        Practice34 practice = new Practice34();
        System.out.println(Arrays.toString(practice.searchRange2(nums, 5)));
        System.out.println(Arrays.toString(practice.searchRange2(nums, 7)));
        System.out.println(Arrays.toString(practice.searchRange2(nums, 8)));
        System.out.println(Arrays.toString(practice.searchRange2(nums, 10)));
    }
}
