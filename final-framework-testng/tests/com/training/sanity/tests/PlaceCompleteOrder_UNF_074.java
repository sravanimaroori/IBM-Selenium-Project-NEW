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


import com.training.pom.PlaceCompleteOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PlaceCompleteOrder_UNF_074 {

	private WebDriver driver;
	private String baseUrl;
	private PlaceCompleteOrderPOM PlaceCompleteOrderPOM;
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
		PlaceCompleteOrderPOM = new PlaceCompleteOrderPOM(driver); 
		// baseUrl = properties.getProperty("baseURL"); //

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	// login as user, place an order//
	
	@Test(priority=0)
	public void validLoginTest() throws InterruptedException, AWTException {
		
		// open the browser 
		driver.get("http://uniform.upskills.in/");
		
		PlaceCompleteOrderPOM.userIcon();
		PlaceCompleteOrderPOM.Login();
		PlaceCompleteOrderPOM.sendEmail("marurisravani82@gmail.com");
		PlaceCompleteOrderPOM.sendPassword("admin@123");
		PlaceCompleteOrderPOM.Login1();
		PlaceCompleteOrderPOM.uniformstore();
		
		PlaceCompleteOrderPOM.regularshirt();
		PlaceCompleteOrderPOM.chestSize("26");
		PlaceCompleteOrderPOM.addtoCart();
		PlaceCompleteOrderPOM.cartIcon();
		PlaceCompleteOrderPOM.viewCart();
		PlaceCompleteOrderPOM.checkOut();
		PlaceCompleteOrderPOM.billingContinue();
		PlaceCompleteOrderPOM.deliveryContinue();
		PlaceCompleteOrderPOM.shippingContinue();
		PlaceCompleteOrderPOM.checkbox();
		PlaceCompleteOrderPOM.paymentContinue();
		PlaceCompleteOrderPOM.confirmOrder();
		
		Thread.sleep(1000);
		
	}
	
	//login as admin, complete the process of order //
	
	
	@Test(priority=1)
	public void validLoginTest1() throws InterruptedException, AWTException {
		
		// open the browser 
		driver.get("http://uniform.upskills.in/admin/");
		
		PlaceCompleteOrderPOM.sendUserName("admin");
		PlaceCompleteOrderPOM.sendadminpassword("admin@123");
		PlaceCompleteOrderPOM.clickLoginBtn();
		PlaceCompleteOrderPOM.menu();
		PlaceCompleteOrderPOM.Sales_link();
		PlaceCompleteOrderPOM.Sales_list();
		PlaceCompleteOrderPOM.Orders_link();
		PlaceCompleteOrderPOM.viewIcon();
		PlaceCompleteOrderPOM.orderStatus("Complete");
		PlaceCompleteOrderPOM.addhistory();
		
		Thread.sleep(1000);
		
	}
	
	// login as user again and check whether the order is in complete status  //
	
	@Test(priority=2)
	public void validLoginTest2() throws InterruptedException, AWTException {
		
		// open the browser 
		driver.get("http://uniform.upskills.in/");
		
		
		PlaceCompleteOrderPOM.userIcon();
		PlaceCompleteOrderPOM.Login();
		PlaceCompleteOrderPOM.sendEmail("marurisravani82@gmail.com");
		PlaceCompleteOrderPOM.sendPassword("admin@123");
		PlaceCompleteOrderPOM.Login1();
		PlaceCompleteOrderPOM.myOrders();
		PlaceCompleteOrderPOM.viewIcon1();
		
		Thread.sleep(1000);
		
	}
}

		