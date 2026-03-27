package org.testleaf.week4.day1.homeAssignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListInterface {
    /**
     * @param args
     */
    public static void main(String[] args) {

        // Launch the Browser

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");

        // maximize the window
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //click the continue shopping button
        driver.findElement(By.className("a-button-text")).click();
        // enter the 'phone' in the search box
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
        // Click the search button
        
        driver.findElement(By.id("nav-search-submit-button")).click();

        System.out.println();

        // Declare the webelement
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        // Print the size
        int size = priceElements.size();
        System.out.println("The Price list is" +" "+size);  

         // Store prices in Integer list
           List<Integer> priceList = new ArrayList<>();
            for (WebElement ele :priceElements) {

                String text = ele.getText().replace(",", "").trim();
                    // Skip empty or invalid values
                if (!text.isEmpty() && text.matches("\\d+")) {
                    priceList.add(Integer.parseInt(text));
                }
            }

                
            

            // Check if list is not empty
            if (priceList.size() > 0) {

                Collections.sort(priceList);

                System.out.println("Lowest Price: Rs" + priceList.get(0));

            } else {
            System.out.println("No prices found!");
            }
        }
    }


