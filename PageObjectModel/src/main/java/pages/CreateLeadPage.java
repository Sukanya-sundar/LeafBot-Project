package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class CreateLeadPage extends ProjectSpecificMethod{
	public CreateLeadPage(ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public CreateLeadPage enterCName(String cname) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
			reportStep(cname+"CompanyName is entered successfully","pass");
		} catch (Exception e) {
			reportStep(cname+"CompanyName is entered successfully","pass");
			
		}
		return this;
	}
	public CreateLeadPage enterFName(String fname) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
			reportStep(fname+"firstName is entered Successfully","pass");
		} catch (Exception e) {
			reportStep(fname+"firstName is not entered Successfully","fail");
		
		}
		return this;
	}
	public CreateLeadPage enterLName(String lname) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
			reportStep(lname+"lastName is entered Successfully","pass");
		} catch (Exception e) {
			reportStep(lname+"lastName is not entered Successfully","pass");
		}
		return this;
	}
	public ViewLeadPage clickCreateLeadButton() throws IOException {
		try {
			driver.findElement(By.name("submitButton")).click();
			reportStep(testAuthor+"submit button is clicked successfully","pass");	
		} catch (Exception e) {
			reportStep(testAuthor+"submit button is not clicked successfully","fail");
			}
		return new ViewLeadPage(driver, node);
	}

	

	}


