package util;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {

	public static void main(String[] args) throws IOException {
		//setup the physical path for report
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("reports/result.html");
		
		// Keep the report History
		reporter.setAppendExisting(true);
		
		//create object for ExtentReports
		ExtentReports extent =new ExtentReports();
		
		//attach data with physical path
		extent.attachReporter(reporter);
		
		//create a test case and assign the test detail
		ExtentTest test = extent.createTest("Login", "LoginTest for LeafTap Application");
		test.assignCategory("Smoke");
		test.assignAuthor("Sukanya");
		
		// Set Status level
		test.pass("Enter UserName");
		test.fail("Enter Password");
		
		//attach the screenshot ../control move back
        test.pass("click login button", MediaEntityBuilder.createScreenCaptureFromPath(".././Snap/leaf.png").build());
        
        //Mandatory step leaf
        extent.flush();
		
		

	}

}
