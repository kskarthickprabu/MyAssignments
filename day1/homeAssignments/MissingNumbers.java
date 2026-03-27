package org.testleaf.week4.day1.homeAssignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingNumbers {

    public static void main(String[] args) {
        
        // Step 1: Declare array
        Integer[] arr = {1, 2, 3, 4, 10, 6, 8};
        
        // Step 2: Convert to List
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        
        // Step 3: Sort the list
        Collections.sort(list);
        
        System.out.println("Sorted List: " + list);
        System.out.print("Missing Numbers: ");
        
        // Step 4: Find missing numbers
        for (int i = 0; i < list.size() - 1; i++) {
            
            int current = list.get(i);
            int next = list.get(i + 1);
            
            // Step 5: Check gap
            for (int j = current + 1; j < next; j++) {
                System.out.print(j + " ");
            }
        }
    }
}

