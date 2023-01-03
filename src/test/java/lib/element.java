package lib;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class element {
	
	public static WebElement byXpath(WebDriver driver, String by, Integer timeout) {
		return CustomWait.byFluentWait(driver, By.xpath(by), timeout);
	}
	
	public static WebElement byName(WebDriver driver, String by, Integer timeout) {
		return CustomWait.byFluentWait(driver, By.cssSelector("[name='"+by+"']"), timeout);
	}
	
	public static WebElement byId(WebDriver driver, String by, Integer timeout) {
		return CustomWait.byFluentWait(driver, By.cssSelector("[id='"+by+"']"), timeout);
	}

	public static WebElement byCss(WebDriver driver, String by, Integer timeout) {
		return CustomWait.byFluentWait(driver, By.cssSelector(by), timeout);
	}
	
	public static WebElement byText(WebDriver driver, String by, Integer timeout) {
		return CustomWait.byFluentWait(driver, By.xpath("//*[text()='"+by+"']"), timeout);
	}
	
	public static boolean retryingFindClick(WebDriver driver, String ele) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            byXpath(driver, ele, null).click();
	            result = true;
	            break;
	        } catch(NoSuchElementException e) {
	        }
	        attempts++;
	    }
	    return result;
	}
}
