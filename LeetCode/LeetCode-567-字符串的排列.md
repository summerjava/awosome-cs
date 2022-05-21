# 题目

[力扣]([力扣](https://leetcode.cn/problems/permutation-in-string/))

题目介绍：

给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。

 

示例 1：

输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").
示例 2：

输入：s1= "ab" s2 = "eidboaoo"
输出：false
 

提示：

1 <= s1.length, s2.length <= 104
s1 和 s2 仅包含小写字母

# 解题代码

java代码：

```java

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author summer
 * @version : checkInclusion567.java, v 0.1 2022年05月21日 3:54 PM summer Exp $
 */
public class checkInclusion567 {

    /**
     * 判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     *
     * 利用滑动窗口的思路
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        //子串中各字符出现次数统计
        Map<String, Integer> subStringCount = new HashMap<>();
        //滑动窗口中各字符出现次数统计
        Map<String, Integer> windowStringCount = new HashMap<>();
        Integer hasSameCountCharNum = 0;//窗口中和子串中出现次数相等的字符数量
        //双指针
        Integer left = 0;
        Integer right = 0;

        //子串相关数据初始化
        for (int index = 0; index < s1.length();++index) {
            String c = s1.substring(index, index + 1);
            incrCount(subStringCount, c);
        }

        //双指针遍历
        while (right < s2.length()) {
            //右指针指向的字符的值
            String rightPointChar = s2.substring(right, right + 1);
            //右指针继续滑动
            ++right;

            //滑动窗口统计值更新
            if (subStringCount.containsKey(rightPointChar)) {
                incrCount(windowStringCount, rightPointChar);
            }

            //出现次数相等的字符数量更新
            if (windowStringCount.containsKey(rightPointChar) && windowStringCount.get(rightPointChar).equals(subStringCount.get(rightPointChar))) {
                ++hasSameCountCharNum;
            }

            //左指针需要移动
            while (right - left > s1.length()) {
                //左指针
                String leftPointChar = s2.substring(left, left + 1);
                //左指针继续右移
                ++left;



                //数据更新
                if (windowStringCount.containsKey(leftPointChar) && windowStringCount.get(leftPointChar).equals(subStringCount.get(leftPointChar))) {
                    --hasSameCountCharNum;
                }

                descCount(windowStringCount, leftPointChar);

                //判断是否找到结果
                //注意不能包含除了子串之外的字符串
                if (windowStringCount.size() == s1.length() && hasSameCountCharNum.equals(s1.length())) {
                    return true;
                }
            }

            //判断是否找到结果
            //注意不能包含除了子串之外的字符串
            if (windowStringCount.size() == subStringCount.size() && hasSameCountCharNum.equals(subStringCount.size())) {
                return true;
            }
        }

        return false;
    }

    /**
     * 统计值加1
     *
     * @param countMap 字符统计值
     * @param c 字符
     */
    private static void incrCount(Map<String, Integer> countMap, String c) {
        if (!countMap.containsKey(c)) {
            countMap.put(c, 1);
        } else {
            countMap.put(c, countMap.get(c) + 1);
        }
    }

    /**
     * 统计值减1
     *
     * @param countMap 字符统计值
     * @param c 字符
     */
    private static void descCount(Map<String, Integer> countMap, String c) {
        if (countMap.containsKey(c)) {
            Integer count = countMap.get(c) - 1;
            if (count.equals(0)) {
                countMap.remove(c);
            } else {
                countMap.put(c, countMap.get(c) - 1);
            }
        }
    }

    /**
     * 测试用例
     *
     * @param args
     */
    public final static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        boolean result = checkInclusion(s1, s2);
        System.out.println(result);

        s1 = "ab";
        s2 = "eidboaoo";
        result = checkInclusion(s1, s2);
        System.out.println(result);
    }
}
```
