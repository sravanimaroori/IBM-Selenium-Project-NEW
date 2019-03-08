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
import com.training.pom.AddMultipleProductsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddMultipleProducts_UNF_071 {
	private WebDriver driver;
	private String baseUrl;
	private AddMultipleProductsPOM AddMultipleProductsPOM;
	private static Properties properties;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AddMultipleProductsPOM = new AddMultipleProductsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		
		// open the browser
		driver.get("http://uniform.upskills.in/admin/");
	}

	// login as admin and create multiple products entering mandatory fields by reading the values from excel //
	
	@Test(priority=0)
	public void loginTest() {
		
		// login as admin //
		
				AddMultipleProductsPOM.sendUserName("admin");
				AddMultipleProductsPOM.sendPassword("admin@123");
				AddMultipleProductsPOM.clickLoginBtn();
				
	}
	
	
	@Test(priority=1, dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String prdct_name, String meta, String model, String price, String category, String discountQuantity, String discountPrice,String inputPoints) throws InterruptedException {

		
		
		AddMultipleProductsPOM.menu();
		AddMultipleProductsPOM.catalog();
		
		// adding multiple products //
		
		AddMultipleProductsPOM.products();
		AddMultipleProductsPOM.add();
		
		// Inputs in general tab //
		
		
		AddMultipleProductsPOM.prdct_name(prdct_name);
		AddMultipleProductsPOM.meta(meta);
		
		// Inputs in data tab //
		
		AddMultipleProductsPOM.data();
		AddMultipleProductsPOM.model(model);
		AddMultipleProductsPOM.price(price);
		AddMultipleProductsPOM.quantity("5");
		
		// Inputs in Links tab //
		
		AddMultipleProductsPOM.links();
		AddMultipleProductsPOM.setCategory(category);
		
		// Inputs in Discounts tab //
		AddMultipleProductsPOM.discount();
		AddMultipleProductsPOM.addDiscount();
		AddMultipleProductsPOM.discountQuantity(discountQuantity);
		AddMultipleProductsPOM.discountPrice(discountPrice);
		AddMultipleProductsPOM.dateStart("2019-03-09");
		AddMultipleProductsPOM.dateEnd("2019-03-10");
		
		// Inputs in rewards tab //
		AddMultipleProductsPOM.reward();
		AddMultipleProductsPOM.inputPoints(inputPoints);
		

		// click on save product //
		
		AddMultipleProductsPOM.save();
		
		//compare the actual title of the page with the expected one
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText()
				.contains("Success: You have modified products!"));
	
		Thread.sleep(3000);
		
	}

}