package org.testleaf.week5.day1.homeassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebTrailEtrain {

    public static void main(String[] args) {
        // Launch the Browser
        ChromeDriver driver = new ChromeDriver();

        // Load the URL
        driver.get("https://erail.in/");
        // Maximize the Browser window
        driver.manage().window().maximize();
        // Add an implicit wait to ensure the webpage elements are fully loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Clear the value present in the From Station field
        driver.findElement(By.id("txtStationFrom")).clear();
        // Enter the From station value
        driver.findElement(By.id("txtStationFrom")).sendKeys("MAS");

        // select the particular Train name for From Station
        driver.findElement(By.xpath("//div[text()='Mgr Chennai Ctr']")).click();

        // Clear the value present in the To Station field
        driver.findElement(By.id("txtStationTo")).clear();
        // Enter the To Station Value
        driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
        // select the particular Train name for To Station
        driver.findElement(By.xpath("//div[text()='Madurai Jn']")).click();

        // Uncheck the "Sort on Date" checkbox.
        driver.findElement(By.id("chkSelectDateOnly")).click();
        // Retrieve the train names from the web table.

        // Count the no of column for the 3rd row
        List<WebElement> trainsList = driver
                .findElements(By.xpath("//div[@id='divTrainsList']/table/tbody/tr/td[2]"));
        int column2Count = trainsList.size();

        System.out.println("Total no of trains" + " " + column2Count);

        // Retrieve all the data of column 2 from the table
        List<String> trainName = new ArrayList<>();

        for (WebElement train : trainsList) {
            String name = train.getText();

            trainName.add(name);
        }

        // convert the list to set

        Set<String> uniqueNames = new HashSet<>(trainName);

        // compare size

        if (trainName.size() == uniqueNames.size()) {
            System.out.println("No duplicate train names");
        } else {
            System.out.println("Duplicate train names found");
        }

        driver.quit();

    }
}
