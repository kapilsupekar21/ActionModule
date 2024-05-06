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

public class AutFunctions {
	public static WebDriver driver;
	public static WebDriverWait wait;
	GetXpathsfromfile prop; 
	ObjectUtilities obj;
	AutFunctions aut;

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

	@SuppressWarnings("deprecation")
	public void LabourSearch() throws FileNotFoundException, IOException {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		String vertical = prop.getXpathFromPropFile("LoginPage.prop", "verticalselect");
		obj.ClickElement(vertical);
		String Contracting = prop.getXpathFromPropFile("LoginPage.prop", "Contracting");
		obj.ClickElement(Contracting);
		String Region = prop.getXpathFromPropFile("LoginPage.prop", "Region"); 
		obj.ClickElement(Region);
		String Ahmedabad = prop.getXpathFromPropFile("LoginPage.prop", "Ahmedabad");
		obj.ClickElement(Ahmedabad);
		String Project = prop.getXpathFromPropFile("LoginPage.prop", "Project");
		obj.ClickElement(Project);
		String ProjectSelect = prop.getXpathFromPropFile("LoginPage.prop", "1581");
		obj.ClickElement(ProjectSelect);
		String LabourName = prop.getXpathFromPropFile("LoginPage.prop", "LabourName");
		String Name = prop.getXpathFromPropFile("LoginPage.prop", "Name");
		obj.Type(LabourName, Name);
		String Search = prop.getXpathFromPropFile("LoginPage.prop", "Search");
		obj.ClickElement(Search);
		

	}

	@SuppressWarnings({ "deprecation" })
	public void VerifyLabourAddNavigation() throws FileNotFoundException, IOException {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement LabourAdd = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "LabourAdd")));
		obj.clickElementJs(LabourAdd);
		String LabourAddVerify= prop.getXpathFromPropFile("LoginPage.prop", "LabourAddverify");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LabourAddVerify)));
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "LabourAddverify")))
				.getText();
		Assert.assertTrue((Text.equalsIgnoreCase("Labour")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to Labour Successfully");
	}

	@SuppressWarnings("deprecation")
	public void HomeNavigation() throws FileNotFoundException, IOException {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		String home = prop.getXpathFromPropFile("LoginPage.prop", "Homelink");
		obj.ClickElement(home);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Hometitle"))).getText();
		Assert.assertTrue((Text.equalsIgnoreCase("YOUR SPACE")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Home Page Successfully");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.go(-1)");
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
//
	}

	public void ProjectNavigation() throws Exception {
		prop = new GetXpathsfromfile(); 
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement Project = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Project")));
		obj.clickElementByJS(Project);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ProjectVerify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Project")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to Project Succesfully");

	}

	public void PicklistNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		//driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement Picklist = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Picklist")));
		obj.clickElementByJS(Picklist);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Picklistverify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Manage Picklist")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated Picklist  Succesfully");

	}

	public void LabourconnectNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement LaboueNavigation = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "labourconnect")));
		obj.clickElementByJS(LaboueNavigation);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "labourconnectverify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Search Transaction")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to LabourConnect Succesfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	public void TimereportNavigation() throws Exception, FileNotFoundException, IOException {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		System.out.println("driver" + driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement TimeReport = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "TimeReport")));
		obj.clickElementJs(TimeReport);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Timereportverify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Time Report")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to TimeReport Succesfully");
	}

	@SuppressWarnings("deprecation")
	public void VerifyCompliancetNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		System.out.println("driver" + driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Compliance = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ComplianceLink")));
		obj.clickElementJs(Compliance);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ComplianceVerify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Generate Report")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to Compliance Succesfully");
	}

	@SuppressWarnings("deprecation")
	public void VerifyCostBill() throws Exception {
		prop = new GetXpathsfromfile();
		ObjectUtilities obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement CostBill = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "CostBillLink")));
		obj.clickElementJs(CostBill);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "CostBillVerify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Search Report")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to CostBill Succesfully");
	}

	@SuppressWarnings("deprecation")
	public void VerifyAdminBill() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement AdminBill = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Adminlink")));
		obj.clickElementJs(AdminBill);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "AdminlinkVerify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Admin Report")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to AdminLink Succesfully");

	}

	@SuppressWarnings("deprecation")
	public void VerifyMusterlinkNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement AdminBill = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Musterlink")));
		obj.clickElementJs(AdminBill);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Musterverify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Search Muster Roll")), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to MusterLink Succesfully");
	}

	@SuppressWarnings("deprecation")
	public void VerifyWagesNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement AdminBill = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Wages")));
		obj.clickElementJs(AdminBill);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "WagesVerify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Wage Management Calculation")),
				"User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to WagesLink Succesfully");
	}

	@SuppressWarnings("deprecation")
	public void VerifyWagesRatesNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement AdminBill = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "LabourContarctorAdd")));
		obj.clickElementJs(AdminBill);
		String Text = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "labourContractorVerify"))).getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase(Text)), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to WagesLink Succesfully");
	}

	@SuppressWarnings("deprecation")
	public void VerifyConfigurationNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement AdminBill = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "configuration")));
		obj.clickElementJs(AdminBill);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "configurationverify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Manage Configuration")),
				"User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to ConfigurationLink Succesfully");
	}

	@SuppressWarnings("deprecation")
	public void VerifyWageScheduldeNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement AdminBill = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "WageSchedulde")));
		obj.clickElementJs(AdminBill);
		String Text = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "WageCalculationScheduleVerify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase(Text)), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to ConfigurationLink Succesfully");
	}

	@SuppressWarnings("deprecation")
	public void VerifyLabourContractorAddNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement AdminBill = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "LabourContarctorAdd")));
		obj.clickElementJs(AdminBill);
		String Text = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "labourContractorVerify"))).getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase(Text)), "User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to ConfigurationLink Succesfully");
	}
}
