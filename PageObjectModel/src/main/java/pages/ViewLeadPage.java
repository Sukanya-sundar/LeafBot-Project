package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class ViewLeadPage extends ProjectSpecificMethod{
	public ViewLeadPage(ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}

	public ViewLeadPage enterFName() {
			String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
        System.out.println(text+"Lead  Created");
        return this;
	}
	
	}


