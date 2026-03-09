package org.testleaf.week2.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class LauchBrowser {

    public static void main(String[] args) {

        ChromeDriver driver= new ChromeDriver();
        driver.get("https://www.google.com/");
        Dimension size=new Dimension(800,600);
        driver.manage().window().setSize(size);
       // driver.close();
    }

}
