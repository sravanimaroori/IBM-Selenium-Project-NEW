package com.training.pom;

import java.awt.List;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_044POM {
	private WebDriver driver; 
	
	public UNF_044POM(WebDriver driver) {
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
	
	//creating new products every time manually instead of disturbing the existing ones//
	
	@FindBy(xpath="//tr[.//td='A-delete']//input")
	private WebElement product1;
	
	@FindBy(xpath="//tr[.//td='A1-delete']//input")
	private WebElement product2;
	
	@FindBy(xpath="//tr[.//td='A1-delete']//input")
	private WebElement product3;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement delete;
	
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
	
	public void product1(String Product1) {
		this.product1.click();
	}
	
	public void product2(String Product2) {
		this.product2.click();
		
	}
	
	public void product3(String Product3) {
		this.product3.click();
		
	}
	public void delete() {
    	this.delete.click();
    }


		
	}

	