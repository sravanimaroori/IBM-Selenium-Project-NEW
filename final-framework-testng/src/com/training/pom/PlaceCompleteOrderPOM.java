package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PlaceCompleteOrderPOM {
	private WebDriver driver; 
	
	public PlaceCompleteOrderPOM(WebDriver driver) {
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
	 
	 @FindBy(xpath="//a[contains(text(),'Uniform Store')]")
     private WebElement uniformstore;
	 
	 public void uniformstore() {
			this.uniformstore.click(); 
	 }
		
		 
		 
	 @FindBy(xpath="//a[contains(text(),'Regular T-Shirt (Royal Blue)')]")
	 private WebElement regularshirt;
		 
		 public void regularshirt() {		
		
			 Actions action = new Actions(driver);
		     action.moveToElement(regularshirt).build().perform();
			 this.regularshirt.click();
		 }
	
	 @FindBy(xpath="//*[@id=\"input-option389\"]")
	 private WebElement chestSize;
			 
	 public void chestSize(String chestsize) {
		 Select option = new Select(chestSize);
			option.selectByIndex(3); 
			
	 }
	 
	 @FindBy(xpath="//button[@id='button-cart']")
	 private WebElement addtoCart;
	 
	 public void addtoCart() {
			this.addtoCart.click(); 
			
	 }
	 
	 @FindBy(xpath="//*[@id=\"cart\"]/button")
	 private WebElement cartIcon;
	 
	 public void cartIcon() {		
			
		 Actions action = new Actions(driver);
	     action.moveToElement(cartIcon).build().perform();
		 this.cartIcon.click();
	 }
	 
	 @FindBy(linkText="View Cart")
	 private WebElement viewCart;
	 
	 public void viewCart() {		
			
		 Actions action = new Actions(driver);
	     action.moveToElement(viewCart).build().perform();
		 this.viewCart.click();
	 }
	 
	 @FindBy(xpath="//a[@class='btn btn-primary']")
     private WebElement checkOut; 
	 
	 public void checkOut() {
			this.checkOut.click(); 
		}
	 
	 @FindBy(xpath="//input[@id='button-payment-address']")
     private WebElement billingContinue; 
	 
	 public void billingContinue() {
			this.billingContinue.click(); 
		}
	 
	 @FindBy(xpath="//input[@id='button-shipping-address']")
     private WebElement deliveryContinue; 
	 
	 public void deliveryContinue() {
			this.deliveryContinue.click(); 
		}
	 
	 @FindBy(xpath="//input[@id='button-shipping-method']")
     private WebElement shippingContinue; 
	 
	 public void shippingContinue() {
			this.shippingContinue.click(); 
		}
	 
	 @FindBy(xpath="//input[@value='1']")
     private WebElement checkbox;
	 
	 public void checkbox() {
			this.checkbox.click(); 
			if (checkbox.isSelected()) {					
	            System.out.println("I Agree terms & conditions");					

	        } else {			
	            System.out.println("I dont Agree terms & conditions");					
	        
	        }
	 }
	 
	 @FindBy(xpath="//input[@id='button-payment-method']")
     private WebElement paymentContinue; 
	 
	 public void paymentContinue() {
			this.paymentContinue.click(); 
		}
	 
	 @FindBy(xpath="//input[@id='button-confirm']")
     private WebElement confirmOrder; 
	 
	 public void  confirmOrder() {
			this.confirmOrder.click(); 
			
		
	 }
	 
	// login as admin //

	 @FindBy(id="input-username")
	 private WebElement userName; 
	 
	 public void sendUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}

	 @FindBy(id="input-password")
	 private WebElement password;

	  public void sendadminpassword(String adminpassword) {
		this.Password.clear(); 
		this.Password.sendKeys(adminpassword); 
	}

	 @FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	 private WebElement loginBtn; 

	 public void clickLoginBtn() {
		this.loginBtn.click(); 
	 }
	 

	 @FindBy(xpath="//a[@id='button-menu']")
	 private WebElement menu;

	 public void menu() {
	 	this.menu.click();
	 }
	 
	 @FindBy(xpath="//nav[@id='column-left']/ul/li[5]") 
	 private WebElement Sales_link;
	 
	 public void Sales_link() {
		 	this.Sales_link.click();
		 }

	 @FindBy(xpath="//nav[@id='column-left']/ul/li[5]/ul/li")
	 private WebElement Sales_list;
	 
	 public void Sales_list() {
		 	this.Sales_list.click();
		 }

	 @FindBy(xpath="//nav[@id='column-left']/ul/li[5]/ul/li[1]")
	 private WebElement Orders_link;
	 
	 public void Orders_link() {
		 	this.Orders_link.click();
		 }
	 
	 @FindBy(xpath="//tr[1]//td[8]//a[1]")
	 private WebElement viewIcon;
	 
	 public void viewIcon() {
		 	this.viewIcon.click();
		 }
	 
	 @FindBy(xpath="//select[@id='input-order-status']")
	 private WebElement orderStatus;
	 
	 public void orderStatus(String orderstatus) 
	  {
		 Select option = new Select(orderStatus);
			option.selectByIndex(3);
      }
	 
	 @FindBy(xpath="//button[@id='button-history']")
     private WebElement addhistory;
	 
	 public void addhistory() {
		 	this.addhistory.click();
	
		
		 }
	 
	// user again logins //
	 
	 @FindBy(xpath="//a[contains(text(),'View your order history')]")
	private WebElement myOrders;
	 
	 public void myOrders() {
			this.myOrders.click(); 
		}
		 
		 @FindBy(xpath="//tr[1]//td[7]//a[1]")
		 private WebElement viewIcon1;
		 
		 public void viewIcon1() {
			 	this.viewIcon1.click();
}
		 
}