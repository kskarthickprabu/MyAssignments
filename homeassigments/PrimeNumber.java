package org.testleaf.week1.day2.homeassigments;

public class PrimeNumber {

    

    static boolean isPrime(int n) 
    {
        if (n <= 1)
            return false;

        
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
   }

    public static void main(String[] args) 
    {
        int n = 1;
      	if(isPrime(n))
            {
        	System.out.println("Prime Number");
        }else{
          System.out.println("Not a Prime Number");
    	}
	}
}

