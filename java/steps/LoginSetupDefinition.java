package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSetupDefinition {

    public ChromeDriver driver;
    @Given("Launch the browser")
    public void launchBrowser() {

        driver = new ChromeDriver();

    }
   @And("Load the url")
    public void loadUrl() {

        driver.get("https://login.salesforce.com/");

    }
   @And("Enter the username as kskarthickprabu.c3348082a2a2")
    public void enterUserName() {
        driver.findElement(By.id("username")).sendKeys("kskarthickprabu.c3348082a2a2@agentforce.com");

    }
   @And("Enter the password as $Surabhi@29")
    public void enterPassWord() {
        driver.findElement(By.id("password")).sendKeys("$Surabhi@29");

    }
   @When("Click on the Login button")
    public void clickLoginButton() {
        driver.findElement(By.id("Login")).click();

    }

    @And("Click Verify button for OTP verification")
    public void clickVerifyButton() throws InterruptedException {

        Thread.sleep(20000);
        driver.findElement(By.xpath("//input[@id='save']")).click();

    }
    @Then("User should be loggedin")
    public void verifyLogin() {

        System.out.println("Logged in Successfully");

    }
    @When("Click on the App Launcher")
    public void clickAppLauncher() {
        driver.findElement(By.xpath(
                "//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']/div"))
                .click();

    }
    @And("Click on View All ")
    public void clickViewAll() {
        driver.findElement(By.xpath("//button[text()='View All']")).click();

    }
    @And("Click Sales from App Launcher")
    public void clickSaleFromAppLauncher() {

        driver.findElement(By.xpath("//input[@class='slds-input']"))
                .sendKeys("Legal Entities" + Keys.ENTER);
        driver.findElement(
                By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"))
                .click();

    }
    @And("Click on Account tab")
    public void clickAccountTab() {
        driver.findElement(By.xpath("(//span[@class='slds-truncate'])[7]")).click();

    }
   @And("Click on New button")
    public void clickNewButton() {
        driver.findElement(By.xpath("//div[@title='New']")).click();

    }
    @And("Enter your name as Account name")
    public void enterAccountName() {
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Karthick");

    }
@And("Select Ownership as Public")
    public void selectOwnerShip() {

        driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value'])[3]")).click();
        driver.findElement(By.xpath("//span[text()='Public']")).click();
    }
@And("Click Save button")
    public void clickSave() {

        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
    }
@Then("User should save and Verify Account Name")
    public void verifySave() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        String error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//div[contains(@class,'fieldLevelErrors')]")))
                                .getText();

                System.out.println("Error Message: " + error);

                Assert.assertTrue(error.contains("Complete this field"));

    }

}
