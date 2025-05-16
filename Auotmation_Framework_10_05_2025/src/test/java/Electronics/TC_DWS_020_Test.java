package Electronics;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import Objectrepository.HomePage;

public class TC_DWS_020_Test extends BaseClass {
	
	@Test
	public void clickOnElectronics() {
		test=eReports.createTest("clickOnElectronics");
		HomePage hp=new HomePage(driver);
		hp.getBookslink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Electronics","Electronics  Page  is not displayed");
		test.log( Status.PASS, "Electronics  Page  is   displayed");
	}


}
