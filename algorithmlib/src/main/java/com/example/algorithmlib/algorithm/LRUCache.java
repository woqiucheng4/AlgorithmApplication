package com.example.algorithmlib.algorithm;

import com.example.algorithmlib.QCLog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {

    public static void main(String[] args) {
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int k = 3;
        int[] result = LRU(operators, k);
        for (int i : result) {
            QCLog.e(i + ",");
        }
    }

    public static int[] LRU(int[][] operators, int k) {
        // write code here
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < operators.length; i++) {
            switch (operators[i][0]) {
                case 1:
                    if (map.containsKey(operators[i][1])) {
                        map.remove(new Integer(operators[i][1]));
                    } else if (map.size() == k) {
                        Iterator<Integer> iterator = map.keySet().iterator();
                        map.remove(iterator.next());
                    }
                    map.put(operators[i][1], operators[i][2]);
                    break;
                case 2:
                    if (map.containsKey(operators[i][1])) {
                        int res = map.get(operators[i][1]);
                        list.add(res);
                        map.remove(operators[i][1]);
                        map.put(operators[i][1], res);
                    } else
                        list.add(-1);
            }
        }
        if (list.size() > 0) {
            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++)
                ans[i] = list.get(i);
            return ans;
        } else
            return null;
    }
}
