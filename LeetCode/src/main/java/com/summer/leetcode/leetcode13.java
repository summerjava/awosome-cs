package com.summer.leetcode;

/**
 * https://leetcode.cn/problems/roman-to-integer/
 */
public class leetcode13 {
    /**
     * 罗马数字转整数
     *
     * 思路：从左到右遍历字符串，每次把能匹配到的最大的值取出来，累加在一起。
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int result = 0;
        while (s.length() > 0) {
            for (int index = 0; index < symbols.length; ++index) {
                String symbol = symbols[index];
                if (s.startsWith(symbol)) {
                    result += values[index];
                    s = s.substring(symbol.length());
                    break;
                }
            }
        }

        return result;
    }

    public final static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
