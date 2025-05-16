package Computers;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import Objectrepository.HomePage;

public class TS_DWS_010_Test extends BaseClass {
	@Test
	public void clickOnComputers() {
		test=eReports.createTest("clickOnComputers");
		HomePage hp=new HomePage(driver);
		hp.getBookslink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers","Computers  Page  is not displayed");
		test.log( Status.PASS, "Computers  Page  is   displayed");
	}


}
