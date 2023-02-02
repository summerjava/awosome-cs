package com.summer.leetcode;

/**
 * https://leetcode.cn/problems/reverse-integer/
 */
public class leetcode7 {
    /**
     * 整数翻转，先转成string，然后反转。
     * @param x
     * @return
     */
    public static int reverse(int x) {
        String string1 = Integer.valueOf(x).toString();
        boolean isNegative = false;
        if (string1.startsWith("-")) {
            string1 = string1.substring(1);
            isNegative = true;
        }


        long result = 0;
        for (int index = 0;index < string1.length();++index) {
            result += Integer.valueOf(string1.substring(index, index + 1)) * Math.pow(10, index);
        }

        if (isNegative) {
            result = result * -1;
        }

        if (result < -1 * Math.pow(2, 31) || result > Math.pow(2, 31) - 1) {
            result = 0;
        }

        return (int)result;
    }


    public final static void main(String[] args) {
        int result = reverse(123);
        System.out.println(result);

        result = reverse(-123);
        System.out.println(result);

        result = reverse(0);
        System.out.println(result);
    }
}
