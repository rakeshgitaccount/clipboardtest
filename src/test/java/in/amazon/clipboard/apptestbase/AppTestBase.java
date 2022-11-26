package in.amazon.clipboard.apptestbase;

import org.testng.asserts.SoftAssert;

import in.amazon.clipboard.pages.StartupPage;
import testBase.TestBase;

public class AppTestBase extends TestBase
{
	public String baseFileLocation = System.getProperty("user.dir");
	public String configFileLocation = baseFileLocation+"/src/main/resources/config.properties";
	public String testDataLocation = baseFileLocation+"/src/test/resources/TestData/";
	public StartupPage startupPage;
	public SoftAssert softAssert;
}