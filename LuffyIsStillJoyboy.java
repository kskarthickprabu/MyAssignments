package org.testleaf.week4.day2;

public class LuffyIsStillJoyboy {

    public static void main(String[] args) {
        String word3 = "luffy is still joyboy";
        System.out.println("Actual Word is" + " " + word3);
        String[] splitWord3 = word3.split(" ");
        System.out.println("Splited Last Word is" + " " + splitWord3[3]);
        System.out.println("Last Word Length is" + " " + splitWord3[3].length());
}
}