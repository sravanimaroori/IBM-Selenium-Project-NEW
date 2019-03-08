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
import com.training.pom.InvalidDetailsAddProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class InvalidDetailsAddProduct_UNF_072 {
	private WebDriver driver;
	private String baseUrl;
	private InvalidDetailsAddProductPOM InvalidDetailsAddProductPOM;
	private static Properties properties;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		InvalidDetailsAddProductPOM = new InvalidDetailsAddProductPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		
		// open the browser
		driver.get("http://uniform.upskills.in/admin/");
	}

	// login as admin and create multiple products by entering invalid details by reading the values from excel //
	
	@Test(priority=0)
	public void loginTest() {
		
		// login as admin //
		
		InvalidDetailsAddProductPOM.sendUserName("admin");
		InvalidDetailsAddProductPOM.sendPassword("admin@123");
		InvalidDetailsAddProductPOM.clickLoginBtn();
				
	}
	
	@Test(priority=1, dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String prdct_name, String meta, String model, String price, String category, String discountQuantity, String discountPrice,String inputPoints) throws InterruptedException {

		
		
		InvalidDetailsAddProductPOM.menu();
		InvalidDetailsAddProductPOM.catalog();
		
		// adding multiple products //
		
		InvalidDetailsAddProductPOM.products();
		InvalidDetailsAddProductPOM.addicon();
		
		// Inputs in general tab //
		
		
		InvalidDetailsAddProductPOM.prdct_name(prdct_name);
		InvalidDetailsAddProductPOM.meta(meta);
		
		// Inputs in data tab //
		
		InvalidDetailsAddProductPOM.data();
		InvalidDetailsAddProductPOM.model(model);
		InvalidDetailsAddProductPOM.price(price);
		
		
		// Inputs in Links tab //
		
		InvalidDetailsAddProductPOM.links();
		InvalidDetailsAddProductPOM.setCategory(category);
		
		// Inputs in Discounts tab //
		InvalidDetailsAddProductPOM.discount();
		InvalidDetailsAddProductPOM.addDiscount();
		InvalidDetailsAddProductPOM.discountQuantity(discountQuantity);
		InvalidDetailsAddProductPOM.discountPrice(discountPrice);
		

		
		// Inputs in rewards tab //
		InvalidDetailsAddProductPOM.reward();
		InvalidDetailsAddProductPOM.inputPoints(inputPoints);
		

		// click on save product //
		
		InvalidDetailsAddProductPOM.save();
		
		Thread.sleep(1000);
		
		//compare the actual title of the page with the expected one
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("Warning: Please check the form carefully for errors!"));
		
		

	}
}