package org.testleaf.week3.day2;

public class RemoveDuplicateWordsString {
    public static void main(String[] args) {
        String text = "We learn Java basics as part of java sessions in java week1";

        String result = removeDuplicates(text);
        System.out.println(result);
    }

    public static String removeDuplicates(String str) {
        String[] count = str.split("\\s+");
        String result = "";

        for (int i = 0; i < count.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < i; j++) {
                if (count[i].equals(count[j])) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                result += count[i] + " ";
            }
        }

        return result.trim();
    }

}
