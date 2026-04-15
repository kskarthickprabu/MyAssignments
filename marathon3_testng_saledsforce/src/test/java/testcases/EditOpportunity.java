package testcases;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditOpportunity extends BaseClass {

    @Test(dependsOnMethods = "createOpp")
    public void editOpp() {

        driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation");

        driver.findElement(By.xpath("//a[@title='Show Actions']")).click();
        driver.findElement(By.xpath("//a[@title='Edit']")).click();

        // Change close date (tomorrow)
        driver.findElement(By.xpath("//input[@name='CloseDate']"))
              .sendKeys(LocalDate.now().plusDays(1).toString());

        // Stage
        driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
        driver.findElement(By.xpath("//span[text()='Perception Analysis']")).click();

        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        String stage = driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();

        Assert.assertEquals(stage, "Perception Analysis");
    }
}