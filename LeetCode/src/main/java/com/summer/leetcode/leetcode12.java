package com.summer.leetcode;

/**
 * https://leetcode.cn/problems/integer-to-roman/
 */
public class leetcode12 {
    /**
     * 整数转罗马数字
     *
     * 思路：每次找出不大于num的最大的值的符号，然后将num减去该符号，重新执行该操作。
     *
     * @param num 注：1 <= num <= 3999
     * @return
     */
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();

        while (num > 0) {
            int maxValue = -1,maxIndex = -1;
            for (int index = 0;index < values.length;++index) {
                if (values[index] > maxValue && values[index] <= num) {
                    maxValue = values[index];
                    maxIndex = index;
                }
            }

            num -= maxValue;
            stringBuilder.append(symbols[maxIndex]);
        }

        return stringBuilder.toString();
    }

    public final static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
