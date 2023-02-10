package com.summer.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/3sum-closest/
 */
public class leetcode16 {
    /**
     * 思路：双指针。
     *
     * 先将数组排序，然后遍历数组，内部使用双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        //边界情况处理
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int index = 0;index < nums.length - 2;++index) {
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmpResult = nums[index] + nums[left] + nums[right];
                if (Math.abs(target - tmpResult) < Math.abs(target - result)) {
                    result = tmpResult;
                }

                //逐步向target靠拢
                if (tmpResult < target) {
                    ++left;
                } else if (tmpResult > target) {
                    --right;
                } else {
                    //相等的时候一定是最小值
                    return result;
                }
            }
        }

        return result;
    }

    public final static void main(String[] args) {
        int nums[] = new int[]{-1,2,1,-4};
        int target = 1;

//        int nums[] = new int[]{0,1,2};
//        int target = 3;

//        int nums[] = new int[]{4,0,5,-5,3,3,0,-4,-5};
//        int target = -2;
        System.out.println(threeSumClosest(nums, target));
    }
}
