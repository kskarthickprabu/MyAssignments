package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesForceCreateAccountDefinition extends BaseClass {

    @When("Enter the username as kskarthickprabu.c3348082a2a2@agentforce.com")
    public void enterUsernameSalesforce() {
        driver.findElement(By.id("username")).sendKeys("kskarthickprabu.c3348082a2a2@agentforce.com");

    }

    @And("Enter the password as $Surabhi@29")
    public void enterPassword() {
        driver.findElement(By.id("password")).sendKeys("$Surabhi@29");
    }

    @When("Click the Login button")
    public void clickLoginButton() {
        driver.findElement(By.id("Login")).click();

    }

    @And("Click Verify button for OTP verification")
    public void verifyOtp() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(By.xpath("//input[@id='save']")).click();
    }

    @Then("User should be loggedin")
    public void verifyLogin() {
        System.out.println("Login successful");
    }

    @When("Click on toggle menu button from the left corner")
    public void clickToggleMenu() {
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
    }

    @And("Click view All")
    public void clickViewAll() {
        driver.findElement(By.xpath("//button[text()='View All']")).click();
    }

    @And("Click on Accounts tab")
    public void clickAccountsTab() {
        WebElement accountsTab = driver.findElement(By.xpath("//a/span[text()='Accounts']"));
        driver.executeScript("arguments[0].click();", accountsTab);
    }

    @And("Click on New button")
    public void clickNewButton() {
        driver.findElement(By.xpath("//div[text()='New']")).click();
    }

    @And("Enter account name as (.*)$")
    public void enterAccountname(String accountName) {
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accountName);
    }

    @And("Select Ownership as Public")
    public void selectOwnership() {
        WebElement ownershipField = driver.findElement(By.xpath("//label[text()='Ownership']//following::button[1]"));
        driver.executeScript("arguments[0].scrollIntoView(true);", ownershipField);
        ownershipField.click();
        driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Public']")).click();
    }

    @And("Click on save")
    public void clickSave() {
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
    }

    @Then("Account should be created")
    public void verifyAccoutCreation() {
        System.out.println("Account is Created");
    }

}
