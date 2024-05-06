package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import Space.Functions.AutFunctions;
import Space.ObjectsUtilities.ObjectUtilities;
import Space.Xpaths.GetXpathsfromfile;

public class Configuration {
	public static WebDriver driver;
	public static WebDriverWait wait;
	GetXpathsfromfile prop;
	ObjectUtilities obj;
	AutFunctions aut;

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
		//obj.clickElement(email);
		obj.Type(email, Loginid);
		obj.clickElement(pwd);
		obj.Type(pwd, Password);
		obj.ClickElement(Signin);
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement lmsbutton = driver.findElement(By.xpath("//span[contains(text(),'LMS (TEMPORARY)')] "));
		obj.clickElementByJS(lmsbutton);	
	}
	@SuppressWarnings("deprecation")
	public void VerifyConfigurationNavigation() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		WebElement AdminBill = driver
				.findElement(By.xpath(prop.GetdataFromPropFile("configuration")));
		obj.clickElementJs(AdminBill);
		String Text = driver.findElement(By.xpath(prop.GetdataFromPropFile( "configurationverify")))
				.getText();
		System.out.println(Text);
		Assert.assertTrue((Text.equalsIgnoreCase("Manage Configuration")),
				"User was unable to Navigate  successfully..");
		Reporter.log("User Navigated to ConfigurationLink Succesfully");
		
		
	}
	@SuppressWarnings("deprecation")
	public void EmployeePfContribution() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("Empfedit");
		String constant = prop.GetdataFromPropFile("constant");
		String Save = prop.GetdataFromPropFile("SaveEmpPF");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath("//div[@id='divSuccessMessageContainer']")).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);

	}
	@SuppressWarnings("deprecation")
	public void EmployerPfContribution() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("EmployerPfEdit");
		String constant = prop.GetdataFromPropFile("EmployerConstant");
		String Save = prop.GetdataFromPropFile("Employersave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath("//div[@id='divSuccessMessageContainer']")).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);

	}
	
	@SuppressWarnings("deprecation")
	public void UpdateWorkingDays1stCutOff() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("CutoffEdit");
		String constant = prop.GetdataFromPropFile("CutoffConstant");
		String Save = prop.GetdataFromPropFile("CutoffSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath("//div[@id='divSuccessMessageContainer']")).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);

	}
	@SuppressWarnings("deprecation")
	public void MinimumWorkingHoursInDay() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String MinimumWorkEdit = prop.GetdataFromPropFile("Minimumwork");
		String constant = prop.GetdataFromPropFile("MimimumWorkconstant");
		String Save_Minimum_work = prop.GetdataFromPropFile("mimimumworksave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(MinimumWorkEdit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save_Minimum_work);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void MaximumWorkingHoursInWeek() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String MaximumWorkEdit = prop.GetdataFromPropFile("MaximumWork");
		String constant = prop.GetdataFromPropFile("MaximumworkConstant");
		String MaximumWorkSave = prop.GetdataFromPropFile("MaximumWorkSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(MaximumWorkEdit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(MaximumWorkSave);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void MaximumOvertimeHoursInWeek() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String maxOvertime_Click = prop.GetdataFromPropFile("maxOvertime");
		String constant = prop.GetdataFromPropFile("MaxConstant");
		String MaximumOvertime_Save = prop.GetdataFromPropFile("MaxSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(maxOvertime_Click);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(MaximumOvertime_Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void MaximumOvertimeHoursInDay() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("MaximumOvertimedayEdit");
		String constant = prop.GetdataFromPropFile("MaximumOverConstant");
		String Save = prop.GetdataFromPropFile("Maximuovertimesave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
}
	@SuppressWarnings("deprecation")
	public void MaximumOverallOvertimeHoursInWeek() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("MaximuOverallOvertimeEdit");
		String constant = prop.GetdataFromPropFile("MaximuOverallOvertimeConstant");
		String Save = prop.GetdataFromPropFile("MaximuOverallOvertimeSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void OvertimeMultiplicationFactor() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("OvertimeMultiplicationFactorEdit");
		String constant = prop.GetdataFromPropFile("OvertimeMultiplicationFactorConstant");
		String Save = prop.GetdataFromPropFile("OvertimeMultiplicationFactorSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void EmployeeStateInsuranceContribution() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("EmployeeStateInsuranceContributionEdit");
		String constant = prop.GetdataFromPropFile("EmployeeStateInsuranceContributionConstant");
		String Save = prop.GetdataFromPropFile("EmployeeStateInsuranceContributionSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void EmployerStateInsuranceContribution() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("EmployerStateInsuranceContributionEdit");
		String constant = prop.GetdataFromPropFile("EmployerStateInsuranceContributionConstant");
		String Save = prop.GetdataFromPropFile("EmployerStateInsuranceContributionSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void StateInsuranceCutOffAmount() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("StateInsuranceCutoffAmountEdit");
		String constant = prop.GetdataFromPropFile("StateInsuranceCutoffAmountConstant");
		String Save = prop.GetdataFromPropFile("StateInsuranceCutoffAmountSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
}
	@SuppressWarnings("deprecation")
	public void LabourAutoDeactivationPeriod() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("LabourAutoDeactivationPeriodEdit");
		String constant = prop.GetdataFromPropFile("LabourAutoDeactivationPeriodConstant");
		String Save = prop.GetdataFromPropFile("LabourAutoDeactivationPeriodSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	
}
	@SuppressWarnings("deprecation")
	public void DayWorkingHours() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("DayWorkingHoursEdit");
		String constant = prop.GetdataFromPropFile("DayWorkingHoursConstant");
		String Save = prop.GetdataFromPropFile("DayWorkingHoursSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	
}
	@SuppressWarnings("deprecation")
	public void HolidayWorkingHours() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("HolidayWorkingHoursEdit");
		String constant = prop.GetdataFromPropFile("HolidayWorkingHoursConstant");
		String Save = prop.GetdataFromPropFile("HolidayWorkingHoursSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void HolidayWorkingAdditionalWage() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("HolidayWorkingAdditionalWageEdit");
		String constant = prop.GetdataFromPropFile("HolidayWorkingAdditionalWageConstant");
		String Save = prop.GetdataFromPropFile("HolidayWorkingAdditionalWageSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void MaximumContinuesWorkingDays2ndCutOff() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("HolidayWorkingAdditionalWageEdit");
		String constant = prop.GetdataFromPropFile("HolidayWorkingAdditionalWageConstant");
		String Save = prop.GetdataFromPropFile("HolidayWorkingAdditionalWageSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void MinimumPFCutoffAmount() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("MinimumPFCutoffAmountEdit");
		String constant = prop.GetdataFromPropFile("MinimumPFCutoffAmountConstant");
		String Save = prop.GetdataFromPropFile("MinimumPFCutoffAmountSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
	@SuppressWarnings("deprecation")
	public void AttendancePunchSyncGracePeriod() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Edit = prop.GetdataFromPropFile("AttendancePunchSyncGracePeriodEdit");
		String constant = prop.GetdataFromPropFile("AttendancePunchSyncGracePeriodConstant");
		String Save = prop.GetdataFromPropFile("AttendancePunchSyncGracePeriodSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue1");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
}
	public void SMSRATE() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		String Edit = prop.GetdataFromPropFile("SMSRateEdit");
		String constant = prop.GetdataFromPropFile("SMSRateConstant");
		String Save = prop.GetdataFromPropFile("SMSRateSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
}
	public void MobileNumberSeriesStartsFrom() throws Exception {
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		driver = Setup.driver;
		String Edit = prop.GetdataFromPropFile("MobileNumberSeriesStartsFromEdit");
		String constant = prop.GetdataFromPropFile("MobileNumberSeriesStartsFromConstant");
		String Save = prop.GetdataFromPropFile("MobileNumberSeriesStartsFromSave");
        String alreadyinputtedvalue = prop.GetdataFromPropFile("alreadyinputtedvalue");
		obj.ClickElement(Edit);
        obj.Clear(constant);
		obj.Type(constant, alreadyinputtedvalue);
		obj.ClickElement(Save);
		String Alertmsg = driver.findElement(By.xpath(prop.GetdataFromPropFile("SuccessMsg"))).getText();
		Assert.assertTrue((Alertmsg.equalsIgnoreCase(Alertmsg)), "Configuration  not updated successfully.");
		Reporter.log(Alertmsg);
		System.out.println(Alertmsg);
	}
}