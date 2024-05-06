/**
 * 
 */
package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Space.ObjectsUtilities.ObjectUtilities;
import Space.Xpaths.GetXpathsfromfile;

/**
 * @author Sandeep.Virk
 *
 */
public class CMSTests {
	public static WebDriver driver;
	GetXpathsfromfile prop;
	ObjectUtilities obj;
	ContractModule aut;
  
	@BeforeClass
 
	public void testsetup() throws Exception {

		driver = Setup.driver;
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		aut = new ContractModule();
	} 
 
	@Test(priority = 0) 
	@Parameters({ "url" })
	public void loginAsAdmin(String url) throws Exception {
		aut.loginAsAdmin(url);

	

}
	@Test(priority = 1)
	@Parameters()
	public void advancedSearch() throws Exception {
		aut.advancedSearch();
}
	@Test(priority = 2)
	@Parameters()
	public void projectTab() throws Exception {
		aut.projectTab();
}
	@Test(priority = 3)
	@Parameters()
	public void contractTab() throws Exception {
		aut.contractTab();
	
}
//@Test(priority = 4)
//	
//	public void contractDocument() throws Exception {
//		aut.contractDocument();
//		
//} 
	
}

