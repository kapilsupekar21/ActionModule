package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import Space.ObjectsUtilities.ObjectUtilities;
import Space.Xpaths.GetXpathsfromfile;

public class UMmodule {
	public static WebDriver driver;
	public static WebDriverWait wait;
	GetXpathsfromfile prop;
	ObjectUtilities obj;
	UMmodule aut1;

	@SuppressWarnings("deprecation")
	public void loginAsAdmin(String url) throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String email = prop.getXpathFromPropFile("LoginPage.prop", "email");
		String Loginid = prop.getXpathFromPropFile("LoginPage.prop", "Loginid");
		String pwd = prop.getXpathFromPropFile("LoginPage.prop", "Pwd");
		String Password = prop.getXpathFromPropFile("LoginPage.prop", "Password");
		String Signin = prop.getXpathFromPropFile("LoginPage.prop", "Signin");
		String Um = prop.getXpathFromPropFile("LoginPage.prop", "UMmodule");
		obj.clickElement(email);
		obj.Type(email, Loginid);
		obj.clickElement(pwd);
		obj.Type(pwd, Password);
		obj.ClickElement(Signin);
		obj.click(Um);
	}

	public void HomeNavigation() throws FileNotFoundException, IOException {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		String home = prop.getXpathFromPropFile("LoginPage.prop", "Homelink");
		obj.click(home);
		String Text = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Hometitle"))).getText();
		Assert.assertTrue((Text.equalsIgnoreCase("YOUR SPACE")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Home Page Successfully");
		WebElement Um = driver.findElement(By.xpath((prop.getXpathFromPropFile("LoginPage.prop", "Hometitle"))));
		obj.clickElementJs(Um);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.go(-1)");

	}

	@SuppressWarnings("deprecation")
	public void LMSReportAccessSearch() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
        WebElement SearchReport = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ReportSearch")));
		obj.clickElementJs(SearchReport);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ReportVerify"))))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.contains("Search LMS Report Access")),
				"User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to LmsReportAccess Search Page Successfully");

	}

	@SuppressWarnings("deprecation")
	public void LMSReportAccessAdd() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement SearchAdd = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ReportAdd")));
		obj.clickElementJs(SearchAdd);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Addverify"))))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Provide Access To LMS Report")),
				"User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to LmsReportAccess Search Page Successfully");
	}

	@SuppressWarnings("deprecation")
	public void ProjectAdd() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement ProjectAdd = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ProjectAdd")));
		obj.clickElementJs(ProjectAdd);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ProjectAddVerify"))))
				.getText();
		System.out.println(Text);
		
		Assert.assertTrue((Text.equalsIgnoreCase("Create Project")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Project Add  Page Successfully");

	}

	@SuppressWarnings("deprecation")
	public void ProjectSearch() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement ProjectSearch = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ProjectSearch")));
		obj.clickElementJs(ProjectSearch);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "ProjectSearchVerify"))))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Search Project")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Project Search  Page Successfully");
	}

	@SuppressWarnings("deprecation")
	public void Vertical() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement ProjectSearch = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "vertical")));
		obj.clickElementJs(ProjectSearch);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "verticalverify"))))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Create Vertical")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Vertical Page Successfully");
	}

	@SuppressWarnings("deprecation")
	public void Region() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement ProjectSearch = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Region")));
		obj.clickElementJs(ProjectSearch);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Regionverify"))))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Region")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Region Page Successfully");
	}

	@SuppressWarnings("deprecation")
	public void Function() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement ProjectSearch = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Function")));
		obj.clickElementJs(ProjectSearch);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "FunctionVerify"))))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Function")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Function Page Successfully");
	}

	@SuppressWarnings("deprecation")
	public void Position() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement ProjectSearch = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Position")));
		obj.clickElementJs(ProjectSearch);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "PositionVerify"))))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Position")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Position Page Successfully");
	}

	@SuppressWarnings("deprecation")
	public void UploadUserRequest() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement ProjectSearch = driver
				.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "UploadRequest")));
		obj.clickElementJs(ProjectSearch);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "UploadRequestVerify"))))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Upload User Request")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Upload Request Page Successfully");

	}

	@SuppressWarnings("deprecation")
	public void Group() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement ProjectSearch = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Group")));
		obj.clickElementJs(ProjectSearch);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String Text = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "GroupVerify"))))
				.getText();
		System.out.println(Text);
	    Assert.assertTrue((Text.equalsIgnoreCase("Group")), "User was unable to Navigate  successfully.");
		Reporter.log("User Navigated to Group Page Successfully");
	}

	@SuppressWarnings("deprecation")
	public void AddNmruser() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;

		// Creating an user From UM Module using UM Admin Credintials

		WebElement UserManagementAdd = driver.findElement(By.xpath(prop.GetdataFromPropFile("Adduser")));
		obj.clickElementJs(UserManagementAdd);
		String Employeeid = prop.GetdataFromPropFile("Employeeid");
		String id = prop.GetdataFromPropFile("id");
		String FirstName = prop.GetdataFromPropFile("Firstname");
		String FirstName1 = prop.GetdataFromPropFile("Firstname1");
		String Middlename = prop.GetdataFromPropFile("Middlename");
		String Middlename1 = prop.GetdataFromPropFile("Middlename1");
		String LastName = prop.GetdataFromPropFile("LastName");
		String LastName1 = prop.GetdataFromPropFile("LastName1");
		String Ad = prop.GetdataFromPropFile("Ad");
		String Ad1 = prop.GetdataFromPropFile("Ad1");
		String Email = prop.GetdataFromPropFile("Email");
		String Email1 = prop.GetdataFromPropFile("Email1");
		String cadre1 = prop.GetdataFromPropFile("cadre");
		String cadre2 = prop.GetdataFromPropFile("cadre1"); 
		String jd = prop.GetdataFromPropFile("JoiningDate");
		String jd1 = prop.GetdataFromPropFile("JoiningDate1");
		String Birthdate_textbox = prop.GetdataFromPropFile("birthdate");
		String Birthdate_textbox1 = prop.GetdataFromPropFile("birthdate1");
		String Designsation = prop.GetdataFromPropFile("Designation");
		String Designsation1 = prop.GetdataFromPropFile("Designation1");
		obj.clickElement(Employeeid);
		obj.Type(Employeeid, id);
		Select se = new Select(driver.findElement(By.xpath(prop.GetdataFromPropFile("Title"))));
		se.selectByVisibleText("Mr");
		obj.Type(FirstName, FirstName1);
		obj.Type(Middlename, Middlename1);
		obj.Type(LastName, LastName1);
		obj.Type(Ad, Ad1);
		obj.Type(Email, Email1);
		obj.Type(jd, jd1);
		obj.Enter(jd);
		obj.Type(Birthdate_textbox, Birthdate_textbox1);
		obj.Enter(Birthdate_textbox);
		obj.Actions(cadre1, cadre2);
		obj.Clear(Designsation);
		obj.Type(Designsation, Designsation1);
		WebElement Save = driver.findElement(By.xpath("//button[@id='btnSaveUserProfile']"));

		obj.clickElementJs(Save);
		WebElement Logout = driver.findElement(By.xpath(prop.GetdataFromPropFile("Logout")));
		obj.clickElementJs(Logout);

		// Login with Created User
		String email = prop.getXpathFromPropFile("LoginPage.prop", "email");
		String loginid = prop.getXpathFromPropFile("LoginPage.prop", "loginid");
		String pwd = prop.getXpathFromPropFile("LoginPage.prop", "Pwd");
		String password = prop.getXpathFromPropFile("LoginPage.prop", "pwd");
		String Signin = prop.getXpathFromPropFile("LoginPage.prop", "Signin");
		obj.clickElement(email);
		obj.Type(email, loginid);
		obj.clickElement(pwd);
		obj.Type(pwd, password);
		obj.ClickElement(Signin);
		String LoggedinUser = driver.findElement(By.xpath("//span[@class='hidden-xs pull-left']")).getText();
		System.out.println(LoggedinUser);
		Assert.assertTrue((LoggedinUser.equalsIgnoreCase("Suhas Chavan")),
				"User was unable to Navigate  successfully.");
		Reporter.log("User was Crerated Successfully");
		WebElement Logout_Created_User = driver.findElement(By.xpath(prop.GetdataFromPropFile("Logout")));
		obj.clickElementJs(Logout_Created_User);
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public void AddAssignment(String url) throws Exception {
		loginAsAdmin(url);
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		String Employee_id = prop.GetdataFromPropFile("SearchEmployeeTextbox");
		String id_data = prop.GetdataFromPropFile("id");
		String Employee_Edit = prop.GetdataFromPropFile("EmployeEdit");
		String Create_Assignment = prop.GetdataFromPropFile("CreateAssignment");

		String Region1 = prop.GetdataFromPropFile("RegionSelectAhmedabad");
		String Functions = prop.GetdataFromPropFile("Functions");
		String Position = prop.GetdataFromPropFile("Position");
 
		String Add = prop.GetdataFromPropFile("Add");
		String SaveAssignment = prop.GetdataFromPropFile("save");
		WebElement Search = driver.findElement(By.xpath(prop.GetdataFromPropFile("Search")));
		obj.clickElementJs(Search);
		obj.Type(Employee_id, id_data);
		obj.Enter(Employee_id);
		WebElement SearchEmployee1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SearchEmployee")));
		obj.clickElementJs(SearchEmployee1);
		Thread.sleep(2000);
		obj.click(Employee_Edit);
		obj.click(Create_Assignment);
		WebElement Corporate = driver.findElement(By.xpath(prop.GetdataFromPropFile("level")));
		obj.clickElementJs(Corporate);
		WebElement Conracting = driver.findElement(By.xpath(prop.GetdataFromPropFile("Vertical")));
		obj.clickElementJs(Conracting);
		WebElement Region = driver.findElement(By.xpath(prop.GetdataFromPropFile("Region")));
		WebDriverWait wait = new WebDriverWait(driver, 20);
         wait.until(ExpectedConditions.visibilityOfElementLocated
        		(By.xpath(prop.GetdataFromPropFile("Region"))));
		obj.clickElementJs(Region);
        obj.click(Region1);
		obj.click(Functions);
		WebElement Functions1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("Functions1")));
		obj.clickElementJs(Functions1);
		obj.click(Position);
		WebElement Position1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SL1")));
		obj.clickElementJs(Position1);
		WebElement Reporting = driver.findElement(By.xpath(prop.GetdataFromPropFile("PrimaryReporting")));
		obj.clickElementJs(Reporting);
		WebElement PrimaryReporting1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("Reporting")));
		obj.clickElementJs(PrimaryReporting1);
		WebElement MatrixReporting = driver.findElement(By.xpath(prop.GetdataFromPropFile("Matrix")));
		obj.clickElementJs(MatrixReporting);
		WebElement MatrixReporting1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("MatrixReporting")));
		obj.clickElementJs(MatrixReporting1);
		obj.click(Add);
		obj.click(SaveAssignment);
		WebDriverWait wait1 = new WebDriverWait(driver,20);
        String Text	= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.GetdataFromPropFile("CreateAssignmentSucessMessage"))))
        		.getText();
        System.out.println(Text);
        Assert.assertTrue((Text.contains("Record saved successfully.")), "User was unable to Navigate  successfully.");
		Reporter.log("First Assignment was  Successfully Added ");
		WebElement Logout = driver.findElement(By.xpath(prop.GetdataFromPropFile("Logout")));
		obj.clickElementJs(Logout);
	}

	@SuppressWarnings("deprecation")
	public void loginCreatedUser() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		String url = "http://192.168.10.37:9081/Account/Login";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String email = prop.getXpathFromPropFile("LoginPage.prop", "email");
		String loginid = prop.getXpathFromPropFile("LoginPage.prop", "loginid");
		String pwd = prop.getXpathFromPropFile("LoginPage.prop", "Pwd");
		String password = prop.getXpathFromPropFile("LoginPage.prop", "pwd");
		String Signin = prop.getXpathFromPropFile("LoginPage.prop", "Signin");
		obj.clickElement(email);
		obj.Type(email, loginid);
		obj.clickElement(pwd);
		obj.Type(pwd, password);
		obj.ClickElement(Signin);
		String Assignment = driver.findElement(By.xpath("//span[normalize-space()='HSE']")).getText();
		System.out.println(Assignment);
		Assert.assertTrue((Assignment.equalsIgnoreCase("HSE")), "User was unable to Navigate  successfully.");
		Reporter.log("Assignment Was Added Succesfully");
		WebElement Logout_Created_User = driver.findElement(By.xpath(prop.GetdataFromPropFile("Logout")));
		obj.clickElementJs(Logout_Created_User);
	}

	public void UpdateUserProfile(String url) throws Exception {
		loginAsAdmin(url);
		String Employee_id = prop.GetdataFromPropFile("SearchEmployeeTextbox");
		String id_data = prop.GetdataFromPropFile("id");
		String Employee_Edit = prop.GetdataFromPropFile("EmployeEdit");
		String OfficeNumber = prop.GetdataFromPropFile("OfficeNumber");
		String OfficeNumber1 = prop.GetdataFromPropFile("OfficeNumber1");
		String MobileNumber = prop.GetdataFromPropFile("MobileNumber");
		String MobileNumber1 = prop.GetdataFromPropFile("MobileNumber1");
		String Update_Profile = prop.GetdataFromPropFile("UpdateProfile");
		WebElement Search = driver.findElement(By.xpath(prop.GetdataFromPropFile("Search")));
		obj.clickElementJs(Search);
		obj.Type(Employee_id, id_data);
		obj.Enter(Employee_id);
		WebElement SearchEmployee1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SearchEmployee")));
		obj.clickElementJs(SearchEmployee1);
		Thread.sleep(2000);
		obj.click(Employee_Edit);
		obj.click(Update_Profile);
		obj.Clear(OfficeNumber);
		obj.Type(OfficeNumber, OfficeNumber1);
		obj.Clear(MobileNumber);
		obj.Type(MobileNumber, MobileNumber1);
		WebElement Save = driver.findElement(By.xpath("//button[@id='btnSaveUserProfile']"));
		obj.clickElementJs(Save);
		WebElement Logout_Created_User = driver.findElement(By.xpath(prop.GetdataFromPropFile("Logout")));
		obj.clickElementJs(Logout_Created_User);
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	public void UpdateUserWithSecondAssignment(String url) throws Exception {
		loginAsAdmin(url);
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		String Employee_id = prop.GetdataFromPropFile("SearchEmployeeTextbox");
		String id_data = prop.GetdataFromPropFile("id");
		String Employee_Edit = prop.GetdataFromPropFile("EmployeEdit");
		String Create_Assignment = prop.GetdataFromPropFile("CreateAssignment");
		String Region1 = prop.GetdataFromPropFile("RegionSelectBengaluru");
		String Functions = prop.GetdataFromPropFile("Functions");
		String Position = prop.GetdataFromPropFile("Position");
		String Back = prop.GetdataFromPropFile("Back");
		
        String Add = prop.GetdataFromPropFile("Add");
		String SaveAssignment = prop.GetdataFromPropFile("save");
		WebElement Search = driver.findElement(By.xpath(prop.GetdataFromPropFile("Search")));
		obj.clickElementJs(Search);
		obj.Type(Employee_id, id_data);
		obj.Enter(Employee_id);
		WebElement SearchEmployee1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SearchEmployee")));
		obj.clickElementJs(SearchEmployee1);
		Thread.sleep(3000);
		obj.click(Employee_Edit);
		obj.click(Create_Assignment);
		WebElement Corporate = driver.findElement(By.xpath(prop.GetdataFromPropFile("level")));
		obj.clickElementJs(Corporate);
		WebElement Conracting = driver.findElement(By.xpath(prop.GetdataFromPropFile("Vertical")));
		obj.clickElementJs(Conracting);
		WebElement Region = driver.findElement(By.xpath(prop.GetdataFromPropFile("Region")));
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated
       		(By.xpath(prop.GetdataFromPropFile("Region"))));
		obj.clickElementJs(Region);
		obj.click(Region1);
		obj.click(Functions);
		WebElement Functions1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("Functions1")));
		obj.clickElementJs(Functions1);
		obj.click(Position);
		WebElement Position1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SL1")));
		obj.clickElementJs(Position1);
		WebElement Reporting = driver.findElement(By.xpath(prop.GetdataFromPropFile("PrimaryReporting")));
		obj.clickElementJs(Reporting);
		WebElement PrimaryReporting1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("Reporting2")));
		obj.clickElementJs(PrimaryReporting1);
		WebElement MatrixReporting = driver.findElement(By.xpath(prop.GetdataFromPropFile("Matrix")));
		obj.clickElementJs(MatrixReporting);
		WebElement MatrixReporting1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("MatrixReporting2")));
		obj.clickElementJs(MatrixReporting1);
		obj.click(Add);
		obj.click(SaveAssignment);
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
        String Text	= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.GetdataFromPropFile("CreateAssignmentSucessMessage"))))
        		.getText();
        System.out.println(Text);
        Assert.assertTrue((Text.contains("Record saved successfully.")), "User was unable to Navigate  successfully.");
		Reporter.log("Second Assignment was  Successfully Added ");
		WebElement Logout = driver.findElement(By.xpath(prop.GetdataFromPropFile("Logout")));
		obj.clickElementJs(Logout);
	}
     @SuppressWarnings({ "deprecation", "unused" })
	public void SecondAssginmentaddedverify(String url) throws Exception {
 		loginAsAdmin(url);
        String Employee_id = prop.GetdataFromPropFile("SearchEmployeeTextbox");
		String id_data = prop.GetdataFromPropFile("id");
		String Employee_Edit = prop.GetdataFromPropFile("EmployeEdit");
		String Update_Profile = prop.GetdataFromPropFile("UpdateProfile");
	    String Assignment1Cancel = prop.GetdataFromPropFile("Cancel");
		String Assignment2Cancel = prop.GetdataFromPropFile("CancelAll");
		String AssignmentCancel = prop.GetdataFromPropFile("CancelAssignment");
        WebElement Search = driver.findElement(By.xpath(prop.GetdataFromPropFile("Search")));
        obj.clickElementJs(Search);
		obj.Type(Employee_id, id_data);
		obj.Enter(Employee_id);
		WebElement SearchEmployee1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SearchEmployee")));
		obj.clickElementJs(SearchEmployee1);
		Thread.sleep(2000);
		obj.click(Employee_Edit);
		obj.click(Update_Profile);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        String Text1	= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.GetdataFromPropFile
        		("BangloreVerify")))).getText();
        System.out.println(Text1);
        Assert.assertTrue((Text1.contains("Bengaluru")), "User was unable to Navigate  successfully.");
		Reporter.log("Second Assignment was  Successfully Updated in System");
		obj.click(Assignment1Cancel);
		obj.click(Assignment2Cancel);
		obj.click(AssignmentCancel);
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
        String Text2	= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.GetdataFromPropFile
        		("CancelSuccesMessage")))).getText();
        System.out.println(Text2);
        Assert.assertTrue((Text2.contains("User Assignment Cancel Successfully")), "User was unable to Navigate  successfully.");
		Reporter.log("Assignments were Successfully Cancelled");
        WebElement Logout = driver.findElement(By.xpath(prop.GetdataFromPropFile("Logout")));
		obj.clickElementJs(Logout);
	}

	@SuppressWarnings("deprecation")
	public void ScheduleTransfer(String url) throws Exception {
		loginAsAdmin(url);
		String Employee_id = prop.GetdataFromPropFile("SearchEmployeeTextbox");
		String id_data = prop.GetdataFromPropFile("id");
		String Employee_Edit = prop.GetdataFromPropFile("EmployeEdit");
		String Scheduledate = prop.GetdataFromPropFile("Scheduledate");
		String Date = prop.GetdataFromPropFile("date");
        String Region1 = prop.GetdataFromPropFile("RegionSelectDelhi");
		String Functions = prop.GetdataFromPropFile("Functions");
		String Position = prop.GetdataFromPropFile("Position");
		String Add = prop.GetdataFromPropFile("Add");
		String Schedule_Transfer = prop.GetdataFromPropFile("ScheduleTransfer");
		WebElement Search = driver.findElement(By.xpath(prop.GetdataFromPropFile("Search")));
		obj.clickElementJs(Search);
		obj.Type(Employee_id, id_data);
		obj.Enter(Employee_id);
		WebElement SearchEmployee1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SearchEmployee")));
		obj.clickElementJs(SearchEmployee1);
		Thread.sleep(2000);
		obj.click(Employee_Edit);
		obj.click(Schedule_Transfer);
		obj.click(Scheduledate);
		obj.Type(Scheduledate, Date);
		obj.Enter(Scheduledate);
		WebElement Corporate = driver.findElement(By.xpath(prop.GetdataFromPropFile("level")));
		obj.clickElementJs(Corporate);
		WebElement Conracting = driver.findElement(By.xpath(prop.GetdataFromPropFile("Vertical")));
		obj.clickElementJs(Conracting);
		WebElement Region = driver.findElement(By.xpath(prop.GetdataFromPropFile("Region")));
		obj.clickElementJs(Region);
		obj.click(Region1);
		obj.click(Functions);
		WebElement Functions1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("Functions1")));
		obj.clickElementJs(Functions1);
		obj.click(Position);
		WebElement Position1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SL1")));
		obj.clickElementJs(Position1);
		WebElement Reporting = driver.findElement(By.xpath(prop.GetdataFromPropFile("PrimaryReporting")));
		obj.clickElementJs(Reporting);
		WebElement PrimaryReporting1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("Reporting3")));
		obj.clickElementJs(PrimaryReporting1);
		WebElement MatrixReporting = driver.findElement(By.xpath(prop.GetdataFromPropFile("Matrix")));
		obj.clickElementJs(MatrixReporting);
		WebElement MatrixReporting1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("MatrixReporting3")));
		obj.clickElementJs(MatrixReporting1);
		obj.click(Add);
		WebElement SaveAssignment = driver.findElement(By.xpath(prop.GetdataFromPropFile("Savetransfer")));
		obj.clickElementJs(SaveAssignment);
		Thread.sleep(5000);
		String SuccessMessage = prop.GetdataFromPropFile("Sucessmsg");
		String Sucsess = driver.findElement(By.xpath(SuccessMessage)).getText();
		System.out.println(Sucsess);
		Assert.assertTrue((Sucsess.contains("Record saved successfully.")), "User was unable to Navigate  successfully.");
		Reporter.log("Schedule Transfer Created  Succesfully");
		WebElement Logout_Created_User = driver.findElement(By.xpath(prop.GetdataFromPropFile("Logout")));
		obj.clickElementJs(Logout_Created_User);
	}

	@SuppressWarnings("deprecation")
	public void VerifyScheduldeTransferRequest(String url) throws Exception {
		loginAsAdmin(url);
		String Employee_id = prop.GetdataFromPropFile("SearchEmployeeTextbox");
		String id_data = prop.GetdataFromPropFile("id");
		String Employee_Edit = prop.GetdataFromPropFile("EmployeEdit");
		String Scheduletransfer = prop.GetdataFromPropFile("ScheduleTransfertab");
		String TransferDate = prop.GetdataFromPropFile("Transferdate");
		String Update_Profile = prop.GetdataFromPropFile("UpdateProfile");
		String Scheduldecancel = prop.GetdataFromPropFile("Scheduldecancel");
		String DeleteScheduletransfer = prop.GetdataFromPropFile("ScheduleTransferCancel");
		String SuccessMessage = prop.GetdataFromPropFile("Sucessmsg");

		WebElement Search = driver.findElement(By.xpath(prop.GetdataFromPropFile("Search")));
		obj.clickElementJs(Search);
		obj.Type(Employee_id, id_data);
		obj.Enter(Employee_id);
		WebElement SearchEmployee1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SearchEmployee")));
		obj.clickElementJs(SearchEmployee1);
		Thread.sleep(2000);
		obj.click(Employee_Edit);
		obj.click(Update_Profile);
		obj.click(Scheduletransfer);
		String Text = driver.findElement(By.xpath(TransferDate)).getText();
		System.out.println(Text);
		Assert.assertTrue((Text.contains("10/10/2022")), "User was unable to Navigate  successfully.");
		Reporter.log("Schedule Transfer Was  Succesfully");
		obj.click(Scheduldecancel);
		obj.click(DeleteScheduletransfer);
		WebDriverWait wait = new WebDriverWait(driver, 20);
        String Text1	= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
        		(prop.GetdataFromPropFile("Sucessmsg")))).getText();
		System.out.println(Text1);
		Assert.assertTrue((Text1.contains("Transfer User Assignment Cancel Successfully")), "User was unable to Navigate  successfully.");
		Reporter.log("Schedule Transfer Was  Succesfully Deleted");
	}
     public void Deactivateuser(String url) throws Exception {
    	 loginAsAdmin(url);
 		String Employee_id = prop.GetdataFromPropFile("SearchEmployeeTextbox");
 		String id_data = prop.GetdataFromPropFile("id");
 		String Employee_Edit = prop.GetdataFromPropFile("EmployeEdit");
 		String Deactivate = prop.GetdataFromPropFile("DeactiviateUser");
 		String Inactive_Date_From = prop.GetdataFromPropFile("InactiveDateFrom");
 		String Inactive_Date_To = prop.GetdataFromPropFile("InactiveDateTo");
 		String Inactive_Date_From_Date = prop.GetdataFromPropFile("InactiveDateFromDate");
 		String Inactive_Date_To_Date = prop.GetdataFromPropFile("InactiveDateto");
        String DeactivateSave = prop.GetdataFromPropFile("DeactivateStatus");
 		String Back = prop.GetdataFromPropFile("Back");
 		String Update_Profile = prop.GetdataFromPropFile("UpdateProfile");
 		String Activelog = prop.GetdataFromPropFile("Activelog");
 		String Cancel = prop.GetdataFromPropFile("DeactivateCancel");

 		String Cancel1 = prop.GetdataFromPropFile("Cancel1");

 		WebElement Search = driver.findElement(By.xpath(prop.GetdataFromPropFile("Search")));
 		obj.clickElementJs(Search);
 		obj.Type(Employee_id, id_data);
 		obj.Enter(Employee_id);
 		WebElement SearchEmployee1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SearchEmployee")));
 		obj.clickElementJs(SearchEmployee1);
 		Thread.sleep(2000);
 		obj.click(Employee_Edit);
 		obj.click(Deactivate);
 		obj.ClickElement(Inactive_Date_From);
 	    obj.Type(Inactive_Date_From, Inactive_Date_From_Date);
    	obj.Enter(Inactive_Date_From);
    	obj.clickElement(Inactive_Date_To);
    	obj.Type(Inactive_Date_To,Inactive_Date_To_Date); 
    	obj.Enter(Inactive_Date_To);
    	obj.click(DeactivateSave);
    	@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
        String Text	= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop","DeActivateSuccessMessage")))).getText();
        System.out.println(Text);
	    Assert.assertTrue((Text.contains("User Deactivation period saved successfully.")), "User was unable to Navigate  successfully.");
		Reporter.log("DeActivation Was Succesfull ");
		obj.click(Back);
		obj.click(Update_Profile);
		obj.click(Activelog);
		Select se = new Select(driver.findElement(By.xpath(prop.GetdataFromPropFile("SelectPagination"))));
		se.selectByVisibleText("50");
		String Text1 = driver.findElement(By.xpath(prop.getXpathFromPropFile("LoginPage.prop", "Verification")))
				.getText();
		System.out.println(Text1);
		Assert.assertTrue((Text1.equalsIgnoreCase("Pending")), "User was unable to Navigate  successfully.");
		Reporter.log("User  DeActivation Was Successfully Updated in System");
	    obj.click(Cancel);
		obj.click(Cancel1);
		Reporter.log("User  DeActivation Request  Was Successfully Deleted");
		}
     public void Delete(String url) throws Exception {
    	 loginAsAdmin(url);
  		String Employee_id = prop.GetdataFromPropFile("SearchEmployeeTextbox");
  		String id_data = prop.GetdataFromPropFile("id");
  		String Employee_Edit = prop.GetdataFromPropFile("EmployeEdit");
  		String Delete = prop.GetdataFromPropFile("Delete");
  		String Delete_Date_From = prop.GetdataFromPropFile("DeleteDate");
  	    String DeleteSave = prop.GetdataFromPropFile("DeleteSave");
  		String Back = prop.GetdataFromPropFile("Back");
  		String Update_Profile = prop.GetdataFromPropFile("UpdateProfile");
  		String Activelog = prop.GetdataFromPropFile("Activelog");
  		String Cancel = prop.GetdataFromPropFile("DeleteButton");
  		String Delete_Textbox = prop.GetdataFromPropFile("DeleteUser");
        String Cancel1 = prop.GetdataFromPropFile("Cancel1");
        String Number_Of_Pages = prop.GetdataFromPropFile("TotalPages");

        WebElement Search = driver.findElement(By.xpath(prop.GetdataFromPropFile("Search")));
  		obj.clickElementJs(Search);
  		obj.Type(Employee_id, id_data);
  		obj.Enter(Employee_id);
  		WebElement SearchEmployee1 = driver.findElement(By.xpath(prop.GetdataFromPropFile("SearchEmployee")));
  		obj.clickElementJs(SearchEmployee1);
  		Thread.sleep(2000);
  		obj.click(Employee_Edit);
  		obj.click(Delete);
 		obj.ClickElement(Delete_Textbox);
 	    obj.Type(Delete_Textbox, Delete_Date_From);
    	obj.Enter(Delete_Textbox);
    	obj.clickElement(DeleteSave);
    	@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
        String Text	= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getXpathFromPropFile("LoginPage.prop","DeleteSuccess")))).getText();
        System.out.println(Text);
        Assert.assertTrue((Text.contains("User Deleted Successfully.")), "User was unable to Navigate  successfully.");
		Reporter.log("User  DeActivation Was Successfully Updated in System");
		obj.click(Back);
		obj.click(Update_Profile);
		obj.click(Activelog);
		//String TotalPages = driver.findElement(By.xpath(prop.GetdataFromPropFile(Number_Of_Pages))).getText();
		//System.out.println(TotalPages);
	//	int TotalPages1= Integer.valueOf(TotalPages.substring(TotalPages.indexOf("f"+1),(""));
		Select se = new Select(driver.findElement(By.xpath(prop.GetdataFromPropFile("SelectPagination"))));
		se.selectByVisibleText("50");
		
	    obj.click(Cancel);
		obj.click(Cancel1);
    	
    	 
     }
     }
