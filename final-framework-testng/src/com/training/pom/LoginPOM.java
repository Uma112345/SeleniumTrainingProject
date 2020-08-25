package com.training.pom;

import java.awt.Desktop.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath = "//i[@class='fa fa-tags fa-fw']")
	private WebElement firstLHNElement;
	
	@FindBy(linkText = "Categories")
	private WebElement Category;
	
	@FindBy(linkText = "Products")
	private WebElement Products;
	
	@FindBy(linkText = "Recurring Profiles")
	private WebElement RecurringProfiles;
	
	@FindBy(linkText = "Filters")
	private WebElement Filters;
	
	@FindBy(linkText = "Attributes")
	private WebElement Attributes;
	
	@FindBy(linkText = "Options")
	private WebElement Options;
	
	
	
	@FindBy(xpath = "//table//thead//tr[1]//td[2]//a")
	private WebElement ColumnCategoryName;
	
	@FindBy(xpath = "//table//thead//tr[1]//td[3]//a")
	private WebElement ColumnSortOrder;
	
	@FindBy(xpath = "//table//thead//tr//td[4]")
	private WebElement ColumnAction;

	@FindBy(xpath = "//td[contains(text(),'15')]//preceding-sibling::td")
	private WebElement checkBox;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement buttonDelete;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement DeleteSuccessMsg;	
	
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void firstLHNElement() {
		Actions act = new Actions(driver);
		act.moveToElement(this.firstLHNElement).build().perform();;
	}
	
	/*
	 * public void clickProducts() { Actions act = new Actions(driver);
	 * act.moveToElement(this.Products).click().perform(); }
	 */
	
	
	public Actions OptionCategory() {
		Actions act = new Actions(driver);
        return act.moveToElement(this.Category);
 	}

	public Actions OptionProducts() {
		Actions act = new Actions(driver);
         return act.moveToElement(this.Products);
 	}
	
	public Actions OptionRecurringProfile() {
		Actions act = new Actions(driver);
        return act.moveToElement(this.RecurringProfiles);
 	}

	public Actions Optionfilters() {
		Actions act = new Actions(driver);
        return act.moveToElement(this.Filters);
 	}
	
	public Actions OptionAttributes() {
		Actions act = new Actions(driver);
        return act.moveToElement(this.Attributes);
 	}
	
	public Actions OptionOptions() {
		Actions act = new Actions(driver);
        return act.moveToElement(this.Options);
 	}
	
	public WebElement TableColumnCategoris() {
      return ColumnCategoryName;
 	}

	public WebElement TableColumnSortOrder() {
	      return ColumnSortOrder;
	 	}
	
	public WebElement TableColumnAction() {
	      return ColumnAction;
	 	}

	public WebElement SelectCheckbox() {
	      return checkBox;
	 	}

	public WebElement buttonDelete() {
	      return buttonDelete;
	 	}
	
	public void confirmDelete() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void CancelDelete() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String DeleteAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public WebElement DeleteSuccessMessage() {
	      return DeleteSuccessMsg;
	 	}
	
}
