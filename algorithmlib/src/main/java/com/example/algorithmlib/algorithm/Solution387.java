package com.example.algorithmlib.algorithm;

import com.example.algorithmlib.QCLog;

import java.util.HashMap;
import java.util.Map;

public class Solution387 {
    public static void main(String[] args) {
        testSolution387();
    }

    public static void testSolution387() {
        String test1 = "leetcode";
        String test2 = "loveleetcode";
        QCLog.e("result2 == " + getFirstUniqueChar(test1) + ",," + getFirstUniqueChar(test2));
    }

    private static int getFirstUniqueChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
