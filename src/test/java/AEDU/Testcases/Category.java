package AEDU.Testcases;


import AEDU.Pages.Studentcategory;
import org.testng.annotations.Test;

import java.io.IOException;

public class Category extends Basecase {
    @Test
    public void addcategory() throws InterruptedException, IOException {
        logger = extent.createTest("Check the add category functionality");
        Studentcategory add = new Studentcategory(driver,logger);
        add.addstudnetcategory("test","addwebsolution@gmail.com","addweb123","","Testedit");
        add.editcategory("testing");

        }
        @Test
        public void Blankdatavalidation()throws IOException,InterruptedException{
            logger = extent.createTest("Check with the blank validation");
        Studentcategory blank=new Studentcategory(driver,logger);

        }
}



