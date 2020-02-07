package AEDU.Testcases;

import AEDU.Pages.AddStudent;
import AEDU.Pages.StudentInformation;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class AddStudents extends Basecase {


    @Test
    public void VcerifyStudentAddmissionpage() throws InterruptedException, IOException, SQLException {
        logger = extent.createTest("Promote Student");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent add = new AddStudent(driver, logger);
        add.AddStudent("", "");


    }

    @Test
    public void Checkallvalidations() throws InterruptedException, IOException, SQLException {
        logger = extent.createTest("Promote Student");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent check = new AddStudent(driver, logger);
        check.VeryFeildValidation();
    }
}