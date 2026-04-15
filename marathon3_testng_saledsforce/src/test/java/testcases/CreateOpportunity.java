package testcases;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateOpportunity extends BaseClass {

    @Test(dataProvider="fetchData")
    public void createOpp(String name, String amount) {

        driver.findElement(By.xpath("//div[text()='New']")).click();

        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);

        driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);

        driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
        
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        WebElement dateField = driver.findElement(By.xpath("//input[@name='CloseDate']"));
        dateField.clear();
        dateField.sendKeys(today);

 // Select 'Stage' as 'Need Analysis'
        WebElement stageDropdown = driver.findElement(
                By.xpath("//button[@aria-label='Stage']"));
        stageDropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Needs Analysis']")));
        option.click();

        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        String actual = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();

        Assert.assertEquals(actual, name);
    }

    @DataProvider
    public String[][] fetchData() throws IOException {
        return ExcelUtility.readData("CreateOpp");
    }
}