package com.algorithms.sort;

public class Merge {
    public static void main(String[] args) {
        int[] ar = sort(Util.arraySuplier());
        Util.print(ar);
    }

    public static int[] sort(int[] inArray) {
        int[] helper = new int[inArray.length];
        splite(inArray, helper, 0, inArray.length - 1);
        return inArray;
    }

    public static void splite(int[] inArray, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;//////////
            splite(inArray, helper, low, mid);
            splite(inArray, helper, mid + 1, high);
            merge(inArray, helper, low, mid, high);
        }
    }

    public static void merge(int[] inArray, int[] helper, int low, int mid, int high) {
        for (int i = 0; i < inArray.length; i++) {
            helper[i] = inArray[i];
        }
        int left = low;
        int right = mid + 1;
        int current = low;
        while (left <= mid && right <= high) {
            if (helper[left] <= helper[right]) {
                inArray[current] = helper[left];
                left++;
            } else {
                inArray[current] = helper[right];
                right++;
            }
            current++;
        }
        int remain = mid - left;
        for (int i = 0; i <= remain; i++) {
            inArray[current + i] = helper[left + i];////left+i
        }
    }
}
