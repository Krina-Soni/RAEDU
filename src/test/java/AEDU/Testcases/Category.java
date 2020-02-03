package AEDU.Testcases;


import AEDU.Pages.Studentcategory;
import org.testng.annotations.Test;

import java.io.IOException;

public class Category extends Basecase {
    @Test
    public void addcategory() throws InterruptedException, IOException {
        logger = extent.createTest("Category Verify that user is able to login successfully to application");
        Studentcategory add = new Studentcategory(driver,logger);
        add.addstudnetcategory("test","addwebsolution@gmail.com","addweb123","","Testedit");
        add.editcategory("testing");

        }
}



