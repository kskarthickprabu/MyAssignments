package org.testleaf.week3.day1;

import java.util.Arrays;

public class LearnArrays {

      public static void main(String[] args) {

     //Array Literal
     //             0  1  2   3  4   
     int[] scores ={78,90,100,65,43};

     //get the number of data: length
     int numberOfData=scores.length;
     System.out.println("The Array length is "+numberOfData);

     //To rettrieve a data
     System.out.println(scores[0]);


     //       0    1   2   3     4 
     for (int i = 0; i < numberOfData ; i++) {
         System.out.println(scores[i]);

      
    }
//Sort th array in ascending order -sort  -->Arrays

Arrays.sort(scores);
// 0  1  2  3   4     index
//{43,65,78,90,100}
// 1  2  3   4   5    length
//To print the lowset number
System.out.println(scores[0]);
//              scores[4]
System.out.println(scores[numberOfData-1]);


//Instanstiation  --> know the no of data  -> dont know the data

//int[] number=new int[5];
//number[0]=100;
//number[1]=200;


String[] teams=new String[2];
teams[0]="India";
teams[1]="Australia";

}

}
