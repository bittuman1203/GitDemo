package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.ForgotPasswordPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;

public class HomePageTest extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.error("Driver is initialized");
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String comments) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.error("Navigated to Home page");
		
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();

		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		log.fatal(comments);
		lp.getLogin().click();
		ForgotPasswordPage fp = lp.forgotPassword();
		Thread.sleep(2000);
		fp.getEmail().sendKeys(username);
		fp.getNext().click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = {{"nonrestricteduser@abc.com","11111","Non Restricted User"},{"restricteduser@abc.com","22222","Restricted User"}};
		return data;
	}
}