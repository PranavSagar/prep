package com.binarysearch.fundamentals;

public class lowerBound {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int lowerBound = n; // To store the lower bound index
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                lowerBound = mid; // Update lower bound
                end = mid - 1;    // Continue searching in the left half
            } else {
                start = mid + 1;
            }
        }
        return lowerBound;
    }

    public static void main(String[] args) {
        int[] nums = {-58210,52968,57654,84387};
        int target = 9;
        int result = search(nums, target);
        System.out.println("Index of lower bound for target " + target + ": " + result);
    }
}