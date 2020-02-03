package AEDU.Pages;

import AEDU.constants.CommonVar;
import AEDU.Actions.VerificationClass;
import AEDU.Actions.ActionClass;
import AEDU.Pages.StudentInformation;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class PromoteStudent {
    WebDriver driver;
    ExtentTest extentTest;


    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"form-username\"]"
    )
    private WebElement addusername;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"form-password\"]\n"
    )
    private WebElement passwodfeild;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/button"
    )
    private WebElement subtn;
    @FindBy(
            how = How.XPATH,
            using="/html/body/div[1]/aside/div/section/ul[2]/li[1]/a/span"
    )
    private WebElement sidemenuclick;
    @FindBy(
            how = How.XPATH,
            using="/html/body/div[1]/aside/div/section/ul[2]/li[1]/ul/li[4]/a"
    )
    private WebElement promotestudent;
    @FindBy(
            how = How.XPATH,
            using="html/body/div[1]/div[1]/section[1]/h1"
    )
    private WebElement titlematch;



    public PromoteStudent(WebDriver driver, ExtentTest test) {
        this.driver = driver;
//        this.extentTest = test;
        PageFactory.initElements(driver, this);
    }

//        public void promote1(String username,String password1)throws IOException {
//            ActionClass actionClass = new ActionClass(this.driver, extentTest);
//            this.addusername.click();
//            actionClass.setValueinTextbox(this.addusername, username);
//            this.passwodfeild.click();



        public void serchforpromote(String username,String password)throws IOException{
            ActionClass actionClass=new ActionClass(this.driver,extentTest);
            this.addusername.click();
         actionClass.setValueinTextbox(this.addusername, username);
            this.passwodfeild.click();
            this.subtn.click();
            this.sidemenuclick.click();
            this.promotestudent.click();
            VerificationClass verifyClass = new VerificationClass(this.driver,extentTest);
            verifyClass.verifyTextPresent(this.titlematch, " Student Information ");

        }


    }
