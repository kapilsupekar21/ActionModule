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
public class ActionModuleKapil {
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

	public String createMeeting() throws ElementNotLocatedOnUIException, IOException {
		String startDate = "30/11/2024";
		String startTime = "10:00";
		String endDate = "30/11/2024";
		String endTime = "10:30";
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
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_startDate"), startDate);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_startTime"), startTime);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_endDtae"), endDate);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_endTime"), endTime);
		WebElement Vertical = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_vertical")));
		obj.clickElementByJS(Vertical);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_verticalContracting"));
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

	public String verifyMeetingCreatedDraftStatus() throws IOException, Exception
	 {
		String meetingID1 = meetingID;
		
		meetingID = obj.getTextHidden(prop.GetdataFromPropFileAM("elem_meetingid"));
		System.out.println("Added step by kapil" +meetingID);
		String Text2 = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_meetingid"))).getText();
		System.out.println(Text2);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_globalsearch"), meetingID);
		driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_globalsearch"))).sendKeys(Keys.ENTER);
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_DraftVerify"));
		String draftText = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_DraftVerify"))).getText();
		System.out.println(draftText);
		String assertText = "Draft";
		Assert.assertTrue((draftText.contentEquals(assertText)), "Test Verification Failed");
		Reporter.log("Test Verification Passed");
		
		return meetingID;
        
		
		
	}
 
	
	
	
	
	/**
  	* @author Manasi Potnis : Search meeting raised by me
  *
  */ 	
 
	
	public String SearchMeetingRaisedByMe() throws IOException, Exception{
		
		String meetingrecord; 
		
		
		
		obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));
	    obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_Meetingtext")); 
//		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("Meetingtext"),Setup.defaultTimeOutForObjectWait);   
	    obj.clickElement(prop.GetdataFromPropFileAM("elem_SearchFilter"));
		System.out.println("search screen is opened");
		
		obj.clickElement(prop.GetdataFromPropFileAM("elem_Advancebutton"));
		System.out.println("Advance search screen is opened");
		

		//Thread.sleep(5000); 
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_RBMRadio"));	
		obj.clickElement(prop.GetdataFromPropFileAM("elem_RBMRadio"));
		System.out.println(" My Team meeting Radio Button Selected");
		//enter meeting id
		obj.typeInElement(prop.GetdataFromPropFileAM("MeetingID"), meetingID);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_SerchMeeting"));
		
		//obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("MeetingGrid")); 
		
		obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 

//		Thread.sleep(5000); 
		//Compare - meetingID with xpath meeting id
		//get text for exact meeting ID
		meetingrecord = driver.findElement(By.xpath("//*[@id='meetingSearch']/div[2]/div/div/div[1]/table/tbody/tr[2]/td[1]/div[1]")).getText();
		System.out.println(meetingrecord);
		String NewmeetingID=meetingrecord.substring(5);
		System.out.println("new string: " + NewmeetingID);
		Assert.assertTrue((meetingID.contentEquals(NewmeetingID)), "Test Verification Failed");
		Reporter.log("Test Verification Passed");
		System.out.println("SearchMeetingRaisedByMe Test Case Passed");
		return meetingID;
		
 }	
	
	/**
	* @author Manasi Potnis : Search Meeting with project
	 * @return 
	  *
	  */ 	
	
	public String SearchWithProject() throws IOException, Exception{
		
		String meetingrecord; 
		String projectname;
		String newprojectname = null;
		
		obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));
			obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 

	    //obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_Meetingtext")); 
