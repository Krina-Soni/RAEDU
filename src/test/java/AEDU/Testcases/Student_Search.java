package AEDU.Testcases;
import AEDU.Pages.StudentInformation;
import AEDU.Pages.StudentSearch;
import AEDU.Pages.Studentcategory;
import AEDU.Utilities.DatabaseFunctions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class Student_Search extends Basecase {

    // @Test
// public void openstudentdetails() throws InterruptedException, IOException, SQLException{
// SearchStudent searchStudent= new SearchStudent(driver);
// searchStudent.searchStudents();
// }
    @Test
    public void searchStudent() throws InterruptedException, IOException, SQLException{
        logger = extent.createTest("Verify that Default Keyword Search details are matched with Database or not");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        StudentSearch searchStudent= new StudentSearch(driver,logger);
        searchStudent.ListStudentDetail();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void SelectClass() throws InterruptedException, IOException, SQLException{
        logger = extent.createTest("Check If Students are filtered By Class only that records match with DB or not");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        StudentSearch searchStudent= new StudentSearch(driver,logger);
        searchStudent.CheckDataByClass();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void SelectClassSection() throws InterruptedException, IOException, SQLException{
        logger = extent.createTest("Check If Students are filtered By Class only that records match with DB or not");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        StudentSearch searchStudent= new StudentSearch(driver,logger);
        searchStudent.CheckDataByClassAndSection();
        Thread.sleep(5000);
        driver.quit();
    }
}