package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InvalidDetailsAddProductPOM {
	private WebDriver driver; 
	
	public InvalidDetailsAddProductPOM(WebDriver driver) {
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

@FindBy(xpath="//a[@id='button-menu']")
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

@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
private WebElement addicon;


public void addicon() {
	this.addicon.click();
}

// go to general tab //

@FindBy(xpath="//input[@id='input-name1']")
private WebElement prdct_name;

public void prdct_name(String prdct_name) {
	this.prdct_name.sendKeys(prdct_name);
}

@FindBy(xpath="//input[@id='input-meta-title1']")
private WebElement meta;


public void meta(String meta) {
	this.meta.sendKeys(meta);
}

// go to data tab //

@FindBy(xpath="//a[contains(text(),'Data')]")
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

@FindBy(xpath="//table[@id='discount']//button[@type='button']")
private WebElement addDiscount;

public void addDiscount() {
	this.addDiscount.click();
}

@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
private WebElement discountQuantity;

public void discountQuantity(String quantity) {
	this.discountQuantity.clear();
	this.discountQuantity.sendKeys(quantity);
}


@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
private WebElement discountPrice;

public void discountPrice(String price) {
	this.discountPrice.clear();
	this.discountPrice.sendKeys(price);
}

// go to reward points //

@FindBy(xpath="//a[@href='#tab-reward']")
private WebElement rewardPoints;

public void reward() {
	this.rewardPoints.click();
}

@FindBy(xpath="//input[@id='input-points']")
private WebElement inputPoints;

public void inputPoints(String points) {
	this.inputPoints.clear();
	this.inputPoints.sendKeys(points);
}

// click on save product //

@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
private WebElement save;

public void save() {
	this.save.click();
	
	//compare the actual title of the page with the expected one
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
			.contains("Warning: Please check the form carefully for errors!"));
	
}

}
