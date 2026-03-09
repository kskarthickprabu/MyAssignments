package org.testleaf.week2.homeassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CreatLead {
    public static void main(String[] args) {
        
        //Login into Guest mode to avoid the Popups

        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("guest");
       
       
        // Lauch the Chrome Browser
        ChromeDriver driver= new ChromeDriver(opt);

        // Lauch the website
        driver.get("http://leaftaps.com/opentaps/");

        // maximize the page

        driver.manage().window().maximize();

        // Enter the login credentials and click login button

        driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        // Click the hyper link CRM/SFA

        driver.findElement(By.linkText("CRM/SFA")).click();

        // Click the Lead tab

        driver.findElement(By.linkText("Leads")).click();

        //Click the Create Lead tab

        driver.findElement(By.partialLinkText("Create")).click();

        // Enter Company Name

        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testing PTY Ltd");

        // Enter fist name, Last name & Title

        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Karthick Prabu");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kuttuva Shyam Kumar");
        driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Mr");

        // click the create lead button

        driver.findElement(By.className("smallSubmit")).click();

        // close the Browser

       // driver.close();


        



    }

}
