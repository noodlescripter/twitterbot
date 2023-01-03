package app;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.CustomWait;
import lib.GETOS;
import lib.GetProp;
import lib.LOG;
import lib.MouseAction;
import lib.RandomG;
import lib.element;

public class MainAPP {

//	public static void main(String[] args) throws InterruptedException {
//		LOG.logger("::::::::::::::::::::::" + "HOPE YOU ARE NOT USING YOUR REAL ACCOUNT!!!!!");
//
//		String userName = System.getProperty("user.name");
//		GetProp prop = null;
//		if (GETOS.getOS().toUpperCase().contains("WINDOWS")) {
//			prop = new GetProp("C:\\Users\\" + userName + "\\Desktop\\instabot\\env.properties");
//		}
//
//		if (GETOS.getOS().toUpperCase().contains("MAC") || GETOS.getOS().contains("LINUX")) {
//			prop = new GetProp("/home/" + userName + "/Desktop/instabot/env.properties");
//		}
//		String isHeadless = prop.getValue("BACKEND");
//		WebDriver driver = null;
//		WebDriverManager.chromedriver().setup();
//		if (isHeadless.equalsIgnoreCase("Y")) {
//			LOG.logger("Running in Backend!!!!");
//			ChromeOptions op = new ChromeOptions();
//			op.setHeadless(true);
//			driver = new ChromeDriver(op);
//		}
//		if (isHeadless.equalsIgnoreCase("N")) {
//			driver = new ChromeDriver();
//		}
//		driver.manage().window().maximize();
//		driver.get("https://www.instagram.com/");
//		CustomWait.imWait(driver);
//		element.byName(driver, "username", null).sendKeys(prop.getValue("USERNAME"));
//		element.byName(driver, "password", null).sendKeys(prop.getValue("PASSWORD"));
//		element.byCss(driver, "[type='submit']", null).click();
//		LOG.logger("LOGGED IN!!");
//
//		boolean isOldPage = element.byXpath(driver, "//div/a[contains(@aria-label, 'Direct messaging')]", null)
//				.isDisplayed();
//		if (isOldPage) {
//			LOG.logger("OLD PAGE IS ENABLED!!!");
//			MouseAction.clickByTap(driver, "//div/a[contains(@aria-label, 'Direct messaging')]");
//		}
//		if (!isOldPage) {
//			LOG.logger("NEW PAGE IS ENABLED!!!");
//			element.byXpath(driver, "//*[text()='Messages']", null).click();
//		}
//
//		LOG.logger("LANDED ON DM PAGE!!!");
//
//		CustomWait.hardWait(null);
//		WebElement popUp = element.byXpath(driver, "//*[text()='Not Now']", 10);
//		if (!popUp.isDisplayed()) {
//			LOG.logger("NO POP UP!!!");
//		}
//		if (popUp.isDisplayed()) {
//			LOG.logger("POP UP FOUND!!!");
//			popUp.click();
//		}
//		CustomWait.hardWait(null);
//
//		element.byText(driver, prop.getValue("PERSON"), null).click();
//		for (int i = 0; i < Integer.parseInt(prop.getValue("TIMES")); i++) {
//			CustomWait.hardWait(500);
//			element.byCss(driver, "[placeholder='Message...']", null).sendKeys(prop.getValue("MESSAGE") + Keys.ENTER);
//		}
//
//		LOG.logger("Exiting the Application!!!!");
//
//		if (isHeadless.equalsIgnoreCase("Y")) {
//			LOG.logger(":::::::::::::::::::::::::::::" + ":::::::::::::::::::::::::::::"
//					+ "PLEASE LOGIN TO YOUR INSTA AND CHECK!!!!!!" + ":::::::::::::::::::::::::::::"
//					+ ":::::::::::::::::::::::::::::");
//		}
//
//		driver.quit();
//
//	}

