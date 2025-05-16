package GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Objectrepository.HomePage;
import Objectrepository.LoginPage;
import Objectrepository.WelcomePage;

public class BaseClass {

	public static ExtentReports eReports;
	public static WebDriver driver;
	
	public static ExtentTest test;

	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public FileUtility fUtil = new FileUtility();

	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"./HTML_Reports/ExtentReport_" + jUtil.getSystemTime() + ".html");

		eReports = new ExtentReports();
		eReports.attachReporter(spark);

	}

	@BeforeClass

	public void openBrowser() throws IOException {
		driver = new ChromeDriver();
		wUtil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(fUtil.getdataFromProperty("url"));

	}

	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		LoginPage lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fUtil.getdataFromProperty("Email"));
		lp.getPasswordTextField().sendKeys(fUtil.getdataFromProperty("Password"));
		lp.getLoginbutton().click();

	}

	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.getLogoutlink().click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void reportBackup() {
		eReports.flush();
	}

}
