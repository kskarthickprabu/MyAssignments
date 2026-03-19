package org.testleaf.week3.day1.homeassignments;



public class FindMissingElement {
     public static void main(String[] args) {
        int arr[] = {1, 4, 3, 2, 8, 6, 7};
        int n = 8; // range is 1 to 8

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
            
        }

        int missing = expectedSum - actualSum;
        System.out.println("Missing number: " + missing);
    }
}