package uiTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SoftAssertVsHardAssert {
    WebDriver driver;

    @BeforeMethod
    public void setup(){  // setup actions are preparing the driver and logging in to the app
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nuclues\\Documents\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }




    @Test
    public void verifyProductDetails(){
        driver.findElement(By.linkText("View all products")).click();

        List<String> expectedProducts = Arrays.asList("MyMoney", "FamilyAlbum", "ScreenSave");
        List<String> expectedPrices = Arrays.asList("$100", "$80", "$20");
        List<String> expectedDiscounts = Arrays.asList("8%", "15%", "10%");


        List<WebElement> products = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td[1]"));



        List<String> actualProducts = new ArrayList<>();

        for (WebElement product : products) {
            actualProducts.add(product.getText());


        }

         SoftAssert softAssert = new SoftAssert();

       softAssert.assertEquals(actualProducts, expectedProducts); // Hard Assertions -

        System.out.println("First Assert");


        List<WebElement> prices = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td[2]"));

        List<String> actualPrices = new ArrayList<>();

        for (WebElement price : prices) {
            actualPrices.add(price.getText());
        }

        softAssert.assertEquals(actualPrices, expectedPrices);
        System.out.println("Second Assert");
        List<WebElement> discounts = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td[3]"));

        List<String> actualDiscounts = new ArrayList<>();

        for (WebElement discount : discounts) {
            actualDiscounts.add(discount.getText());
        }

        softAssert.assertEquals(actualDiscounts, expectedDiscounts);
        System.out.println("Third Assert");



      softAssert.assertAll();


    }



}
