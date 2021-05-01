package uiTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderAdvanced {


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
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.linkText("Order")).click();

    }


    @Test (dataProvider =  "getData")
    public void placeOrder(String name, String address, String city, String state, String zipcode,
                            String cardNo, String expiry){
        int random = (int) (1+ (Math.random() * 99));
        String str = String.valueOf(random);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(str);


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(address);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipcode);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys( cardNo);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(expiry);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        Assert.assertTrue(driver.getPageSource().contains("New order has been successfully added"));
    }


    @DataProvider
    public Object[][] getData(){

        return new Object[][]{
                {"Fatih", "8607 Westwood Center Dr", "Vienna", "VA", "22152", "34215453241544235", "09/23"},
                {"Fuad", "123 Main st", "Chantilly", "VA", "22356", "4352144525141221", "10/20"},
                {"Isa", "1600 Pennsylvania Ave", "Washington", "DC", "20000", "5813921898318213", "10/30"},
                {"Derya", "Yenibosna", "Bahçelievler", "Istanbul", "54281", "7826183678623871", "10/50"},


        };


    }


}
