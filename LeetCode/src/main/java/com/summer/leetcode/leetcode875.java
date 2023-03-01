package com.summer.leetcode;

public class leetcode875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        while( left <= right){
            int mid = left+(right-left)/2;
            if (f(piles,mid) > h){
                left = mid + 1;
            } else if(f(piles,mid) <= h){
                right = mid - 1;
            }
        }
        return left;
    }
    // 计算时间
    private  static long f(int [] piles, int k){
        long hours = 0;
        for(int i = 0; i < piles.length; i++){
            hours = hours + piles[i]/k;
            if (piles[i]%k>0){
                hours ++;
            }
        }
        return hours;
    }

    public final static void main(String[] args) {
        int[] piles = new int[]{805306368,805306368,805306368};
        System.out.println(minEatingSpeed(piles, 1000000000));
    }

}
