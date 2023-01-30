package com.summer.leetcode;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class leetcode5 {
    /**
     * 求最长回文子串
     *
     * 思路：动态规划
     *
     * 状态转移方程
     * P(i,j)=P(i+1,j-1) & S(i)==S(j)
     *
     * P(i,j)表示第i到j之间的字符串组成的串是否是回文串
     * 注意边界条件：
     * P(i,i)=true【单个字符组成的串是回文串】
     * P(i,i+1)=(S(i)==S(j))【长度为2的字符串，如果2个字符相等，则是回文串】
     *
     * 在状态转移方程中，我们是从较短的字符串向较长的字符串进行转移。需要注意动态规划的转移顺序。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        Integer len = s.length();

        //边界条件
        if (len == 1) {
            return s;
        }

        //状态转移方程
        boolean[][] dp = new boolean[len][len];

        //初始化（这里可以做优化）
        for (int index = 0;index < len;++index) {
            dp[index][index] = true;
        }

        char[] charArray = s.toCharArray();

        for (int index = 0;index < len - 1;++index) {
            if (charArray[index] == charArray[index + 1]) {
                dp[index][index + 1] = true;
            }
        }

        for (int index = 0;index < len - 2;++index) {
            if (charArray[index] == charArray[index + 2]) {
                dp[index][index + 2] = true;
            }
        }

        //子串长度逐步扩大
        for (int loopLength = 3;loopLength < len;++loopLength) {
            for (int index = 0; index < len - loopLength;++index) {
                dp[index][index + loopLength] = dp[index + 1][index + loopLength - 1]
                        && charArray[index] == charArray[index + loopLength];
            }
        }

        //捞取最长的返回
        int maxLen = -1;
        int begin = -1;
        for (int i = 0;i < len;++i) {
            for (int j = 0;j < len;++j) {
                if (dp[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public final static void main(String[] args) {
        String s = "aaaa";
        String result = longestPalindrome(s);
        System.out.println(result);
    }
}
