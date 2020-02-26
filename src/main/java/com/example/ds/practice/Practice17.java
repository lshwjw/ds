package com.example.ds.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 17. 电话号码的字母组合
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 说明:
 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Practice17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> tmpMap = new HashMap<>();
        tmpMap.put('2', "abc");
        tmpMap.put('3', "def");
        tmpMap.put('4', "ghi");
        tmpMap.put('5', "jkl");
        tmpMap.put('6', "mno");
        tmpMap.put('7', "pqrs");
        tmpMap.put('8', "tuv");
        tmpMap.put('9', "wxyz");
        return concat(digits, 0, result, tmpMap, "");
    }

    private List<String> concat(String digits, int index, List<String> result, Map<Character, String> tmpMap, String start) {
        String str = tmpMap.get(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            String end = start + str.charAt(i);
            if (index == digits.length() - 1) {
                result.add(end);
            } else {
                concat(digits, index + 1, result, tmpMap, end);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String digits = "234";
        Practice17 practice = new Practice17();
        System.out.println(practice.letterCombinations(digits));
    }
}
