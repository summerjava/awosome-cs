package com.summer.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class leetcode17 {

    /**
     * 数字按键到字符的映射关系
     */
    static String[] map = { " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    //存放结果
    static List<String> res = new ArrayList<>();

    /**
     * 解题思路：
     * DFS+回溯
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        //边界情况处理
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }

        dfs(digits, 0, new StringBuilder());

        return res;
    }

    /**
     * 深度遍历
     * @param digits 输入的数字字符串
     * @param index 当前执行到了哪一层
     * @param stringBuilder 结果
     */
    private static void dfs(String digits, int index, StringBuilder stringBuilder) {
        //已遍历完
        if (index == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }

        char c = digits.charAt(index);
        String string = map[c - '0'];
        for (int tmp = 0;tmp < string.length();++tmp) {
            //把每个可能得字符循环遍历放入结果字符串
            stringBuilder.append(string.charAt(tmp));
            //递归深度遍历
            dfs(digits, index + 1, stringBuilder);
            //再把当前这层的结果删除，进行回溯
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public final static void main(String[] args) {
        //System.out.println(letterCombinations("23"));
        //System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }
}
