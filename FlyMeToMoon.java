package org.testleaf.week4.day2;

public class FlyMeToMoon {

    public static void main(String[] args) {
        String word2 = "fly me to the moon";
        System.out.println("Actual Word is" + " " + word2);
        String[] splitWord2 = word2.split(" ");
        System.out.println("Splited Last Word is" + " " + splitWord2[4]);
        System.out.println("Last Word Length is" + " " + splitWord2[4].length());

    }
}
