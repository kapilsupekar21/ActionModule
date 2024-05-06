/**
 * 
 */
package Tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
public class ActionModuleNew {
	public static WebDriver driver = Setup.driver;;
	public static WebDriverWait wait; 
	public String  meetingID;
	GetXpathsfromfile prop = new GetXpathsfromfile();
	ObjectUtilities obj = new ObjectUtilities();
	


    // Call method1
	

	public void loginAsAdmin(String Url) throws Exception {
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.clickElement(prop.GetdataFromPropFileAM("Username"));
		obj.typeInElement(prop.GetdataFromPropFileAM("Username"), prop.GetdataFromPropFileAM("un"));
		obj.clickElement(prop.GetdataFromPropFileAM("Password"));
		obj.typeInElement(prop.GetdataFromPropFileAM("Password"), prop.GetdataFromPropFileAM("pw"));
		obj.clickElement(prop.GetdataFromPropFileAM("LoginButton"));
		Thread.sleep(1000);
		
		while (true) {

			WebElement elem_Action = driver
					.findElement(By.xpath("//span[@class='Moduled_name'][normalize-space()='Action']"));

			if (elem_Action.isDisplayed()) {
				// Click the element if it is found
				obj.clickElementByJS(elem_Action);
				// You can add further actions here if needed
				break; // Exit the loop if element is found
			} else {
				// If the element is not found, click the "Next" button or perform other actions
				WebElement nextButton = driver.findElement(
						By.xpath("//div[@id='divOurSpaceCarasoulContainer']//i[@class='fa fa-chevron-right']"));
				obj.clickElementByJS(nextButton);

			}

		}
		obj.assertVerify(prop.GetdataFromPropFileAM("VerifyText"), "List Of Meeting");
	}

