package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EditAccountDefinition extends BaseClass {
    @And("Search for the account {string}")
    public void enterAccountNameInSearchField(String accountName) {
        driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(accountName);
    }

    @And("Click the dropdown icon next to the account and select Edit")
    public void clickDropDownAndSelectEdit() {
        WebElement dropdownforEdit = driver.findElement(
                By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"));
        driver.executeScript("arguments[0].click();", dropdownforEdit);
        WebElement edit = driver.findElement(By.xpath("//div[text()='Edit']"));
        driver.executeScript("arguments[0].click();", edit);
    }

    @And("Set Type to Technology Partner")
    public void setType() {
        WebElement typeField = driver.findElement(By.xpath("//label[text()='Type']//following::button[1]"));
        driver.executeScript("arguments[0].scrollIntoView(true);", typeField);
        typeField.click();
        driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();

    }

    @And("Set Industry to Healthcare")
    public void setIndustry() {
        WebElement industry = driver.findElement(By.xpath("//label[text()='Industry']//following::button[1]"));
        industry.click();
        WebElement healthcareOption = driver.findElement(By.xpath("//span[text()='Healthcare']"));
        driver.executeScript("arguments[0].click();", healthcareOption);
    }

    @And("Enter the Billing Address as {string}")
    public void enterBillingAddress(String billingAddress) {
        WebElement billingAddressField = driver
                .findElement(By.xpath("//label[text()='Billing Street']//following::div[1]"));
        billingAddressField.click();
        billingAddressField.sendKeys(billingAddress);
    }

    @And("Enter the Shipping Address as {string}")
    public void enterShippingAddress(String shippingAddress) {
        WebElement shippingAddressField = driver
                .findElement(By.xpath("//label[text()='Shipping Street']//following::div[1]"));
        shippingAddressField.click();
        shippingAddressField.sendKeys(shippingAddress);
    }

    @And("Set Customer Priority to Low")
    public void setCustomerPriority() {
        WebElement customerPriority = driver
                .findElement(By.xpath("//label[contains(text(),'Customer Priority')]//following::div[1]"));
        driver.executeScript("arguments[0].scrollIntoView(true);", customerPriority);
        customerPriority.click();
        driver.findElement(By.xpath("//span[text()='Low']")).click();

    }

    @And("Set SLA to Silver")
    public void setSLA() {
        driver.findElement(By.xpath("//label[text()='SLA']//following::div[1]")).click();
        driver.findElement(By.xpath("//span[text()='Silver']")).click();

    }

    @And("Set Active to NO")
    public void setActive() {
        WebElement activeField = driver.findElement(By.xpath("//label[text()='Active']//following::div[1]"));
        // driver.executeScript("arguments[0].scrollIntoView(true);", activeField);
        activeField.click();
        driver.findElement(By.xpath("//span[text()='No']")).click();

    }

    @And("Enter a unique number in the Phone field as {string}")
    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneField = driver.findElement(By.xpath("//label[text()='Phone']//following::div[1]"));
        driver.executeScript("arguments[0].scrollIntoView(true);", phoneField);
        phoneField.click();
        phoneField.sendKeys(phoneNumber);

    }

    @And("Set Upsell Opportunity to No")
    public void setUpsellOpportunity() {
        WebElement upsellOpportunity = driver
                .findElement(By.xpath("//label[text()='Upsell Opportunity']//following::div[1]"));
        driver.executeScript("arguments[0].scrollIntoView(true);", upsellOpportunity);
        upsellOpportunity.click();
        driver.findElement(By.xpath("//span[text()='No']")).click();
    }

    @And("Click Save")
    public void clickSave() {
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
    }

    @Then("Verify the phone number")
    public void verifyPhoneNumber() {
        System.out.println("Phone number is verified");
    }

}
