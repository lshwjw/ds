package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2019-12-05 11:33
 * @Description: 8. 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−2^31) 。
 */
public class Practice8 {

    public int myAtoi(String str) {
        int result = 0;
        boolean negativeFlag = false;
        boolean firstCharFlag = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (firstCharFlag) {
                if (c != ' ') {
                    if (c == '-') {
                        negativeFlag = true;
                        firstCharFlag = false;
                    } else if (c == '+') {
                        firstCharFlag = false;
                    } else if (isDigit(c)) {
                        result  = c - '0';
                        firstCharFlag = false;
                    } else {
                        break;
                    }
                }
            } else {
                if (isDigit(c)) {
                    int pop = c - '0';
                    if (negativeFlag) {
                        if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop > (Integer.MIN_VALUE % 10) * -1)) {
                            result = Integer.MIN_VALUE;
                            break;
                        }
                        result  = result * 10 - pop;
                    } else {
                        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                            result = Integer.MAX_VALUE;
                            break;
                        }
                        result  = result * 10 + pop;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Practice8 practice = new Practice8();
        System.out.println(practice.myAtoi("42"));
        System.out.println(practice.myAtoi("-42"));
        System.out.println(practice.myAtoi("4193 with words"));
        System.out.println(practice.myAtoi("words and 987"));
        System.out.println(practice.myAtoi("-91283472332"));
        System.out.println(practice.myAtoi("+1"));
        System.out.println(practice.myAtoi("-2147483649"));
        System.out.println(practice.myAtoi("-2147483647"));
    }
}
