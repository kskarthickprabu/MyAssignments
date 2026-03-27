package org.testleaf.week4.day2.homeassignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueCharacter {
        public static void main(String[] args) {
        
        String companyName = "google";
        
        //  Create LinkedHashSet (maintains order)
        Set<Character> set = new LinkedHashSet<>();
        
        // Iterate through string
        for (int i = 0; i < companyName.length(); i++) {
            set.add(companyName.charAt(i));
        }
        
        // Print unique characters (enhanced for loop ch->variable holds each element, set-> Collection to be iterated)
        for (Character ch : set) {
            System.out.print(ch);
        }
    }
}


