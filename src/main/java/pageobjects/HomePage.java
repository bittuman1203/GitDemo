package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage
{
	public WebDriver driver;

	By searchbox = By.id("search-courses");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getSearchBox()
	{
		return driver.findElement(searchbox);
	}
}