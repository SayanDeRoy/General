package priority1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Base;
import pageObjectClasses.BSEMainPO;

public class ElementPresentOrNot {
	
	WebDriver driver;
	BSEMainPO bmp;
	Base base = new Base();
	
	@BeforeClass
	public void initializeBrowser()
	{
		driver = base.openBrowser();
		base.openURL("stockUrl");
	}
	@Test
	public void landingPageTitleVerification()
	{
		bmp = new BSEMainPO(driver);
		int count = driver.findElements(By.xpath("//a[@id='De-slide-two']")).size();
		System.out.println(count);
	}
	@AfterClass
	public void closeBrowser()
	{
		base.closeBrowser();
		driver = null;
	}
}
