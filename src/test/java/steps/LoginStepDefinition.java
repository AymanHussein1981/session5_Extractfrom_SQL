package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.Database;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase{
	
	LoginPage loginPage;
	Database database;
	
	
	@Before
	public void beforeRun() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		database = new Database();
		}
	
	
	
	@Given ("User is on codfios login page")
	public void user_is_on_codfios_login_page() {
	
		driver.get("https://codefios.com/ebilling/login");
		takeScreenshot(driver);
		}
	
	
	@When ("User enters username as {string}")
	public void user_enters_username_as(String username) { //snake case
		
		loginPage.insertUserName(username);
		}

	
	
	@When ("User enters password as {string}")
	public void userEntersPasswordAs(String password) { //camel case
		loginPage.insertPassword(password);
		}
	
	
	
	@When("User enters {string} from mysql database")
	public void user_enters_from_mysql_database(String loginInfo) {
			  
		if(loginInfo.equalsIgnoreCase("username")){
			loginPage.insertUserName(database.getDataFromDb("user_name"));
			System.out.println("Username from DB:" + database.getDataFromDb("user_name"));
		}
		else if(loginInfo.equalsIgnoreCase("password")){
			loginPage.insertPassword(database.getDataFromDb("user_password"));
			System.out.println("Password from DB:" + database.getDataFromDb("user_password"));
		}
		else {
		System.out.println("Unable to extract data from Db!!");
		}
	}


	
	
	@When("User clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
		loginPage.clicSigninButton();
		takeScreenshot(driver);
		}
	

	@Then("User lands on dashboard page")
	public void user_lands_on_dashboard_page() {
		String expectedTitle = "Codefios";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		}
	
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
		}
	
	 

	
	

}
