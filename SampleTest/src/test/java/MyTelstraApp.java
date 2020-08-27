import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;

public class MyTelstraApp {
	public WebDriver driver;
	public WebDriverWait wait;

	public void swipeUp() {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int width = size.width / 2;
		int startPoint = (int) (size.getHeight() * 0.60);
		int endPoint = (int) (size.getHeight() * 0.20);
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(width, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint))
				.release().perform();
	}

	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("no", true);
		caps.setCapability("deviceName", "oneplus-gm1901");
		caps.setCapability("udid", "c5720220");
		// DeviceId from "adb devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
		caps.setCapability("skipUnlock", "true");
		caps.setCapability("app",
				"C:\\Users\\sh20092315\\Desktop\\Mobile App Automation\\APK\\MyTelstra-dev-R55.0-55.0.72.apk");
		caps.setCapability("appPackage", "com.telstra.mobile.android.mytelstra.dev.debug");
		caps.setCapability("appActivity", "com.telstra.android.myt.main.MainActivity");
		caps.setCapability("noReset", "true");
		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	
//	  @Test public void basicTest () throws InterruptedException {
//	  
//	  Thread.sleep(5000); driver.findElement(By.xpath(
//	  "//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra:id/next']"
//	  )).click(); Thread.sleep(1000); driver.findElement(By.xpath(
//	  "//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra:id/next']"
//	  )).click(); Thread.sleep(1000); driver.findElement(By.xpath(
//	  "//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra:id/next']"
//	  )).click();
//	  driver.findElement(By.id("com.telstra.mobile.android.mytelstra:id/close")).
//	  click(); Thread.sleep(5000); //The viewing size of the device
//	  org.openqa.selenium.Dimension size = driver.manage().window().getSize(); //x
//	  position set to mid-screen horizontally int width = size.width / 2;
//	  //Starting y location set to 60% of the height (near bottom) int startPoint =
//	  (int) (size.getHeight() * 0.60); //Ending y location set to 20% of the height
//	  (near top) int endPoint = (int) (size.getHeight() * 0.20); new
//	  TouchAction((PerformsTouchActions) driver).press(PointOption.point(width,
//	  startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).
//	  moveTo(PointOption.point(width, endPoint)).release().perform();
//	  Thread.sleep(5000); try { // Block of code to try
//	  driver.findElement(By.xpath("//android.widget.TextView[@text='Shop']")).click
//	  (); Thread.sleep(5000); Reporter.log("Successfully selected shop option"); }
//	  catch(Exception e) { // Block of code to handle errors
//	  Reporter.log("Failed to  select shop option"); }
//	  
//	  }
	 

	@Test
	public void awsmockLogin() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/profile']"))
				.click();
		Thread.sleep(5000);
		swipeUp();
		swipeUp();
		driver.findElement(By.xpath(
				"//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/developerPlaygroundButton']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/environmentButton']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//android.widget.Spinner[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/dropDownList']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='AWSMOCK']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/doneButton']"))
				.click();
		Thread.sleep(1000);
		// ((AndroidDriver)driver).activateApp("com.telstra.android.myt.main.MainActivity");
		Reporter.log("Successfully logged on with AWS_MOCK");
	}

	@Test
	public void validateService() throws InterruptedException {
		
		Thread.sleep(5000);
		try
		{
				driver.findElement(By.xpath(
						  "//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/next']"
						  )).click(); 
				Thread.sleep(1000); 
				driver.findElement(By.xpath(
						  "//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/next']"
						  )).click(); 
				Thread.sleep(1000); 
				driver.findElement(By.xpath(
						  "//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/next']"
						  )).click();
				Thread.sleep(3000);
				driver.findElement(By.id("com.telstra.mobile.android.mytelstra.dev.debug:id/signInNowButton")).click();
		}
		catch(Exception e)
		{
			System.out.println("Already onboarded into Telstra App");
		}
		Thread.sleep(5000);
		try {
//			swipeUp();
			driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.telstra.mobile.android.mytelstra.dev.debug:id/signInButton\"]")).click();
		}
		catch(Exception e) {
			System.out.println("Already initiated signin steps");
		}
		//driver.findElement(By.id("com.telstra.mobile.android.mytelstra.dev.debug:id/close")).click();
		//signInButton.click();
		Thread.sleep(3000);
		try {
			WebElement usernameBox=driver.findElement(By.id("username"));
			WebElement passwordBox=driver.findElement(By.id("password"));
			usernameBox.click();
			usernameBox.sendKeys("myt_usage");
			Thread.sleep(3000);
			passwordBox.click();
			passwordBox.sendKeys("myt_usage");
			driver.navigate().back();
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					  "//android.widget.Button[@text='Sign in']")).click();
			Thread.sleep(10000);
			driver.findElement(By.id(
					  "com.telstra.mobile.android.mytelstra.dev.debug:id/close")).click();
			Thread.sleep(3000);
		}
		catch(Exception e){
			System.out.println("Already logged inside aws mock user");
		}
		
		driver.findElement(By.xpath(
				"//android.widget.FrameLayout[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/servicesDest']"))
				.click();
		Thread.sleep(3000);
		while ((driver.findElements(By.xpath(
				"//android.widget.Button[@content-desc=\"Internet ; joe.profile@bigpond.com\"]/android.widget.TextView[2]")))
						.isEmpty()) {
			swipeUp();
		}
		swipeUp();
		Thread.sleep(5000);
		WebElement data_used = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/usageCardDataUsedSubText']"));
		WebElement days_left = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/usageCardDaysText']"));
		String days_remaining = days_left.getText();
		String data_consumed = data_used.getText();
		System.out.println("Days remaining as in services:" + days_remaining);
		System.out.println("Data Usage as in services:    " + data_consumed);
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//android.widget.Button[@content-desc=\"Internet ; joe.profile@bigpond.com\"]/android.widget.ImageView[2]"))
				.click();
		Thread.sleep(3000);
		WebElement data_used_summary = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/usageCardDataUsedSubText']"));
		Thread.sleep(3000);
		WebElement days_left_summary = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/usageCardDaysText']"));
		String days_remaining_summary = days_left_summary.getText();
		String data_consumed_summary = data_used_summary.getText();
		System.out.println("Days remaining as in internet summary:" + days_remaining_summary);
		System.out.println("Data Usage as in internet summary:    " + data_consumed_summary);
//    	data_consumed_summary="150";
		Thread.sleep(5000);
		Assert.assertEquals(data_consumed, data_consumed_summary, "Data Values does not match with each other");
		Assert.assertEquals(days_remaining, days_remaining_summary, "Day Values does not match with each other");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
