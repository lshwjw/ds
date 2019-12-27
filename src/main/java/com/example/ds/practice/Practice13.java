package com.example.ds.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weijianwei
 * @Date: 2019-12-09 20:50
 * @Description: 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Practice13 {

    public int romanToInt(String s) {
        int result = 0;
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        int index = 0;
        String tmp = "";
        while (i < s.length() && index < roman.length) {
            String str = s.charAt(i) + "";
            tmp = tmp + str;
            if (tmp.equals(roman[index])) {
                result += arab[index];
                s = s.substring(i + 1);
                tmp = "";
                i = 0;
            } else if (tmp.length() >= roman[index].length() || i == (s.length() - 1)) {
                tmp = "";
                i = 0;
                index++;
            } else {
                i++;
            }
        }
        return result;
    }

    public int romanToInt2(String s) {
        int result = 0;
        Map<String, Integer> tmpMap = new HashMap<>();
        tmpMap.put("M", 1000);
        tmpMap.put("CM", 900);
        tmpMap.put("D", 500);
        tmpMap.put("CD", 400);
        tmpMap.put("C", 100);
        tmpMap.put("XC", 90);
        tmpMap.put("L", 50);
        tmpMap.put("XL", 40);
        tmpMap.put("X", 10);
        tmpMap.put("IX", 9);
        tmpMap.put("V", 5);
        tmpMap.put("IV", 4);
        tmpMap.put("I", 1);
        int index = 0;
        while (index < s.length()) {
            if (index < s.length() - 1 && tmpMap.containsKey(s.substring(index, index + 2))) {
                result += tmpMap.get(s.substring(index, index + 2));
                index += 2;
            } else {
                result += tmpMap.get(s.substring(index, index + 1));
                index += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Practice13 practice = new Practice13();
        System.out.println(practice.romanToInt2("III"));
        System.out.println(practice.romanToInt2("IV"));
        System.out.println(practice.romanToInt2("IX"));
        System.out.println(practice.romanToInt2("LVIII"));
        System.out.println(practice.romanToInt2("MCMXCIV"));
        System.out.println(practice.romanToInt2("DCXXI"));
    }
}
