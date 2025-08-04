package com.binarysearch.logicBuilding;

import java.util.ArrayList;

public class searchInARotatedSortedArrayII {
    public boolean searchInARotatedSortedArrayTwo(ArrayList<Integer> nums, int target) {
        return bs(nums, 0, nums.size() - 1, target) != -1;
    }

    public static int bs(ArrayList<Integer> nums, int start, int end, int target) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (nums.get(mid) == target) return mid;

        // Handle duplicates case
        if (nums.get(mid).equals(nums.get(start)) && nums.get(mid).equals(nums.get(end))) {
            return bs(nums, start + 1, end - 1, target);
        }

        // Check which side is sorted
        if (nums.get(start) <= nums.get(mid)) {
            // Left side is sorted
            if (target < nums.get(mid) && target >= nums.get(start)) {
                return bs(nums, start, mid - 1, target);
            } else {
                return bs(nums, mid + 1, end, target);
            }
        } else {
            // Right side is sorted
            if (target > nums.get(mid) && target <= nums.get(end)) {
                return bs(nums, mid + 1, end, target);
            } else {
                return bs(nums, start, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        searchInARotatedSortedArrayII solver = new searchInARotatedSortedArrayII();
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(4);
        nums1.add(5);
        nums1.add(6);
        nums1.add(7);
        nums1.add(0);
        nums1.add(1);
        nums1.add(2);
        int target1 = 0; // Expected output: true
        System.out.println("Is target " + target1 + " found: " + solver.searchInARotatedSortedArrayTwo(nums1, target1));

        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(4);
        nums2.add(5);
        nums2.add(6);
        nums2.add(7);
        nums2.add(0);
        nums2.add(1);
        nums2.add(2);
        int target2 = 3; // Expected output: false
        System.out.println("Is target " + target2 + " found: " + solver.searchInARotatedSortedArrayTwo(nums2, target2));
    }

    //Expected output:
//    Is target 0 found: true
//    Is target 3 found: false
}
