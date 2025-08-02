package com.binarysearch.logicBuilding;

public class floorAndCeilInSortedArray {

    public int[] getFloorAndCeil(int[] nums, int target) {
        int n = nums.length;
        int floor = -1, ceil = -1;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // If target found, both floor and ceil are target
                return new int[]{nums[mid], nums[mid]};
            } else if (nums[mid] < target) {
                floor = nums[mid];
                start = mid + 1;
            } else {
                ceil = nums[mid];
                end = mid - 1;
            }
        }
        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        floorAndCeilInSortedArray solver = new floorAndCeilInSortedArray();
        int[][] testArrays = {
            {}, // empty array
            {5}, // single element
            {5}, // single element, target equal
            {1, 2, 2, 2, 3, 4, 5}, // duplicates
            {1, 3, 5, 7, 9}, // strictly increasing
            {10, 20, 30, 40}, // all greater than target
            {-10, -5, 0, 5}, // negative and positive
            {2, 2, 2, 2}, // all same
            {1, 2, 3, 4, 5}, // target less than all
            {1, 2, 3, 4, 5}, // target greater than all
            {1, 2, 3, 4, 5}, // target in the middle
            {1, 2, 3, 4, 5}, // target just below min
            {1, 2, 3, 4, 5}, // target just above max
            {-5, -3, -1, 0, 2, 4, 6}, // negative and positive, target negative
            {-5, -3, -1, 0, 2, 4, 6}, // negative and positive, target positive
            {-5, -3, -1, 0, 2, 4, 6}, // negative and positive, target zero
            {Integer.MIN_VALUE, -1000, 0, 1000, Integer.MAX_VALUE}, // extreme values
        };
        int[] targets = {
            1, // for empty array
            4, // less than single element
            5, // equal to single element
            2, // present in duplicates
            6, // not present, between elements
            5, // less than all
            -20, // less than all
            2, // equal to all
            0, // less than all
            10, // greater than all
            3, // in the middle
            0, // just below min
            6, // just above max
            -4, // negative, between -5 and -3
            3, // positive, between 2 and 4
            0, // exactly zero
            100, // between 1000 and Integer.MAX_VALUE
        };
        for (int i = 0; i < testArrays.length; i++) {
            int[] result = solver.getFloorAndCeil(testArrays[i], targets[i]);
            System.out.println("Array: " + java.util.Arrays.toString(testArrays[i]) + ", Target: " + targets[i] + ", Floor: " + result[0] + ", Ceil: " + result[1]);
        }
    }
}
