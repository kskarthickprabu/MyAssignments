package org.testleaf.week4.day1.homeAssignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersectionUsingList {

    public static void main(String[] args) {

        //  Declare arrays
        Integer[] arr1 = { 3, 2, 11, 4, 6, 7 };
        Integer[] arr2 = { 1, 2, 8, 4, 9, 7 };

        //  Convert arrays to List
        List<Integer> list1 = new ArrayList<>(Arrays.asList(arr1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(arr2));
        // Print the values of Array 1 & 2
        System.out.println("Array 1 Values" + list1);
        System.out.println("Array 2 Values" + list2);

        // Compare arrays and print equal values
        System.out.print("Matching Values: ");
 
        // Iterate the values through the length of the list    
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                System.out.print(arr1[i] + " ");
            }

        }
    }
}
