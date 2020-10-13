package com.algorithms.sort;

public class Bubble {
    public static void main(String[] args) {
        int[] ar = sort(Util.arraySuplier());
        Util.print(ar);
    }

    public static int[] sort(int[] inArray) {
        int len = inArray.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (inArray[j] > inArray[j + 1]) {
                    int max = inArray[j];
                    inArray[j] = inArray[j + 1];
                    inArray[j + 1] = max;
                }
            }
        }
        return inArray;
    }
}
