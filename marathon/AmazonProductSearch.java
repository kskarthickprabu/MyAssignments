package org.testleaf.week3.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductSearch {

    public static void main(String[] args) throws InterruptedException {

        // Launch the Browser & Load the URL
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Click the continue shopping button
        driver.findElement(By.className("a-button-text")).click();

        // Enter the "Bags for boys" in the search box

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");

        // click the search button

        driver.findElement(By.id("nav-search-submit-button")).click();

        // Capture and print the total number of search results displayed
        String text = driver.findElement(By.xpath("//span[contains(text(),'results')]")).getText();
        System.out.println(text + " " + "Searched Product");

        // Select the first two brands from the left-side filter menu

        driver.findElement(By.xpath(
                "//a[@aria-label='Apply the filter Skybags to narrow results']//i[@class='a-icon a-icon-checkbox']"))
                .click();

        driver.findElement(By.xpath(
                "//a[@aria-label='Apply the filter Safari to narrow results']//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']"))
                .click();

        // Apply sorting by selecting "New Arrivals"
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]")).click();
        driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();

        //Capture and print the first product details (name and discounted price)
        String productName = driver.findElement(By.xpath("//span[text()='Aero Pro 38L Casual Backpack for Boys & Girls with 3 Compartments & Adjustable Strap | Insulated Tiffin Pouch | Rain Cover | Aer-Zone Back Panel | Perfect for School & Travel - Unisex']")).getText();
        System.out.println("Name of the Product is"+" "+productName);

        String dicountPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
        System.out.println("Dicount Price of the Product is Rs"+" "+dicountPrice);

        //Capture and print the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page Title is"+" "+pageTitle);

        //close the browser

        driver.quit();



    }

}
