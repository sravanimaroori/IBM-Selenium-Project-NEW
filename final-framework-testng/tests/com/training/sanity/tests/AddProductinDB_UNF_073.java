package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.AddProductinDBPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductinDB_UNF_073 {
	private WebDriver driver;
	private String baseUrl;
	private AddProductinDBPOM AddProductinDBPOM;
	private static Properties properties;
	@SuppressWarnings("unused")

	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AddProductinDBPOM = new AddProductinDBPOM(driver);
		baseUrl = properties.getProperty("baseURL");
	
		// open the browser
		driver.get("http://uniform.upskills.in/admin/");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	// create a new product with mandatory values and check the values asserts same as in DB //

	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String prdct_name, String meta, String model, String price, String quantity, String category) {
	
		AddProductinDBPOM.sendUserName("admin");
		AddProductinDBPOM.sendPassword("admin@123");
		AddProductinDBPOM.clickLoginBtn();
		AddProductinDBPOM.menu();
		AddProductinDBPOM.catalog();
		
		// adding multiple products //
		
		AddProductinDBPOM.products();
		AddProductinDBPOM.add();
		
		// Inputs in general tab //
		
		
		AddProductinDBPOM.prdct_name("Socks");
		AddProductinDBPOM.meta("White Socks");
		
		// Inputs in data tab //
		
		AddProductinDBPOM.data();
		AddProductinDBPOM.model("SCK-014");
		AddProductinDBPOM.price("200");
		AddProductinDBPOM.quantity("20");
		
		// Inputs in Links tab //
		
		AddProductinDBPOM.links();
		AddProductinDBPOM.setCategory("Sports wear");
		
		// Inputs in Discounts tab //
		AddProductinDBPOM.discount();
		
		
		// Inputs in rewards tab //
		AddProductinDBPOM.reward();
		
		

		// click on save product //
		
		AddProductinDBPOM.save();
		

	}

}