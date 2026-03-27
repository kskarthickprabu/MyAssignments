package org.testleaf.week4.day2.homeassignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandling {

        public static void main(String[] args) {

                // Login as guest

                ChromeOptions opt = new ChromeOptions();
                opt.addArguments("guest");

                // Launch the Browser

                ChromeDriver driver = new ChromeDriver(opt);

                // Load the URL
                driver.get("http://leaftaps.com/opentaps/control/login");

                // Maximize the Browser

                driver.manage().window().maximize();

                // adding implicit wait

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

                // Enter the User name

                driver.findElement(By.id("username")).sendKeys("DemoCSR");

                // Enter the password

                driver.findElement(By.id("password")).sendKeys("crmsfa");

                // Click Login Button

                driver.findElement(By.className("decorativeSubmit")).click();

                // Click the CRM/SFA link

                driver.findElement(By.linkText("CRM/SFA")).click();

                // click the contacts button

                driver.findElement(By.linkText("Contacts")).click();

                // Click the merge contact tab

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

                WebElement ele = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                (By.linkText("Merge Contacts"))));

                ele.click();
                // getWindowHandle- Retreive the address of current window
                String parentAddress = driver.getWindowHandle();
                System.out.println("Parent window address" + " " + parentAddress);

                // Parent window address A710F40CFCE1A1BE866B039CE095A410

                // Click on the widget of the "From Contact" (xpath: Following sibling)

                // driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();

                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));

                WebElement ele1 = wait1.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                By.xpath("//input[@id='partyIdFrom']/following-sibling::a")));

                ele1.click();

                // getWindowHandles- Retrieve the address of all windows.

                Set<String> allAdd = driver.getWindowHandles();
                System.out.println("All window address" + " " + allAdd);
                // 0 1
                // All window address [A710F40CFCE1A1BE866B039CE095A410,
                // 01424A285005FAC28C0B032FEE97C966]

                // creating empty list and store all the address

                List<String> address = new ArrayList<String>(allAdd);
                System.out.println(address);

                // print the child address

                String childAddress = address.get(1);
                System.out.println("Child address" + " " + childAddress);

                // parent window Title

                String parentTitle = driver.getTitle();
                System.out.println("Parent window Title" + " " + parentTitle);

                // switch to child window using address
                driver.switchTo().window(childAddress);

                // maximize the child window
                driver.manage().window().maximize();

                // Childwindow Title

                String childTitle = driver.getTitle();
                System.out.println("Child page Title" + " " + childTitle);

                // Click on the first resulting contact.

                driver.findElement(By.xpath(
                                "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[text()='DemoCustomer']"))
                                .click();

                // Switch back to parent window
                driver.switchTo().window(parentAddress);

                // Click on the widget of the "To Contact".

                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));

                WebElement ele2 = wait2.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                By.xpath("//input[@id='partyIdTo']/following-sibling::a")));

                ele2.click();

                // get the address of the current window
                String parentWindow2 = driver.getWindowHandle();
                System.out.println("Parent Window2 Address" + " " + parentWindow2);

                // get the address of all windows

                Set<String> alladdress2 = driver.getWindowHandles();
                System.out.println("All window address" + " " + alladdress2);

                // create empty list
                List<String> address2 = new ArrayList<String>(alladdress2);
                System.out.println("Address" + " " + address2);

                String childwindow2 = address2.get(1);
                System.out.println("Child window 2 address" + " " + childwindow2);

                // Switch to child2 window

                driver.switchTo().window(childwindow2);

                // maximize the window

                driver.manage().window().maximize();

                // click the second resulting contact

                driver.findElement(By.xpath(
                                "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[text()='DemoLBCust']"))
                                .click();

                // Switch to parent window
                driver.switchTo().window(parentAddress);

                // click on the merge button

                driver.findElement(By.className("buttonDangerous")).click();

                // Accept the Alert - switch to alert screen

                Alert simpleAlert = driver.switchTo().alert();
                // Accept the alert
                simpleAlert.accept();

                // Switch back to parten page
                driver.switchTo().window(parentAddress);

                // print the Title of the page

                String finalPageTitle = driver.getTitle();
                System.out.println("Final Page Title" + " " + finalPageTitle);

        }

}
