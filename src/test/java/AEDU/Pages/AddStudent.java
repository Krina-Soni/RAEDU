package AEDU.Pages;

import AEDU.Utilities.DatabaseFunctions;
import AEDU.constants.CommonVar;
import AEDU.Actions.VerificationClass;
import AEDU.Actions.ActionClass;
import AEDU.Pages.StudentInformation;
import com.aventstack.extentreports.ExtentTest;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddStudent{
    WebDriver driver;
    ExtentTest extentTest;
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"form-username\"]\n")
    private WebElement username;
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"form-password\"]\n"
    )
    private WebElement password1;
    @FindBy(how = How.XPATH,
            using = "/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/button"
    )
    private WebElement submitbtn;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/a/span"
    )
    private WebElement sidemenustudentinfomenuclick;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/ul/li[2]/a"
    )
    private WebElement SidemenuStudentAddmissionclick;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[1]/h4"
    )
    private WebElement VerifyStudentAddmissionTitle;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[4]/button"
    )
    private WebElement Savebtn;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[1]/div/div[1]/div[1]/div/span/p"
    )
    private WebElement Addmissionfeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[1]/div/div[1]/div[3]/div/span/p"
    )
    private WebElement Classfeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[1]/div/div[1]/div[4]/div/span/p"
    )
    private WebElement Sectionfeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[1]/div/div[2]/div[1]/div/span/p"
    )
    private WebElement Fristnamefeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[2]/div/div[1]/div[1]/div/span/p"
    )
    private WebElement FatherNamefeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[2]/div/div[1]/div[2]/div/span/p"
    )
    private WebElement FatherPhonevalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[2]/div/div[6]/div[1]/div[1]/div[1]/div/span/p"
    )
    private WebElement GardianNamefeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[2]/div/div[6]/div[1]/div[2]/div[1]/div/span/p"
    )
    private WebElement Gardianphonefeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[1]/div/div[2]/div[3]/div/span/p"
    )
    private WebElement Genderfeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/ul/li[5]/a"
    )
    private WebElement Trasfercertificate;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"admission_no\"]"
    )
    private WebElement Addmissionnumber;
    //*[@id="class_id"]
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_id\"]"
    )
    private WebElement SelectClassfeild;
    //*[@id="class_id"]/option[2]
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_id\"]/option[2]"
    )
    private WebElement SelectClassOption;







    public AddStudent(WebDriver driver,ExtentTest test){
        this.driver = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);

    }
    public void AddStudent(String username1,String pwd)throws IOException,InterruptedException {
        ActionClass actionClass = new ActionClass(driver, extentTest);
        actionClass.clickOnObject(username);
        actionClass.setValueinTextbox(this.username, username1);
        actionClass.clickOnObject(password1);
        actionClass.setValueinTextbox(this.password1, pwd);
        actionClass.clickOnObject(this.submitbtn);
        actionClass.clickOnObject(this.sidemenustudentinfomenuclick);
        actionClass.clickOnObject(this.SidemenuStudentAddmissionclick);
        VerificationClass verificationClass = new VerificationClass(this.driver, extentTest);
        verificationClass.verifyTextPresent(this.VerifyStudentAddmissionTitle, "Student Admission");

    }
    public void VeryFeildValidation()throws IOException,InterruptedException{
        ActionClass actionClass=new ActionClass(driver,extentTest);
        actionClass.clickOnObject(this.sidemenustudentinfomenuclick);
        Thread.sleep(3000);
        actionClass.clickOnObject(this.SidemenuStudentAddmissionclick);
        JavascriptExecutor jsetaskscore = (JavascriptExecutor) driver;
        jsetaskscore.executeScript("scrollBy(0, 500)");
        actionClass.clickOnObject(this.Savebtn);
        VerificationClass verificationClass=new VerificationClass(this.driver,extentTest);
        verificationClass.verifyTextPresent(this.Addmissionfeildvalidation,"The Admission No. field is required.");
        verificationClass.verifyTextPresent(this.Sectionfeildvalidation,"The Class field is required.");
        verificationClass.verifyTextPresent(this.Fristnamefeildvalidation,"The First Name field is required.");
        verificationClass.verifyTextPresent(this.Genderfeildvalidation,"The Gender field is required.");
        verificationClass.verifyTextPresent(this.FatherNamefeildvalidation,"The Father Name field is required.");
        verificationClass.verifyTextPresent(this.FatherPhonevalidation,"The Father Phone field is required.");
        verificationClass.verifyTextPresent(this.GardianNamefeildvalidation,"The Guardian Name field is required.");
        verificationClass.verifyTextPresent(this.Gardianphonefeildvalidation,"The Guardian Phone field is required.");


    }
    public void SetudentAddmissionform(String Addmissionnb)throws IOException ,InterruptedException{
        ActionClass actionClass=new ActionClass(driver,extentTest);
        actionClass.clickOnObject(this.sidemenustudentinfomenuclick);
        Thread.sleep(3000);
        actionClass.clickOnObject(this.SidemenuStudentAddmissionclick);
        actionClass.setValueinTextbox(this.Addmissionnumber,Addmissionnb);
        actionClass.clickOnObject(this.SelectClassfeild);
        actionClass.clickOnObject(this.SelectClassOption);

    }
}

