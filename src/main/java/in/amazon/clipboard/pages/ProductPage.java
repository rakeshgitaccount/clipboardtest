package in.amazon.clipboard.pages;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends StartupPage {
	
	By aboutThisItemHeader = By.cssSelector("div#featurebullets_feature_div h1");

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public String getAboutItemHeaderText() throws Exception {
		Iterator<String> windows = commonEvents.getWindowHandles();
		String window1 = windows.next();
		String window2 = windows.next();
		String text = commonEvents.switchToWindow(window2)
									.waitTillElementVisible(aboutThisItemHeader, 30)
									.getText(aboutThisItemHeader).trim();
		commonEvents.closeCurrentWindow()
					.switchToWindow(window1);
		return text;
	}

}
