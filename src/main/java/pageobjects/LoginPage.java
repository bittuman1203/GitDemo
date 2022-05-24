package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email = By.id("email");
	By password = By.id("password");
	By login = By.xpath("//input[@name='commit']");
	By forgotPassword = By.xpath("//a[normalize-space()='Forgot Password']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public ForgotPasswordPage forgotPassword()
	{
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPage(driver);
	}
}