//		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("Meetingtext"),Setup.defaultTimeOutForObjectWait);   
	    obj.clickElement(prop.GetdataFromPropFileAM("elem_SearchFilter"));
		System.out.println("search screen is opened");
		obj.clickElement(prop.GetdataFromPropFileAM("elem_Reset"));

		obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 

		
		obj.clickElement(prop.GetdataFromPropFileAM("elem_Advancebutton"));
		System.out.println("Advance search screen is opened");
		//Thread.sleep(5000); 
		//Search Project

		obj.clickElement(prop.GetdataFromPropFileAM("elem_Project"));
		System.out.println("Open Project Dropdown");
		obj.clickElement(prop.GetdataFromPropFileAM("elem_ProjectSelect"));
	//	obj.clickElement(prop.GetdataFromPropFileAM("elem_ProjectNameXpath"));
		System.out.println("Project Selected");
		//enter meeting id
		obj.typeInElement(prop.GetdataFromPropFileAM("MeetingID"), meetingID);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_SerchMeeting"));
		
		
		obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 

		//----------------------------------------------------
		
		meetingrecord = driver.findElement(By.xpath("//*[@id='meetingSearch']/div[2]/div/div/div[1]/table/tbody/tr[2]/td[1]/div[1]")).getText();
		projectname = "081-Admin project";
				//driver.findElement(By.xpath("//label[normalize-space()='081-Admin project']")).getText();
		System.out.println(meetingrecord);
		System.out.println("Project Name" + projectname);
		String NewmeetingID=meetingrecord.substring(5);
		System.out.println("new string: " + NewmeetingID);
		System.out.println("new : " + meetingID);
		
		
		if(meetingID.equals(NewmeetingID))
		{
			// action click 
			obj.clickElement(prop.GetdataFromPropFileAM("elem_editmeeting"));
			
			newprojectname = driver.findElement(By.xpath("//*[@id=\"_divProjectDropDown\"]/div/span/div/button/span")).getText();
			Assert.assertTrue((projectname.contentEquals(newprojectname)), "Test Verification Failed");
			Reporter.log("Test Verification Passed");
			/// project compare
		}

		System.out.println("SearchMeetingwithproject Test Case Passed");
	
		
		obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));
		
		obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 

		
		//----------------------------------------------------
		
		//obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("MeetingGrid")); 
	//	Thread.sleep(5000); 
		//Compare - meetingID with xpath meeting id
		//get text for exact meeting ID
		
		return meetingID;
		
 }	
	
	 /**
		* @author Manasi Potnis : Search meeting with Team
		  *
		  */ 	
		 
		public String SearchMeetingWithTeam() throws IOException, Exception{
			
			String meetingrecord1; 
			
			//obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));
		   //obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("Meetingtext")); 
	   
		    obj.clickElement(prop.GetdataFromPropFileAM("elem_SearchFilter"));
			System.out.println("search screen is opened");
			obj.clickElement(prop.GetdataFromPropFileAM("elem_Reset"));		
			//obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("SerchMeeting")); 
			//Thread.sleep(5000);
			obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 
			
			obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_MTMRadio"));	
			obj.clickElement(prop.GetdataFromPropFileAM("elem_MTMRadio"));
			System.out.println(" My Team meeting Radio Button Selected");
			
			obj.clickElement(prop.GetdataFromPropFileAM("elem_Advancebutton"));
			System.out.println("Advance search screen is opened");
			//Thread.sleep(5000); 
			
			//enter meeting id
			String meetingbyTeam = "2312/000185";
			obj.typeInElement(prop.GetdataFromPropFileAM("MeetingID"), meetingbyTeam);
		//	obj.typeInElement(prop.GetdataFromPropFileAM("MeetingID"), meetingID);
			obj.clickElement(prop.GetdataFromPropFileAM("elem_SerchMeeting"));
			
			obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 

			
			//obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("MeetingGrid")); 
			//Thread.sleep(5000); 
			//Compare - meetingID with xpath meeting id
			//get text for exact meeting ID
			meetingrecord1 = driver.findElement(By.xpath("//*[@id='meetingSearch']/div[2]/div/div/div[1]/table/tbody/tr[2]/td[1]/div[1]")).getText();
			System.out.println(meetingrecord1);
			String NewmeetingID=meetingrecord1.substring(5);
			System.out.println("new string: " + NewmeetingID);
			//Assert.assertTrue((meetingID.contentEquals(NewmeetingID)), "Test Verification Failed");
			Assert.assertTrue((meetingbyTeam.contentEquals(NewmeetingID)), "Test Verification Failed");
			Reporter.log("Test Verification Passed");
			
			System.out.println("SearchMeetingWithTeam Test Case Passed");
			return meetingID;
			
		
	 }	
		

