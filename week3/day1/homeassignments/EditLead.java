package org.testleaf.week3.day1.homeassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("guest");

        ChromeDriver driver = new ChromeDriver(opt);

        driver.get("http://leaftaps.com/opentaps/");

        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        driver.findElement(By.linkText("CRM/SFA")).click();

        driver.findElement(By.linkText("Leads")).click();

        driver.findElement(By.partialLinkText("Create")).click();
        driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("ABSA Bank");

        driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Karthick Prabu");
        driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Kuttuva ShyamKumar");
        driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("testing");
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Quality Assurance");
        driver.findElement(By.id("createLeadForm_description")).sendKeys("Edit the lead form");
        driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("kskarthickprabu@gmail.com");

        WebElement SourceElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
        Select options = new Select(SourceElement);
        options.selectByVisibleText("New York");
        Thread.sleep(3000);

        driver.findElement(By.className("smallSubmit")).click();

        driver.findElement(By.linkText("Edit")).click();
        Thread.sleep(3000);

        WebElement textbox = driver.findElement(By.id("updateLeadForm_description"));
        textbox.clear();

        driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Successfully Edited");
        driver.findElement(By.name("submitButton")).click();
        String title = driver.getTitle(); // Get the page title
        System.out.println("Page title is: " + title);

        driver.quit();

    }
}
