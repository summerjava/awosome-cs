package com.summer.leetcode;

/**
 * https://leetcode.cn/problems/container-with-most-water/solution/
 */
public class leetcode11 {

    /**
     * 解法：双指针。
     * 两个指针i,j分别指向下标为i,j的槽板，高度用h[i]和h[j]表示。
     * 那么面积S(i,j)=min(h[i],h[j])*(j-i)
     *
     * 若向内移动长的这个槽板，面积一定变小。
     * 若向内移动短的这个槽板，面积可能变大。
     *
     * 初始化：分别指向最左短和最右端的槽板。
     * 每次移动短板，一直到二者重合。过程中最大的面积即为所求的最大值。
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0,right = len - 1;
        int maxArea = Math.min(height[left], height[right]) * (right - left);

        while (right > left) {
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }

            int tempArea = Math.min(height[left], height[right]) * (right - left);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }
        }

        return maxArea;
    }

    public final static void main(String[] args) {
        //int height[] = new int[]{1,8,6,2,5,4,8,3,7};
        int height[] = new int[]{1,1};
        System.out.println(maxArea(height));

    }
}
