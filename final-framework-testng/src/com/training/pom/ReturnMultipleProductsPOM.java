package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnMultipleProductsPOM {
	private WebDriver driver; 
	
	public ReturnMultipleProductsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


// login as user //
	
	 @FindBy(xpath="//span[@class='caret']")
	 private WebElement userIcon; 
	 
	 public void userIcon() {
			this.userIcon.click(); 
		}
	 
	 @FindBy(xpath="//a[contains(text(),'Login')]")
	 private WebElement Login;
	 
	 public void Login() {
			this.Login.click(); 
		}
	 
	 @FindBy(xpath="//input[@placeholder='E-Mail Address']")
     private WebElement Email;
	 
	 public void sendEmail(String Email) {
			this.Email.clear(); 
			this.Email.sendKeys(Email); 
		}
	 
	 @FindBy(xpath="//input[@id='input-password']")
	 private WebElement Password;
	 
	 public void sendPassword(String password) {
			this.Password.clear(); 
			this.Password.sendKeys(password); 
		}
	 
	 @FindBy(xpath="//input[@value='Login']")
    private WebElement Login1;
	 
	 public void Login1() {
			this.Login1.click(); 
		}
	 @FindBy(xpath="//a[contains(text(),'View your order history')]")
	 private WebElement myOrders;
	 
	 public void myOrders() {
			this.myOrders.click(); 
		}
	 
	 @FindBy(xpath="//tr[1]//td[7]//a[1]")
     private WebElement viewIcon;
	 
	 public void viewIcon() {
			this.viewIcon.click(); 
		}
	 
	 @FindBy(xpath="//tr[1]//td[6]//a[2]")
     private WebElement returnIcon;
	 
	 public void returnIcon() {
			this.returnIcon.click(); 
		}
	 
	 @FindBy(xpath="//div[@class='col-sm-10']//div[1]//label[1]//input[1]")
     private WebElement reasonForReturn;
	 
	 public void reasonForReturn(String reasonForReturn) {
		 this.reasonForReturn.click(); 
		}
	 
	 @FindBy(name="opened")
     private WebElement productOpen;
	 
	 public void productOpen(String productOpen) {
			this.productOpen.isSelected(); 
		}
	 
	 @FindBy(xpath="//textarea[@id='input-comment']")
     private WebElement faultyDetails;
	 
	 public void faultyDetails(String faultyDetails) {
			this.faultyDetails.clear(); 
			this.faultyDetails.sendKeys(faultyDetails); 
		}
	 
	 @FindBy(xpath="//div[@class='pull-right']//input[@value='1']")
     private WebElement checkbox;
	 
	 public void checkbox() {
			this.checkbox.click(); 
			if (checkbox.isSelected()) {					
	            System.out.println("Checkbox is Toggled On");					

	        } else {			
	            System.out.println("Checkbox is Toggled Off");					
	        }	
	 }
	 
			
	@FindBy(xpath="//input[@value='Submit']")
     private WebElement submit;
	 
	 public void submit() {
			this.submit.click(); 
		
	 }
	 
	 
}
