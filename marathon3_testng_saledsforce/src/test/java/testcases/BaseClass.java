package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static ChromeDriver driver;
    public WebDriverWait wait;

    @Parameters({ "url", "username", "password" })
    @BeforeMethod
    public void preConditions(String url, String uName, String pWord) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Login
        driver.findElement(By.id("username")).sendKeys(uName);
        driver.findElement(By.id("password")).sendKeys(pWord);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Login"))).click();

        // Wait for OTP manually
        Thread.sleep(20000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save"))).click();

        // Open App Launcher
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();

        // View All
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='View All']"))).click();

        // Click Sales option

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement saleElement = wait3.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and more']")));
        Actions op = new Actions(driver);
        op.moveToElement(saleElement).perform();
        saleElement.click();

        // click the opportunity tab
        Thread.sleep(3000);
        WebElement opportunities = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[@href='/lightning/o/Opportunity/home']")));
        opportunities.click();
    }

    @AfterMethod
    public void postConditions() {
        driver.quit();
    }
}
