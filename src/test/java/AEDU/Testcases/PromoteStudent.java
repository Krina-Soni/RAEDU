package AEDU.Testcases;

import AEDU.Actions.VerificationClass;
import AEDU.Pages.PromoteStudents;
import AEDU.Pages.StudentInformation;
import AEDU.Pages.StudentSearch;
import AEDU.Pages.Studentcategory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class PromoteStudent extends Basecase {

    @Test
    public void CheckPromote() throws InterruptedException, IOException, SQLException {
        logger = extent.createTest("Promote Student");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        PromoteStudents login = new PromoteStudents(driver, logger);
        //PromoteStudents login = new PromoteStudents("addwebsolution@gmail.com","addweb123");
//        login.Promote("addwebsolution@gmail.com", "addweb123");
//        login.ListPromoteStudentDetail();
    }

    @Test
    public void validations() throws InterruptedException, IOException {
        logger = extent.createTest("Verify with the no filter value ");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        PromoteStudents promoteStudents = new PromoteStudents(driver, logger);
        promoteStudents.validation("");
    }

    @Test
    public void checkvalidations() throws InterruptedException, IOException {
        logger = extent.createTest("Check class feild and section feild validation");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        driver.get("https://dev1.aedu.co.in/admin/stdtransfer/index");
        PromoteStudents promoteStudents1 = new PromoteStudents(driver, logger);
        promoteStudents1.feildvalidations();
    }
    @Test
    public void checksectionfeildvalidation()throws InterruptedException,IOException {
        logger = extent.createTest("Check class feild and section feild validation");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        driver.get("https://dev1.aedu.co.in/admin/stdtransfer/index");
        PromoteStudents promoteStudents2 = new PromoteStudents(driver, logger);
        promoteStudents2.classfeildvalidations();


}
    @Test
    public void dbmatchs() throws InterruptedException, IOException, SQLException {
        logger = extent.createTest("Check class feild and section feild validation");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
//        driver.get("https://dev1.aedu.co.in/admin/stdtransfer/index");
        PromoteStudents promoteStudents3 = new PromoteStudents(driver, logger);
        promoteStudents3.listdata();

    }
    @Test
    public void PromoteinNextsession()throws InterruptedException,IOException{
      logger=extent.createTest("Promote Student in thenext Session");
      StudentInformation SI = new StudentInformation(driver,logger);
      SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
      PromoteStudents Nextsession=new PromoteStudents(driver,logger);
      Nextsession.Promoteinsession();

    }
}








