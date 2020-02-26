package com.example.ds.practice;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。
 */
public class Practice14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int index  = 0;
        String first = strs[0];
        while (index < first.length()) {
            char tmp = first.charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != tmp) {
                    return first.substring(0, index);
                }
            }
            index++;
        }
        return first;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String leftStr = longestCommonPrefix(strs, left, mid);
            String rightStr = longestCommonPrefix(strs, mid + 1, right);
            int min = Math.min(leftStr.length(), rightStr.length());
            for (int i = 0; i < min; i++) {
                if (leftStr.charAt(i) != rightStr.charAt(i)) {
                    return leftStr.substring(0, i);
                }
            }
            return leftStr.substring(0, min);
        }
    }

    public static void main(String[] args) {
         String[] strs = {"flower", "flo"};
//        String[] strs = {"dog", "racecar", "car"};
        Practice14 practice = new Practice14();
        System.out.println(practice.longestCommonPrefix(strs));
    }
}
