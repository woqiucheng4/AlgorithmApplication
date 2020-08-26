package com.example.algorithmlib.algorithm;

import java.io.*;

public class MoneyTest {

    public static int reader(StreamTokenizer st) throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] main) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int[] redPocket = new int[reader(st)];
        for (int i = 0; i < redPocket.length; ++i) {
            redPocket[i] = reader(st);
        }

        int left = 0;
        int right = redPocket.length - 1;
        long leftSum = 0;
        long rightSum = 0;
        long max = 0;
        while (left <= right) {
            if (leftSum == rightSum) {
                max = leftSum;
                leftSum += redPocket[left++];
            } else if (leftSum < rightSum) {
                leftSum += redPocket[left++];
            } else {
                rightSum += redPocket[right--];
            }
            if (leftSum == rightSum) {
                max = leftSum;
            }
        }
        System.out.println(max);
    }
}
