package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Space.Functions.AutFunctions;
import Space.ObjectsUtilities.ObjectUtilities;
import Space.Xpaths.GetXpathsfromfile;

public class ConfigurationTests {

	public static WebDriver driver;
	GetXpathsfromfile prop;
	ObjectUtilities obj;
	Configuration aut1;

	@BeforeClass

	public void testsetup() throws Exception {

		this.driver = Setup.driver;
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		aut1 = new Configuration();
	}

	@Test(priority = 0)
	@Parameters({ "url" })
	public void loginAsAdmin(String url) throws Exception {
		aut1.loginAsAdmin(url);

	}

	@Test(priority = 1)
	public void VerifyConfigurationNavigation() throws Exception {
		aut1.VerifyConfigurationNavigation();

	}
	@Test(priority =2)
	public void EmployeePfContribution() throws Exception {
		aut1.EmployeePfContribution();

	}
	@Test(priority =3)
	public void EmployerPfContribution() throws Exception {
		aut1.EmployerPfContribution();
	}

	@Test(priority=4)
	public void UpdateWorkingDays1stCutOff() throws Exception {
		aut1.UpdateWorkingDays1stCutOff();
	}

	 @Test(priority=5)
	public void MinimumWorkingHoursInDay() throws Exception {
		aut1.MinimumWorkingHoursInDay();
	}

	 @Test(priority=6)
	public void MaximumWorkingHoursInWeek() throws Exception {
		aut1.MaximumWorkingHoursInWeek();
	}

	 @Test(priority = 7)
	public void MaximumOvertimeHoursInWeek() throws Exception {
		aut1.MaximumOvertimeHoursInWeek();
	}

	 @Test(priority =8)
	public void MaximumOvertimeHoursInDay() throws Exception {
		aut1.MaximumOvertimeHoursInDay();
	}

	 @Test(priority = 9)
	public void MaximumOverallOvertimeHoursInWeek() throws Exception {
		aut1.MaximumOverallOvertimeHoursInWeek();
	}

     @Test(priority = 10)
	public void OvertimeMultiplicationFactor() throws Exception {
		aut1.OvertimeMultiplicationFactor();
	}

	@Test(priority = 11)
	public void EmployeeStateInsuranceContribution() throws Exception {
		aut1.EmployeeStateInsuranceContribution();
	}
	@Test(priority = 12)
	public void EmployerStateInsuranceContribution() throws Exception {
		aut1.EmployerStateInsuranceContribution();
	}
	@Test(priority = 13)
	public void StateInsuranceCutOffAmount() throws Exception {
		aut1.StateInsuranceCutOffAmount();
	}
	@Test(priority = 14)
	public void LabourAutoDeactivationPeriod() throws Exception {
		aut1.LabourAutoDeactivationPeriod();
	}
	@Test(priority = 15)
	public void DayWorkingHours() throws Exception {
		aut1.DayWorkingHours();
	}
	@Test(priority = 16)
	public void HolidayWorkingHours() throws Exception {
		aut1.HolidayWorkingHours();
	}
	@Test(priority = 17)
	public void HolidayWorkingAdditionalWage() throws Exception {
		aut1.HolidayWorkingAdditionalWage();
	}
	@Test(priority = 18)
	public void MaximumContinuesWorkingDays2ndCutOff() throws Exception {
		aut1.MaximumContinuesWorkingDays2ndCutOff();
	}
	@Test(priority = 19)
	public void MinimumPFCutoffAmount() throws Exception {
		aut1.MinimumPFCutoffAmount();
	}
	@Test(priority = 20)
	public void AttendancePunchSyncGracePeriod() throws Exception {
		aut1.AttendancePunchSyncGracePeriod();
	}
	@Test(priority = 21)
	public void SMSRate() throws Exception {
		aut1.SMSRATE();
	}
	@Test(priority = 22)
	public void MobileNumberSeriesStartsFrom() throws Exception {
		aut1.MobileNumberSeriesStartsFrom();
	}
}
