package com.binarysearch.fundamentals;

public class searchXInSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        searchXInSortedArray solver = new searchXInSortedArray();
        int[] nums = {1, 3, 5, 7, 9, 11,12};
        int target = 7;
        int result = solver.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);
    }
}
