package com.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class Util {
    public static int[] arraySuplier() {
        int len = 25;
        int rg = 100;
        Random r = new Random();
        int[] rslt = new int[len];
        for (int i = 0; i < len; i++) {
            rslt[i] = r.nextInt(rg);
            System.out.print(rslt[i] + " ");
        }
        System.out.println(";");
        return rslt;
    }

    public static void print(int[] arr) {
        Arrays.stream(arr).forEach(val -> {
            System.out.print(val + " ");
        });
        System.out.println(";");
    }
}
