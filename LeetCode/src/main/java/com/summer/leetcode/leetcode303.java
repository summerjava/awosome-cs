package com.summer.leetcode;

/**
 * https://leetcode.cn/problems/range-sum-query-immutable/
 */
public class leetcode303 {
    int[] preResults;

    public leetcode303(int[] nums) {
        preResults = new int[nums.length + 1];
        for (int index = 0;index < nums.length;++index) {
            preResults[index + 1] = preResults[index] + nums[index];
        }
    }

    public int sumRange(int left, int right) {
        return preResults[right + 1] - preResults[left];
    }

    public final static void main(String[] args) {
        leetcode303 obj = new leetcode303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
    }
}
