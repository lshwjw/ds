package com.example.ds.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weijianwei
 * @Date: 2019-12-05 20:30
 * @Description: 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Practice9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        int i = 0;
        int j = list.size() - 1;
        while (j > i) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        String str = x + "";
        int i = 0;
        int j = str.length() - 1;
        while (j > i) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int reverse = 0;
        int tmp = x;
        while (tmp > 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }
        return reverse == x;
    }

    public static void main(String[] args) {
        Practice9 practice = new Practice9();
        System.out.println(practice.isPalindrome3(121));
        System.out.println(practice.isPalindrome3(-121));
        System.out.println(practice.isPalindrome3(10));
    }
}
