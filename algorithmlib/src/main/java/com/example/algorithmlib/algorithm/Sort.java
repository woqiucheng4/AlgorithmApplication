package com.example.algorithmlib.algorithm;

import com.example.algorithmlib.QCLog;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        testTwoSum();
    }

    public static void testTwoSum() {
        int[] arr = new int[]{3, 38, 45, 2, 4, 6, 23, 3, 44, 9, 20, 13, 15, 44, 46, 48, 42, 9, 20, 1};
        QCLog.e("bubbleSort == " + bubbleSort(Arrays.copyOf(arr, arr.length)) + "\n");
        QCLog.e("selectionSort == " + selectionSort(Arrays.copyOf(arr, arr.length)) + "\n");
        QCLog.e("insertSort == " + insertSort(Arrays.copyOf(arr, arr.length)) + "\n");
        QCLog.e("shellSort == " + shellSort(Arrays.copyOf(arr, arr.length)) + "\n");
        QCLog.e("mergeSort == " + mergeSort(Arrays.copyOf(arr, arr.length)) + "\n");
        QCLog.e("quickSort == " + quickSort(Arrays.copyOf(arr, arr.length)) + "\n");
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static String bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return toString(arr);
    }

    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static String selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
        return toString(arr);
    }

    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public static String insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
//            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }

        }
        return toString(arr);
    }

    /**
     * 希尔排序
     *
     * @param arr
     * @return
     */
    public static String shellSort(int[] arr) {

        return toString(arr);
    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static String mergeSort(int[] arr) {
        return toString(arr);
    }

    /**
     * 快速排序
     *
     * @param arr
     * @return
     */
    public static String quickSort(int[] arr) {
        arr = quickSortMethod(arr);
        return toString(arr);
    }

    public static int[] quickSortMethod(int[] arr) {
        arr = quickSortLoop(arr, 0, arr.length - 1);
        return arr;
    }

    public static int[] quickSortLoop(int[] arr, int left, int right){

        if (left < right) {
            int dividerIndex = getDividerIndex(arr, left, right);
            quickSortLoop(arr, left, dividerIndex - 1);
            quickSortLoop(arr, dividerIndex + 1, right);
        }
        return arr;
    }

    public static int getDividerIndex(int[] arr, int left, int right){
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static String toString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : arr) {
            stringBuilder.append(i + ",");
        }
        return stringBuilder.toString();
    }

}
