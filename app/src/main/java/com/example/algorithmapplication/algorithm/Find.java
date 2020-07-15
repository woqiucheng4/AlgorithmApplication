package com.example.algorithmapplication.algorithm;

import com.example.algorithmapplication.QCLog;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {

    public static void testFindNum() {
        int[][] testData = {{1, 2, 3}, {4, 5, 6}, {5, 6, 7}, {7, 8, 9}};
        int target = 8;
        boolean isInclude = findNum(target, testData);
        QCLog.e("isInclude == " + isInclude);
    }

    public static boolean findNumForce(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (target == array[i][j]) {
                    QCLog.e("result == " + i + ",," + j);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findNum(int target, int[][] array) {
        int row = array.length;
        if (row == 0) {
            return false;
        }

        int col = array[0].length;
        if (col == 0) {
            return false;
        }

        int realRow = row - 1;
        int relCol = 0;
        //
        //每次将 m 和目标值 target 比较：
        //
        //当 m < target，由于 m 已经是该行最大的元素，想要更大只有从列考虑，取值右移一位
        //当 m > target，由于 m 已经是该列最小的元素，想要更小只有从行考虑，取值上移一位
        //当 m = target，找到该值，返回 true
        while (realRow >= 0 && relCol < col) {
            if (array[realRow][relCol] < target) {
                relCol++;
            } else if (array[realRow][relCol] > target) {
                realRow--;
            } else {
                QCLog.e("result == " + relCol + ",," + realRow);
                return true;
            }
        }
        return false;
    }
}
