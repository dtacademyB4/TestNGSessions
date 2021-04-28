package testPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGDemo {






    @Test
    public void test1(){

        // Go to google.com

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nuclues\\Documents\\Selenium\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();



        driver.get("https://google.com");
        // Search for high heel shoes
        String expected = "High Heel Shoes";
        driver.findElement(By.name("q")).sendKeys(expected + Keys.ENTER);

        // Verify that high heel shoes is a part of the results page title
        String resultsPageTitle = driver.getTitle();

        Assert.assertTrue(resultsPageTitle.contains(expected));

//        System.out.println("Testing TestNG");
    }


    @Test
    public void test2(){
        Assert.assertTrue(false);
        Assert.assertFalse(true);
        Assert.assertEquals("java", "avaj");




    }
}
