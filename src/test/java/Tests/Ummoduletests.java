package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Space.Functions.AutFunctions;
import Space.ObjectsUtilities.ObjectUtilities;
import Space.Xpaths.GetXpathsfromfile;

public class Ummoduletests {
	public static WebDriver driver;
	GetXpathsfromfile prop;
	ObjectUtilities obj;
	UMmodule aut2;
	

	@SuppressWarnings("static-access")
	@BeforeClass
	
	public  void testsetup() throws Exception {

	    driver = Setup.driver;
		prop = new GetXpathsfromfile();
		obj = new ObjectUtilities();
		aut2 = new UMmodule();
	}

	@Test(priority = 1)
	@Parameters({ "url" })
	public void loginAsAdmin(String url) throws Exception {
	 aut2.loginAsAdmin(url); 
	 }


	
	

  @Test(priority = 2) 
  public void LMSReportAccessSearch() throws Exception {
  aut2.LMSReportAccessSearch(); }
  
  @Test(priority = 3) 
  public void LMSReportAccessAdd() throws Exception {
  aut2.LMSReportAccessAdd(); }
 
  @Test(priority = 4) 
  public void ProjectAdd() throws Exception {
  aut2.ProjectAdd(); }
  
  @Test(priority = 6) public void ProjectSearch() throws Exception {
  aut2.ProjectSearch(); }
  
  @Test(priority = 7)
  public void Vertical() throws Exception {
  aut2.Vertical();
  }
  
  @Test(priority = 8) 
  public void Region() throws Exception { aut2.Region(); }
  
  @Test(priority = 9)
  public void Function() throws Exception {
  aut2.Function(); }
  
  @Test(priority = 10)
  public void Position() throws Exception {
  aut2.Position();
  
  }
  
  @Test(priority = 11)
  public void UploadUserRequest() throws Exception {
  aut2.UploadUserRequest(); }
 
  @Test(priority = 12)
   public void Group() throws Exception { 
	  aut2.Group(); 
	  }
  
@Test(priority= 13) 
  public void AddNmruser() throws Exception {
  aut2.AddNmruser(); 
  }

@Test(priority =14)
  @Parameters({ "url"})
  public void AddAssignment(String url) throws Exception {
	  aut2.AddAssignment(url); 
  }
  
  @Test(priority =15)
  public void loginCreatedUser() throws Exception {
	  aut2.loginCreatedUser(); 
  }
  @Test(priority =16)
  @Parameters({ "url"})
  public void UpdateUserProfile(String url) throws Exception {
	  aut2.UpdateUserProfile(url); 

	  }
  
 @Test(priority =17)
  @Parameters({ "url"})
  public void UpdateUserWithSecondAssignment(String url) throws Exception {
	  aut2.UpdateUserWithSecondAssignment( url); 
	
  }
  
	
  @Test(priority =18)
  @Parameters({ "url"})
public void SecondAssginmentaddedverify(String url) throws Exception {
	  aut2.SecondAssginmentaddedverify(url); 
   }
  
 @Test(priority =19)
  @Parameters({ "url"})
  public void ScheduleTransfer(String url) throws Exception {
	  aut2.ScheduleTransfer(url);
  }
	
@Test(priority =20)
  @Parameters({ "url"})
  public void VerifyScheduldeTransferRequest(String url) throws Exception {
	  aut2.VerifyScheduldeTransferRequest(url);
  }

@Test(priority =21)
@Parameters({ "url"})
public void Deactivateuser(String url) throws Exception {
    aut2.Deactivateuser(url);
	
}

@Test(priority =22)
@Parameters({ "url"})
public void Delete(String url) throws Exception {
	aut2.Delete(url);
}
}
