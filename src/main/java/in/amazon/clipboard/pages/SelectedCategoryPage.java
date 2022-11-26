package in.amazon.clipboard.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectedCategoryPage extends StartupPage {
	
	//Web elements
	By sortBySelector = By.cssSelector("span[aria-label='Sort by:']");
	
	
	//Web elements for dynamic valued input
	String sortProductsByPath = "//a[text()='value']";
	String desiredBrandCheckboxPath = "//span[text()=\"Brands\"]/../following-sibling::ul//span[text()='value']/preceding-sibling::div";

	public SelectedCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	private SelectedCategoryPage sortResultBy(String option) {
		commonEvents.waitTillElementVisible(sortBySelector, 30)
					.click(sortBySelector);
		By finalSortingType = By.xpath(sortProductsByPath.replace("value", option));
		commonEvents.waitTillElementVisible(finalSortingType, 30)
					.click(finalSortingType);
		return new SelectedCategoryPage(driver);
	}
	
	private SelectedCategoryPage chooseDesiredBrands(String brands) {
		String[] desiredBrands = brands.split("-");
		for(String x:desiredBrands) {
			By finalBrandNameCheckboxElement = By.xpath(desiredBrandCheckboxPath.replace("value", x.trim()));
			commonEvents.waitTillElementVisible(finalBrandNameCheckboxElement, 30)
						.click(finalBrandNameCheckboxElement);
		}
		return new SelectedCategoryPage(driver);
	}
	
	public ResultPage chooseDesiredProductWithSort(Map<String, String> map) {
		chooseDesiredBrands(map.get("Brands"))
		.sortResultBy(map.get("Sort by"));
		return new ResultPage(driver);
	}

}
