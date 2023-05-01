package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ProjectSpecificMethod {
	public ChromeDriver driver;
	public String excelFile;
	public static ExtentReports extent;
	public static ExtentTest test, node;
	public String testName, testDescription, testCategory, testAuthor;
	@BeforeSuite// root
	public void startReport() {
     ExtentHtmlReporter reporter=new ExtentHtmlReporter("reports/result.html");
	 reporter.setAppendExisting(true);
	 extent =new ExtentReports();
	 extent.attachReporter(reporter);
	}
	@AfterSuite
 public void stopReport() {
        
        extent.flush();
    }
	@BeforeClass// test report details
	public void testDetails() {
    test = extent.createTest(testName, testDescription);
	test.assignCategory(testCategory);
	test.assignAuthor(testAuthor);
	}
	public int takeSnap() throws IOException {
        int random=(int)(Math.random()*99999+10000);
        File source = driver.getScreenshotAs(OutputType.FILE);
        File desc =new File("./snap/img"+random+".png");//img1123.png img 234.png
        FileUtils.copyFile(source, desc);
        return random;
    }
	public void reportStep(String stepDesc,String status) throws IOException {
        if(status.equalsIgnoreCase("Pass")) {
            node.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././Snap/img"+takeSnap()+".png").build());    
        }
        else if(status.equalsIgnoreCase("fail")) {
            node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././Snap/img"+takeSnap()+".png").build());
        }
        
    }
	@BeforeMethod

	public void launchBrowser() {
		node = test.createNode(testName);
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@DataProvider(name="fetchData")
	public String[][] getdata() throws IOException {
	     String[][] readData = util.ReadExcel.readData(excelFile);
		return readData;
	}	

	}


