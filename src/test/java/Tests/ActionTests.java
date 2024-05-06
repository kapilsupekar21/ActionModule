package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Space.ObjectsUtilities.ObjectUtilities;
import Space.Xpaths.GetXpathsfromfile;

public class ActionTests {
	public static WebDriver driver;
	GetXpathsfromfile prop;
	ObjectUtilities obj;
	ActionModuleNew amn;
	
	//editMember em;
	public static int defaultTimeOutForObjectWait;
  
	@BeforeClass
 
	public void testsetup() throws Exception {

		driver = Setup.driver;
	//	int wait = Setup.defaultTimeOutForObjectWait;
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		amn = new ActionModuleNew();
		
		
	} 
	
	@Test(priority = 0) 
	@Parameters({ "url" })
	public void loginAsAdmin(String url) throws Exception {
	
				
			amn.loginAsAdmin(url);
			amn.createMeeting();
			amn.addMemberAndTopic();
		
	}
}