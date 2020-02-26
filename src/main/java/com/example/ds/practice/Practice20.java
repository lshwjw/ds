package com.example.ds.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 20. 有效的括号
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true
 */
public class Practice20 {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        if (length == 0) {
            return true;
        }
        if (length % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[' || stack.isEmpty()) {
                stack.push(c);
            } else {
                Character top = stack.peek();
                if (top == '(' && c == ')') {
                    stack.pop();
                } else if (top == '{' && c == '}') {
                    stack.pop();
                } else if (top == '[' && c == ']') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        if (length == 0) {
            return true;
        }
        if (length % 2 == 1) {
            return false;
        }
        Map<Character, Character> tmpMap = new HashMap<>();
        tmpMap.put(')', '(');
        tmpMap.put('}', '{');
        tmpMap.put(']', '[');
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
        Practice20 practice = new Practice20();
        System.out.println(practice.isValid("()"));
        System.out.println(practice.isValid("()[]{}"));
        System.out.println(practice.isValid("(]"));
        System.out.println(practice.isValid("([)]"));
        System.out.println(practice.isValid("{[]}"));
    }
}
