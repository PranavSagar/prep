package com.binarysearch.fundamentals;

public class upperBound {
    public static int findUpperBound(int[] nums, int x) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int upperBound = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > x) {
                upperBound = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return upperBound;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3};
        int x1 = 2;
        System.out.println("Upper bound index: " + findUpperBound(nums1, x1)); // Output: 3

        int[] nums2 = {3, 5, 8, 15, 19};
        int x2 = 9;
        System.out.println("Upper bound index: " + findUpperBound(nums2, x2)); // Output: 3
    }
}