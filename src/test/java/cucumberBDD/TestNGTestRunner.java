/**
 * 
 */
package cucumberBDD;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Sandeep.Virk
 *  
 */

@CucumberOptions(features="src/test/java/cucumberBDD", glue = "cucumberBDD",
monochrome=true,plugin= {"html:target/cucumber.html"}) 
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
