package testNG.marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataClipTesting {

    public static void main(String[] args) throws InterruptedException, IOException {

        // Initialize the driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);

        // Load the URL
        driver.get("https://www.tatacliq.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // MouseHover on Brands
        WebElement brands = driver.findElement(By.xpath("//div[text()='Brands']"));
        Actions action = new Actions(driver);
        action.moveToElement(brands).perform();

        // MouseHover on 'Watches & Accessories'
        WebElement watches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
        action.moveToElement(watches).perform();

        // Choose the first option from the'Featured brands'
        WebElement firstOption = driver
                .findElement(By.xpath("//div[text()='Featured brands']/following-sibling::div[1]"));
        firstOption.click();

        // Wait added to load the page after clicking first option
        //Thread.sleep(1000);

        // Select sortby: New Arrivals
        WebElement sortByDropdown = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
        Select newArrivalsOption = new Select(sortByDropdown);
        newArrivalsOption.selectByIndex(3);

        // choose men from catagories filter
        driver.findElement(By.xpath("//div[text()='Men']/preceding-sibling::div")).click();

        Thread.sleep(3000);

        // print all price of watches
        List<WebElement> allWatchesPrices = driver
                .findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));
        int size = allWatchesPrices.size();
        System.out.println("Size is : "+size);

        List<Integer> priceList = new ArrayList<>();

        // Iterate the list of webelemnts and get the price values and store as int
        // values in list priceList
        for (int i = 0; i < size; i++) {
            try {
                String price = allWatchesPrices.get(i).getText().replaceAll("[^0-9]", "");
                int priceValue = Integer.parseInt(price);
                priceList.add(priceValue);
            } catch (NumberFormatException e) {

            }

        }

        System.out.println(priceList);
        int firstPrice = priceList.get(0);
        System.out.println("First Price value in the list is : " + firstPrice);

        //Thread.sleep(1000);
        // click on the first resulting watch
        //driver.findElement(By.xpath("(//div[contains(@class ,'ProductDescription')])[1]")).click();;
        WebElement firstWatch= driver.findElement(By.xpath("//div[@class='ProductModule__flagHolder']"));
        driver.executeScript("arguments[0].click();", firstWatch);

        // switch to child window
        Set<String> allAddress = driver.getWindowHandles();

        List<String> address = new ArrayList<String>(allAddress);
        String childWindow = address.get(1);
        driver.switchTo().window(childWindow);

        // compare two price are similar
        WebElement priceofFirst = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3"));
        String priceOfFirtWatch = priceofFirst.getText().replaceAll("[^0-9]", "");
        int priceValueofFirstWatch = Integer.parseInt(priceOfFirtWatch);
        System.out.println("priceValueofFirstWatch is : "+priceValueofFirstWatch);

        if (firstPrice == priceValueofFirstWatch) {
            System.out.println("Two prices are similar");
        } else
            System.out.println("Two prices are DIFFERENT");

        // click Add to cart
        driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();

        // Get count from the cart icon
        WebElement cartIcon = driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']/span"));
        String countOfItemsInCart = cartIcon.getText();
        System.out.println("Count of Items in the Cart : " + countOfItemsInCart);

        //Click on the cart
        cartIcon.click();
        Thread.sleep(3000);

       // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:/SeleniumLearning/screenshots/cart.png");
        
        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot taken");


        //Close All the opened windows one by one.
        driver.close();

        //Move to parent window and close it
        String parentWindow = address.get(0);
        driver.switchTo().window(parentWindow);
        driver.close();

        

    }

}


