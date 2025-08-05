package com.binarysearch.logicBuilding;

import java.util.ArrayList;

public class findMinimumInRotatedSortedArray {

    public int findMin(ArrayList<Integer> arr) {
        int n = arr.size();
        int start = 0, end = n - 1;
        if (arr.get(end) > arr.get(start)) {
            return arr.get(start);
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > arr.get(end)) {
                // Minimum is in the right half
                start = mid + 1;
            } else if (arr.get(mid) < arr.get(end)) {
                // Minimum is in the left half or at mid
                end = mid;
            } else {
                // If arr[mid] == arr[end], we cannot determine the side, so we reduce the end
                end--;
            }
        }

        return arr.get(start); // Return the minimum element
    }

    public static void main(String[] args) {
        findMinimumInRotatedSortedArray finder = new findMinimumInRotatedSortedArray();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(1);
        arr.add(2);

        int min = finder.findMin(arr);
        System.out.println("The minimum element in the rotated sorted array is: " + min); // Output: 1
    }
}
