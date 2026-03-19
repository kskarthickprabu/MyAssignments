package org.testleaf.week3.day1;

import java.util.Arrays;

public class PrintDuplicates {

    public static void main(String[] args) {
        int[] num = { 2, 5, 7, 7, 5, 9, 2, 3 };

        Arrays.sort(num);
        int numberOfData = num.length;
        for (int i = 0; i < numberOfData; i++) {
            for (int j = i + 1; j < numberOfData; j++) {
                if (num[i] == num[j]) {
                    System.out.println("Duplicate number in the array:" + num[i]);
                }
            }

        }

    }
}
