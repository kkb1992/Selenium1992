package books;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import Objectrepository.HomePage;

public class TS_DWS_001_Test extends BaseClass {
	
	@Test
	public void clickOnBooks() {
		test=eReports.createTest("clickOnBooks");
		HomePage hp=new HomePage(driver);
		hp.getBookslink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books","BookS  Page  is not displayed");
		test.log( Status.PASS, "BookS  Page  is   displayed");
	}

}
