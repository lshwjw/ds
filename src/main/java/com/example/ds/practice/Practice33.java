package com.example.ds.practice;

/**
 33. 搜索旋转排序数组
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 示例 1:

 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: 4
 示例 2:

 输入: nums = [4,5,6,7,0,1,2], target = 3
 输出: -1
 */
public class Practice33 {

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int index;
        if (nums[0] < nums[length - 1]) {
            index = 0;
        } else {
            index = findRotateIndex(nums, 0, length - 1);
        }
        if (nums[index] == target) {
            return index;
        }
        if (index == 0) {
            return binarySearch(nums, target, 0, length - 1);
        }
        if (target < nums[0]) {
            return binarySearch(nums, target, index, length - 1);
        }
        return binarySearch(nums, target, 0, index);
    }

    private int findRotateIndex(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = (end - start) / 2 + start;
        if (nums[mid] > nums[mid + 1]) {
            return mid + 1;
        } else {
            if (nums[mid] < nums[start]) {
                return findRotateIndex(nums, start, mid - 1);
            } else {
                return findRotateIndex(nums, mid + 1, end);
            }
        }
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
        int[] nums = {8,9,2,3,4};
        Practice33 practice = new Practice33();
        System.out.println(practice.search(nums, 9));
    }
}
