package org.testleaf.week5.day2.homeassigment;

import java.io.File;
import java.time.Duration;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

    public static void main(String[] args) throws IOException {

        // Launch the Browser & Load the URL
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Click the continue shopping button
        driver.findElement(By.className("a-button-text")).click();

        // Scroll down to the "Conditions of Use and Sale" section at the bottom of the
        // page using Actions class.

        WebElement scrollActionElement = driver.findElement(By.linkText("Conditions of Use & Sale"));

        // declare the actions call
        Actions act = new Actions(driver);

        // create object to call the methods

        act.scrollToElement(scrollActionElement).perform();

        // Print the text of the Element
        String text = scrollActionElement.getText();
        System.out.println("The located element text is" + " " + text);

        // screenshot of the displayed webpage.

        File src = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/amazon.png");
        FileUtils.copyFile(src, dest);

        // close the browser
        driver.quit();

    }

}
