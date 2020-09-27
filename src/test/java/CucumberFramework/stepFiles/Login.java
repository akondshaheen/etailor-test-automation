package CucumberFramework.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Login {
	WebDriver driver;

	// import cucumber for @Before when shows red line.
	@Before
	public void setup() {
		// If resources link value comes with single "/", make it double"//".
		System.setProperty("webdriver.chrome.driver",  "/Users/migracode/Desktop/MC_project_Test/CucumberFramework/src/test/java/CucumberFramework/resources/chromedriver");
		// select actual driver object to chromeDriver.
		this.driver = new ChromeDriver();
		// maximise window.
		this.driver.manage().window().maximize();
		// mention page load time.
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

	}

	// import cucumber api
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		this.driver.manage().deleteAllCookies();
		// this.driver.quit();
		this.driver = null;

	}
	@Given("^User navigates to etailor website$")
	public void user_navigates_to_etailor_website() throws Throwable {
	   driver.get("http://localhost:3000/");
	}

	@And("^User clicks on the Login button on homepage$")
	public void user_clicks_on_the_Login_button_on_homepage() throws Throwable {
	   driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/ul/li[1]")).click();
	}

	@And("^User enters a valid email$")
	public void user_enters_a_valid_email() throws Throwable {
		   driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[1]")).sendKeys("akondshaheen.es@gmail.com");

	}

	@And("^User enter a valid password$")
	public void user_enter_a_valid_password() throws Throwable {
		   driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]")).sendKeys("akondshaheen");

	}

	@When("^User click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		   driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/button")).click();

	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
	  Thread.sleep(3000);
	  WebElement Hello = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/ul/li[1]"));
	  Assert.assertEquals(true, Hello.isDisplayed());

	}
	

}
