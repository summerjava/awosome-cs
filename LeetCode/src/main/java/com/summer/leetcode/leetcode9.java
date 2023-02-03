package com.summer.leetcode;

/**
 * https://leetcode.cn/problems/palindrome-number/
 */
public class leetcode9 {
    /**
     * 判断是否是回文
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        //负数一定不是
        if (x < 0) {
            return false;
        }

        //将整数翻转，如果得到的结果整数一样，则是回文
        int revertValue = 0;
        int tmpValue = x;
        while (tmpValue > 0) {
            int modValue = tmpValue % 10;
            tmpValue = tmpValue / 10;
            revertValue = revertValue * 10 + modValue;
        }

        return revertValue == x;
    }

    public final static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
