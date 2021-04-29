package uiTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


//@Ignore  prevents this class methods from running
public class AllOrdersPageTests {

    WebDriver driver;

    @BeforeMethod (alwaysRun = true) // always run will make sure that before or after methods will run even with groups
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

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Test (groups = "smoke")
//    @Ignore  prevent this method from running
    public void verifyCheckAllButton(){
        // Click on select all
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));



        // Verify all checkboxes are checked

        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }


    }

    @Test
    public void verifyUncheckAllButton_UI(){
        // Get all checkboxes


        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));



        // Check all of them

        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }

        // Verify uncheck all unchecks all of them

        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();

        checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(! checkbox.isSelected());
        }




    }

    @Test
    public void verifyDeleteSelectedButton(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        String expected = "List of orders is empty. In order to add new order use";

        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_orderMessage")).getText().contains(expected));
    }

    @Test (groups = "smoke")
    public void verifyDeleteSelectedButtonOne(){
        // First grab all checkboxes into a list

        // Store the number of elements
        int before = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        // Delete the first row
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        //  grab all checkboxes into a list
        // Store the number of elements
        int after = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        //Assert that the before and after is n

        Assert.assertTrue(before-after==1);

    }


}
