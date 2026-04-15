package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteOpportunity extends BaseClass {

    @Test(dependsOnMethods = "editOpp")
    public void deleteOpp() {

        driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation");

        driver.findElement(By.xpath("//a[@title='Show Actions']")).click();
        driver.findElement(By.xpath("//a[@title='Delete']")).click();

        driver.findElement(By.xpath("//button[@title='Delete']")).click();

        // Verify deletion (toast message)
        String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();

        Assert.assertTrue(msg.contains("deleted"));
    }
}