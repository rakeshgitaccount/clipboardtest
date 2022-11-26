package in.amazon.clipboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage extends StartupPage {
	
	By hamburgerMenu = By.id("nav-hamburger-menu");

	public AmazonHomePage(WebDriver driver) {
		super(driver);
	}
	
	public HamburgerMenuPage clickHamburgerMenu() {
		commonEvents.waitTillElementVisible(hamburgerMenu, 60)
					.click(hamburgerMenu);
		return new HamburgerMenuPage(driver);
	}
}

