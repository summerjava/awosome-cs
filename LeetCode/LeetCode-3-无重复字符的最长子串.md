# 题目

[力扣](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)



题目介绍：

给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
  请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。 

提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成



# 解题代码

java代码：

```java

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author summer
 * @version : LongestSubString.java, v 0.1 2022年05月15日 2:48 PM summer Exp $
 */
public class LongestSubString {
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
```




