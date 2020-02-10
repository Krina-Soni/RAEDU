package AEDU.Pages;

import AEDU.Utilities.DatabaseFunctions;
import AEDU.Utilities.ReadWriteFunction;
import AEDU.Actions.VerificationClass;
import AEDU.Actions.ActionClass;
import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddStudent{
    WebDriver driver;
    ExtentTest extentTest;
    Connection conn = null;
    // Docker
    String url = "jdbc:mysql://localhost:6603/";
    //    //localDB
//    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "aedu-dev1";
    String driver1 = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";

    Statement statement;
    ResultSet queryRs;
    ResultSet Qcount;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/a/span"
    )
    private WebElement ClickOnStudentInformation;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"sibe-box\"]/ul[2]/li[1]/ul/li[1]/a"
    )
    private WebElement ClickOnStudentDetails;

    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/div/div[2]/div/form/div[2]/div/button"
    )
    private WebElement ClickOnbtnSearch;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div/div/section[2]/div/div/div[1]/div[2]/div/div[2]/div/form/div[1]/div/input"

    )
    private WebElement KeywordSearchtxt;

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
    @FindBy(
            how = How.XPATH,
            using = " //*[@id=\"section_id\"]"
    )
    private WebElement SelectSectionFeild;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_id\"]/option[2]"
    )
    private WebElement SelectSectionOption;
    //*[@id="roll_no"]
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"roll_no\"]"
    )
    private WebElement RollnbFeild;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"firstname\"]"
    )
    private WebElement FristNamefeild;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[1]/div/div[2]/div[3]/div/select]"
    )
    private WebElement GenderFeild;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"form1\"]/div/div[1]/div/div[2]/div[3]/div/select/option[2]"
    )
    private WebElement SelectGender;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"father_name\"]"
    )
    private WebElement FatherNamefeild;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"father_phone\"]"
    )
    private WebElement FatherPhonenumber;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[2]/div/div[5]/div/label[2]/input"
    )
    private WebElement GardiunSelection;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[1]/div/div[6]/div[1]/div/div/div/input"
    )
    private WebElement Uploadfile;

    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div/div[1]/div/div[1]\n"
    )
    private WebElement StudentAddedmessage;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/div/a/button"
    )
    private WebElement ImportCsvbButton;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_id\"]"
    )
    private WebElement ImportCsvbSelectclass;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_id\"]/option[2]"
    )
    private WebElement ImportCsvbSelectclassOption;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_id\"]"
    )
    private WebElement ImportCsvbSelectSection;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_id\"]/option[2]"
    )
    private WebElement ImportCsvbSelectSectionOption;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div/div[3]/div/div/div/input"
    )
    private WebElement SelectCsvFile;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div[2]/button"
    )
    private WebElement ImportStudentbutton;
    @FindBy(
            how = How.XPATH,
            using = " /html/body/div[1]/div[1]/section[2]/div/div/div/form/div[2]/button[1]"
    )
    private WebElement ComfimmessageYes;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div[1]"
    )
    private WebElement SuccessMegforCsv;
    public AddStudent(WebDriver driver,ExtentTest test){
        this.driver = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);

    }


//    This script will take us to admission page
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


//    Test if all the mandatory field shows validations
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


