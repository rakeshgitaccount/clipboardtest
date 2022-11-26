package in.amazon.clipboard.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HamburgerMenuPage extends StartupPage {
	
	String categoryPath = "//div[text()=\"value\"]/..";
	String subCategoryPath = "//a[text()=\"value\"]";

	public HamburgerMenuPage(WebDriver driver) {
		super(driver);
	}
	
	private HamburgerMenuPage clickDesiredOption(String option) {
		By finalElementPath = By.xpath(categoryPath.replace("value", option));
		commonEvents.waitTillElementVisible(finalElementPath, 30)
					.click(finalElementPath);
		return new HamburgerMenuPage(driver);
	}
	
	private HamburgerMenuPage clickDesiredChildOption(String childOption) {
		By finalElementPath = By.xpath(subCategoryPath.replace("value", childOption));
		commonEvents.waitTillElementVisible(finalElementPath, 30)
					.click(finalElementPath);
		return new HamburgerMenuPage(driver);
	}
	
	public SelectedCategoryPage selectCategory(Map<String, String> map) {
		clickDesiredOption(map.get("Category"))
		.clickDesiredChildOption(map.get("Child category"));
		return new SelectedCategoryPage(driver);
	}

}
