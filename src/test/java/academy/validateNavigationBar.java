package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import resources.base;

public class validateNavigationBar extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.error("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.error("Navigated to Home page");
	}
	
	@Test
	public void validateHomeNavigationBar() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.error("Navigation bar is displayed");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}