package com.binarysearch.logicBuilding;

public class searchInRotatedSortedArrayI {
    public static int bs(int[] nums,int start, int end ,int target) {
        if(start>end)return -1;
        int mid = start + (end-start)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid] == nums[start] && nums[mid] ==  nums[end]) return bs(nums, start+1, end-1, target);
        //now we have to find which side is sorted

        if(nums[start]<= nums[mid]){
            //left side is sorted
            if(target<nums[mid] && target >= nums[start]){
                return bs(nums, start, mid-1, target);
            }else{
                return bs(nums, mid+1, end, target);
            }
        }else{
            //right side is sorted
            if(target>nums[mid] && target <= nums[end]){
                return bs(nums, mid+1, end, target);
            }else{
                return bs(nums, start, mid-1, target);
            }
        }
    }

    public static int search(int[] nums, int target) {
        return bs(nums, 0, nums.length-1, target);
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0; // Expected output: 4
        System.out.println("Index of target " + target1 + ": " + search(nums1, target1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3; // Expected output: -1 (not found)
        System.out.println("Index of target " + target2 + ": " + search(nums2, target2));

        int[] nums3 = {1};
        int target3 = 0; // Expected output: -1 (not found)
        System.out.println("Index of target " + target3 + ": " + search(nums3, target3));

        int[] nums4 = {1, 3};
        int target4 = 3; // Expected output: 1
        System.out.println("Index of target " + target4 + ": " + search(nums4, target4));
    }


//    The line:
//     if (nums[mid] == nums[start] && nums[mid] == nums[end])
//         return bs(nums, start + 1, end - 1, target);
//     is used to handle the duplicate elements case in a rotated sorted array.
//     ⸻
//     🔍 Why is this needed?
//     In a rotated sorted array without duplicates, you can always determine whether the left or right half is sorted by comparing nums[start] and nums[mid].
//     However, if duplicates exist, for example:
//     [2, 2, 2, 3, 4, 2]
//     and start = 0, mid = 2, end = 5
//         •   nums[mid] == nums[start] == nums[end] == 2
//     In this situation, you cannot decide which half is sorted because duplicates make it ambiguous.

    //EXPECTED OUTPUT:
//    Index of target 0: 4
//    Index of target 3: -1
//    Index of target 0: -1
//    Index of target 3: 1
}
