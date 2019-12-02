package com.example.ds.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: weijianwei
 * @Date: 2019-11-30 11:38
 * @Description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Practice3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] charArray = s.toCharArray();
        int maxLength = 1;
        for (int i = 0; i < charArray.length; i++) {
            if (maxLength > charArray.length - i) {
                return maxLength;
            }
            String tmp = charArray[i] + "";
            for (int j = i + 1; j < charArray.length; j++) {
                if (tmp.indexOf(charArray[j]) != -1) {
                    maxLength = tmp.length() > maxLength ? tmp.length() : maxLength;
                    break;
                }
                tmp = tmp + charArray[j];
            }
            maxLength = tmp.length() > maxLength ? tmp.length() : maxLength;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] charArray = s.toCharArray();
        int maxLength = 1;
        for (int i = 0; i < charArray.length; i++) {
            if (maxLength > charArray.length - i) {
                return maxLength;
            }
            Set<Character> tmp = new HashSet<>();
            tmp.add(charArray[i]);
            for (int j = i + 1; j < charArray.length; j++) {
                if (tmp.contains(charArray[j])) {
                    maxLength = tmp.size() > maxLength ? tmp.size() : maxLength;
                    break;
                }
                tmp.add(charArray[j]);
            }
            maxLength = tmp.size() > maxLength ? tmp.size() : maxLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Practice3 practice = new Practice3();
        System.out.println(practice.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(practice.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(practice.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(practice.lengthOfLongestSubstring2("au"));
    }
}
