package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC_002_CreateLeadPage extends ProjectSpecificMethod {
	@BeforeTest
	public void setup() {
		excelFile="CreateLead";
		testName ="Login Test";
		testDescription ="Login is entered successfully";
		testCategory ="Smoke";
		testAuthor="Sukanya";
	}
	@Test(dataProvider="fetchData")
	public void runCreateLead(String uname, String pwd,String cname, String fname, String lname) throws IOException {
		LoginPage lp=new LoginPage(driver, node);
		lp.enterUserName(uname)
		.enterpassword(pwd)
		.clickLoginButton()
		.clickcrmsfa()
		.clickLead()
		.clickCreateLead()
		.enterCName(cname)
		.enterFName(fname)
		.enterLName(lname)
		.clickCreateLeadButton();
		
		
		
	
	}

}
