package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	public WebDriver driver;
	
	By email = By.id("email");
	By next = By.xpath("//input[@name='commit']");
	
	public ForgotPasswordPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getNext()
	{
		return driver.findElement(next);
	}
}