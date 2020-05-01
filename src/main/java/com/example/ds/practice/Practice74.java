package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2020-04-25 11:12
 * @Description: 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class Practice74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        return binarySearch2(matrix, n, 0, m * n - 1, target);
//        return binarySearch(matrix, 0, m - 1, 0, n - 1, target);
    }

    private boolean binarySearch(int[][] matrix, int startM, int endM, int startN, int endN, int target) {
        if (startM == endM) {
            if (startN > endN) {
                return false;
            }
            int midN = (startN + endN) / 2;
            int cur = matrix[startM][midN];
            if (cur > target) {
                return binarySearch(matrix, startM, endM, startN, midN - 1, target);
            } else if (cur < target) {
                return binarySearch(matrix, startM, endM, midN + 1, endN, target);
            } else {
                return true;
            }
        } else {
            int midM = (startM + endM) / 2;
            int cur = matrix[midM][endN];
            if (cur > target) {
                return binarySearch(matrix, startM, midM, startN, endN, target);
            } else if (cur < target) {
                return binarySearch(matrix, midM + 1, endM, startN, endN, target);
            } else {
                return true;
            }
        }
    }

    private boolean binarySearch2(int[][] matrix, int n, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        int cur = matrix[mid / n][mid % n];
        if (cur > target) {
            return binarySearch2(matrix, n, start, mid - 1, target);
        } else if (cur < target) {
            return binarySearch2(matrix, n, mid + 1, end, target);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Practice74 practice = new Practice74();
//        int[][] matrix = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
//        int[][] matrix = {{1}};
        System.out.println(practice.searchMatrix(matrix, 13));
    }
}
