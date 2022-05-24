package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By login = By.xpath("//a[normalize-space()='Login']");
	private By title = By.xpath("//h2[normalize-space()='Featured Courses']");
	private By navigationBar = By.xpath("//ul[@class='navigation clearfix']");
	private By header = By.xpath("//div[@class='container-fluid']//h2//span[1]");
	
	public LandingPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage getLogin()
	{
		driver.findElement(login).click();
		return new LoginPage(driver);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
}