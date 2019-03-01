package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_042POM {
	private WebDriver driver; 
	
	public UNF_042POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"button-menu\"]/i")
	private WebElement menu;
	
	@FindBy(xpath="//*[@id=\"catalog\"]/a")
	private WebElement catalog;
	
	@FindBy(xpath="//*[@id=\"catalog\"]/ul/li[2]/a")
	private WebElement products;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")
	private WebElement add;
	
	@FindBy(id="input-name1")
	private WebElement prdct_name;
	
	@FindBy(id="input-meta-title1")
	private WebElement meta;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[2]/a")
	private WebElement data;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[3]/a")
	private WebElement links;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]/div[2]/div[1]/input[1]")
	private WebElement category;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[7]/a")
	private WebElement discount;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[10]/a")
	private WebElement rewardpoints;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[4]/a")
	private WebElement Attribute;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[5]/a")
	private WebElement option;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[6]/a")
	private WebElement Recurring;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[8]/a")
	private WebElement special;
	
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[9]/a")
	private WebElement image;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[11]/a")
	private WebElement design;
	

	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement save;
	
	
	
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
	public void menu() {
		this.menu.click();
	}
	public void catalog() {
		this.catalog.click();
	}
	public void products() {
		this.products.click();
	}
	public void add() {
		this.add.click();
	}
	public void prdct_name(String prdct_name) {
		this.prdct_name.sendKeys(prdct_name);
	}
	public void meta(String meta) {
		this.meta.sendKeys(meta);
	}
	public void data() {
		this.data.click();
	}
	public void model(String model) {
		this.model.sendKeys(model);
	}
	public void price(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	public void quantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	public void links() {
		this.links.click();
	}
	public void setCategory(String category) {
		this.category.clear();
		this.category.sendKeys(category);
	}
	public void discount() {
		this.discount.click();
	}
    public void reward() {
    	this.rewardpoints.click();
    }
    
    public void Attribute() {
    	this.Attribute.click();
    }
    public void option() {
    	this.option.click();
    }
    public void Recurring() {
    	this.Recurring.click();
    }
    public void special() {
    	this.special.click();
    }
    public void image() {
    	this.image.click();
    }
    public void design() {
    	this.design.click();
    }
    public void save() {
    	this.save.click();
    }

	{
		// TODO Auto-generated method stub
		
	}
}


