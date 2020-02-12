package AEDU.Testcases;
import AEDU.constants.CommonVar;
import org.junit.Before;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import AEDU.Reports.ReportClass;
import java.sql.SQLException;

public class Basecase extends ReportClass {

    public static WebDriver driver;

    /*
 Below method will execute before each testcase.
     */
    @Before
    public void initialize() throws SQLException {
        System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") + "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("headless");

        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe" );
        driver = new ChromeDriver(options);
        //driver.get("http://toolsqa.com/automation-practice-form/");
        //driver.get("http://toolsqa.com/automation-practice-table/");
        //driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
        CommonVar common = new CommonVar();
        driver.get(common.url);
        driver.manage().window().maximize();
    }


    /*
 Below method will execute after each testcase.
     */
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
