package week6day1testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StaticParameterizationSalesForce extends ProjectSpecificMethod  {


    public void dyamnicValue() throws InterruptedException
{
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Click login button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Login']"))).click();

        // Click the Verify button after entering the OTP manually
        Thread.sleep(20000);
        driver.findElement(By.xpath("//input[@id='save']")).click();
        // Click on the toggle menu button from the left corner

        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']/div")))
                .click();
        // Click View All button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']"))).click();

        // Search the Legal Entities on the search box
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='slds-input']")))
                .sendKeys("Legal Entities" + Keys.ENTER);
        // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        // WebElement element = wait.until(
        // ExpectedConditions.presenceOfElementLocated(
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Legal Entities']")))
                .click();

        // Click on new button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New']"))).click();
        // Enter the Legal Entity name as TestLeaf
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Name']"))).sendKeys("TestLeaf");
        // Enter the description as Salesforce
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@class='slds-textarea'])[2]")))
                .sendKeys("Salesforce");
        // Select status as Active
        WebElement status = driver.findElement(By.xpath("(//select[@type='button'])[18]"));
        status.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Active']"))).click();

        // Click Save button
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        // Validation error
        // Validate Error
        String error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'fieldLevelErrors')]")))
                .getText();

        System.out.println("Error Message: " + error);

        Assert.assertTrue(error.contains("Complete this field"));

}

}
