package com.example.algorithmapplication.algorithm;
import com.example.algorithmapplication.QCLog;

import java.util.HashMap;
import java.util.Map;

/**
 *
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 示例:
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */
public class TwoSum {

    public static void testTwoSum(){
        int[] testData = new int[]{2,2,3,4,5,6,2,3,4,5};
        int target = 6;
        int[] result1 = twoSum(testData,target);
        int[] result2 = twoSumForce(testData,target);
        QCLog.e("result1 == "+result1[0]+",,"+result1[1]);
        QCLog.e("result2 == "+result2[0]+",,"+result2[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
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