//  Start Kapil Supekar	
	public String verifyMeetingCreatedanyStatus() throws IOException, Exception
	 {
		//start if user navigate from Meeting screen. click on Back button and navigate to Meeting Grid Screen
		
		
			obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));	
			obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 
		
		// End if user navigate from Meeting screen. click on Back button and navigate to Meeting Grid Screen
		
	 
	 
	 
	//if user navigate from Home screen or serach from Meeting Grid Screen . click on Back button and navigate to Meeting Grid Screen

			obj.clickElement(prop.GetdataFromPropFileAM("elem_SearchFilter"));
				
			obj.clickElement(prop.GetdataFromPropFileAM("elem_Reset"));

				System.out.println("search screen is opened");
			//	Thread.sleep(20000); 
			
				obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 
				 
				
				obj.clickElement(prop.GetdataFromPropFileAM("elem_Advancebutton"));
				
				System.out.println("Advance search screen is opened");
				
				//end if user navigate from Home screen or serach from Meeting Grid Screen . click on Back button and navigate to Meeting Grid Screen


				
				obj.typeInElement(prop.GetdataFromPropFileAM("MeetingID"), meetingID);

//				Thread.sleep(1000); 
				
			//	obj.clickElement(prop.GetdataFromPropFileAM("elem_StatusDropdown"));
				
				obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_StatusDropdown")); 
				obj.clickElement(prop.GetdataFromPropFileAM("elem_StatusDropdown"));

				
				 System.out.println("Meeting status opened");

				 String s1 = prop.GetdataFromPropFileAM("elem_Meeting_StatusXpath");
				 
				//Start if user want to allocate status  in assertText or taken value from Action.Prop file. Created new xpath from for status. 

				 //	String assertText ="Draft";	 
				 String assertText = prop.GetdataFromPropFileAM("Data_Meeting_Status");
				 
				 
				 String NewStatus=s1.replace("X", assertText);

				 System.out.println(NewStatus);  
				 

				obj.click(NewStatus);
				//end if user want to allocate status  in assertText or taken value from Action.Prop file. Created new xpath from for status. 
	 

			obj.clickElement(prop.GetdataFromPropFileAM("elem_SerchMeeting"));
			//Thread.sleep(20000); 
			 obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 

		  //   obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_MeetingGrid")); 

		
			//Start Compare Actual and expected  Status
			String draftText = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_MIDgettextStatus"))).getText();
			 System.out.println("Get test from search screen" +draftText);  

			Assert.assertTrue((draftText.contentEquals(assertText)), "Test Verification Failed");
			Reporter.log("Test Verification Passed");
			
			
			
			//End Compare Actual and expected  Status

			return meetingID;
       
		
		
	}
	
//  end Kapil Supekar	

