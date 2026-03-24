package org.testleaf.week4.day2;

public class HelloWorld {

    public static void main(String[] args) {

        String word1 = "Hello World";
        System.out.println("Actual Word is" + " " + word1);
        String[] splitWord1 = word1.split(" ");
        System.out.println("Splited Last Word is" + " " + splitWord1[1]);
        System.out.println("Last Word Length is" + " " + splitWord1[1].length());

    }

}
