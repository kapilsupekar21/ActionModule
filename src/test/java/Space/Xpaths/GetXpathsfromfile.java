package Space.Xpaths;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetXpathsfromfile {
	public String getXpathFromPropFile(String pageReference, String keyEntry)
			throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		// properties.load(new FileInputStream("C:\\Users\\Sandeep.Virk\\eclipse-workspace\\Space1\\src\\test\\java\\Space\\Xpaths\\LoginPage.prop"));
		
		 properties.load(new FileInputStream("/Users/admin/Desktop/kapil_ItCube/Kapil/SOFTWARE/Space/src/test/java/Space/Xpaths/LoginPage.prop"));
		
		return properties.getProperty(keyEntry);
	}
	public String getXpathFromPropFile1(String pageReference, String keyEntry)
			throws FileNotFoundException, IOException,Exception {
		Properties properties = new Properties();
		//properties.load(new FileInputStream("C:\\Users\\Sandeep.Virk\\eclipse-workspace\\space\\src\\main\\java\\Xpaths\\Configuration.Prop"));
		
		properties.load(new FileInputStream("/Users/admin/Desktop/kapil_ItCube/Kapil/SOFTWARE/Space/src/test/java/Space/Xpaths/Configuration.Prop"));
		
		return properties.getProperty(keyEntry);

	}
	public String getXpathFromPropFile2(String pageReference, String keyEntry)
			throws FileNotFoundException, IOException,Exception {
		Properties properties = new Properties();
		//properties.load(new FileInputStream("C:\\Users\\Sandeep.Virk\\Desktop\\Space1\\src\\test\\java\\Space\\Xpaths\\NewXpaths.prop"));
		properties.load(new FileInputStream("/Users/admin/Desktop/kapil_ItCube/Kapil/SOFTWARE/Space/src/test/java/Space/Xpaths/NewXpaths.prop"));
		
		
		return properties.getProperty(keyEntry);

	}

	
	public String GetdataFromPropFile( String Keyentry) throws IOException {
		Properties 	prop= new Properties();
		// prop.load(new FileInputStream("C:\\Users\\Sandeep.Virk\\eclipse-workspace\\Space1\\Config.properties"));
		
		prop.load(new FileInputStream("/Users/admin/Desktop/kapil_ItCube/Kapil/SOFTWARE/Space/src/test/java/Space/Xpaths/Config.properties"));
		
		
		return prop.getProperty(Keyentry);
	
	
		
	} 
	public String GetdataFromPropFileCM( String Keyentry) throws IOException {
		Properties 	prop= new Properties();
		// prop.load(new FileInputStream("C:\\Users\\Sandeep.Virk\\Desktop\\Space1\\src\\test\\java\\Space\\Xpaths\\CMS.prop"));
		
		prop.load(new FileInputStream("/Users/admin/Desktop/kapil_ItCube/Kapil/SOFTWARE/Space/src/test/java/Space/Xpaths/CMS.prop"));
		
		
		return prop.getProperty(Keyentry);
	
	
		
	}
	public String GetdataFromPropFileAM( String Keyentry) throws IOException {
		Properties 	prop= new Properties();
		// prop.load(new FileInputStream("C:\\Users\\Sandeep.Virk\\Desktop\\Space1\\src\\test\\java\\Space\\Xpaths\\ACTION.prop"));
		
		prop.load(new FileInputStream("/Users/admin/Desktop/kapil_ItCube/Kapil/SOFTWARE/Space/src/test/java/Space/Xpaths/ACTION.prop"));
		
		
		return prop.getProperty(Keyentry);
}
	
	public String GetdataFromPropFilenew( String Keyentry) throws IOException {
		Properties 	prop= new Properties();
		// prop.load(new FileInputStream("C:\\Users\\Sandeep.Virk\\Desktop\\Space1\\src\\test\\java\\Space\\Xpaths\\ACTION.prop"));
		
		prop.load(new FileInputStream("/Users/admin/Desktop/kapil_ItCube/Kapil/SOFTWARE/Space/src/test/java/Space/Xpaths/ACTIONnewdata.prop"));
		
		
		return prop.getProperty(Keyentry);
}	
	
	public String GetdataFromPropFilenewCM( String Keyentry) throws IOException {
		Properties 	prop= new Properties();
		// prop.load(new FileInputStream("C:\\Users\\Sandeep.Virk\\Desktop\\Space1\\src\\test\\java\\Space\\Xpaths\\ACTION.prop"));
		
		prop.load(new FileInputStream("/Users/admin/Desktop/kapil_ItCube/Kapil/SOFTWARE/Space/src/test/java/Space/Xpaths/ACTIONCMdata.prop"));
		
		
		return prop.getProperty(Keyentry);
}	
	
	
	
}
