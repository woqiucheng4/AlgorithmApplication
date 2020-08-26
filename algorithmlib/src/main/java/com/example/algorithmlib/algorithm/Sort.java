package com.example.algorithmlib.algorithm;

import com.example.algorithmlib.QCLog;

public class Sort {

    public static void main(String[] args) {
        testTwoSum();
    }

    public static void testTwoSum() {
        int[] arr = new int[]{3, 38, 45, 2, 4, 6, 23, 3, 44, 9, 20, 13, 15, 44, 46, 48, 42, 9, 20, 1};
//        QCLog.e("bubbleSort == " + bubbleSort(arr));
//        QCLog.e("selectionSort == " + selectionSort(arr));
//        QCLog.e("insertSort == " + insertSort(arr));
//        QCLog.e("shellSort == " + shellSort(arr));
        QCLog.e("shellSort == " + mergeSort(arr));
    }

    public static String bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {//交换次数
            for (int j = 0; j < length - 1 - i; j++) {//比较次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return toString(arr);
    }

    public static String selectionSort(int[] arr) {
        int length = arr.length;
        int minIndex, temp;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return toString(arr);
    }

    public static String insertSort(int[] arr) {
        int length = arr.length;
        int current, preIndex;
        for (int i = 1; i < length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return toString(arr);
    }

    public static String shellSort(int[] arr) {
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < length; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && arr[j - gap] > current) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }

        }
        return toString(arr);
    }

    public static String mergeSort(int[] arr) {
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < length; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && arr[j - gap] > current) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }

        }
        return toString(arr);
    }


    public static String toString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : arr) {
            stringBuilder.append(i + ",");
        }
        return stringBuilder.toString();
    }

}
