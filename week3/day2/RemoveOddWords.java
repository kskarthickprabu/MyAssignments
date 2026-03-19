package org.testleaf.week3.day2;

public class RemoveOddWords {

      public static void main(String[] args) {
        String test = "my name is karthick prabu";

        String result = reverseOddWords(test);
        System.out.println(result);
    }

    public static String reverseOddWords(String str) {
        String[] words = str.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            // i % 2 == 0 → odd position (1-based index)
            if (i % 2 == 0) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }

        return String.join(" ", words);
    }
}

