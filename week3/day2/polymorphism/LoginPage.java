package org.testleaf.week3.day2.polymorphism;
//inherit from baseclass BasePage
public class LoginPage extends BasePage {

    public void performCommonTasks() {
        super.performCommonTasks();// It will call the base class performCommonTask method 
        System.out.println("PerformBaspage method accessed from subclass");
    }

    public static void main(String[] args) {

        LoginPage m = new LoginPage();
        m.performCommonTasks();// it will call only the Base class performCommonTask method first and then call the subclass performCommonTask
    }

}
