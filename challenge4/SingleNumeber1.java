package org.testleaf.javaChallenge.challenge4;

public class SingleNumeber1 {

     public static void main(String[] args) {

        //I use XOR operation because duplicate elements cancel each other (a ^ a = 0)
        //The remaining element will be the unique one. This gives constant space.
        int[] nums = {4,1,2,1,2};

        int result = 0;

        for (int i=0; i<nums.length;i++){
            int num =nums[i];
            result = result ^ num;
        }

        System.out.println("Single number is: " + result);
    }
}


