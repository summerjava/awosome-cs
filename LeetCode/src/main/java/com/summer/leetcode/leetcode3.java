package com.summer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目链接：
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class leetcode3 {
    /**
     * 求无重复字符的最长子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //存放遍历的时候子串中每个字符出现的次数
        Map<String, Integer> charCount = new HashMap<>();
        Integer left = 0;//左指针
        Integer right = 0;//右指针
        Integer result = 0;//最终的结果

        //右指针不断向右
        while (right < s.length()) {
            String c = s.substring(right, right + 1);

            right++;

            //子串中字符出现次数更新
            Integer charResult = 0;
            if (charCount.containsKey(c)) {
                charResult = charCount.get(c);
            }

            charCount.put(c, ++charResult);

            //如果右指针指向的字符出现次数大于1，则将左指针不断右移
            while (charCount.get(c) > 1) {
                String leftChar = s.substring(left, left + 1);
                left++;

                //统计出现次数更新
                charCount.put(leftChar, charCount.get(leftChar) - 1);
            }

            result = Math.max(result, right - left);
        }

        return result;
    }

    /**
     * 测试用例
     *
     * @param args
     */
    public final static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
