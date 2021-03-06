package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
// login tests are maintaned here.
// without Page Object approach
public class LogInTests {
    WebDriver driver;

//    /
//    /
//    /
//    /
//    /
//    /

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void logInTest1(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);

        Assert.assertEquals(driver.getTitle(),"Web Orders");

    }

    @Test
    public void NagitivelogInTest1(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("tester2");

        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);

        Assert.assertEquals(driver.findElement(By.id("ctl00_MainContent_status")).getText(),"Invalid Login or Password.");

    }
    @Test
    public void logOut(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
        driver.findElement(By.id("ctl00_logout")).click();
        Assert.assertEquals(driver.getTitle(),"Web Orders Login" );
    }
  @Test
    public void logInTest2(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);

        Assert.assertEquals(driver.getTitle(),"Web Orders");

    }
    @AfterMethod
    public void logOutTest(){
        driver.close();
    }
}
