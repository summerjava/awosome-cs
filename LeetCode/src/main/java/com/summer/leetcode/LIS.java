package com.summer.leetcode;

public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for (int i = 0;i < nums.length;++i) {
            int poker = nums[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if(top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == piles) {
                piles++;
            }

            top[left] = poker;
        }
        return piles;
    }

    public final static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5};
        System.out.println(lengthOfLIS(nums));
    }
}
