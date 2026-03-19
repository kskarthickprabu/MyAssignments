package org.testleaf.week3.day2;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        // Define two input strings.
        String text1 = "stops";
        String text2 = "spots";
        // Convert both the strings to character arrays
        int length1 = text1.length();
        int length2 = text2.length();
        // Check if the lengths of the two strings are equal-if equal continue the
        // loop,otherwise exist the loop & print the else loop
        if (length1 == length2) {
            char[] charArray1 = text1.toCharArray();
            char[] charArray2 = text2.toCharArray();
            // Sort both the character arrays
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

        } else {
            System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
        }
        //Check if the sorted arrays are equal
        if (text1 == text2) {
            System.out.println("The given strings are Anagram");

        }
        //if the sorted arrays are not equal

        else if (text1 != text2) {
            System.out.println("The given strings are not an Anagram");
        }

    }

}
