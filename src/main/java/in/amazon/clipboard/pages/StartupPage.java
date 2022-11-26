package in.amazon.clipboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonEvents;

public class StartupPage 
{
	public WebDriver driver;
	public CommonEvents commonEvents;
	
	public StartupPage(WebDriver driver)
	{
		this.driver=driver;
		commonEvents = new CommonEvents(this.driver);
	}
	
	public AmazonHomePage navigateToAmazonHomePage() {
		return new AmazonHomePage(driver);
	}
	
	public void navigateToUrl(String url) throws Exception {
		commonEvents.navigateTo(url);
	}
	
	public String getLocatorValueFromBy(By by){
		String[] split = by.toString().split(":");
		return split[1].trim();
	}
	
	public String getLocatorTypeFromBy(By by) {
		String[] split = by.toString().split(":");
		String[] split2 = split[0].split("[^A-Za-z]");
		return split2[1].trim();
	}
}
