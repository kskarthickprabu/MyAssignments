package org.testleaf.week3.day1.homeassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeletLead {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("guest");

        ChromeDriver driver = new ChromeDriver(opt);
        driver.get("http://leaftaps.com/opentaps/");
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.linkText("Phone")).click();
        driver.findElement(By.name("phoneNumber")).sendKeys("98127");
        driver.findElement(By.xpath("//button[@id='ext-gen334']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        driver.findElement(By.className("subMenuButtonDangerous")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.name("id")).sendKeys("10056");
        driver.findElement(By.xpath("//button[@id='ext-gen334']")).click();
        driver.quit();

    }

}
