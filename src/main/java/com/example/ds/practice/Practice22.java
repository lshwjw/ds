package com.example.ds.practice;

import java.util.*;

/**
 22. 括号生成
 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class Practice22 {

    /**
     * 回溯
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        generateBack(result, "", n, n);
        return result;
    }

    /**
     * 回溯法
     * @param result
     * @param tmp
     * @param left 剩余左括号数
     * @param right 剩余右括号数
     */
    private void generateBack(List<String> result, String tmp, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(tmp);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            generateBack(result, tmp + "(", left - 1, right);
        }
        if (right > 0) {
            generateBack(result, tmp + ")", left, right - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        return generate(result, "(", 2 * n);
    }

    private List<String> generate(List<String> result, String tmp, int maxLength) {
        if (tmp.length() == maxLength) {
            boolean valid = isValid(tmp);
            if (valid) {
                result.add(tmp);
            }
        } else {
            generate(result, tmp + "(", maxLength);
            generate(result, tmp + ")", maxLength);
        }
        return result;
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

    private boolean isValid3(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || stack.isEmpty()) {
                stack.push(c);
            } else {
                Character top = stack.peek();
                if (top == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isValid2(String s) {
        int length = s.length();
        Map<Character, Character> tmpMap = new HashMap<>();
        tmpMap.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!stack.empty() && tmpMap.containsKey(c)) {
                if (stack.pop() != tmpMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Practice22 practice = new Practice22();
        System.out.println(practice.generateParenthesis2(3));
    }
}
