package com.goodreads.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goodreads.qa.base.TestBase;

public class HomePage extends TestBase {
	//PageFactory 
	
	@FindBy(xpath="//input[@class='searchBox__input searchBox__input--navbar']")
	WebElement searchText;
	
	@FindBy(xpath="//button[@type='submit' and @class='searchBox__icon--magnifyingGlass gr-iconButton searchBox__icon searchBox__icon--navbar']")
	WebElement  searchButton;
	
	@FindBy(xpath="//input[@id='search_query_main']")
	WebElement searchArea; 
	
	@FindBy(xpath="//input[@id='search_field_author']")
	WebElement authorRadio;
	
	@FindBy(xpath="//input[@class='searchBox__button searchBox--large__button']")
	WebElement authorSearch;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePage() {
		 return driver.getTitle();
	}
	
 public SearchResultPage searchByAuthor(String author) {
	 searchText.sendKeys(author);
	 searchButton.click();
	 searchArea.clear();
	 searchArea.sendKeys(author);
	 authorRadio.click();
	 authorSearch.click();
	 
	 
	 return new SearchResultPage();
	 
 }
}
