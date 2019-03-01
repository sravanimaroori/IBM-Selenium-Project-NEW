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
import com.training.pom.UNF_045POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_045 {

	private WebDriver driver;
	private String baseUrl;
	private UNF_045POM unf_045POM;
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
        unf_045POM = new UNF_045POM(driver); 
		baseUrl = properties.getProperty("baseURL");

		// open the browser 
		driver.get("http://uniform.upskills.in/admin/");
		
	}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(2000);
			driver.quit();
		}
		
		@Test
		public void validLoginTest() throws InterruptedException, AWTException {
			
			//login as admin     
			
			unf_045POM.sendUserName("admin");
			unf_045POM.sendPassword("admin@123");
			unf_045POM.clickLoginBtn(); 
			
			// As mentioned in pre-requisite placed a new order manually by logging as user// 
			//so it displays at the first row when logged in as admin//
			
			unf_045POM.orderslist();
			Thread.sleep(1000);
			unf_045POM.viewicon();
			Thread.sleep(1000);
			unf_045POM.generateinvoice();
			
			Thread.sleep(3000);
		}
}