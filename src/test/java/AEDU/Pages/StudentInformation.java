package AEDU.Pages;

import AEDU.constants.CommonVar;
import AEDU.Actions.VerificationClass;
import AEDU.Actions.ActionClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static AEDU.Reports.ReportClass.extent;

public class StudentInformation {
    WebDriver driver;
    ExtentTest extentTest;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/button")
    private WebElement btn_submit;

    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/div[1]/span/p\n"
    )
    private WebElement Vldusername;

    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/div[2]/span/p\n"
    )
    private WebElement vldpassword;

    @FindBy(
            how = How.ID,
            using = "form-username"
    )
    private WebElement username1;

    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div/div/div[2]/div/div/div[2]/div\n"
    )
    private WebElement Msginvalidforusername;

    @FindBy(
            how = How.NAME,
            using = "password"
    )
    private WebElement Fieldpassword;

    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/header/div[1]/nav/div[2]/div/div[1]/ul/li/a"
    )
    private WebElement NEXTPAGETITLE;


    public StudentInformation(WebDriver driver, ExtentTest test) {

        this.driver = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);

    }
    public void StudentInformation() throws InterruptedException, IOException {
        ActionClass actionClass = new ActionClass(driver,extentTest);
        System.out.println("hello");
        actionClass.clickOnObject(btn_submit);
        VerificationClass verifyClass = new VerificationClass(driver,extentTest);
        verifyClass.verifyTextPresent(this.Vldusername, "The Username field is required." );
        verifyClass.verifyTextPresent(this.vldpassword, "The Password field is required." );
        Thread.sleep(5000);
        actionClass.captureScreen("Check if both the fields are mandatory or not");
    }
    public void loginWithCredentials(String username, String password) throws InterruptedException, IOException {
        ActionClass actionclass = new ActionClass(driver,extentTest);
        actionclass.clickOnObject(username1);
        actionclass.setValueinTextbox(this.username1, username);
        this.Fieldpassword.click();
        actionclass.setValueinTextbox(this.Fieldpassword, password);
        actionclass.clickOnObject(this.btn_submit);
        VerificationClass verifyClass = new VerificationClass(driver,extentTest);
        verifyClass.verifyTextPresent(this.Msginvalidforusername, "Invalid Username or Password");
        System.out.println("entered invalid credentials");
        Thread.sleep(5000);
        actionclass.captureScreen("Checked with an Invalid Email");

    }
    public void loginWithCredentials1(String username, String password) throws InterruptedException, IOException {
        ActionClass actionclass = new ActionClass(driver,extentTest);
        this.username1.click();
        actionclass.setValueinTextbox(this.username1, username);
        this.Fieldpassword.click();
        actionclass.setValueinTextbox(this.Fieldpassword, password);
        actionclass.clickOnObject(this.btn_submit);
        VerificationClass verifyClass = new VerificationClass(driver,extentTest);
        verifyClass.verifyTextPresent(this.Msginvalidforusername, "Invalid Username or Password");
        System.out.println("entered invalid credentials");
        Thread.sleep(5000);
        actionclass.captureScreen("Checked with an Invalid Email");

    }
    public void loginWithCredentials2(String username, String password ) throws InterruptedException, IOException {
        ActionClass actionclass = new ActionClass(driver,extentTest);
        actionclass.clickOnObject(username1);
        actionclass.setValueinTextbox(this.username1, username);
        actionclass.clickOnObject(Fieldpassword);
        actionclass.setValueinTextbox(this.Fieldpassword, password);
        actionclass.clickOnObject(this.btn_submit);
        VerificationClass verifyClass = new VerificationClass(driver,extentTest);
        verifyClass.verifyTextPresent(this.NEXTPAGETITLE, "Admin");
        System.out.println("entered Valid credentials");
        Thread.sleep(5000);
        actionclass.captureScreen("Checked with a valid Credentials");

    }}