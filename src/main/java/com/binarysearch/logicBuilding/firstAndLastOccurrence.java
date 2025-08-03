package com.binarysearch.logicBuilding;

public class firstAndLastOccurrence {

    // Helper method to find first or last occurrence
    private int findOccurrence(int[] nums, int target, boolean findFirst) {
        int start = 0, end = nums.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (findFirst) {
                    end = mid - 1; // Continue searching in left half for first occurrence
                } else {
                    start = mid + 1; // Continue searching in right half for last occurrence
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = findOccurrence(nums, target, true);

        // Early termination: if first occurrence not found, last won't exist either
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findOccurrence(nums, target, false);

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        firstAndLastOccurrence solver = new firstAndLastOccurrence();

        // Test cases with different scenarios
        int[][] testArrays = {
            {}, // empty array
            {5}, // single element - target present
            {5}, // single element - target not present
            {1, 1, 1, 1}, // all same elements
            {5, 7, 7, 8, 8, 10}, // original test case
            {1, 2, 3, 4, 5}, // target not present
            {1, 2, 2, 2, 3}, // multiple occurrences in middle
            {2, 2, 2, 3, 4}, // multiple occurrences at start
            {1, 2, 3, 3, 3}, // multiple occurrences at end
            {1, 3, 5, 7, 9}, // target less than all
            {1, 3, 5, 7, 9}, // target greater than all
            {-5, -3, -1, 0, 2}, // negative numbers
        };

        int[] targets = {
            1, // empty array
            5, // single element present
            3, // single element not present
            1, // all same
            8, // original test
            6, // not present
            2, // middle occurrences
            2, // start occurrences
            3, // end occurrences
            0, // less than all
            10, // greater than all
            -3, // negative target
        };

        for (int i = 0; i < testArrays.length; i++) {
            int[] result = solver.searchRange(testArrays[i], targets[i]);
            System.out.println("Array: " + java.util.Arrays.toString(testArrays[i]) +
                             ", Target: " + targets[i] +
                             ", Range: [" + result[0] + ", " + result[1] + "]");
        }
    }

    // Expected output:
//    Array: [], Target: 1, Range: [-1, -1]
//    Array: [5], Target: 5, Range: [0, 0]
//    Array: [5], Target: 3, Range: [-1, -1]
//    Array: [1, 1, 1, 1], Target: 1, Range: [0, 3]
//    Array: [5, 7, 7, 8, 8, 10], Target: 8, Range: [3, 4]
//    Array: [1, 2, 3, 4, 5], Target: 6, Range: [-1, -1]
//    Array: [1, 2, 2, 2, 3], Target: 2, Range: [1, 3]
//    Array: [2, 2, 2, 3, 4], Target: 2, Range: [0, 2]
//    Array: [1, 2, 3, 3, 3], Target: 3, Range: [2, 4]
//    Array: [1, 3, 5, 7, 9], Target: 0, Range: [-1, -1]
//    Array: [1, 3, 5, 7, 9], Target: 10, Range: [-1, -1]
//    Array: [-5, -3, -1, 0, 2], Target: -3, Range: [1, 1]
}
