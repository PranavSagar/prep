package com.binarysearch.logicBuilding;

public class searchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0,end = n-1, ans = n;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target <= nums[mid]){
                ans = mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }


        return ans;
    }

    public static void main(String[] args){
        //this is same as lowerBound, there is no difference
        searchInsertPosition sip = new searchInsertPosition();
        int[] nums = {-1,3,5,6,9,10,10};
        int target = 7;
        int result = sip.searchInsert(nums, target);
        System.out.println("The insert position is: " + result); // Expected output: 2
    }

}
