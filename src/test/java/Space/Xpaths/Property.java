package Space.Xpaths;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Test;

@Test
public class Property {
	
	
	public void GetdataFromPropFile() throws IOException {
		Properties 	prop= new Properties();
		InputStream value= new FileInputStream("C:\\Users\\Sandeep.Virk\\eclipse-workspace\\Space1\\Config.properties");
		prop.load(value);
		
	
		System.out.println(prop.getProperty("value"));
		
	}

}
