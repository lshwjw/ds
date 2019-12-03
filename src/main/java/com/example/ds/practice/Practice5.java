package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2019-12-02 11:35
 * @Description: 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Practice5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        String longestText = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                boolean flag = judge(s, i, j);
                if (flag && (j - i + 1 > longestText.length())) {
                    longestText = s.substring(i, j + 1);
                }
            }
        }
        return longestText;
    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int start, int end) {
        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    private boolean judge(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (start == end) {
            return true;
        }
        if (s.charAt(start) == s.charAt(end)) {
            if ((end - start == 1)) {
                return true;
            }
            return judge(s, start + 1, end - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        Practice5 practice = new Practice5();
        System.out.println(practice.longestPalindrome2(s));
    }
}
