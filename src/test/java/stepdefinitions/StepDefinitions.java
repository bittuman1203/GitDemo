package stepdefinitions;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;


@RunWith(Cucumber.class)
public class StepDefinitions extends base
{
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws IOException
	{
		driver = initializeDriver();
	}

	//@Given("Navigate to {string} site")
	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String string)
	{
		driver.get(string);
	}

	@And("^Click on Login link in Home page to land on secure sign in page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page()
	{
		LandingPage l = new LandingPage(driver);
		l.getLogin();
	}

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password)
	{
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	}

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in()
	{
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.getSearchBox().isDisplayed());
	}
	
	@And("^Close browser$")
    public void close_browser() throws Throwable
	{
		driver.quit();
    }
}