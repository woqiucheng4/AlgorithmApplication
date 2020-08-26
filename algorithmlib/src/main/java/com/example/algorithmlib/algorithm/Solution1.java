package com.example.algorithmlib.algorithm;

import com.example.algorithmlib.QCLog;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Solution1 {

    public static void main(String[] args) {
        testTwoSum();
    }

    public static void testTwoSum() {
        int[] testData = new int[]{2, 2, 3, 4, 5, 6, 2, 3, 4, 5};
        int target = 6;
        int[] result1 = twoSum(testData, target);
        int[] result2 = twoSumForce(testData, target);
        QCLog.e("result1 == " + result1[0] + ",," + result1[1]);
        QCLog.e("result2 == " + result2[0] + ",," + result2[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
           if(map.containsKey(otherNum)){
               return new int[]{map.get(otherNum),i};
           }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no two sum");
    }

    public static int[] twoSumForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}