 package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC_001_LoginPage extends ProjectSpecificMethod {
	@BeforeTest
	public void setup() {
		excelFile="LoginBook";
		testName ="Login Test";
		testDescription ="Login is entered successfully";
		testCategory ="Smoke";
		testAuthor="Sukanya";
	}
	@Test(dataProvider="fetchData")
	public void runLogin(String uname, String pwd ) throws IOException {
		LoginPage lp=new LoginPage(driver, node);
		lp.enterUserName(uname).enterpassword(pwd).clickLoginButton();
	}
	
	

}
