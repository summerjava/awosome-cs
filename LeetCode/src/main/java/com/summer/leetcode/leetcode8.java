package com.summer.leetcode;

/**
 * https://leetcode.cn/problems/string-to-integer-atoi/
 */
public class leetcode8 {
    /**
     * 字符串转换为整数
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        //边界情况处理
        if (s == null || s.length() < 1) {
            return 0;
        }

        int lowValue = Integer.MIN_VALUE;
        int highValue = Integer.MAX_VALUE;

        //丢弃空格
        s = s.trim();

        //是否是负数
        boolean isNegative = s.startsWith("-");
        if (isNegative) {
            //边界情况处理
            if (s.length() == 1) {
                return 0;
            }

            s = s.substring(1);

            //如果负号后面还跟了正号
            if (s.startsWith("+")) {
                return 0;
            }
        }

        //正号
        if (s.startsWith("+")) {
            s = s.substring(1);
        }

        //边界情况处理
        if (s.length() < 1) {
            return 0;
        }

        char[] charArr = s.toCharArray();
        //判断下一个字符是不是0-9之间的整数
        if (charArr[0] < '0' || charArr[0] > '9') {
            return 0;
        }

        int result = 0;
        for (int index = 0;index < s.length();++index) {
            char c = charArr[index];
            if (c >= '0' && c <= '9') {
                long tmpRes = Math.abs(Long.valueOf(result)) * 10 + Integer.valueOf(String.valueOf(c));
                if (isNegative) {
                    tmpRes = -1 * tmpRes;
                }

                if (tmpRes >= lowValue && tmpRes <= highValue) {
                    result = (int)tmpRes;
                } else if (tmpRes < lowValue) {
                    return lowValue;
                } else {
                    return highValue;
                }
            } else {
                //遇到其他字符，直接结束
                return result;
            }
        }

        return result;
    }

    public final static void main(String[] args) {
        //System.out.println(myAtoi("42"));
        //System.out.println(myAtoi("   -42"));
        //System.out.println(myAtoi("4193 with words"));
        //System.out.println(myAtoi("words and 987"));
        //System.out.println(myAtoi("-91283472332"));
        //System.out.println(myAtoi("3.14159"));
        //System.out.println(myAtoi("-"));
        //System.out.println(myAtoi("+1"));
        //System.out.println(myAtoi("-+12"));
        //System.out.println(myAtoi("+"));
        System.out.println(myAtoi("00000-42a1234"));
    }
}
