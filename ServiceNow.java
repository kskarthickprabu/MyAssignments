package testNG.marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.sukgu.Shadow;

public class ServiceNow {

    public static void main(String[] args) throws InterruptedException, IOException {
        // Guest mode & Launch the chrome Browser
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("guest");
        WebDriver driver = new ChromeDriver(opt);
        // Enter the URl
        driver.get("https://dev376222.service-now.com/login.do?");
        // maximize the browser window
        driver.manage().window().maximize();
        // adding implicitwait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Enter User name & Password
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("k%2A0Z/cyUsU");
        // click Login Button
        driver.findElement(By.id("sysverb_login")).click();
        // Click All under the shadow root
        Shadow shadow = new Shadow(driver);
        shadow.setImplicitWait(10);
        shadow.findElementByXPath("//div[text()='All']").click();
        // Click the Service Catalog option
        WebElement filter = shadow.findElementByXPath("//input[@placeholder='Filter']");
        filter.sendKeys("Service Catalog");
        shadow.findElementByXPath("//span[text()='Service Catalog']").click();

        // Click Mobile- This is inside a frame and that frame again inside the shadow root
        // locating the iframe element
        WebElement iframe = shadow.findElementByXPath("//iframe[@title='Main Content']");
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement mobiles = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(text(),'Mobiles')]")));

        mobiles.click();

        // Click the iphone 13 pro
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iphone13Pro = wait1.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//strong[contains(text(),'Apple iPhone 13 pro')]")));
        iphone13Pro.click();

        // Select Yes for lost/broken
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='Yes']")).click();

        // Enter phone number
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']"))
                .sendKeys("99");

        // Select Unlimited Data
        WebElement dropdown = driver.findElement(By.xpath("//select[contains(@class,'form-control')]"));
        dropdown.sendKeys("Unlimited");

        // Select Color & Storage
        driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'512')]")).click();

        // Order Now
        Thread.sleep(1000);
        driver.findElement(By.id("oi_order_now_button")).click();

        // Verify order & get request number
        WebElement req = driver.findElement(By.xpath("//a[@id='requesturl']"));
        System.out.println("Request Number: " + req.getText());
        Thread.sleep(3000);

        // Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:/SeleniumLearning/screenshots/OrderPlaced.png");
        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot captured");

        //close the Browser
        driver.quit();
    }

}
