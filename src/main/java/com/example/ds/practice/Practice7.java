package com.example.ds.practice;

/**
 7. 整数反转
 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
  示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Practice7 {

    public int reverse(int x) {
        String str = String.valueOf(x);
        char[] charArray = str.toCharArray();
        int p = 0;
        int q = charArray.length - 1;
        while (q > p) {
            if (p == 0 && charArray[p] == '-') {
                p++;
                continue;
            }
            char temp = charArray[p];
            charArray[p] = charArray[q];
            charArray[q] = temp;
            p++;
            q--;
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        String maxStr = String.valueOf(max);
        String minStr = String.valueOf(min);
        String reverseStr = String.valueOf(charArray);
        if (reverseStr.startsWith("-")) {
            return calculate(minStr, reverseStr);
        } else {
            return calculate(maxStr, reverseStr);
        }
    }

    private int calculate(String compareStr, String reverseStr) {
        int result;
        if (reverseStr.length() < compareStr.length()) {
            result = Integer.parseInt(reverseStr);
        } else if (reverseStr.length() > compareStr.length()) {
            result = 0;
        } else {
            if (reverseStr.compareTo(compareStr) <= 0) {
                result = Integer.parseInt(reverseStr);
            } else {
                result = 0;
            }
        }
        return result;
    }

    public int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        Practice7 practice = new Practice7();
        int reverse = practice.reverse2(1147483641);
        System.out.println(reverse);
        System.out.println(-108 % 10);
    }
}
