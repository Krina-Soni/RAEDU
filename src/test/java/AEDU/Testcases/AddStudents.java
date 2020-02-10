package AEDU.Testcases;

import AEDU.Pages.AddStudent;
import AEDU.Pages.StudentInformation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
        logger = extent.createTest("Check the Addmission form  validation");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent check = new AddStudent(driver, logger);
        check.VeryFeildValidation();
    }

    @Test
    public void Studentadd() throws IOException, InterruptedException, SQLException {
        logger = extent.createTest("Check the Add Student Functionality ");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent Add = new AddStudent(driver, logger);
        Add.SetudentAddmissionform("2525", "53", "Johnny27", "Harper", "4978412542");
        addddd

    }

    @Test
    public void ImportCsv() throws IOException, InterruptedException, SQLException, InvalidFormatException {
        logger = extent.createTest("Check the Add Student via CSV Functionality ");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent Import = new AddStudent(driver, logger);
        Import.Importstudentcsv();
    }
}