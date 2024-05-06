package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class Setup {
	public static int defaultTimeOutForObjectWait=120;
	public static int defaultTimeOutForObjectWait1=20;
	public static int defaultTimeOutForObjectWait2=5;
	public static WebDriver driver;
	public static String downloadFolderPath = "\\src\\test\\resources\\Downloads";
	public static String uploadFolderPath = "\\src\\test\\resources\\Uploads";
	public static String uploadFile = "AA";
	
	public void Initialize() {
		System.out.println("BeforeClassSetup");
//		System.setProperty("webdriver.chrome.driver", "/src/test/resources/chromedriver.exe");
		
	//	System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/kapil_ItCube/Kapil/SOFTWARE/Space/src/test/resources/chromedriver");

		// WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, defaultTimeOutForObjectWait);

	//	ChromeOptions opt = new ChromeOptions();
	//	opt.addArguments("--remote-allow-origins=*");
	//	driver = new ChromeDriver(opt); 
		driver.manage().window().maximize();
	} 
} 
 