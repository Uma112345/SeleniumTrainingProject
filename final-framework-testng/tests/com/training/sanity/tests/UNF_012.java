package com.training.sanity.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_012 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private String adminUrl;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		// baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		// driver.get(baseUrl);
		driver.get(adminUrl);
	}

	@AfterMethod
	
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}

	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		Thread.sleep(300);
		String expectedText = "Dashboard";
		AssertJUnit.assertEquals(driver.findElement(By.linkText("Dashboard")).getText(), expectedText);
		// System.out.println(driver.findElement(By.linkText("Dashboard")).getText());
		screenShot.captureScreenShot("First");
		loginPOM.firstLHNElement();
		Thread.sleep(300);
		loginPOM.OptionCategory().click().perform();
		System.out.println("Product"+loginPOM.OptionProducts().toString());
		AssertJUnit.assertEquals(driver.findElement(By.linkText("Categories")).getText(), "Categories");
		AssertJUnit.assertEquals(loginPOM.TableColumnCategoris().getText(), "Category Name");
		AssertJUnit.assertEquals(loginPOM.TableColumnSortOrder().getText(), "Sort Order");
		AssertJUnit.assertEquals(loginPOM.TableColumnAction().getText(), "Action");
		loginPOM.SelectCheckbox().click();
		loginPOM.buttonDelete().click();
		Thread.sleep(400);
		System.out.println(loginPOM.DeleteAlertText());
		loginPOM.confirmDelete();
		AssertJUnit.assertEquals(loginPOM.DeleteSuccessMessage().getText(), "Success: You have modified categories!x");
		
		
		
		//screenShot.captureScreenShot("CategoryTable");
	}
}
