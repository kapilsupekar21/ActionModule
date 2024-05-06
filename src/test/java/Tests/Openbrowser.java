package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Openbrowser {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		System.out.println("Start"); 
		WebDriver driver;
		driver = new ChromeDriver();				
	//     	driver = new FirefoxDriver();				
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		System.out.println("Browser open successfully");
	    // Launch Website
	    driver.get("https://www.zooplus.com");
		System.out.println("Browser open Zooplus.com shops successfully");			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));				

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));				
		// driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"onetrust-reject-all-handler\"]")).click();
		 //*[@id="onetrust-reject-all-handler"]
		 System.out.println("Browser Closed for T&C");
		 //Wait time
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));					
		 //System.out.println("Coopli");				 
	     //	 driver.findElement(By.id("shopHeaderAccountLink")).click();
		 driver.findElement(By.xpath("//*[@id=\"shopHeaderAccountLink\"]")).click();
		//*[@id="shopHeaderAccountLink"]
//		driver.findElementByXpath("//input[@value='cancel'][@title='cancel']").click();
//		driver.findElementBy("//*[@id=\"cartButton\"]").
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();				 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));			
		 
		 
		 
		 driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tester-tech@zooplus.com");
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		 driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		 driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("penguin");
		 
		 
		 driver.findElement(By.xpath("//*[@id=\"login-btn\"]")).click();
		
		
		 
		 
		 
		// driver.findElement(By.xpath("//*[@id=\"mzp-navigation\"]/div/ul/li[9]/a")).click();
		 
		//*[@id="mzp-navigation"]/div/ul/li[9]/a
		//*[@id="mzp-navigation"]/div/ul/li[9]/a 
		
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		// driver.findElement(By.xpath("//*[@id=\"mzp-navigation\"]/div/ul/li[14]/a")).click();
		   driver.findElement(By.xpath("//*[@id=\"account-overview-app\"]/div/div[1]/div/a")).click();
		 
		
		 
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	      String strUrl = driver.getCurrentUrl();
	      
	      System.out.println(strUrl);
	      
	      String url = "https://www.zooplus.com/#feedback_logout";
	      
	      boolean compare  =   strUrl.equals(url);
	      

			 driver.close();
		 driver.quit();
			 
			 
		 System.out.println("Browser closed successfully");

		 System.out.println(strUrl);
		 System.out.println(url);
		    
		 
	      System.out.println("Result should be : " +compare);
	      
		

	}
	


	}


