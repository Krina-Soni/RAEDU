package AEDU.Pages;


import AEDU.Actions.ActionClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import AEDU.Utilities.*;

import java.sql.*;
import java.util.*;

import java.io.IOException;
import java.sql.Connection;

public class StudentSearch {
    WebDriver driver1;
    ExtentTest extentTest;

    Connection conn = null;
    //Docker
    String url = "jdbc:mysql://localhost:6603/";
    //localDB
    //String url = "jdbc:mysql://localhost:3306/";
    String dbName = "AEDU";
    String driver = "com.mysql.jdbc.Driver";
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
            how = How.NAME,
            using = "search"
    )
    private WebElement ClickOnbtnSearch;

    public StudentSearch(WebDriver driver, ExtentTest test) {
        this.driver1 = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);
        try {
            //Class.forName(driver).newInstance();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + dbName, userName, password);
            test.log(Status.INFO, "Sucessfully connected to Databse" + dbName);
            System.out.println("connected to database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Unable to Provide Connection With Database" + dbName);
        }
        //return conn;
    }

    public Object[] ListStudentDetail() throws IOException, SQLException {

        ActionClass actionClass = new ActionClass(this.driver1, extentTest);
        actionClass.clickOnObject(this.ClickOnStudentInformation);
        actionClass.clickOnObject(this.ClickOnStudentDetails);
        actionClass.clickOnObject(this.ClickOnbtnSearch);
        List<WebElement> ListStudent = driver1.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr"));

        int listsize = ListStudent.size();
        ArrayList listNames1 = new ArrayList();
        for (int i = 1; i <= listsize; i++) {
            String s = driver1.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[1]")).getText();
            System.out.println("Value in list is: " + s);
            listNames1.add(driver1.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[1]")).getText());
        }

        DatabaseFunctions DAB = new DatabaseFunctions(extentTest);
        conn = DAB.connect();
        statement = conn.createStatement();
        String students = "SELECT student_session.id, student_session.session_id, students.firstname, students.lastname, students.is_active, students.is_inactive, classes.class, students.admission_no FROM `student_session` INNER JOIN students ON student_session.student_id = students.id INNER JOIN classes ON student_session.class_id=classes.id WHERE student_session.session_id='15' AND students.is_inactive='no' ORDER BY `students`.`admission_no` ASC";
        queryRs = statement.executeQuery(students);
        ArrayList listNames = new ArrayList();

        while (queryRs.next()) {
            String s = null;
//            s1 = queryRs.getString("students.admission_no");
//            System.out.println("Admission no. is " + s1);
            listNames.add(queryRs.getString("students.admission_no"));

        }
        System.out.println(listNames.equals(listNames1));
        actionClass.CompareList(listNames,listNames1);

        actionClass.captureScreen("Default Keyword search");

     return listNames.toArray();
    }
    }





