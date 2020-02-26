package com.example.ds.practice;

import java.util.Stack;

/**
 32. 最长有效括号
 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

 示例 1:

 输入: "(()"
 输出: 2
 解释: 最长有效括号子串为 "()"
 示例 2:

 输入: ")()())"
 输出: 4
 解释: 最长有效括号子串为 "()()"
 */
public class Practice32 {

    public int longestValidParentheses2(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return getMax(s, length - 1);
        } else {
            return getMax(s, length);
        }
    }

    private int getMax(String s, int max) {
        if (max <= 0) {
            return 0;
        }
        int tmpMax = s.length() - max + 1;
        int index = 0;
        while (index < tmpMax) {
            if (isValid(s.substring(index, index + max))) {
                return max;
            }
            index++;
        }
        return getMax(s, max - 2);
    }

    private boolean isValid(String tmp) {
        int balance = 0;
        for (char c: tmp.toCharArray()) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    public static void main(String[] args) {
        Practice32 practice = new Practice32();
        System.out.println(practice.longestValidParentheses2("(()"));
    }
}
