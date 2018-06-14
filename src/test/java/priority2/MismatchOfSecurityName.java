package priority2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import library.Base;
import pageObjectClasses.BSEMainPO;
import pageObjectClasses.ResultCalendarPO;

public class MismatchOfSecurityName {
	

	WebDriver driver;
	Base base = new Base();
	String validSecurityName = "TATA";
	
	@BeforeClass
	public void initializeBrowser() throws MalformedURLException
	{
		//URL url = new URL("https://www.bseindia.com/");
		driver = base.openBrowser();
		//driver.navigate().to(url);
		base.openURL("stockUrl");
	}
	@Test
	public void performLandingPageActivity()
	{
		BSEMainPO bsp = new BSEMainPO(driver);
		String landingPageTitle = driver.getTitle();
		Assert.assertEquals(landingPageTitle, bsp.expectedTitle);
		
		bsp.clickOnMainLink("Corporates");
		bsp.clickOnsubLink("Result Calendar");
	}
	@Test(dependsOnMethods = {"performLandingPageActivity"})
	public void verifyMismatchOfSecurityName() throws InterruptedException
	{
		ResultCalendarPO rcp = new ResultCalendarPO(driver);
		String resultCalendarPageTitle = driver.getTitle();
		Assert.assertEquals(resultCalendarPageTitle, rcp.expectedTitle);
		
		String actualText = rcp.enterSecurityNameAndSelect(validSecurityName, "TATASTEEL");
		System.out.println(actualText);
		Assert.assertTrue(actualText.contains(" Doesn't match with "+validSecurityName));
	}
	@AfterClass
	public void closeBrowser()
	{
		base.closeBrowser();
	}
}
