package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base
{
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		/*
		//TestNG code
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
//		String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");
		
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))
		{
			//initialize chrome
			System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		else if (browserName.contains("firefox"))
		{
			//initialize firefox
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.contains("IE"))
		{
			//initialize IE
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			//initialize chrome
			System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		*/
		
		//Cucumber code
		System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".jpeg";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}