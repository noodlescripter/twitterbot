package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction {
	
	public static void clickByTap(WebDriver driver, String by) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element.byXpath(driver, by, 5)).click().perform();
	}

}

