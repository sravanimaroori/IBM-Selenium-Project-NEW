package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductinDBPOM {
	private WebDriver driver; 
	
	public AddProductinDBPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
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

public void sendPassword(String password) {
	this.password.clear(); 
	this.password.sendKeys(password); 
}

 @FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
 private WebElement loginBtn; 

public void clickLoginBtn() {
	this.loginBtn.click(); 
}
// Go to menu //

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

@FindBy(xpath="//a[contains(text(),'Products')]")
private WebElement products;

public void products() {
	this.products.click();
}

// Click on add new product //

@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")
private WebElement add;


public void add() {
	this.add.click();
}

// go to general tab //

@FindBy(id="input-name1")
private WebElement prdct_name;

public void prdct_name(String prdct_name) {
	this.prdct_name.sendKeys(prdct_name);
}

@FindBy(id="input-meta-title1")
private WebElement meta;


public void meta(String meta) {
	this.meta.sendKeys(meta);
}

// go to data tab //

@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[2]/a")
private WebElement data;


public void data() {
	this.data.click();
}

@FindBy(id="input-model")
private WebElement model;


public void model(String model) {
	this.model.sendKeys(model);
}


@FindBy(id="input-price")
private WebElement price;

public void price(String price) {
	this.price.clear();
	this.price.sendKeys(price);
}

@FindBy(id="input-quantity")
private WebElement quantity;


public void quantity(String quantity) {
	this.quantity.clear();
	this.quantity.sendKeys(quantity);
}

// go to links tab //

@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[3]/a")
private WebElement links;

public void links() {
	this.links.click();
}

@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]/div[2]/div[1]/input[1]")
private WebElement category;

public void setCategory(String category) {
	this.category.clear();
	this.category.sendKeys(category);
}

// go to discounts tab //

@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[7]/a")
private WebElement discount;

public void discount() {
	this.discount.click();
}

// go to reward points //

@FindBy(xpath="//a[@href='#tab-reward']")
private WebElement rewardPoints;

public void reward() {
	this.rewardPoints.click();
}


// click on save product //

@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
private WebElement save;

public void save() {
	this.save.click();
}

}
