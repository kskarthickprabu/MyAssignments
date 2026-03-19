package org.testleaf.week3.day2;

public class OddIndexUppercase {

  public static void main(String[] args) {
        String test = "changeme";
        System.out.println(changeOddToUpper(test));
    }

    public static String changeOddToUpper(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // Odd index (1, 3, 5...)
            if (i % 2 != 0) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }

        return new String(chars);
    }
}
