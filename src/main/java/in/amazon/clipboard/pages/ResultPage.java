package in.amazon.clipboard.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage extends StartupPage {
	
	By products = By.xpath("//span[contains(@data-component-type,'search-results')]");
	
	String desiredProductPath = "//div[contains(@data-component-type,'search-result')][index]";

	public ResultPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductPage selectDesiredProduct(Map<String, String> map) {
		List<WebElement> productsList = commonEvents.getWebElements(products);
		if(!productsList.isEmpty()) {
			By finalProduct = By.xpath(desiredProductPath.replace("index", map.get("Product index")));
			commonEvents.waitTillElementVisible(finalProduct, 30)
						.click(finalProduct);
		}
		return new ProductPage(driver);
	}

}
