package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class MyLeadsPage extends ProjectSpecificMethod {
	public MyLeadsPage(ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public CreateLeadPage clickCreateLead() throws IOException {
		try {
			driver.findElement(By.linkText("Create Lead")).click();
			reportStep(testAuthor+"clicked create lead succesfully","pass");
		} catch (Exception e) {
			reportStep(testAuthor+ "Not clicked create lead succesfully","pass");
		
		}
		return new CreateLeadPage(driver, node);
	}
	public CreateLeadPage clickFindLeads() throws IOException {
		try {
			driver.findElement(By.linkText("Find Leads")).click();
			reportStep(testAuthor+"clicked find Leads successfully", "pass");
		} catch (Exception e) {
			reportStep(testAuthor+" Not clicked find Leads successfully", "fail");
		}
		return new CreateLeadPage(driver, node);
	}
	public CreateLeadPage clickMergeLeads() throws IOException {
		try {
			driver.findElement(By.linkText("Merge Leads")).click();
			reportStep(testAuthor+"clicked Merge Leads successfully", "pass");
		} catch (Exception e) {
			reportStep(testAuthor+"Not clicked Merge Leads successfully", "fail");
	    
		}
		return new CreateLeadPage(driver, node);
	}

	

	}


