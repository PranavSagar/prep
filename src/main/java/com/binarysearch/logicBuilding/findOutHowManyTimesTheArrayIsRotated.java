package com.binarysearch.logicBuilding;

import java.util.ArrayList;

public class findOutHowManyTimesTheArrayIsRotated {

    //this is same as find min ..instead of returning the element we return the index of the minimum element
    public int findKRotation(ArrayList<Integer> arr) {
        int n = arr.size();
        int start = 0, end = n - 1;
        if (arr.get(end) > arr.get(start)) {
            return 0;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > arr.get(end)) {
                start = mid + 1;
            } else if (arr.get(mid) < arr.get(end)) {
                end = mid;
            } else {
                end--;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        findOutHowManyTimesTheArrayIsRotated finder = new findOutHowManyTimesTheArrayIsRotated();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(1);
        arr.add(2);
        // list = [3, 4, 5, 1, 2]
        int rotations = finder.findKRotation(arr);
        System.out.println("The array is rotated " + rotations + " times."); // Output: 3
    }
}
