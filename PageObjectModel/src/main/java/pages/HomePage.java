package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod {
	public HomePage(ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}

	public MyHomePage clickcrmsfa() throws IOException {
		try {
			driver.findElement(By.linkText("CRM/SFA")).click();
			reportStep(testAuthor+"clicked CRM successfully", "pass");
		} catch (Exception e) {
			reportStep(testAuthor+" Not clicked CRM successfully", "fail");
			
		}
		return new MyHomePage(driver, node);
		
	}


}
