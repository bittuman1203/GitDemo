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

public class validateTitle extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	LandingPage l;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.error("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.error("Navigated to Home page");
	}
	
	@Test
	public void validateHomeTitle() throws IOException
	{
//		l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "Featured Coursess");
		log.error("Successfully validated Header");
	}
	
	@Test
	public void validateHeader() throws IOException
	{
		l = new LandingPage(driver);
		Assert.assertEquals(l.getHeader().getText(), "An Academy to Learn Earn & Shine  in your QA Career");
		log.error("Successfully validated title");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}