//  Start Kapil Supekar for Start Meetring Before Time
	//public String StartMeetringBeforeTime() throws IOException, Exception
	public void StartMeetringBeforeTime() throws IOException, Exception

	{

		/*
		//if user navigate from Meeting screen. click on Back button and navigate to Meeting Grid Screen
		
		obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));	
		 obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 
			
		 */

		
		
		//if user navigate from Home screen or serach from Meeting Grid Screen . click on Back button and navigate to Meeting Grid Screen

		obj.clickElement(prop.GetdataFromPropFileAM("elem_SearchFilter"));
			
		obj.clickElement(prop.GetdataFromPropFileAM("elem_Reset"));

			System.out.println("search screen is opened");
		//	Thread.sleep(20000); 
		
			obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 
			 
			obj.clickElement(prop.GetdataFromPropFileAM("elem_Advancebutton"));
			
			System.out.println("Advance search screen is opened");
			
			
			
			
			 // start if user takes meeting id from previous steps which status should Scheduled otherwise user search  meetings which status are Scheduled
		
			
	 	//		obj.typeInElement(prop.GetdataFromPropFileAM("MeetingID"), meetingID);

	
			//	Thread.sleep(1000); 
				
				obj.clickElement(prop.GetdataFromPropFileAM("elem_StatusDropdown"));
				obj.clickElement(prop.GetdataFromPropFileAM("elem_Scheduled_select"));
				obj.clickElement(prop.GetdataFromPropFileAM("elem_SerchMeeting"));
				 
				 // end if user takes meeting id from previous steps which status should Scheduled otherwise user search  meetings which status are Scheduled

				//Thread.sleep(20000); 

				//open meeting	
				obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 
				
				
				 //start if meeting id not provide, user exact meeting id from search screen and save in newmeetingID field
				 String meetingIDtext = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_MIDgettext"))).getText();
				 System.out.println(meetingIDtext);
				 String newmeetingID=meetingIDtext.substring(5);
				 System.out.println("new string: " + newmeetingID);
				 
				 meetingID =newmeetingID;
				 //end if meeting id not provide, user exact meeting id from search screen
			
				obj.clickElement(prop.GetdataFromPropFileAM("elem_editmeeting"));
				
				obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 
				//			 Thread.sleep(5000);


				//start taken current system time in "DD/MM/YYYY HH:MM" format
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
					LocalDateTime currentdatetime = LocalDateTime.now();  
				 	System.out.println(dtf.format(currentdatetime));  
				//end Taken current system time in "DD/MM/YYYY HH:MM" format

			//	 Thread.sleep(10000);
			 
				//start Extract start date and time from StartDate & time field and convert into "DD/MM/YYYY HH:MM" format in datetime 
				 WebDriverWait wait = new WebDriverWait(driver, 40);
				 WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.GetdataFromPropFileAM("elem_StartDate"))));
				 String StartDate = inputField.getAttribute("value");


				 WebDriverWait wait1 = new WebDriverWait(driver, 20);
				 WebElement inputValue1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.GetdataFromPropFileAM("elem_StartTime"))));
				 String Starttime = inputValue1.getAttribute("value");


				 System.out.println("Input Field Value: " + Starttime);
		     
				 String Space = " ";
		     
		     
				 String newdatetime =  (StartDate + Space + Starttime);
		     
				 System.out.println("String4: " + newdatetime);
		     


		 //    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(String4);
		   //  System.out.println("New Time " + String4);
		     String pattern = "dd/MM/yyyy HH:mm";
		     DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(pattern);
		     LocalDateTime localDateTime = LocalDateTime.parse(newdatetime, dtf1);
		     String formattedDateTime = localDateTime.format(dtf1);
		     System.out.println("Converted Date and Time: " + formattedDateTime);
		 
		     
		     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		     LocalDateTime localDateTime1 = LocalDateTime.parse((dtf.format(currentdatetime)), formatter);
		     LocalDateTime localDateTime2 = LocalDateTime.parse(newdatetime, formatter);
			//end Extract start date and time from StartDate & time field and convert into "DD/MM/YYYY HH:MM" format in datetime 

		     // Calculate the difference in minutes
		    
		     long minutesDifference = ChronoUnit.MINUTES.between(localDateTime1, localDateTime2);
		     System.out.println("Difference in minutes: " + minutesDifference);
		     String assertText = "Null";
		     
		    
		     
		     //Start check meeting start before time or not,	//   if user set flag as  "YES" in action.prop then meeting will start before time
		     
		     
		     
		     if (minutesDifference>0)
		    	 
		     {
		    	 
		    
		    	 System.out.println("Meeting Start before time " + minutesDifference);
		    	  
		    	  String Meeting_Start = prop.GetdataFromPropFileAM("Data_Meeting_Start");
		    	
		    	  System.out.println("Meeting Start Flag: " + Meeting_Start);
		    	  
		    	
		    	  if(Meeting_Start.equals("YES")) 
		    	  
		    	  {
		    		  
		    		  obj.clickElement(prop.GetdataFromPropFileAM("elem_Start_Meeting"));
		    		  
		    		  
		    		     System.out.println("User has  Started Meeting before " + minutesDifference + " minute");
		    		     
		    		 	 assertText = "Ongoing";
		    	  }
		    	  else
		    	  {

		 		     System.out.println("User not want to start Meeting before time "  + minutesDifference + " minute");

		 		 	 assertText = "Scheduled";
		    	  }
		    	  
		    		// end if user set flag as  "YES" in action.prop then meeting will start before time  
		    	 
			}
			else if (minutesDifference<0)
		    	 
		     {
		  	  System.out.println("Meeting Start After  time " + minutesDifference);
		  	 assertText = "Scheduled";

		    	 
		     }else 
		     {
		      	  System.out.println("Meeting Start on time " + minutesDifference);
		      	 assertText = "Scheduled";

		     }
		     
	    	  System.out.println("Meeting assertText Status: " + assertText);

			     //end check meeting start before time or not,	//   if user set flag as  "YES" in action.prop then meeting will start before time

		    
	    	 	
	    	 
	    	  /*
	    	   //Start if user start meeting at any condition 
	    	  obj.clickElement(prop.GetdataFromPropFileAM("elem_Start_Meeting"));
	    	  	System.out.println("User has  Started Meeting with " + minutesDifference + " minute");
 		     	assertText = "Ongoing";
 	  		  //End if user start meeting at any condition 
 		    	 		    	
			*/
	    	  
	    	//  Thread.sleep(5000); 
		     
				obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));

				
				 obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_MeetingGrid")); 
				obj.clickElement(prop.GetdataFromPropFileAM("elem_SearchFilter"));
				
				//	obj.clickElement(prop.GetdataFromPropFileAM("elem_Reset"));

					System.out.println("search screen is opened");
					//Thread.sleep(5000); 
					obj.clickElement(prop.GetdataFromPropFileAM("elem_Advancebutton"));
					System.out.println("Advance search screen is opened");
					
					
				//	meetingID=newmeetingID;
					System.out.println("newmeetingID" + newmeetingID);
				//	start if user takes meeting id from previous steps which status should Scheduled otherwise meeting search by newmeetingID
					//System.out.println("meetingID" + meetingID);	 
					//obj.typeInElement(prop.GetdataFromPropFileAM("MeetingID"), meetingID);

					 obj.typeInElement(prop.GetdataFromPropFileAM("MeetingID"), meetingID);

						obj.clickElement(prop.GetdataFromPropFileAM("elem_SerchMeeting"));
							 

						 obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 

						 
		     
			String draftText = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_MIDgettextStatus"))).getText();

	    	  System.out.println("Meeting assertText Status: " + assertText);

						
				//Start Compare Actual and expected  Status
				
		Assert.assertTrue((draftText.contentEquals(assertText)), "Test Verification Failed");
		Reporter.log("Test Verification Passed");
		//end Compare Actual and expected  Status

	//	return meetingID;
       
		
		
	}
	
