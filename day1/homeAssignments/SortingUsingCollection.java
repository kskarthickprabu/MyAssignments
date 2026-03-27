package org.testleaf.week4.day1.homeAssignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingUsingCollection {
    public static void main(String[] args) {

        // Step 1: Declare String array
        String[] companies = { "HCL", "Wipro", "Aspire Systems", "CTS" };

        // Step 2: Add array to a list
        List<String> list = new ArrayList<>(Arrays.asList(companies));
        System.out.println("Actual list of companies" + list);

        // Step 3: Rearrange to required order (List follows FIFO order)
        List<String> result = new ArrayList<>();
        result.add("Wipro");
        result.add("HCL");
        result.add("CTS");
        result.add("Aspire Systems");

        System.out.println("Rearrange list of comapnies");

        // Step 4: Iterate and print ()
        for (int i = 0; i < result.size(); i++) {
            String company = result.get(i);
            System.out.println(company);
        }
    }
}
