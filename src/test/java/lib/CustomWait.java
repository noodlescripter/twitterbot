package lib;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CustomWait {

	public static WebElement byFluentWait(WebDriver driver, By locator, Integer timeoutSeconds) {
	    //FluentWait Declaration
		Integer dTimeoutSecconds = timeoutSeconds;
		if (timeoutSeconds == null) {
			dTimeoutSecconds = 5;
		}
	    FluentWait<WebDriver> wait = new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(dTimeoutSecconds)) //Set timeout
	        .pollingEvery(Duration.ofMillis(100)) //Set query/check/control interval
	        .withMessage("Timeout occured!") //Set timeout message
	        .ignoring(NoSuchElementException.class); //Ignore NoSuchElementException
	    //Wait until timeout period and when an element is found, then return it.
	    return wait.until(WebDriver -> driver.findElement(locator));
	}
	
	public static void hardWait(Integer dTime) throws InterruptedException {
		Integer dTime1 = dTime;
		if (dTime == null) {
			dTime1 = 5000;
			LOG.logger("Application will wait till given Time 5000ms");
		}

		Thread.sleep(dTime1);
	}
	
	public static void imWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public static void waitTillDisplayed(WebDriver driver,String by, Integer timeout) {
		Integer dTime1 = timeout;
		if (timeout == null) {
			dTime1 = 5000;
			LOG.logger("Application will wait till given Time 5000ms");
		}
		
		WebDriverWait wait = new WebDriverWait(driver, dTime1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(by)));
	}
	
}
