package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_043POM {
	private WebDriver driver; 
	
	public UNF_043POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	@FindBy(id="input-password")
	private WebElement password;
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn;
	
	public void clickLoginBtn() {
		this.loginBtn.click();
	}
	
	@FindBy(xpath="//*[@id=\"button-menu\"]/i")
	private WebElement menu;
	
	public void menu() {
		this.menu.click();
	}
	
	@FindBy(xpath="//*[@id=\"catalog\"]/a")
	private WebElement catalog;
	
	public void catalog() {
		this.catalog.click();
	}
	
	@FindBy(xpath="//*[@id=\"catalog\"]/ul/li[2]/a")
	private WebElement products;
	
	public void products() {
		this.products.click();
	}
	
	@FindBy(xpath="//*[@id=\"form-product\"]/div/table/tbody/tr[1]/td[8]/a/i")
	private WebElement editBtn;
	
	public void clickEditBtn() {
		this.editBtn.click();
	}
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[2]/a")
	private WebElement data;
	
	public void data() {
		this.data.click();
	}
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	public void quantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[3]/a")
	private WebElement links;
	
	public void links() {
		this.links.click();
	}
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[4]/a")
	private WebElement Attribute;
	
	public void Attribute() {
	   	this.Attribute.click();
	}
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[5]/a")
	private WebElement option;
	
	public void option() {
    	this.option.click();
    }
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[6]/a")
	private WebElement Recurring;
	
	public void Recurring() {
	   	this.Recurring.click();
	}
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[7]/a")
	private WebElement discount;
	
	public void discount() {
		this.discount.click();
	}
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[8]/a")
	private WebElement special;
	
	public void special() {
    	this.special.click();
    }
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[9]/a")
	private WebElement image;
	
	public void image() {
    	this.image.click();
    }
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[10]/a")
	private WebElement reward;
	
	public void reward() {
    	this.reward.click();
    }
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[11]/a")
	private WebElement design;
	
	public void design() {
    	this.design.click();
    }
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement save;
	
	public void save() {
    	this.save.click();
    }
}