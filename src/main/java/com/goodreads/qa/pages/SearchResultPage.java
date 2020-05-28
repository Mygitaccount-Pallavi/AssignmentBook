package com.goodreads.qa.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.Context;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goodreads.qa.base.TestBase;

public class SearchResultPage extends TestBase {

//    Map<String,String> bookDetails = new HashMap<String,String>();

	@FindBy(xpath = "//table//tbody//tr//td//a[@class='bookTitle']//span")
	List<WebElement> bookName;
	  @FindBy(xpath = "//table//tbody//tr//td//a[@class='bookTitle']")
		List<WebElement> booklink;

	@FindBy(xpath = "//a[contains(.,'next »')]")
	WebElement nextButton;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifySerachPageTitle() {
		return driver.getTitle();
	}
	
	public  Map<String,String> getbookDetails(){
		 Map<String,String> bookDetails = new HashMap<String,String>();
		 for(int i=0;i<=bookName.size()-1;i++) {
			 boolean found=false;
			 bookDetails.put(bookName.get(i).getText(), booklink.get(i).getAttribute("href"));
			 try {
				 found=nextButton.isEnabled();
			 }catch(Exception e) {
				found=false; 
			 }
			
			 if(bookName.size()-1==i && found) {
				 nextButton.click();
				 bookName.size();
				 i=-1;
			 }
		 }
		 
		return bookDetails;
		
	}
public void getBooklink(Map details) {
	Iterator hmIterator = details.entrySet().iterator(); 
	
	while(hmIterator.hasNext()) {
		Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
		System.out.println(mapElement.getKey() + "="+mapElement.getValue());
		
	}
}
}
