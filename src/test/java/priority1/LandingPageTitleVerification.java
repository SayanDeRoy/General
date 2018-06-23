package priority1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.Base;
import listeners.Listeners;
import pageObjectClasses.BSEMainPO;

public class LandingPageTitleVerification extends Listeners {
	
	WebDriver driver;
	BSEMainPO bmp;
	Base base = new Base();
	String expectedTitle = "BSE Ltd. (Bombay Stock Exchange)";
	
	@BeforeClass
	public void initializeBrowser()
	{
		driver = base.openBrowser();
		//driver.navigate().to("https://www.bseindia.com/");
		driver.get("https://www.bseindia.com/");
		//base.openURL("stockUrl");
	}
	@Test
	public void landingPageTitleVerification()
	{
		bmp = new BSEMainPO(driver);
		String actualTitle = driver.getTitle();
		if(actualTitle.contains(bmp.expectedTitle))
		{
			Assert.assertTrue(actualTitle.contains(bmp.expectedTitle));
		}
		else
		{
			logger.log(LogStatus.INFO, "Title Mismatch");
			Assert.assertTrue(actualTitle.contains(bmp.expectedTitle));
		}
	}
	@AfterClass
	public void closeBrowser()
	{
		base.closeBrowser();
		driver = null;
	}
}
