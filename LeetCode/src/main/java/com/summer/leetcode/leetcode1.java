package com.summer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目链接：
 * https://leetcode.cn/problems/two-sum/submissions/
 */
public class leetcode1 {
    public static int[] twoSum(int[] nums, int target) {

        //利用hash表，降低时间复杂度
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int index = 0;index < nums.length;++index) {
            if (hashMap.containsKey(target - nums[index])) {
                return new int[]{hashMap.get(target - nums[index]), index};
            }
            hashMap.put(nums[index], index);
        }

        return new int[0];
    }

    public final static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] result = twoSum(nums, 6);
        System.out.println(result);
    }
}
