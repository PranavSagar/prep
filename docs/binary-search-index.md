# Binary Search - Complete Guide & Index

This document serves as an index for all binary search topics covered in this repository. Each topic includes a description, approach, time/space complexity, and links to the implementation.

## Table of Contents

1. [Fundamentals](#fundamentals)
2. [Logic Building](#logic-building)
3. [Medium Problems](#medium-problems)
4. [Hard Problems](#hard-problems)

---

## Fundamentals

### 1. Search Element in Sorted Array
**File:** [searchXInSortedArray.java](../src/main/java/com/binarysearch/fundamentals/searchXInSortedArray.java)

**Problem:** Find if a target element exists in a sorted array.

**Approach:** Classic binary search with left and right pointers.

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

---

### 2. Lower Bound
**File:** [lowerBound.java](../src/main/java/com/binarysearch/fundamentals/lowerBound.java)

**Problem:** Find the smallest index where `arr[index] >= target`.

**Approach:** Binary search with condition checking for first occurrence of target or greater.

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

---

### 3. Upper Bound
**File:** [upperBound.java](../src/main/java/com/binarysearch/fundamentals/upperBound.java)

**Problem:** Find the smallest index where `arr[index] > target`.

**Approach:** Binary search with condition checking for first element strictly greater than target.

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

---

## Logic Building

### 1. Search Insert Position
**File:** [searchInsertPosition.java](../src/main/java/com/binarysearch/logicBuilding/searchInsertPosition.java)

**Problem:** Find the index where target should be inserted to maintain sorted order.

**Approach:** Binary search to find the lower bound position.

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

---

### 2. Floor and Ceil in Sorted Array
**File:** [floorAndCeilInSortedArray.java](../src/main/java/com/binarysearch/logicBuilding/floorAndCeilInSortedArray.java)

**Problem:** Find the floor (largest element ≤ x) and ceil (smallest element ≥ x) of a given number.

**Approach:** 
- Floor: Largest element ≤ target
- Ceil: Smallest element ≥ target

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

---

### 3. First and Last Occurrence
**File:** [firstAndLastOccurrence.java](../src/main/java/com/binarysearch/logicBuilding/firstAndLastOccurrence.java)

**Problem:** Find the first and last position of a target element in a sorted array.

**Approach:** 
- First occurrence: Binary search moving left when target found
- Last occurrence: Binary search moving right when target found

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

---

### 4. Single Element in Sorted Array
**File:** [singleElementInSortedArray.java](../src/main/java/com/binarysearch/logicBuilding/singleElementInSortedArray.java)

**Problem:** Find the single element in a sorted array where every other element appears exactly twice.

**Approach:** 
- Use binary search with index parity check
- Align mid to even index and check pairing pattern
- Single element disrupts the even-odd pairing pattern

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

**Key Logic:**
```java
// Align mid to even
if (mid % 2 == 1) mid--;
if (nums[mid] == nums[mid + 1]) {
    start = mid + 2; // single element is on the right
} else {
    end = mid; // single element is on the left or at mid
}
```

---

### 5. Search in Rotated Sorted Array I
**File:** [searchInRotatedSortedArrayI.java](../src/main/java/com/binarysearch/logicBuilding/searchInRotatedSortedArrayI.java)

**Problem:** Search for a target in a rotated sorted array (no duplicates).

**Approach:** 
- Identify which half is sorted
- Check if target lies in the sorted half
- Eliminate the other half

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

---

### 6. Search in Rotated Sorted Array II
**File:** [searchInARotatedSortedArrayII.java](../src/main/java/com/binarysearch/logicBuilding/searchInARotatedSortedArrayII.java)

**Problem:** Search for a target in a rotated sorted array (with duplicates).

**Approach:** 
- Handle duplicates by trimming edges when `nums[start] == nums[mid] == nums[end]`
- Apply same logic as Array I after handling duplicates

**Time Complexity:** O(log n) average, O(n) worst case  
**Space Complexity:** O(1)

---

### 7. Find Minimum in Rotated Sorted Array
**File:** [findMinimumInRotatedSortedArray.java](../src/main/java/com/binarysearch/logicBuilding/findMinimumInRotatedSortedArray.java)

**Problem:** Find the minimum element in a rotated sorted array.

**Approach:** 
- Compare mid with end element
- Minimum is always in the unsorted half

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

---

### 8. Find Rotation Count
**File:** [findOutHowManyTimesTheArrayIsRotated.java](../src/main/java/com/binarysearch/logicBuilding/findOutHowManyTimesTheArrayIsRotated.java)

**Problem:** Find how many times a sorted array has been rotated.

**Approach:** 
- Find the index of minimum element
- The index of minimum element = number of rotations

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

---

## Medium Problems

*Currently no implementations - placeholder for future medium-level problems*

**File:** [medium/](../src/main/java/com/binarysearch/medium/)

---

## Hard Problems

*Currently no implementations - placeholder for future hard-level problems*

**File:** [hard/](../src/main/java/com/binarysearch/hard/)

---

## Key Binary Search Patterns

### 1. **Classic Binary Search**
```java
while (start <= end) {
    int mid = start + (end - start) / 2;
    if (nums[mid] == target) return mid;
    else if (nums[mid] < target) start = mid + 1;
    else end = mid - 1;
}
```

### 2. **Lower Bound Pattern**
```java
while (start < end) {
    int mid = start + (end - start) / 2;
    if (nums[mid] < target) start = mid + 1;
    else end = mid;
}
```

### 3. **Upper Bound Pattern**
```java
while (start < end) {
    int mid = start + (end - start) / 2;
    if (nums[mid] <= target) start = mid + 1;
    else end = mid;
}
```

### 4. **Rotated Array Pattern**
```java
// Identify sorted half and search accordingly
if (nums[start] <= nums[mid]) {
    // Left half is sorted
    if (target >= nums[start] && target < nums[mid]) {
        end = mid - 1;
    } else {
        start = mid + 1;
    }
} else {
    // Right half is sorted
    if (target > nums[mid] && target <= nums[end]) {
        start = mid + 1;
    } else {
        end = mid - 1;
    }
}
```

---

## Common Edge Cases to Consider

1. **Empty Array:** `nums.length == 0`
2. **Single Element:** `nums.length == 1`
3. **Target at Boundaries:** First or last element
4. **Target Not Found:** Return appropriate default value (-1, insertion position, etc.)
5. **Duplicates:** Handle when elements are repeated
6. **Rotated Arrays:** Handle pivot points and sorted portions

---

## Test Case Patterns

### Small Arrays (Dry Run Friendly)
- `[1, 2, 3]` - Simple sorted array
- `[1]` - Single element
- `[]` - Empty array
- `[2, 1]` - Two elements (rotated)

### Edge Cases
- `[1, 1, 1, 1]` - All duplicates
- `[1, 2, 2, 2, 3]` - Multiple duplicates
- `[5, 1, 2, 3, 4]` - Rotated array
- `[1, 1, 2, 3, 3, 4, 4, 8, 8]` - Single element with pairs

### Comprehensive Test Sets
- **Target Found:** At start, middle, end positions
- **Target Not Found:** Before first, between elements, after last
- **Boundary Values:** Minimum and maximum possible values

---

*Last Updated: August 5, 2025*
