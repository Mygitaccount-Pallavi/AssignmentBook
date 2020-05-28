package com.goodreads.qa.test;

import java.io.ObjectInputFilter.Status;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goodreads.qa.ExtentReportsListner.ExtentReportsNG;
import com.goodreads.qa.base.TestBase;
import com.goodreads.qa.pages.HomePage;
import com.goodreads.qa.pages.LoginPage;
import com.goodreads.qa.pages.SearchResultPage;
import com.goodreads.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	Map<String, String> bookInfo;
	WebDriver driver;

	public LoginPageTest() {
		super();
	}

	public ExtentReportsNG extent;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void loginPageTitleTest() {

		String title = loginPage.validatLoginPage();
		Assert.assertEquals(title, "Goodreads | Meet your next favorite book");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		String homePagetitle = homePage.verifyHomePage();
		Assert.assertEquals(homePagetitle, "Recent updates | Goodreads");
		searchResultPage = homePage.searchByAuthor("Chetan Bhagat");
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		bookInfo = searchResultPage.getbookDetails();
		searchResultPage.getBooklink(bookInfo);

	}

	// @Test
	// public void loginTest() {
	//
	// }
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
