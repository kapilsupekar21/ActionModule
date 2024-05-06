package cucumberBDD;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Space.Functions.AutFunctions;
import Space.ObjectsUtilities.ObjectUtilities;
import Space.Xpaths.GetXpathsfromfile;
import Tests.Setup;
import autoFW.exceptions.ElementNotLocatedOnUIException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinations {

	public static WebDriver driver;
	public static WebDriverWait wait;
	private String Updatedtext = "Automation Test Data Cleared And Updated";
	GetXpathsfromfile prop = new GetXpathsfromfile();
	ObjectUtilities obj = new ObjectUtilities();
	AutFunctions aut;

	@Given("the user is on the login page")
	public void userIsOnLoginPage() {
		System.out.println("BeforeClassSetup");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();

		String url = "http://192.168.10.172:2021/Account/Login";
		driver.get(url);
	}

	@When("^the user enters \"(.+)\" and \"(.+)\" and clicks Sign In$")
	public void userEntersCredentialsAndClicksSignIn(String username, String password)
			throws ElementNotLocatedOnUIException, IOException, InterruptedException {
		String email = prop.getXpathFromPropFile("LoginPage.prop", "email");
		String Loginid = prop.getXpathFromPropFile("LoginPage.prop", "Loginid");
		String pwd = prop.getXpathFromPropFile("LoginPage.prop", "Pwd");
		String Password = prop.getXpathFromPropFile("LoginPage.prop", "Password");
		String Signin = prop.getXpathFromPropFile("LoginPage.prop", "Signin");
		driver = Setup.driver;
		obj = new ObjectUtilities();
		prop = new GetXpathsfromfile();

		obj.clickElement1(email);
		System.out.println(email);
		obj.typeInElement(email, username);
		System.out.println(email + "\\n" + username);
		obj.clickElement(pwd);
		obj.typeInElement(pwd, password);
		obj.clickElement(Signin);
		Thread.sleep(5000);
		obj.clickElement(prop.GetdataFromPropFileCM("elem_scroll"));
		WebElement CMS = driver.findElement(By.xpath(prop.GetdataFromPropFileCM("CMS")));
		obj.clickElementByJS(CMS);
	}

	@Then("the user should be logged in as an admin")
	public void userShouldBeLoggedInAsAdmin() {
		// Your verification code here
	}
}
