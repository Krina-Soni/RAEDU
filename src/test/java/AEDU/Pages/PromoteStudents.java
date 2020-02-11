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


public class PromoteStudents {
    WebDriver driver1;
    ExtentTest extentTest;
    Connection conn = null;
    //Docker
//    String url = "jdbc:mysql://localhost:6603/";
    //localDB
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "aedu-dev1";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "";
    Statement statement;
    ResultSet queryRs;
    ResultSet Qcount;

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
            using = "//*[@id=\"sibe-box\"]/ul[2]/li[1]/ul/li[4]/a"
    )
    private WebElement PromoteStudentMenu;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"sibe-box\"]/ul[2]/li[1]/ul/li[1]/a"
    )
    private WebElement ClickOnStudentDetails;

    @FindBy(
            how = How.NAME,
            using = "class_id"
    )
    private WebElement classfeild;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_id\"]"
    )
    private WebElement sectionfeild;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div[2]/button"
    )
    private WebElement searchbtn;
    @FindBy(
            how = How.XPATH,
            using = " /html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div/div[1]/div/span/p"
    )
    private WebElement classfeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div/div[2]/div/span/p"
    )
    private WebElement sectionfeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/a/span"
    )
    private WebElement ClickOnStudentInformation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/ul/li[4]/a"
    )
    private WebElement ClickOnPromoteStudent;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_id\"]/option[7]"
    )
    private WebElement selectoption;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_id\"]/option[2]"
    )
    private WebElement selectoptionforsection;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"session_id\"]"
    )
    private WebElement Promoteinsessionclcik;
    //*[@id="session_id"]/option[3]
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"session_id\"]/option[3]"
    )
    private WebElement SelectSession;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_promote_id\"]"
    )
    private WebElement PromoteClass;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_promote_id\"]"
    )
    private WebElement PromoteSession;
    //*[@id="class_promote_id"]/option[7]
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_promote_id\"]/option[7]"
    )
    private WebElement SelectclassforPromote;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_promote_id\"]/option[3]"
    )
    private WebElement SelectsectionforPromote;

    @FindBy(
            how = How.XPATH,
            using = " /html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[3]/a"
    )
    private WebElement Promotebtn;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr[2]/td"
    )
    private WebElement Nodatabehavormatch;





    public PromoteStudents(WebDriver driver, ExtentTest test) {

        this.driver1 = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);

    }

    public void Promote(String username1, String pwd) throws IOException {

        ActionClass actionClass = new ActionClass(driver1, extentTest);
        actionClass.clickOnObject(username);
        actionClass.setValueinTextbox(this.username, username1);
        actionClass.clickOnObject(password1);
        actionClass.setValueinTextbox(this.password1, pwd);
        actionClass.clickOnObject(this.submitbtn);
        actionClass.clickOnObject(this.sidemenustudentinfomenuclick);
//        driver.get("https://dev1.aedu.co.in/admin/stdtransfer/index");

    }

    public void validation(String add1) throws IOException, InterruptedException {
        driver1.get("https://dev1.aedu.co.in/admin/stdtransfer/index");
        ActionClass actionClass5 = new ActionClass(driver1, extentTest);
        actionClass5.clickOnObject(searchbtn);
        ActionClass actionClass = new ActionClass(this.driver1, extentTest);
        actionClass.clickOnObject(this.ClickOnStudentInformation);
        Thread.sleep(3000);
        actionClass.clickOnObject(this.ClickOnPromoteStudent);
        actionClass.clickOnObject(this.searchbtn);
        VerificationClass very = new VerificationClass(driver1, extentTest);
        very.verifyTextPresent(this.classfeildvalidation, "The Class field is required.");
        very.verifyTextPresent(this.sectionfeildvalidation, "The Section field is required.");
        //section feild validation
    }

    public void feildvalidations() throws IOException, IOException {
        ActionClass actionClass1 = new ActionClass(this.driver1, extentTest);
        actionClass1.clickOnObject(this.classfeild);
        actionClass1.clickOnObject(this.selectoption);
        actionClass1.clickOnObject(this.searchbtn);
        VerificationClass very1 = new VerificationClass(driver1, extentTest);
        very1.verifyTextPresent(this.sectionfeildvalidation, "The Section field is required.");

    }

    public void classfeildvalidations() throws IOException, IOException {
        if (selectoption.isSelected() == true) {
            System.out.println("hii");
            ActionClass actionClass2 = new ActionClass(this.driver1, extentTest);
            actionClass2.clickOnObject(this.sectionfeild);
            actionClass2.clickOnObject(this.selectoptionforsection);

        } else {
            VerificationClass very3 = new VerificationClass(driver1, extentTest);
            very3.verifyTextPresent(this.classfeildvalidation, "The Class field is required");
        }
        //check the class wise filter data with db
    }


    public Object[] listdata() throws IOException, InterruptedException, SQLException {

        ActionClass actionClass4 = new ActionClass(this.driver1, extentTest);
        actionClass4.clickOnObject(this.sidemenustudentinfomenuclick);
        Thread.sleep(3000);
        actionClass4.clickOnObject(this.ClickOnPromoteStudent);
        actionClass4.clickOnObject(this.classfeild);
        actionClass4.clickOnObject(this.selectoption);
        if (selectoption.isSelected() == true) {

            actionClass4.clickOnObject(this.sectionfeild);
            actionClass4.clickOnObject(this.selectoptionforsection);
            actionClass4.clickOnObject(this.searchbtn);
            JavascriptExecutor jsetaskscore = (JavascriptExecutor) driver1;
            jsetaskscore.executeScript("scrollBy(0, 300)");
            List<WebElement> ListStudent = driver1.findElements(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr"));

            int listsize = ListStudent.size();
            System.out.println(listsize);
            ArrayList listNames1 = new ArrayList();
            for (int i = 2; i <= listsize; i++) {
                String s = driver1.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr[" + i + "]/td[1]")).getText();
                System.out.println("Value in list is: " + s);
                listNames1.add(driver1.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr[\" + i + \"]/td[1]")).getText());
            }
            DatabaseFunctions DAB = new DatabaseFunctions(extentTest);
            conn = DAB.connect();
            statement = conn.createStatement();
            String students = "SELECT `classes`.`id` AS `class_id`, `student_session`.`id` AS `student_session_id`, `students`.`id`, `classes`.`class`, `sections`.`id` AS `section_id`, `sections`.`section`, `students`.`id`, `students`.`admission_no`, `students`.`roll_no`, `students`.`admission_date`, `students`.`firstname`, `students`.`lastname`, `students`.`image`, `students`.`mobileno`, `students`.`email`, `students`.`state`, `students`.`city`, `students`.`pincode`, `students`.`religion`, `students`.`dob`, `students`.`current_address`, `students`.`permanent_address`, \n" +
                    " `students`.`adhar_no`, `students`.`samagra_id`, `students`.`bank_account_no`, `students`.`bank_name`, `students`.`ifsc_code`, `students`.`guardian_name`, `students`.`guardian_relation`, `students`.`guardian_phone`, `students`.`guardian_address`, `students`.`is_active`, `students`.`is_inactive`, `students`.`created_at`, `students`.`updated_at`, `students`.`father_name`, `students`.`rte`, `students`.`gender` FROM `students` JOIN `student_session` ON `student_session`.`student_id` = `students`.`id` JOIN `classes` ON `student_session`.`class_id` = `classes`.`id` JOIN `sections` ON `sections`.`id` = `student_session`.`section_id` LEFT JOIN `categories` ON `students`.`category_id` = `categories`.`id` WHERE `student_session`.`session_id` = '15' AND `student_session`.`class_id` = '23' AND `student_session`.`is_inactive` = 'no' AND `student_session`.`section_id` = 7 AND students.id NOT IN( SELECT student_id FROM promot_student ) ORDER BY `students`.`id`";
            queryRs = statement.executeQuery(students);
            ArrayList listNames = new ArrayList();

            while (queryRs.next()) {
                String s1 = null;
                s1 = queryRs.getString("students.admission_no");
                System.out.println("Admission no. is " + s1);
                listNames.add(queryRs.getString("students.admission_no"));

            }
            System.out.println(listNames.equals(listNames1));

            actionClass4.CompareList(listNames, listNames1);

            actionClass4.captureScreen("Default Keyword search");
            return listNames1.toArray();
        } else {
            VerificationClass very = new VerificationClass(driver1, extentTest);
            very.verifyTextPresent(this.classfeildvalidation, "The Class field is required");
        }
//        return listNames1.toArray();

        return new Object[0];
    }
    public void Promoteinsession()throws InterruptedException,IOException{
        ActionClass actionClass=new ActionClass(this.driver1,extentTest);
        actionClass.clickOnObject(this.ClickOnStudentInformation);
        Thread.sleep(3000);
        actionClass.clickOnObject(this.ClickOnPromoteStudent);
        actionClass.clickOnObject(this.classfeild);
        actionClass.clickOnObject(this.selectoption);
        actionClass.clickOnObject(this.sectionfeild);
        actionClass.clickOnObject(this.selectoptionforsection);
        actionClass.clickOnObject(this.searchbtn);
        actionClass.clickOnObject(this.Promoteinsessionclcik);
        actionClass.clickOnObject(this.SelectSession);
        actionClass.clickOnObject(this.PromoteClass);
        actionClass.clickOnObject(this.SelectclassforPromote);
        actionClass.clickOnObject(this.PromoteSession);
        actionClass.clickOnObject(this.SelectsectionforPromote);
        actionClass.clickOnObject(this.Promotebtn);
        VerificationClass very = new VerificationClass(driver1, extentTest);
        very.verifyTextPresent(this.classfeildvalidation, "No Record Found");




    }
}









