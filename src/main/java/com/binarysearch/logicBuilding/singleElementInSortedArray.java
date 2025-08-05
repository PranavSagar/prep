package com.binarysearch.logicBuilding;

public class singleElementInSortedArray {
//    Binary Search Logic
//  1.  Initialize:
//            • start = 0, end = nums.length - 1
//            2.  While start < end:
//            • mid = start + (end - start) / 2
//            • If mid is odd, make it even → mid-- (this aligns mid to the start of a pair).
//            • Check pairing:
//            • If nums[mid] == nums[mid + 1] → single element is on the right → start = mid + 2
//            • Else → single element is on the left (or at mid) → end = mid
//  3.  Return:
//            • When loop ends, start == end → return nums[start]
// ✅ Time Complexity: O(log n)
//✅ Space Complexity: O(1)
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            // Align mid to even
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2; // single element is on the right
            } else {
                end = mid; // single element is on the left or at mid
            }
        }
        return nums[start]; // single element index
    }

    public static void main(String[] args) {
        singleElementInSortedArray finder = new singleElementInSortedArray();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int singleElement = finder.singleNonDuplicate(nums);
        System.out.println("The single element in the sorted array is: " + singleElement); // Output: 2
    }
}
