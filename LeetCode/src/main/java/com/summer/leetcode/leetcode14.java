package com.summer.leetcode;

/**
 * https://leetcode.cn/problems/longest-common-prefix/
 */
public class leetcode14 {

    /**
     * 最长公共前缀查找
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        //边界情况处理
        if (strs.length == 1) {
            return strs[0];
        }

        String result = "";
        for (int loop = 1;loop <= strs[0].length();++loop) {
            String prefix = strs[0].substring(0, loop);
            for (int index = 1; index < strs.length; ++index) {
                if (strs[index].length() < loop || !strs[index].startsWith(prefix)) {
                    return result;
                }
            }

            result = prefix;
        }

        return result;
    }

    public final static void main(String[] args) {
        //String[] strs = new String[]{"flower","flow","flight"};
        //String[] strs = new String[]{"dog","racecar","car"};
        //String[] strs = new String[]{"a"};
        String[] strs = new String[]{"flower","flower","flower","flower"};
        System.out.println(longestCommonPrefix(strs));
    }

}
