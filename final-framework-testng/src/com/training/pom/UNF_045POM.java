package com.training.pom;

import java.awt.List;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_045POM {
	private WebDriver driver; 
	
	public UNF_045POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn;
	
	// As mentioned in pre-requisite placed a new order manually by logging as user// 
	//so it displays at the first row when logged in as admin//
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div[1]/div/div[3]/a")
	private WebElement orderslist;
	
	@FindBy(xpath="//*[@id=\"form-order\"]/div/table/tbody/tr[1]/td[8]/a[1]")
	private WebElement viewicon;
	
	@FindBy(xpath="//tr[1]//td[3]//button[1]")
	private WebElement generateinvoice;

			
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
	
	public void orderslist() {
		this.orderslist.click();
	}
	
	public void viewicon() {
		this.viewicon.click();
    }
	
	public void generateinvoice() {
		this.generateinvoice.click();
    }
	
	}
