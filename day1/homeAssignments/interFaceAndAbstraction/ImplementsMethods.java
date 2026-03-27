package org.testleaf.week4.day1.homeAssignments;

// implement the methods in Concerte class

public class ImplementsMethods implements DataBaseConnection {

    public static void main(String[] args) {
            ImplementsMethods implementsMethodsObj=new ImplementsMethods();
            implementsMethodsObj.connect();
            implementsMethodsObj.disconnect();
            implementsMethodsObj.executeUpdate();
    }


    public void connect() {
     System.out.println("Unimplemented method 'connect' implemented in concrete class");
    }

 
    public void disconnect() {
       System.out.println("Unimplemented method 'disconnect' implemented in concrete class");
    }

    
    public void executeUpdate() {
      System.out.println("Unimplemented method 'executeUpdate'implemented in concrete class");
    }
}
