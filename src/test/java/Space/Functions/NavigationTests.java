package Space.Functions;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import Space.ObjectsUtilities.ObjectUtilities;
import Space.Xpaths.GetXpathsfromfile;
import Tests.Setup;


public class NavigationTests {
	public static WebDriver driver;
	public static WebDriverWait wait;
	GetXpathsfromfile prop; 
	ObjectUtilities obj;
	NavigationTests aut;
	@SuppressWarnings("deprecation")
	public void loginAsAdmin(String url) throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver; 
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String email = prop.getXpathFromPropFile("LoginPage.prop", "email");
		String Loginid = prop.getXpathFromPropFile("LoginPage.prop", "Loginid");
		String pwd = prop.getXpathFromPropFile("LoginPage.prop", "Pwd");
		String Password = prop.getXpathFromPropFile("LoginPage.prop", "Password");
		String Signin = prop.getXpathFromPropFile("LoginPage.prop", "Signin");
		obj.clickElement(email);
		obj.Type(email, Loginid);
		obj.clickElement(pwd); 
		obj.Type(pwd, Password);
		obj.ClickElement(Signin);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement lmsbutton = driver.findElement(By.xpath("//span[@class='Moduled_name'][normalize-space()='LMS (TEMPORARY)']"));
		obj.clickElementByJS(lmsbutton);

}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void VerifyLabourAttendanceNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement LabourAttendance = driver.findElement(By.xpath( prop.getXpathFromPropFile2("NewXpaths.prop", "labourattendances")));
		obj.clickElementJs(LabourAttendance);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "LabourAttendancetitlee")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Attendance")),
				"User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to Labour Attendance Successfully");
	}
	@SuppressWarnings("deprecation")
	public void AdvanceRecoveryNavigation() throws Exception {
		// TODO Auto-generated method stub
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement AdvanceRecovery = driver.findElement(By.xpath( prop.getXpathFromPropFile2("NewXpaths.prop", "AdvanceRecovery")));
		obj.clickElementJs(AdvanceRecovery);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "AdvanceRecoveryTitle"))));
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "AdvanceRecoveryTitle")))
				.getText();
		System.out.println(Text);
	Assert.assertTrue((Text.contains("Status")),
				"User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to Advance Recovery Successfully");

}
	public void SiteMappingNavigation() throws Exception, IOException {
		// TODO Auto-generated method stub
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement SiteMapping = driver.findElement(By.xpath( prop.getXpathFromPropFile2("NewXpaths.prop", "SiteMapping")));
		obj.clickElementJs(SiteMapping);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "MappingTitle")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Device To Site Mapping")),
				"User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to Site Mapping  Successfully");
 
	}
	public void HolidayNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement Holiday = driver.findElement(By.xpath( prop.getXpathFromPropFile2("NewXpaths.prop", "Holidays")));
		obj.clickElementJs(Holiday);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "HolidaysTitle")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("List")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to Holidays Succesfully");

	}
	public void ProjectNavigation() throws Exception {
		prop = new GetXpathsfromfile(); 
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement Project = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "ProjectNavigation")));
		obj.clickElementJs(Project);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "ProjectNavigationVerification")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Project")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to Project Succesfully");

	}
	public void PicklistNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement Project = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "Picklist")));
		obj.clickElementJs(Project);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "PicklistNavigation")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Picklist")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated Picklist  Succesfully");
}
	public void TimeReport() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement Project = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "TimeReport")));
		obj.clickElementJs(Project);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile2("NewXpaths.prop", "TimeReportVerification")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Time Report")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated Picklist  Succesfully");
	} 
}