package uiTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ParametrizedTests {


    WebDriver driver;

    @BeforeClass(alwaysRun = true)   // this method will run only once before everything else in this class
    /// any logic that you must execute only once before everything in the class
    public void setUpClass(){
        System.setProperty("webdriver.chrome.driver", "/Users/duotech/Documents/drivers/chromedriver");

    }

    @BeforeMethod(alwaysRun = true)   //   // this method will run  before each @Test method this class
    public void setUpMethod(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }



    @Test
    @Parameters ({"url", "username", "password"})
    public void positiveLogin(String link, String usrName, String pass){

        driver.get(link);

        // Enter the correct credentials
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(usrName);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(pass);
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        // Verify that the login was successful
        String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
        assertEquals(driver.getCurrentUrl(), expectedURL);

    }
}
