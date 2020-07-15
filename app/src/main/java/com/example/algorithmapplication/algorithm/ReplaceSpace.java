package com.example.algorithmapplication.algorithm;

import com.example.algorithmapplication.QCLog;

public class ReplaceSpace {

    public static void testReplaceSpace() {
        String testData = "we are happy ! ";
        String result = replaceSpace(testData);
        QCLog.e("result == " + result);
    }

    public static String replaceSpace(String str) {
        if (str != null) {
            return str.replace(" ", "%20");
        }
        return null;
    }

    public String replaceSpaceChar(String value) {
        StringBuffer str = new StringBuffer(value);
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                n += 2;
                str.replace(i, i + 1, "%20");
            }
        }
        return str.toString();
    }
}