	public String createMeeting() throws ElementNotLocatedOnUIException, IOException, InterruptedException {
	//	String startDate = "30/11/2024";
	//	String startTime = "10:00";
	//	String endDate = "30/11/2024";
	//	String endTime = "10:30";
		String Topic = " Sandeep Automation Testing Dont Edit";
		String Description = "Automation Regression Suite";
		String Location = "Automation online Call";
		obj.clickElement(prop.GetdataFromPropFileAM("elem_newMeeting"));
		WebElement RequestType = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_meetingType")));
		obj.clickElementByJS(RequestType);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_reqType"));
		WebElement RequestSubType = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_subType")));
		obj.clickElementByJS(RequestSubType);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_reqSubType"));
		WebElement CategoryType = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_category")));
		obj.clickElementByJS(CategoryType);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_categoryType"));
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_topic"), Topic);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_description"), Description);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_location"), Location);
		
		String startDate = prop.GetdataFromPropFilenewCM("startDate0");
		String startTime = prop.GetdataFromPropFilenewCM("startTime0");
		String endDate = prop.GetdataFromPropFilenewCM("endDate0");
		String endTime = prop.GetdataFromPropFilenewCM("endTime0");
		
		System.out.println("Start Date: " + startDate);
		System.out.println("startTime: " + startTime);
		System.out.println("end Date: " + endDate);
		System.out.println("StastartTimee: " + endTime);


		
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_startDate"), startDate);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_startTime"), startTime);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_endDtae"), endDate);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_endTime"), endTime);
		
		
		WebElement Vertical = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_vertical")));
		obj.clickElementByJS(Vertical);
		
		
		String s1 = prop.GetdataFromPropFilenewCM("elem_verticalContracting");
		
		 String assertText1 = prop.GetdataFromPropFilenewCM("elem_verticaldata0");
		 
		 System.out.println("assertText1 " + assertText1);
		 
		 
		 if (assertText1 != null) {
	            String[] splitValues = assertText1.split("\\|");

	            // Remove leading and trailing whitespaces from each part
	            for (int i = 0; i < splitValues.length; i++) {
	                splitValues[i] = splitValues[i].trim();
	                System.out.println("assertText1 is  " + splitValues[i]);
	                
	                
	                obj.typeInElement(prop.GetdataFromPropFilenewCM("elem_searchTextMember1"), splitValues[i]);

	                String NewStatus=s1.replace("X", splitValues[i]);
	                
	              

	                
	        		System.out.println(NewStatus); 

	            //    WebElement RequestType1 = driver.findElement(By.xpath(NewStatus));

	              //  obj.clickElementByJS(RequestType1);
	                
//	        		WebElement RequestType = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_meetingType")));
       	//	obj.clickElementByJS(RequestType);
	       		
	       		//obj.clickElement(prop.GetdataFromPropFileAM(NewStatus));
	     		obj.click(NewStatus);
	            
	            }
		 }       else {
	                 System.out.println("assertText1 is null " );
	             }
		 
		
		
		WebElement Region = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_region")));
		obj.clickElementByJS(Region);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_regionselect"));
		WebElement Project = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_Project")));
		obj.clickElementByJS(Project);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_ProjectSelect"));
		WebElement Function = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_Function")));
		obj.clickElementByJS(Function);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_functionSelect"));
		obj.clickElementByJS(Function);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_createMeeting"));
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_successMessage"));
		String Text = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_successMessage"))).getText();
		meetingID = obj.getTextHidden(prop.GetdataFromPropFileAM("elem_meetingid"));
		System.out.println(meetingID);
		String assertText = prop.GetdataFromPropFileAM("success_verification");
		assertText = assertText.trim();
		Text = Text.replace("x", " ");
		Text = Text.trim();
		System.out.println(Text + "\n" + assertText);
		Assert.assertTrue((Text.contentEquals(assertText)), "Test Verification Failed");
		Reporter.log("Test Verification Passed");
		
		return meetingID;
	}


	public void addMemberAndTopic() throws Exception, Exception {

	 	String internalUser = "Vru";  
		String externalUser = "Sandeep@gmail.com"; 
		String addTopic = "Adding Topic For Automation Testing";
		String Description = "Automation Regression Suite";
		
	//    WebElement elem_edit = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_edit")));
		 
	//	obj.clickElementByJS(elem_edit);
		
//	int meetingmembser =0;
    	
		   
	String meetingmembser = prop.GetdataFromPropFileAM("Data_Meetingmenber");
	
    System.out.println("meetingmembser="  + meetingmembser);

	
	int Member=Integer.parseInt(meetingmembser);  
	
	 System.out.println("Member="  + Member);

	    
        for (int j = 0; j < Member; j++) {
            String s;
            // Initialize s with an empty string or any appropriate initial value
            s = "MailData"; // or s = "some_initial_value";

            // Multiply s by j (assuming s is intended to be a string)
            s = s + j;

            // Print the result or use it as needed
//            System.out.println("Result for j=" + j + ": " + s);
            
           String S6 =s;
           
           System.out.println("Result for S6="  + S6);

            
        	String s11 = prop.GetdataFromPropFilenew(S6);
        	 if (s11 != null) {
                 String[] splitValues = s11.split("\\|");

                 // Remove leading and trailing whitespaces from each part
                 for (int i = 0; i < splitValues.length; i++) {
                     splitValues[i] = splitValues[i].trim();
                 }

                 // Save in 4 different variables
                 String variable1 = splitValues[0];
                 String variable2 = splitValues[1];
                 String variable3 = splitValues[2];
                 String variable4 = splitValues[3];

                 // Print the variables
                 System.out.println("Variable 1: " + variable1);
                 System.out.println("Variable 2: " + variable2);
                 System.out.println("Variable 3: " + variable3);
                   System.out.println("Variable 4: " + variable4);
                 
                 if(variable3.equals("SPCPL")) 
   		    	  
		    	  {
             		obj.typeInElement(prop.GetdataFromPropFileAM("elem_searchTextMember"), variable1);
            	//	obj.clickElement(prop.GetdataFromPropFileAM("elem_addMember"));
            		
             		obj.clickElement(prop.GetdataFromPropFileAM("elem_addMembernew"));
             		
             	
                	 
		    	  } else  if(variable3.equals("External")) 
		    	  {
		    		  	obj.clickElement(prop.GetdataFromPropFileAM("elem_addExternal"));
		    			obj.typeInElement(prop.GetdataFromPropFileAM("elem_emailIDExternalUser"), variable2);
		    			obj.typeInElement(prop.GetdataFromPropFileAM("elem_addExternalUser"), variable1);
		    		  
		    	  }
                 
                // driver.findElement(By.xpath("//*[@id=\"_divStakHolderRole\"]/span/div/button")
                 
                 obj.clickElement(prop.GetdataFromPropFileAM("elem_roleDropdown"));
                
				 String s1 = prop.GetdataFromPropFileAM("elem_role");
				 
				 System.out.println(s1);

				 String NewStatus=s1.replace("X", variable4);
				 
			 System.out.println(NewStatus);

			//	 System.out.println(NewStatus);  
                 
                 
					obj.click(NewStatus);
				// obj.clickElement(prop.GetdataFromPropFileAM("elem_role"));
                 
				  
				 
                 obj.clickElement(prop.GetdataFromPropFileAM("elem_addMemberButton"));
                 
         		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_addMemberSuccessMessage"));
         		String elem_TextRetrived = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_addMemberSuccessMessage")))
        				.getText();
        		System.out.println(elem_TextRetrived);
        		String assertText ="Record saved successfully.";
        		elem_TextRetrived = elem_TextRetrived.replace("x"," "); 
        		elem_TextRetrived = elem_TextRetrived.trim();

        		System.out.println(elem_TextRetrived + "\n" + assertText);
        		
        	//	assertTrue((elem_TextRetrived.equalsIgnoreCase(assertText)), "Test Verification Failed");
        		Assert.assertTrue((elem_TextRetrived.contentEquals(assertText)), "Test Verification Failed");

        		Reporter.log("Test Verification Passed");
                 
             } else {
                 System.out.println("s11 is null for j=" + j);
             }
	


    
}
		/*		
		
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_searchTextMember"), internalUser);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_addMember"));
		obj.clickElement(prop.GetdataFromPropFileAM("elem_addMemberButton"));
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_addMemberSuccessMessage"));
		String elem_TextRetrived = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_addMemberSuccessMessage")))
				.getText();
		System.out.println(elem_TextRetrived);
		String assertText ="Record saved successfully.";
		elem_TextRetrived = elem_TextRetrived.replace("x"," "); 
		elem_TextRetrived = elem_TextRetrived.trim();

		System.out.println(elem_TextRetrived + "\n" + assertText);
	//	assertTrue((elem_TextRetrived.equalsIgnoreCase(assertText)), "Test Verification Failed");
		Assert.assertTrue((elem_TextRetrived.contentEquals(assertText)), "Test Verification Failed");

		Reporter.log("Test Verification Passed");

		// adding external user

		
		obj.clickElement(prop.GetdataFromPropFileAM("elem_addExternal"));
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_emailIDExternalUser"), externalUser);
	
		externalUser =	externalUser.substring(0, 7);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_addExternalUser"), externalUser);
		
		obj.clickElement(prop.GetdataFromPropFileAM("elem_addMemberButton"));
		String ExternalUserText = driver
				.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_addMemberSuccessMessage"))).getText();
		String ExternalUserassertText = "Record saved successfully.";
		ExternalUserText = ExternalUserText.replace("x", " ");
		ExternalUserText = ExternalUserText.trim();
		System.out.println(ExternalUserText + "\n" + assertText);
		Assert.assertTrue((ExternalUserText.contains(ExternalUserassertText)), "Test Verification Failed");
		Reporter.log("Test Verification Passed");

	*/
		
		// add Topic

		obj.typeInElement(prop.GetdataFromPropFileAM("elem_addTopic"),addTopic);
       WebElement elem_save = driver
					.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_save")));
			 
			obj.clickElementByJS(elem_save);
			String topicSave = driver
					.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_addMemberSuccessMessage"))).getText();
			String assertSave = "Record saved successfully.";
			topicSave = topicSave.replace("x", " ");
			topicSave = topicSave.trim();
			System.out.println(topicSave + "\n" + assertSave);
			Assert.assertTrue((topicSave.contains(assertSave)), "Test Verification Failed");
			Reporter.log("Test Verification Passed");
			
		//	   obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));
			   
			    WebElement elem_edit1 = driver
						.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_backButton")));
			   
			   obj.clickElementByJS(elem_edit1);

			    
	}
 	

public void test() throws Exception, Exception {
	// TODO Auto-generated method stub

	 System.out.println(meetingID); 
}
             
} 
