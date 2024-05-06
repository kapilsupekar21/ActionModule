package Tests;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Space.Functions.AutFunctions;
import Space.Functions.NavigationTests;
import Space.ObjectsUtilities.ObjectUtilities;
import Space.Xpaths.GetXpathsfromfile;


public class NavTests {
    public static WebDriver driver;	
	GetXpathsfromfile prop;
	ObjectUtilities obj;
	NavigationTests aut;
@BeforeClass
	
	public void testsetup() throws Exception {

	    driver = Setup.driver;
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		aut = new NavigationTests();
	}
@Test(priority = 1)
@Parameters({"url"})
public void loginAsAdmin(String url) throws Exception {
	aut.loginAsAdmin(url); 

}

@Test(priority = 2)
public void VerifyLabourAttendance() throws Exception { 
	aut.VerifyLabourAttendanceNavigation();
} 
@Test(priority = 4)
public void SiteMappingNavigation() throws Exception {
	aut.SiteMappingNavigation();
}

@Test(priority = 3)
public void AdvanceRecoveryNavigation() throws Exception { 
	aut.AdvanceRecoveryNavigation();
}
 
@Test(priority = 5)
public void HolidayNavigation() throws Exception {
	aut.HolidayNavigation();
}
@Test(priority = 6)
public void ProjectNavigation() throws Exception {
	aut.ProjectNavigation();
}
@Test(priority = 7)
public void PicklistNavigation() throws Exception {
	aut.PicklistNavigation();
}
@Test(priority = 7)
public void TimeReport() throws Exception {
	aut.TimeReport(); 
}
}