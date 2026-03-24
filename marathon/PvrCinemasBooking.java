package org.testleaf.week3.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PvrCinemasBooking {

    public static void main(String[] args) throws InterruptedException {
        // Launch the Browser & Load the URL
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.pvrcinemas.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Select location as Chennai if not auto-detected

        driver.findElement(By.className("p-dropdown-trigger")).click();// select the DropDown
        Thread.sleep(3000);
        // Click the Chennai image
        driver.findElement(By.xpath(
                "//div[@class='p-sidebar-mask p-component-overlay p-component-overlay-enter p-sidebar-mask-scrollblocker p-sidebar-visible p-sidebar-right']//div[7]//div[1]//div[1]"))
                .click();
        // Click on Cinema under Quick Book
        driver.findElement(By.xpath("//span[@class='cinemas-inactive']")).click();
        // select the cinemas

        driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
        // Select the Drop down value(1st value)- Parent to 1st child
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@class='p-dropdown-items']/li")).click();

        // Select date as Tomorrow-22/03/2026 (2nd Value)- Parent to 2nd child

        driver.findElement(By.xpath("//span[text()='Select Date']"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@class='p-dropdown-items']/li[2]")).click();
        // Select a Movie

        driver.findElement(By.xpath("//span[text()='Select Movie']"));
        Thread.sleep(3000);
        // select the 5th value-Parent to 5th child
        driver.findElement(By.xpath("//ul[@class='p-dropdown-items']/li[3]")).click();

        // Select Time- 1st value
        driver.findElement(By.xpath("//span[text()='Select Timing']"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@class='p-dropdown-items']/li")).click();

        // click book button
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@class='p-button p-component sc-hjsuWn kDwaXw bgColor filter-btn']"))
                .click();

        // Accept the Terms and condition

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='sc-kCuUfV iBvycX reject-terms']")).click();

        // Select any one available seats
        driver.findElement(By.className("seat-current-pvr")).click();

        // Click Proceed button

        driver.findElement(By.xpath("//button[@class='sc-bbbBoY kbsOBB btn-proceeded']")).click();

        // Capture and print Seat info from Booking Summary
        String seatNumber = driver.findElement(By.xpath("//div[@class='seat-number']")).getText();
        System.out.println("Booking Seat Number" + " " + seatNumber);

        // Capture and print Grand Total from Booking Summary
        Thread.sleep(3000);
        // xpath grandparent to grandchild
        String grandTotal = driver.findElement(By.xpath("//div[@class='all-grand']/div/h6/span")).getText();
        System.out.println("Grand Total Amount" + " " + "Rs" + grandTotal);

        // click on continue Button

        driver.findElement(By.xpath("//button[@class='fb-added-btndesk']")).click();

        // Capture and print current page title

        String title = driver.getTitle(); // Get the page title
        System.out.println("Page title is: " + title);
        // close the browser
        driver.quit();

    }

}
