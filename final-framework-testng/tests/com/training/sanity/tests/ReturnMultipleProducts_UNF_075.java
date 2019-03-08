package com.training.sanity.tests;

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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ReturnMultipleProductsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturnMultipleProducts_UNF_075 {
	private WebDriver driver;
	private String baseUrl;
	private ReturnMultipleProductsPOM ReturnMultipleProductsPOM;
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
		ReturnMultipleProductsPOM = new ReturnMultipleProductsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		// open the browser
		driver.get("http://uniform.upskills.in/");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	
// login as user and return multiple products entering mandatory fields as reasons by the values from excel //
		
		        
		@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
				public void loginDBTest(String reasonForReturn, String productOpen, String faultyDetails) throws InterruptedException {
	
			// login as user //
			
		       ReturnMultipleProductsPOM.userIcon();
               ReturnMultipleProductsPOM.Login();
		       ReturnMultipleProductsPOM.sendEmail("marurisravani82@gmail.com");
		       ReturnMultipleProductsPOM.sendPassword("admin@123");
		       ReturnMultipleProductsPOM.Login1();
		       
		    // click on order history//
		       
		       ReturnMultipleProductsPOM.myOrders();
		       ReturnMultipleProductsPOM.viewIcon();
		       ReturnMultipleProductsPOM.returnIcon();
		       ReturnMultipleProductsPOM.reasonForReturn(reasonForReturn);
		       ReturnMultipleProductsPOM.productOpen(productOpen);
		       ReturnMultipleProductsPOM.faultyDetails(faultyDetails);
		       ReturnMultipleProductsPOM.checkbox();
		       ReturnMultipleProductsPOM.submit();
		       
		       
	}
}