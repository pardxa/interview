package com.algorithms.sort;

public class Selection {
    public static void main(String[] args) {
        int[] ar = sort(Util.arraySuplier());
        Util.print(ar);
    }

    public static int[] sort(int[] inArray) {
        int len = inArray.length;
        for (int i = 0; i < len; i++) {
            int mIdx = 0;
            for (int j = 0; j < len - i; j++) {
                if (inArray[mIdx] < inArray[j]) {
                    mIdx = j;
                }
            }
            int max = inArray[mIdx];
            inArray[mIdx] = inArray[len - 1 - i];
            inArray[len - 1 - i] = max;
        }
        return inArray;

    }
}