//  end Kapil Supekar  for Start Meetring Before Time
//  Start Kapil Supekar	
//	public String VerifyEscalatedToMe() throws IOException, Exception
	public void VerifyEscalatedToMe(String Url) throws IOException, Exception

	 {  

			//Start user first logout and login with different user for EscalatedToMe
			EscalatedToMeLogout();  
			EscalatedToMeLogin();
		   //end user first logout and login with different user for EscalatedToMe
		
		 System.out.println("kapil VerifyEscalatedToMe");  
		 	obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_Meetingtext")); 

		  obj.clickElement(prop.GetdataFromPropFileAM("elem_SearchFilter"));
		  System.out.println("search screen is opened");
					obj.clickElement(prop.GetdataFromPropFileAM("elem_ETMRadio"));
				
			//	Thread.sleep(1000); 
				
				obj.clickElement(prop.GetdataFromPropFileAM("elem_ETMButton"));
				
				 obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 

				
				
					//Start Compare ActualObservationid and ExpectedObservationid  Status
				 String ActualObservationid = prop.GetdataFromPropFileAM("Data_ETMID");
				
				System.out.println("MID :"+ ActualObservationid);
				String ExpectedObservationid = obj.Gettext(prop.GetdataFromPropFileAM("elem_ETMIDcompare"));
				System.out.println(ExpectedObservationid);
				
				Assert.assertTrue((ActualObservationid.contentEquals(ExpectedObservationid)), "Test Verification Failed");
				Reporter.log("Test Verification Passed");
				//Assert.assertEquals(ActualObservationid, ExpectedObservationid, "correct meeting Searched");
				//End Compare ActualObservationid and ExpectedObservationid  Status

				
			//	Thread.sleep(5000); 
	     
				
		 
				//Start user first logout and login with space admin user for EscalatedToMe
				EscalatedToMeLogout();
				loginAsAdmin(Url);
				//End user first logout and login with space admin user for EscalatedToMe
				
//		 return meetingID;
       
		
		
	}
	
