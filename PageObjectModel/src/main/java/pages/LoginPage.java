package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {
	public LoginPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public LoginPage enterUserName(String UserName) throws IOException {
	        try {
       driver.findElement(By.id("username")).sendKeys(UserName);
       reportStep(UserName+" Username is successfully entered", "pass");    
     }
       catch (Exception e) {
       reportStep("Username is wrongly entered "+e, "fail");
     }
     return this;
	}
       public LoginPage enterpassword(String pwd) throws IOException {
        try {
            driver.findElement(By.id("password")).sendKeys(pwd);
            reportStep(pwd+"password Entered sucessfully","Pass");
        } 
        catch (Exception e) {
            reportStep(pwd+"password Not Entered "+e,"fail");
        }
        return this;
    }
    public HomePage clickLoginButton() throws IOException  {
        try {
            driver.findElement(By.className("decorativeSubmit")).click();
            reportStep("Login button clicked sucessfully","Pass");
        } catch (Exception e) {
            reportStep("Login button not clicked"+e,"fail");
        }
        return new HomePage(driver,node);
    }

	

	
	
	
	}


