package com.training.sanity.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.UNF_043POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_043 {
	private WebDriver driver;
	private String baseUrl;
	private UNF_043POM unf_043POM;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
        unf_043POM = new UNF_043POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		new ScreenShot(driver); 
		// open the browser 
		driver.get("http://uniform.upskills.in/admin/");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		//login as admin     
		unf_043POM.sendUserName("admin");
		unf_043POM.sendPassword("admin@123");
		unf_043POM.clickLoginBtn();
				
				//select the product and save it   
		unf_043POM.menu();
		unf_043POM.catalog();
		unf_043POM.products();
		unf_043POM.clickEditBtn();
				Thread.sleep(2000);
				unf_043POM.data();
				unf_043POM.quantity("100");
				unf_043POM.links();
				unf_043POM.Attribute();
				Thread.sleep(2000);
				unf_043POM.option();
				Thread.sleep(2000);
				unf_043POM.Recurring();
				Thread.sleep(2000);
				unf_043POM.discount();
				Thread.sleep(2000);
				unf_043POM.special();
				Thread.sleep(2000);
				unf_043POM.image();
				Thread.sleep(2000);
				unf_043POM.reward();
				Thread.sleep(2000);
				unf_043POM.design();
				Thread.sleep(2000);
				unf_043POM.save();
				Thread.sleep(5000);
				
				//compare the actual title of the page with the expected one
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText()
						.contains("Success: You have modified products!"));
				
				
				
	}
}