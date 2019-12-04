package com.example.ds.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weijianwei
 * @Date: 2019-12-03 20:28
 * @Description: 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Practice6 {

    public String convert(String s, int numRows) {
        if (s == null) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int currentRow = 0;
        boolean flag = false;
        for(int i = 0; i < s.length(); i++) {
            rows.get(currentRow).append(s.charAt(i));
            if (currentRow == 0 || currentRow == numRows - 1) {
                flag = !flag;
            }
            currentRow += flag ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Practice6 practice = new Practice6();
        System.out.println(practice.convert("AB", 1));
        System.out.println(practice.convert("ABCDEFGH", 3));
        System.out.println(practice.convert("LEETCODEISHIRING", 3));
        System.out.println(practice.convert("PAYPALISHIRING", 4));
    }
}
