package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class MyHomePage extends ProjectSpecificMethod {
	public MyHomePage(ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public MyLeadsPage clickLead() throws IOException {
		try {
			driver.findElement(By.linkText("Leads")).click();
			reportStep(testAuthor+ "Clicked Leads successfully", "pass");
		} catch (Exception e) {
			reportStep(testAuthor+ "Not Clicked Leads successfully", "fail");
		
		}
		return new MyLeadsPage(driver, node);
	}

	
	}


