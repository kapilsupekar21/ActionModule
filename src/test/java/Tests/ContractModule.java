/**
 * 
 */
package Tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
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

import autoFW.exceptions.ElementNotLocatedOnUIException;

/**
 * @author Sandeep.Virk
 *
 */
public class ContractModule {
	public static WebDriver driver = Setup.driver;;
	public static WebDriverWait wait;
	private String Updatedtext = "Automation Test Data Cleared And Updated";
	GetXpathsfromfile prop = new GetXpathsfromfile();
	ObjectUtilities obj = new ObjectUtilities();
	

	public void loginAsAdmin(String Url) throws Exception {
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.clickElement(prop.GetdataFromPropFileCM("elem_Login")); 
		obj.typeInElement(prop.GetdataFromPropFileCM("elem_Login"), prop.GetdataFromPropFileCM("login"));
		obj.clickElement(prop.GetdataFromPropFileCM("next"));
		obj.clickElement(prop.GetdataFromPropFileCM("pw"));
		obj.typeInElement(prop.GetdataFromPropFileCM("pw"), prop.GetdataFromPropFileCM("Password")); 
		obj.clickElement(prop.GetdataFromPropFileCM("signin"));
		Thread.sleep(1000); 


		while (true) {

			WebElement CMS = driver.findElement(By.xpath("//span[@class='Moduled_name'][normalize-space()='CMS']"));

			if (CMS.isDisplayed()) {
				// Click the element if it is found
				obj.clickElementByJS(CMS);
				// You can add further actions here if needed
				break; // Exit the loop if element is found
			} else {
				// If the element is not found, click the "Next" button or perform other actions
				WebElement nextButton = driver.findElement(
						By.xpath("//div[@id='divOurSpaceCarasoulContainer']//i[@class='fa fa-chevron-right']"));
				obj.clickElementByJS(nextButton);

			}
		}

	}

	public void loader() throws IOException {
		String xpath_elem_ajaxLoaderSmall = prop.GetdataFromPropFileCM("elem_loader");
		obj.Reporter__log("Waiting for smallLoader to appear");
		obj.waitUntilElementIsVisible(xpath_elem_ajaxLoaderSmall, Setup.defaultTimeOutForObjectWait);
		obj.Reporter__log("Waiting for smallLoader to disappear");
		obj.waitUntilElementNotVisible(xpath_elem_ajaxLoaderSmall, Setup.defaultTimeOutForObjectWait);

	}

	public void advancedSearch() throws IOException, ElementNotLocatedOnUIException, Exception {
		// wait for loader to appear and disappear
		loader();
		WebElement elem_filter = driver.findElement(By.xpath(prop.GetdataFromPropFileCM("elem_searchFunnel")));
		obj.clickElementByJS(elem_filter);
		WebElement verticalDropdown = driver.findElement(By.xpath(prop.GetdataFromPropFileCM("elem_verticalDropdown")));
		obj.clickElementByJS(verticalDropdown);

		obj.typeInElement(prop.GetdataFromPropFileCM("elem_projectInfo"), "Automation Testing");
		WebElement elem_search = driver.findElement(By.xpath(prop.GetdataFromPropFileCM("elem_btnSearch")));
		obj.clickElementByJS(elem_search);
		obj.clickElement(prop.GetdataFromPropFileCM("elem_view"));

	} 

