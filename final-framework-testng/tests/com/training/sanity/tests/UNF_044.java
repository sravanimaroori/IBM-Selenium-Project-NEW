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

import com.training.pom.UNF_044POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_044 {

	private WebDriver driver;
	private String baseUrl;
	private UNF_044POM unf_044POM;
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
        unf_044POM = new UNF_044POM(driver); 
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
			
			unf_044POM.sendUserName("admin");
			unf_044POM.sendPassword("admin@123");
			unf_044POM.clickLoginBtn(); 
			
			//select the multiple products and delete them
			unf_044POM.menu();
			unf_044POM.catalog();
			unf_044POM.products();
			
			//creating new products every time manually before running the script instead of disturbing the existing ones//
			unf_044POM.product1("A-delete");
			Thread.sleep(2000);
			unf_044POM.product2("A1-delete");
			Thread.sleep(2000);
			unf_044POM.product3("AB-delete");
			Thread.sleep(2000);
			
			unf_044POM.delete();
			Thread.sleep(3000);
			
			//compare the actual title of the page with the expected one
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText()
					.contains("Success: You have modified products!"));
		}
}