//  end Kapil Supekar	

	
	
	
	
	//  Start Kapil Supekar	
	public void EscalatedToMeLogout() throws IOException, Exception
	 {
		
		obj.clickElement(prop.GetdataFromPropFileAM("elem_LogoutNavigation"));


//		Thread.sleep(3000); 

		obj.clickElement(prop.GetdataFromPropFileAM("elem_LogoutButton"));


		System.out.println("End with StartMeetringBT");
		

		 System.out.println("kapil logout");  

       
			
		
	}
	
	public void EscalatedToMeLogin() throws IOException, Exception
	 {

		 
		//Thread.sleep(5000); 
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		obj.clickElement(prop.GetdataFromPropFileAM("Username")); 
		obj.typeInElement(prop.GetdataFromPropFileAM("Username"), prop.GetdataFromPropFileAM("ETMun"));
		obj.clickElement(prop.GetdataFromPropFileAM("Password"));
		obj.typeInElement(prop.GetdataFromPropFileAM("Password"), prop.GetdataFromPropFileAM("ETMpw")); 
		obj.clickElement(prop.GetdataFromPropFileAM("LoginButton"));
		//Thread.sleep(1000); 

	
       
       while (true) {

			WebElement elem_Action = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_Action_Xpath")));
			


			if (elem_Action.isDisplayed()) {
				// Click the element if it is found
				obj.clickElementByJS(elem_Action);
				// You can add further actions here if needed
				break; // Exit the loop if element is found
			} else {
				// If the element is not found, click the "Next" button or perform other actions
			
				WebElement nextButton = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_nextButton_Xpath")));

				obj.clickElementByJS(nextButton);

			}

		}
       

		
	}
