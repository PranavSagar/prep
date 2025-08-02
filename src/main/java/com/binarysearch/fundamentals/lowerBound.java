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
        int[][] testArrays = {
            {}, // empty array
            {5}, // single element
            {5},
            {1, 2, 2, 2, 3, 4, 5}, // duplicates
            {1, 3, 5, 7, 9}, // strictly increasing
            {10, 20, 30, 40}, // all greater than target
            {-10, -5, 0, 5}, // negative and positive
            {2, 2, 2, 2}, // all same
        };
        int[] targets = {
            1, // for empty array
            4, // less than single element
            5, // equal to single element
            2, // present in duplicates
            6, // not present, between elements
            5, // less than all
            -20, // less than all
            2 // equal to all
        };
        for (int i = 0; i < testArrays.length; i++) {
            int result = search(testArrays[i], targets[i]);
            System.out.println("Array: " + java.util.Arrays.toString(testArrays[i]) + ", Target: " + targets[i] + ", Lower Bound Index: " + result);
        }
    }

// Expected output:
//    Array: [], Target: 1, Lower Bound Index: 0
//    Array: [5], Target: 4, Lower Bound Index: 0
//    Array: [5], Target: 5, Lower Bound Index: 0
//    Array: [1, 2, 2, 2, 3, 4, 5], Target: 2, Lower Bound Index: 1
//    Array: [1, 3, 5, 7, 9], Target: 6, Lower Bound Index: 3
//    Array: [10, 20, 30, 40], Target: 5, Lower Bound Index: 0
//    Array: [-10, -5, 0, 5], Target: -20, Lower Bound Index: 0
//    Array: [2, 2, 2, 2], Target: 2, Lower Bound Index: 0
}