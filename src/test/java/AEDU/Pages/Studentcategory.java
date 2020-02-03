package AEDU.Pages;

import AEDU.Actions.VerificationClass;
import AEDU.Actions.ActionClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;
import AEDU.Utilities.*;
import java.sql.*;
import java.util.HashMap;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class Studentcategory {
    WebDriver driver;
    ExtentTest extentTest;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"form-username\"]\n"
    )
    private WebElement addusername;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"form-password\"]\n"
    )
    private WebElement addpassword;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/a/span"
    )
    private WebElement sidemenustudentinfomenuclick;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/ul/li[3]/a"
    )
    private WebElement sidemenustudentcatogorymenuclick;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"category\"]"
    )
    private WebElement categoryfeild;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/button"
    )
    private WebElement subtn;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div[1]/div/form/div[2]/button"
    )
    private WebElement savebtn;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div[1]/div/form/div[1]/div[1]"
    )
    private WebElement veryfysave;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div[1]/div/form/div[1]/div/span/p"


    )
    private WebElement Errormsg;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[2]/a[1]"


    )
    private WebElement Editbtn;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div[1]/div/div/h3"


    )
    private WebElement Edipage;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div[1]/div/form/div[1]/div[1]"


    )
    private WebElement updatetext;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[2]/a[2]/i"


    )
    private WebElement Deletecategory;
    @FindBy(
            how = How.XPATH,
            using="/html/body/div[1]/aside/div/section/ul[2]/li[1]/ul/li[4]/a"
    )
    private WebElement promotestudent;

    public Studentcategory(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);
    }

    public void addstudnetcategory(String Catname, String username, String pwd, String catname1, String cat3) throws IOException {

        ActionClass actionClass = new ActionClass(this.driver,extentTest);
        this.addusername.click();
        actionClass.setValueinTextbox(this.addusername, username);
        this.addpassword.click();
        actionClass.setValueinTextbox(this.addpassword, pwd);
        actionClass.clickOnObject(this.subtn);
        actionClass.clickOnObject(this.sidemenustudentinfomenuclick);
        actionClass.clickOnObject(this.sidemenustudentcatogorymenuclick);
        actionClass.clickOnObject(this.categoryfeild);
        actionClass.setValueinTextbox(this.categoryfeild, Catname);
        actionClass.clickOnObject(this.savebtn);
        VerificationClass verifyClass = new VerificationClass(this.driver,extentTest);
        verifyClass.verifyTextPresent(this.veryfysave, "Category added successfully");
        System.out.println("Category added");
//            ActionClass.captureScreen("Successfully added category");
    }

    public void Blankvalidation(String Catname) throws IOException {
        ActionClass actionClass = new ActionClass(this.driver,extentTest);
        actionClass.clickOnObject(this.savebtn);
        VerificationClass verifyClass1 = new VerificationClass(this.driver,extentTest);
        verifyClass1.verifyTextPresent(this.Errormsg, "The Category field is required.");
//                ActionClass.captureScreen("Blank added  category validation");
        System.out.println("Not accepting blank value");
    }

    public void validationforspacevalue(String catname1) throws IOException {
        ActionClass actionClass = new ActionClass(this.driver,extentTest);
        actionClass.clickOnObject(this.categoryfeild);
        actionClass.setValueinTextbox(this.categoryfeild, catname1);
        actionClass.clickOnObject((this.savebtn));
        VerificationClass verifyClass2 = new VerificationClass(this.driver,extentTest);
        verifyClass2.verifyTextPresent(this.Errormsg, "The Category field is required.");
//                ActionClass.captureScreen("value as space validation ");
        System.out.println("Not accepting value as space");
    }

    public void editcategory(String cat3) throws IOException {
        ActionClass actionClass = new ActionClass(this.driver,extentTest);
        actionClass.clickOnObject(this.Editbtn);
        actionClass.clickOnObject(this.categoryfeild);
        VerificationClass verifyClass3 = new VerificationClass(this.driver,extentTest);
        verifyClass3.verifyTextPresent(this.Edipage, "Edit Category");
        actionClass.setValueinTextbox(this.categoryfeild, cat3);
        actionClass.clickOnObject(this.savebtn);
        verifyClass3.verifyTextPresent(this.updatetext, "Category updated successfully");
//                ActionClass.captureScreen("updated category");
        actionClass.clickOnObject(this.Deletecategory);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        List<WebElement> Category = driver.findElements(By.id("DataTables_Table_0_wrapper"));
        for (WebElement nameTitle : Category) {
            String PrintAuthAsc = nameTitle.getText();
            System.out.println("Category is " + PrintAuthAsc);
        }

        }
    }


