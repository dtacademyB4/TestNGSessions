package uiTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CrossBrowserTest {


    // 1. create an xml file



    WebDriver driver;


    @BeforeMethod
    @Parameters ("browser")
    public void setUpMethod(String browser){
        switch (browser){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", "/Users/duotech/Documents/drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", "/Users/duotech/Documents/drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "edge" :
                System.setProperty("webdriver.edge.driver", "/Users/duotech/Documents/drivers/msedgedriver");
                driver = new EdgeDriver();
                break;
            case "opera" :
                System.setProperty("webdriver.opera.driver", "/Users/duotech/Documents/drivers/operadriver");
                driver = new OperaDriver();
                break;

            case "safari" :
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Invalid browser");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    }



    @Test
    public void positiveLogin(){

        // Enter the correct credentials
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        // Verify that the login was successful
        String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
        assertEquals(driver.getCurrentUrl(), expectedURL);

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
