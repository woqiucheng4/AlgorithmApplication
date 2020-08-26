package com.example.algorithmlib.algorithm;

import com.example.algorithmlib.QCLog;

public class BinarySearch {

    public static void main(String[] args) {
        int target = 2;
        int[] array = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 4, 5};
//        QCLog.e(upperBound(array,target) + "");
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        QCLog.e(search(array, target) + "");
    }

    public static int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    public static int upperBound(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                if (mid == 0 || array[mid - 1] < target) return mid + 1;
                else
                    right = mid;
            } else
                left = mid + 1;
        }
        return target + 1;
    }
}