	public static void twitterBOT(String username, String pass, int tweet, boolean isBackground)
			throws InterruptedException {
		LOG.logger("::::::::::::::::::::::" + "HOPE YOU ARE NOT USING YOUR REAL ACCOUNT!!!!!");

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		if (isBackground) {
			LOG.logger("Running in Backend!!!!");
			ChromeOptions op = new ChromeOptions();
			op.setHeadless(true);
			driver = new ChromeDriver(op);
		}
		if (!isBackground) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.twitter.com/");
		CustomWait.imWait(driver);
		element.byCss(driver, "[data-testid='login']", null).click();
		CustomWait.waitTillDisplayed(driver, "//input[@autocomplete='username']", null);
		element.byXpath(driver, "//input[@autocomplete='username']", null).sendKeys(username);
		CustomWait.hardWait(3000);
		element.byText(driver, "Next", null).click();
		try {
			WebElement verifyUserAcc = element.byText(driver, "Enter your phone number or username", 10);
			if (verifyUserAcc.isDisplayed()) {
				LOG.logger("Verify account is displayed reeeee");
				element.byCss(driver, "[name='text']", null).sendKeys("masterhommy");
				element.retryingFindClick(driver, "//*[text()='Next']");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		element.byName(driver, "password", null).sendKeys(pass);
		CustomWait.hardWait(null);
		WebElement loginButtonIsEnabled = element.byText(driver, "Log in", null);
		if (loginButtonIsEnabled.isEnabled()) {
			element.retryingFindClick(driver, "//div[@role]//span[text()='Log in']");
		}

		LOG.logger("LOGGED IN TO THE APPLICATION!!!!");

		CustomWait.hardWait(null);

		try {
			CustomWait.waitTillDisplayed(driver, "//*[@aria-label='Account menu']", 5000);
			CustomWait.hardWait(5000);
			element.byCss(driver, "[placeholder='Search Twitter']", null).sendKeys("Elon Musk" + Keys.ENTER);
		} catch (Exception e) {
			WebElement closePOPUP = driver.findElement(By.xpath("//*[text()='Get Started']"));
			if (closePOPUP.isDisplayed()) {
				LOG.logger("SECURITY POP UP FOUND");
				closePOPUP.click();
			}
			CustomWait.waitTillDisplayed(driver, "//*[text()='masterhommy']", 5000);
			CustomWait.hardWait(5000);
			element.byCss(driver, "[placeholder='Search Twitter']", null).sendKeys("Elon Musk" + Keys.ENTER);
		}

		CustomWait.hardWait(3000);
		WebElement followingPeople = element.byXpath(driver,
				"//span[text()='People you follow']//following::input[@name='People']", null);
		if (!followingPeople.isSelected()) {
			followingPeople.click();
		}
		element.byText(driver, "Elon Musk", 10).click();
		CustomWait.hardWait(3000);

		for (int i = 0; i < tweet; i++) {
			CustomWait.hardWait(1000);
			driver.findElements(By.cssSelector("[aria-label*='Reply']")).get(0).click();
			element.byXpath(driver, "//div[@aria-label='Tweet text']", 10)
					.sendKeys(RandomG.topics.get(RandomG.random()));
			WebElement replyButton = element.byText(driver, "Reply", 10);
			if (replyButton.isEnabled()) {
				element.retryingFindClick(driver, "//*[text()='Reply']");
				CustomWait.hardWait(1000);
				driver.navigate().refresh();
			}
		}
		/*
		 * WebElement replyButton = element.byText(driver, "Reply", 10); if
		 * (replyButton.isEnabled()) { element.retryingFindClick(driver,
		 * "//*[text()='Reply']"); CustomWait.hardWait(2000); }
		 */

		CustomWait.hardWait(2000);
		element.byCss(driver, "[data-testid='SideNav_AccountSwitcher_Button']", 10).click();
		CustomWait.hardWait(1000);
		if (element.byCss(driver, "a[href*='logout']", 10).isDisplayed()) {
			element.byCss(driver, "a[href*='logout']", null).click();
			element.retryingFindClick(driver, "//*[text()='Log out']");
		}
		LOG.logger("Exiting the Application!!!!");

		if (isBackground) {
			LOG.logger(":::::::::::::::::::::::::::::" + ":::::::::::::::::::::::::::::"
					+ "PLEASE LOGIN TO YOUR INSTA AND CHECK!!!!!!" + ":::::::::::::::::::::::::::::"
					+ ":::::::::::::::::::::::::::::");
		}
		CustomWait.hardWait(5000);
		driver.quit();

	}

}
