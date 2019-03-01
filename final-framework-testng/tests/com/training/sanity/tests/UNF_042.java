package com.training.sanity.tests;


import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.UNF_042POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_042 {

	private WebDriver driver;
	private String baseUrl;
	private UNF_042POM unf_042POM;
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
        unf_042POM = new UNF_042POM(driver); 
		baseUrl = properties.getProperty("baseURL");

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
		unf_042POM.sendUserName("admin");
		unf_042POM.sendPassword("admin@123");
		unf_042POM.clickLoginBtn(); 
		
		//select the product and save it   
		unf_042POM.menu();
		unf_042POM.catalog();
		unf_042POM.products();
		unf_042POM.add();
		unf_042POM.prdct_name("Shirt");
		unf_042POM.meta("Shirts for all");
		unf_042POM.data();
		unf_042POM.model("SHG-010");
		unf_042POM.price("750");
		unf_042POM.quantity("50");
		unf_042POM.links();
		unf_042POM.setCategory("Shirt");
		unf_042POM.discount();

		
		unf_042POM.discount();
		unf_042POM.reward();
		unf_042POM.Attribute();
		Thread.sleep(2000);
		unf_042POM.option();
		Thread.sleep(2000);
		unf_042POM.Recurring();
		Thread.sleep(2000);
		unf_042POM.special();
		Thread.sleep(2000);
		unf_042POM.image();
		Thread.sleep(2000);
		unf_042POM.design();
		Thread.sleep(2000);
		unf_042POM.save();
		
		Thread.sleep(5000);
		
	//compare the actual title of the page with the expected one
		String Actual="Products";
		String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/h1")).getText();
		Assert.assertEquals(Actual, Expected);
		
		
	
	}
}
