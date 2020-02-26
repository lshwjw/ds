package com.example.ds.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 30. 串联所有单词的子串
 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

  

 示例 1：

 输入：
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 输出：[0,9]
 解释：
 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 输出的顺序不重要, [9,0] 也是有效答案。
 示例 2：

 输入：
 s = "wordgoodgoodgoodbestword",
 words = ["word","good","best","word"]
 输出：[]
 */
public class Practice30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result  = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return result;
        }
        int wordLen = words[0].length();
        Map<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            Integer count = allWords.getOrDefault(word, 0);
            allWords.put(word, count + 1);
        }
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            Map<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWords.containsKey(word)) {
                    Integer count = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, count + 1);
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == wordNum) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s  = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        Practice30 practice = new Practice30();
        System.out.println(practice.findSubstring(s, words));
    }
}
