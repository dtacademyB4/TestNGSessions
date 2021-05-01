package uiTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo {

   // Data driven testing - running the same test with multiple sets of set of data
   WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(){
        System.setProperty("webdriver.chrome.driver", "/Users/duotech/Documents/drivers/chromedriver");

    }

    @BeforeMethod(alwaysRun = true)   //   // this method will run  before each @Test method this class
    public void setUpMethod(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }


     @Test (dataProvider = "getData")
    public void googleSearch(String searchTerm){

        driver.findElement(By.name("q")).sendKeys(searchTerm + Keys.ENTER);

        String actual = driver.getTitle();

         Assert.assertTrue(actual.contains(searchTerm));

     }


     @DataProvider
     public Object[][] getData(){

        return new Object[][]{
                {"Armani"},
                {"Teşekkürler"},
                {"спасибо"},
                {"спасибо"},
                {"ありがとう"}

        };


     }




     @AfterMethod
     public void tearDown(){
        driver.quit();
     }

}
