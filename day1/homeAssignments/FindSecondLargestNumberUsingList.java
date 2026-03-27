package org.testleaf.week4.day1.homeAssignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestNumberUsingList {

    public static void main(String[] args)
     {
          //  Declare array
        Integer[] arr = {3, 2, 11, 4, 6, 7};
        
        //  Convert to List
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        
        // Sort in ascending order
        Collections.sort(list);
        System.out.println("Ascending Order of list"+" "+list);
        System.out.println("List Size"+" "+list.size());
        
        // Get 2nd element from last
        int secondLargest = list.get(list.size() - 2);
        
        // Print result
        System.out.println("Second Largest Number: " + secondLargest);
    }
    }

