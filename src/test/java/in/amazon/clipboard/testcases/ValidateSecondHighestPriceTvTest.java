package in.amazon.clipboard.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import in.amazon.clipboard.apptestbase.AppTestBase;
import in.amazon.clipboard.pages.AmazonHomePage;
import in.amazon.clipboard.pages.HamburgerMenuPage;
import in.amazon.clipboard.pages.ProductPage;
import in.amazon.clipboard.pages.ResultPage;
import in.amazon.clipboard.pages.SelectedCategoryPage;
import in.amazon.clipboard.pages.StartupPage;
import testutils.ApiHelper;
import utils.FileOperations;


public class ValidateSecondHighestPriceTvTest extends AppTestBase {
	
	Map<String, String> readProperty;
	AmazonHomePage amazonHomePage;


	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser) throws Exception
	{
		readProperty = new FileOperations().readProperty(configFileLocation);
		readProperty.put("browser", browser);
		readProperty.put("url", readProperty.get("url"));
		boolean isValidUrl = new ApiHelper().isValidUrl(readProperty.get("url"));
		Assert.assertTrue(isValidUrl, readProperty.get("url")+" might be down in this moment. Please try after sometime.");
		initialize(readProperty);
		startupPage = new StartupPage(driver);
		amazonHomePage = startupPage.navigateToAmazonHomePage();
	}
	
	@Test(groups = {"test", "sanity", "regression"})
	public void samsungSecondHighestPricedTvPageTest() throws Exception {
		softAssert = new SoftAssert();
		
		String jsonFileLocation = testDataLocation+"AmazonScenario.JSON";
		Map<String, String> testData = new FileOperations().readJson(jsonFileLocation, "inputdata");
		Map<String, String> expectedData = new FileOperations().readJson(jsonFileLocation, "expecteddata");
		
		HamburgerMenuPage hamburgerMenuPage = amazonHomePage.clickHamburgerMenu();
		
		SelectedCategoryPage selectedCategoryPage = hamburgerMenuPage.selectCategory(testData);
		
		ResultPage resultPage = selectedCategoryPage.chooseDesiredProductWithSort(testData);
		
		ProductPage productPage = resultPage.selectDesiredProduct(testData);
		
		String actualText = productPage.getAboutItemHeaderText();
		System.out.println(actualText);
		
		String expectedText = expectedData.get("Expected output");
		
		softAssert.assertEquals(actualText, expectedText, "Actual text is "+actualText+" but the expected text is "+expectedText);
		softAssert.assertAll();
	}

	@AfterMethod(alwaysRun = true)
	public void navigateToHomePage() throws Exception {
		Set<String> windowHandles = driver.getWindowHandles();
		if(windowHandles.size()>1) {
			List<String> windows = new ArrayList<>();
			Iterator<String> iterator = windowHandles.iterator();
			while(iterator.hasNext())
				windows.add(iterator.next());
			for(int id = windows.size()-1; id>0; id--) {
				driver.switchTo().window(windows.get(id));
				driver.close();
			}
		}
		startupPage.navigateToUrl(readProperty.get("url"));
	}

//	@AfterClass(alwaysRun = true)
//	public void tearDown() {
//		browserTearDown();
//	}

}
