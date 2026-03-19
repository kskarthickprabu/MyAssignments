package org.testleaf.week3.day2.polymorphism;

public class APIClient {

    public void sendRequest(String endpoint) {

        System.out.println("https://www.gmail.com");

    }

    public void sendRequest(String endpoint, String requestBody, boolean requestStatus)

    {
        System.out.println("url successfully launched");
        System.out.println("payLoad successfully verified");
        System.out.println("conidtion passed");

    }

    public static void main(String[] args) {
        APIClient obj = new APIClient();
        obj.sendRequest("https://www.gmail.com");
        obj.sendRequest("https://www.gmail.com", "payLoad", true);

    }

}