	public void projectTab() throws Exception, IOException {
	      loader();
		obj.typeInElement(prop.GetdataFromPropFileCM("elem_description"), Updatedtext);
		obj.typeInElement(prop.GetdataFromPropFileCM("elem_address"), Updatedtext);

		obj.clickElement(prop.GetdataFromPropFileCM("elem_contractualDate"));
		obj.clickcss(prop.GetdataFromPropFileCM("elem_currentDate"));
		obj.clickElement(prop.GetdataFromPropFileCM("elem_save"));
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileCM("elem_succesmessage"));
		String Text = driver.findElement(By.xpath(prop.GetdataFromPropFileCM("elem_succesmessage"))).getText();
		String assertText = prop.GetdataFromPropFileCM("success_MessageProjectDetails");
		assertText =	assertText.trim();
		Text = Text.replace("x", " ");
		Text = Text.trim();
		System.out.println(Text); 
		System.out.println(Text  + "\n" + assertText);
		Assert.assertTrue((Text.contentEquals(assertText)), "Test Verification Failed");
		Reporter.log("Test Verification Passed");
	} 

	public void contractTab() throws IOException, ElementNotLocatedOnUIException {
		String contractTab = "Updated text after clearing";
		String originalContractValue ="11111";
		String elem_contractDuration ="98";
		WebElement elem_contractSailentFeatures = driver.findElement(By.xpath(prop.GetdataFromPropFileCM("elem_contratTab")));
		obj.clickElementByJS(elem_contractSailentFeatures);
	
		obj.selectItemFromDropdown(prop.GetdataFromPropFileCM("elem_Sector"), "Airport", true, false, 0);
		obj.selectItemFromDropdown(prop.GetdataFromPropFileCM("elem_clienType"), "Government", true, false, 0);
		obj.selectItemFromDropdown(prop.GetdataFromPropFileCM("elem_TypeOfContract"), "Conventional", true, false, 0);
		obj.selectItemFromDropdown(prop.GetdataFromPropFileCM("elem_contractModel"), "BOT", true, false, 0);
		obj.typeInElement(prop.GetdataFromPropFileCM("elem_nameOfContract"), contractTab);
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileCM("elem_nameOfContract"));
		obj.typeInElement(prop.GetdataFromPropFileCM("elem_contractnumber"), contractTab);
		obj.typeInElement(prop.GetdataFromPropFileCM("elem_originalContractvalue"), originalContractValue);
		obj.typeInElement(prop.GetdataFromPropFileCM("elem_contractduration"), elem_contractDuration); 
		obj.clickElement(prop.GetdataFromPropFileCM("elem_contractTabSave")); 
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileCM("elem_succesmessage"));
		String Text = driver.findElement(By.xpath(prop.GetdataFromPropFileCM("elem_succesmessage"))).getText();
		String assertText = prop.GetdataFromPropFileCM("success_ContractSailentFeatures");
		assertText =	assertText.trim();
		Text = Text.replace("x", " ");
		Text = Text.trim();
		System.out.println(Text);
		System.out.println(Text  + "\n" + assertText);
		Assert.assertTrue((Text.contentEquals(assertText)), "Test Verification Failed");
		Reporter.log("Test Verification Passed");
	} 
  
		public void keyDates() throws ElementNotLocatedOnUIException, Exception {
			obj.clickElement(prop.GetdataFromPropFileCM("elem_keyValueDates")); 
			WebElement browseBtn = obj.getWebElement(prop.GetdataFromPropFileCM("elem_browseBtn"));
			obj.clickElement(browseBtn); 
			Thread.sleep(2000); // allow windows popup to appear 
			Robot robot = new Robot();  
			obj.sendRobotKeys(robot, "C:\\Users\\Sandeep.Virk\\Desktop\\automation1\\AA.jpg"); 
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
            obj.clickElement(prop.GetdataFromPropFileCM("elem_btnUpload"));
            obj.clickElement(prop.GetdataFromPropFileCM("elem_confirmatorySave"));
            Thread.sleep(5000);
            WebElement saveBtn = obj.getWebElement(prop.GetdataFromPropFileCM("elem_save1"));
			obj.clickElementByJS(saveBtn);  
			
		}
		public void contractDocument() throws IOException, Exception {
			WebElement elem_contractSailentFeatures = driver.findElement(By.xpath(prop.GetdataFromPropFileCM("elem_contractTab")));
			obj.clickElementByJS(elem_contractSailentFeatures);
			
			String title = " Automation Testing Contract Updated text after clearing";
			String description ="Automation Testing Contract Updated text after clearing";
			obj.clickElement(prop.GetdataFromPropFileCM("elem_addcontract"));
			
			obj.typeInElement(prop.GetdataFromPropFileCM("elem_titlecontract"), title);
			obj.typeInElement(prop.GetdataFromPropFileCM("elem_descriptioncontract"), description);
			obj.selectItemFromDropdown(prop.GetdataFromPropFileCM("elem_documentVersion"), " Contract Document # Volume [2]", true, false, 0);
			obj.selectItemFromDropdown(prop.GetdataFromPropFileCM("elem_documentType"), " The Construction Agreement", true, false, 0);
			obj.clickElement(prop.GetdataFromPropFileCM("elem_contractDocumentdate"));
			WebElement elem_contractCurrentDate = driver.findElement(By.xpath(prop.GetdataFromPropFileCM("currentdate")));
			obj.clickElementByJS(elem_contractCurrentDate);
			WebElement browseBtn = obj.getWebElement(prop.GetdataFromPropFileCM("elem_browseButton"));
			obj.clickElement(browseBtn); 
			Thread.sleep(2000); // allow windows popup to appear 
			Robot robot = new Robot();  
			obj.sendRobotKeys(robot, "C:\\Users\\Sandeep.Virk\\Desktop\\automation1\\Testing.pdf"); 
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(5000);  
            obj.clickElement(prop.GetdataFromPropFileCM("elem_fileUpload"));
            Thread.sleep(5000);    
            WebElement saveBtn = obj.getWebElement(prop.GetdataFromPropFileCM("elem_Save")); 
			obj.clickElementByJS(saveBtn);   
		}  
}     