//    Add a student
    public void SetudentAddmissionform(String Addmissionnb, String Rollnumber, String Fristname, String Fathername, String FatherPhone) throws IOException, InterruptedException, SQLException {
        ActionClass actionClass = new ActionClass(driver, extentTest);
        actionClass.clickOnObject(this.sidemenustudentinfomenuclick);
        Thread.sleep(3000);
        actionClass.clickOnObject(this.SidemenuStudentAddmissionclick);
        actionClass.setValueinTextbox(this.Addmissionnumber, Addmissionnb);
        actionClass.setValueinTextbox(this.RollnbFeild, Rollnumber);
        actionClass.clickOnObject(this.SelectClassfeild);

        actionClass.clickOnObject(this.SelectClassOption);
        actionClass.clickOnObject(this.SelectSectionFeild);
        actionClass.clickOnObject(this.SelectSectionOption);
        actionClass.clickOnObject(this.FristNamefeild);
        actionClass.setValueinTextbox(this.FristNamefeild, Fristname);
        actionClass.clickOnObject(this.GenderFeild);
        actionClass.clickOnObject(this.SelectGender);
        JavascriptExecutor jsetaskscore = (JavascriptExecutor) driver;
        jsetaskscore.executeScript("scrollBy(0, 500)");
        WebElement uploadElement = driver.findElement(By.id("file"));
        uploadElement.sendKeys("/Applications/XAMPP/xamppfiles/htdocs/addwebsms-master-live/uploads/student_images/download.jpeg");
        actionClass.clickOnObject(this.FatherNamefeild);
        actionClass.setValueinTextbox(this.FatherNamefeild, Fathername);
        actionClass.clickOnObject(this.FatherPhonenumber);
        actionClass.setValueinTextbox(this.FatherPhonenumber, FatherPhone);
        actionClass.clickOnObject(this.GardiunSelection);
        String Admissionnumber = Addmissionnumber.getText();
        actionClass.clickOnObject(this.Savebtn);
        VerificationClass verificationClass = new VerificationClass(driver, extentTest);
       verificationClass.verifyTextPresent(this.VerifyStudentAddmissionTitle, "Student added Successfully");
        actionClass.clickOnObject(this.ClickOnStudentInformation);
        actionClass.clickOnObject(this.ClickOnStudentDetails);
        actionClass.clickOnObject(this.KeywordSearchtxt);
        actionClass.setValueinTextbox(KeywordSearchtxt,"2525");
        actionClass.clickOnObject(this.ClickOnbtnSearch);

        List<WebElement> ListStudent1 = driver.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr"));
        int listsize = ListStudent1.size();
        ArrayList<String> KeywordListF = new ArrayList<String>();
        for (int i = 1; i <= listsize; i++) {
            String s = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[1]")).getText();
            System.out.println("Value in list is: " + s);
            KeywordListF.add(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[1]")).getText());
        }
        ArrayList<Integer> KeywordSearchIntegerList1= new ArrayList<Integer>(KeywordListF.size());
        for(String myInt : KeywordListF ){
            KeywordSearchIntegerList1.add(Integer.valueOf(myInt));
        }
        System.out.println(KeywordSearchIntegerList1);
        DatabaseFunctions DAB = new DatabaseFunctions(extentTest);
        conn = DAB.connect();
        statement = conn.createStatement();
        System.out.println(KeywordSearchtxt.getText());
        String B22 = KeywordSearchtxt.getText();
        String searchstudentbykeyword = "SELECT student_session.id, student_session.session_id, students.firstname, students.lastname, students.is_active, students.is_inactive, students.admission_no FROM `student_session` INNER JOIN students ON student_session.student_id = students.id WHERE (students.firstname = 'riddhi' OR students.lastname = 'riddhi' OR students.guardian_name = 'riddhi' OR students.adhar_no = 'riddhi' OR students.samagra_id = 'riddhi' OR students.roll_no = 'riddhi' OR students.admission_no = 'riddhi') AND student_session.session_id='15' ORDER BY students.admission_no ASC";
        ResultSet queryRs7 = statement.executeQuery(searchstudentbykeyword);
        ArrayList<String> KeywordList = new ArrayList<String>();
        while (queryRs7.next()) {
            String s1 = null;
            s1 = queryRs7.getString("students.admission_no");
            System.out.println("Admission no. is " + s1);
            KeywordList.add(queryRs7.getString("students.admission_no"));
        }
        ArrayList<Integer> KeywordSearchIntegerList= new ArrayList<Integer>(KeywordList.size());
        for(String myInt : KeywordList ){
            KeywordSearchIntegerList.add(Integer.valueOf(myInt));
        }
        Collections.sort(KeywordSearchIntegerList);
        System.out.println(KeywordSearchIntegerList);
        System.out.println(KeywordList.equals(KeywordListF));
        actionClass.CompareList(KeywordSearchIntegerList, KeywordSearchIntegerList1);

        actionClass.captureScreen("Default Keyword search");

    }



//    Import Student using CSV
        public void Importstudentcsv() throws InterruptedException, IOException, InvalidFormatException {
        ActionClass actionClass=new ActionClass(driver,extentTest);
        actionClass.clickOnObject(this.sidemenustudentinfomenuclick);
        Thread.sleep(3000);
        actionClass.clickOnObject(this.SidemenuStudentAddmissionclick);
        actionClass.clickOnObject(this.ImportCsvbButton);
        actionClass.clickOnObject(this.ImportCsvbSelectclass);
        actionClass.clickOnObject(this.ImportCsvbSelectclassOption);
        actionClass.clickOnObject(this.ImportCsvbSelectSection);
        actionClass.clickOnObject(this.ImportCsvbSelectSection);
        actionClass.clickOnObject(this.ImportCsvbSelectSectionOption);
        actionClass.clickOnObject(this.SelectCsvFile);
        WebElement uploadElement = driver.findElement(By.id("file"));
        uploadElement.sendKeys("/home/addweb/IdeaProjects/RAEDU/test-output/CSV/Riddhi56456 - Riddhi.csv");

        actionClass.clickOnObject(this.ImportStudentbutton);
        actionClass.clickOnObject(this.ComfimmessageYes);
        VerificationClass very=new VerificationClass(driver,extentTest);
        very.verifyTextPresent(this.SuccessMegforCsv,"Students imported successfully.");
        System.out.println(ReadWriteFunction.getRowCount("/home/addweb/IdeaProjects/RAEDU/test-output/CSV/Riddhi56456 - Riddhi.csv","Riddhi" ));
        }
}


