package AEDU.Testcases;

import org.testng.annotations.Test;

import java.io.IOException;

public class PromoteStudent extends Basecase{
//    @Test
//    public void promotestudent() throws InterruptedException, IOException{
//        Promote promoteStudent= new Promote(driver, logger);
//        promoteStudent.promote1("addwebsolution@gmail.com","addweb123");
//    }
//            StudentInformation login = new StudentInformation(driver,logger);
//        login.StudentInformation();
@Test
    public void serchforpromo()throws IOException{
    AEDU.Pages.PromoteStudent serchforpromo= new AEDU.Pages.PromoteStudent(driver,logger);
    serchforpromo.serchforpromote("addwebsolution@gmail.com","addweb123");
    }
}
