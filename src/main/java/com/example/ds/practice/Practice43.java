package com.example.ds.practice;

/**
 * @Author: weijianwei
 * @Date: 2020-02-27 22:18
 * @Description: 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Practice43 {

    /**
     * TODO 未完成！
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int initRate = 1;
        int sum = 0;
        for (int i = chars1.length - 1; i >= 0; i--) {
            int rate = initRate;
            for (int j = chars2.length - 1; j >= 0; j--) {
                int tmp = Integer.parseInt(chars1[i] + "") * Integer.parseInt(chars2[j] + "") * rate;
                sum += tmp;
                rate *= 10;
            }
            initRate *= 10;
        }
        return sum + "";
    }

    public static void main(String[] args) {
        Practice43 practice = new Practice43();
        System.out.println(practice.multiply("123", "456"));
        System.out.println(Integer.MAX_VALUE);
    }
}
