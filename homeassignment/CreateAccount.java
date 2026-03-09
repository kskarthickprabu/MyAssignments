package org.testleaf.week2.homeassignment;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
 public static void main(String[] args) {

        // Lauch the Browser
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("guest");
        ChromeDriver driver = new ChromeDriver(opt);
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();

        // Enter the credentials and Login
        driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        // Click the Hyperlink- CRM/SFA
        // driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.partialLinkText("CRM")).click();

        // Click the Account link
        driver.findElement(By.linkText("Accounts")).click();

        // Click Create Account link
        driver.findElement(By.partialLinkText("Create")).click();

        // Enter the account name
        driver.findElement(By.id("accountName")).sendKeys("Selenium Automation Tester5");
         //Select "ComputerSoftware" as the industry.
        WebElement SourceElement=driver.findElement(By.className("inputBox"));
        Select options=new Select(SourceElement);
        options.selectByValue("IND_SOFTWARE");

        // Select "S-Corporation" as ownership using SelectByVisibleText.
        WebElement SourceElement1=driver.findElement(By.name("ownershipEnumId"));
        Select options1=new Select(SourceElement1);
         options1.selectByVisibleText("S-Corporation");

         //Select "Employee" as the source using SelectByValue.
         WebElement SourceElement2=driver.findElement(By.id("dataSourceId"));
         Select options3=new Select(SourceElement2);
         options3.selectByValue("LEAD_EMPLOYEE");

         //Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex.

         WebElement SourceElement3=driver.findElement(By.id("marketingCampaignId"));
         Select options4=new Select(SourceElement3);
         options4.selectByIndex(6);

         //Select "Texas" as the state/province using SelectByValue.

         WebElement SourceElement4=driver.findElement(By.id("generalStateProvinceGeoId"));
         Select options5=new Select(SourceElement4);
         options5.selectByValue("TX");

         // click the Creat account button

         driver.findElement(By.className("smallSubmit")).click();

         // close the browser window

         //driver.close();


        


    }

}