//  end Kapil Supekar	

 public void addMemberAndTopic() throws Exception, Exception {

	 	String internalUser = "Vru";  
		String externalUser = "Sandeep@gmail.com"; 
		String addTopic = "Adding Topic For Automation Testing";
		String Description = "Automation Regression Suite";
		
	    WebElement elem_edit = driver
				.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_edit")));
		 
		obj.clickElementByJS(elem_edit);
		
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
 
 public void addMemberAndTopicnew() throws Exception, Exception {

		String internalUser = "Vru";
		String externalUser = "Sandeep@gmail.com";
		String addTopic = "Add meeting agenda Testing";
		String Description = "Automation Regression Suite";

		 obj.clickElement(prop.GetdataFromPropFileAM("elem_backButton"));

		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_newMeeting"));

		obj.clickElement(prop.GetdataFromPropFileAM("elem_filter"));

		obj.clickElement(prop.GetdataFromPropFileAM("elem_advance_search"));

		obj.typeInElement(prop.GetdataFromPropFileAM("elem_input_meeting_ID"), meetingID);

		obj.clickElement(prop.GetdataFromPropFileAM("elem_search_meeting"));
		
		obj.waitUntilElementNotVisible(prop.GetdataFromPropFileAM("elem_loader")); 



//		Thread.sleep(10000);

		// obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_edit"));
		obj.clickElement(prop.GetdataFromPropFileAM("elem_R_edit"));

		obj.Reporter__log("enter in metting edit");

		obj.typeInElement(prop.GetdataFromPropFileAM("elem_searchTextMember"), internalUser);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_addMember"));
		obj.clickElement(prop.GetdataFromPropFileAM("elem_addMemberButton"));
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_addMemberSuccessMessage"));
		String elem_TextRetrived = driver
				.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_addMemberSuccessMessage"))).getText();
		System.out.println(elem_TextRetrived);
		String assertText = "Record saved successfully.";
		elem_TextRetrived = elem_TextRetrived.replace("x", " ");
		elem_TextRetrived = elem_TextRetrived.trim();

		System.out.println(elem_TextRetrived + "\n" + assertText);
		Assert.assertTrue((elem_TextRetrived.equalsIgnoreCase(assertText)), "Test Verification Failed");
		Reporter.log("Test Verification Passed");

		// adding external user

		obj.clickElement(prop.GetdataFromPropFileAM("elem_addExternal"));
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_emailIDExternalUser"), externalUser);

		externalUser = externalUser.substring(0, 7);
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

		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_addTopic"));

		obj.typeInElement(prop.GetdataFromPropFileAM("elem_addTopic"), addTopic);
		
	
      WebElement elem_save = driver
					.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_save")));
			 obj.clickElementByJS(elem_save);
			 
			String topicSave = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_addMemberSuccessMessage"))).getText();
			String assertSave = "Record saved successfully.";
			topicSave = topicSave.replace("x", " ");
			topicSave = topicSave.trim();
			System.out.println(topicSave + "\n" + assertSave);
			Assert.assertTrue((topicSave.contains(assertSave)), "Test Verification Failed");
			Reporter.log("Test Verification Passed");

	}
 
 public void editMember() throws Exception, Exception {

		String internalUser = "Anu";
		String externalUser = "Raghu@gmail.com";
		String addTopic = "Edit member agenda Testing";
		

		/*
		 * obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_R_sendinvite") ); 
		 * Thread.sleep(3000);
		 * obj.clickElement(prop.GetdataFromPropFileAM("elem_R_sendinvite"));
		 */
	
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_R_sendinvite") ); 
		Thread.sleep(3000);
		obj.clickElement(prop.GetdataFromPropFileAM("elem_R_sendinvite"));
		
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_R_addMemberSuccessMessage"));
		String send = driver.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_R_addMemberSuccessMessage"))).getText();
		String sendtext = "Invitation sent successfully.";
		send = send.replace("x", " ");
		send = send.trim();
		System.out.println(send + "\n" + sendtext);
		
		obj.assertVerify(prop.GetdataFromPropFileAM("VerifyText"), "List Of Meeting");

		
		//Thread.sleep(10000);
	
		obj.clickElement(prop.GetdataFromPropFileAM("elem_R_edit"));

		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_R_delete_member1"));
		obj.clickElement(prop.GetdataFromPropFileAM("elem_R_delete_member1"));

		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_R_delete_member2"));

		obj.clickElement(prop.GetdataFromPropFileAM("elem_R_delete_member2"));

		obj.Reporter__log("Member deleted sucessfully");

		// Add member Again
		
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_R_searchTextMember"));
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_R_searchTextMember"), internalUser);
		obj.clickElement(prop.GetdataFromPropFileAM("search_R_member1"));

		obj.clickElement(prop.GetdataFromPropFileAM("elem_R_addMember"));
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_R_addMemberSuccessMessage"));
		String elem_TextRetrived = driver
				.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_R_addMemberSuccessMessage"))).getText();
		System.out.println(elem_TextRetrived);
		String assertText = "Record saved successfully.";
		elem_TextRetrived = elem_TextRetrived.replace("x", " ");
		elem_TextRetrived = elem_TextRetrived.trim();

		System.out.println(elem_TextRetrived + "\n" + assertText);
		Assert.assertEquals(elem_TextRetrived, assertText);

		
		Reporter.log("Add member Test Verification Passed");

		// adding external user

		obj.clickElement(prop.GetdataFromPropFileAM("elem_R_addExternal"));
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_R_emailIDExternalUser"), externalUser);

		externalUser = externalUser.substring(0, 5);
		obj.typeInElement(prop.GetdataFromPropFileAM("elem_addExternalUser"), externalUser);

		obj.clickElement(prop.GetdataFromPropFileAM("elem_R_addMemberButton"));
		
		
		obj.waitUntilElementIsVisible(prop.GetdataFromPropFileAM("elem_R_addMemberSuccessMessage"));
		String ExternalUserText = driver
				.findElement(By.xpath(prop.GetdataFromPropFileAM("elem_R_addMemberSuccessMessage"))).getText();
		String ExternalUserassertText = "Record saved successfully.";
		ExternalUserText = ExternalUserText.replace("x", " ");
		ExternalUserText = ExternalUserText.trim();
		System.out.println(ExternalUserText + "\n" + assertText);
		Assert.assertTrue((ExternalUserText.contains(ExternalUserassertText)), "Test Verification Failed");
		Reporter.log("Test Verification Passed");


		obj.Reporter__log("Member Removed And added Succesfully");

		WebElement elem_R_back1 = driver.findElement(By.xpath("//button[@title='Back']"));
		obj.clickElementByJS(elem_R_back1);

	}

public void test() throws Exception, Exception {
	// TODO Auto-generated method stub

	 System.out.println(meetingID); 
}
             
} 
