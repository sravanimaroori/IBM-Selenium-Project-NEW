package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class UNF_071 {
	WebDriver driver;

	@Test(priority = 0)
	public void InvokeApplication() {
		System.setProperty("webdriver.chrome.driver", "C:\\IBM_Selenium_CMD\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://uniform.upskills.in/admin/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void LoginIntoAdmin() {
		driver.findElement(By.id("input-username")).sendKeys("admin");
		driver.findElement(By.id("input-password")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test(priority = 2)
	public void ValidateCatalogAndProductSections() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='button-menu']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Catalog')]")).click();
		Thread.sleep(2000);
		WebElement Categories = driver.findElement(By.xpath("//a[contains(text(),'Categories')]"));
		Assert.assertTrue(Categories.isDisplayed());
		WebElement Products = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
		Assert.assertTrue(Products.isDisplayed());

		WebElement RecurringProfiles = driver.findElement(By.xpath("//a[contains(text(),'Recurring Profiles')]"));
		Assert.assertTrue(RecurringProfiles.isDisplayed());
		Products.click();
		if (driver.findElement(By.xpath("//h3[@class='panel-title']")).isDisplayed()) {
			System.out.println("Product list with product details is displayed.");
		} else {
			System.out.println("Product list with product details is not displayed.");
		}

	}

	@Test(priority = 3)
	public void AddNewProduct() throws InterruptedException, IOException {
		File file = new File("C:\\Users\\IBM_ADMIN\\Desktop\\UniformTestcase\\TestData.xlsx");
		FileInputStream input = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheet("TestData");
		int rowsCount = sheet.getFirstRowNum() - sheet.getLastRowNum();
		System.out.println("Total Rows --> " + rowsCount);
		Thread.sleep(2000);
		for (int i = 1; i <= 4; i++) {
			Row row = sheet.getRow(i);
			DataFormatter formatter = new DataFormatter();

			String ProductName = row.getCell(2).getStringCellValue();
			String MetaTitle = row.getCell(3).getStringCellValue();
			String Model = row.getCell(4).getStringCellValue();
			String Price = formatter.formatCellValue(row.getCell(5));
			String Category = row.getCell(6).getStringCellValue();
			String Quantity = formatter.formatCellValue(row.getCell(7));
			String Price1 = formatter.formatCellValue(row.getCell(8));
			String Points = formatter.formatCellValue(row.getCell(9));

			driver.findElement(By.xpath("//div[@class='pull-right']//a[@class='btn btn-primary']")).click();
			if (driver.findElement(By.xpath("//h3[@class='panel-title']")).isDisplayed()) {
				System.out.println("User navigated to Add Product page.");
			} else {
				System.out.println("User npt navigated to Add Product page.");
			}

			// General Tab
			driver.findElement(By.name("product_description[1][name]")).sendKeys(ProductName);
			driver.findElement(By.xpath("//input[@placeholder='Meta Tag Title']")).sendKeys(MetaTitle);

			// Data Tab
			driver.findElement(By.xpath("//a[contains(text(),'Data')]")).click();
			driver.findElement(By.xpath("//input[@id='input-model']")).sendKeys(Model);
			driver.findElement(By.xpath("//input[@id='input-price']")).sendKeys(Price);
			driver.findElement(By.xpath("//input[@id='input-minimum']")).sendKeys("4");

			// Links Tab
			driver.findElement(By.xpath("//a[contains(text(),'Links')]")).click();
			driver.findElement(By.xpath("//input[@id='input-category']")).click();
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//div[@class='panel-body']//div[2]//div[1]//ul[1]")).isDisplayed()) {
				System.out.println("Categories list is displayed.");
			} else {
				System.out.println("Categories list is not displayed.");
			}
			/*driver.findElement(By.xpath("//input[@id='input-category']")).sendKeys(Category);
			WebElement Sports = driver.findElement(By.xpath("//a[contains(text(),'Sports Uniform')]"));
			Actions a = new Actions(driver);
			a.moveToElement(Sports).build().perform();
			a.click(Sports).build().perform();
			if (driver.findElement(By.xpath("//*[text()=' Sports Uniform']")).isDisplayed()) {
				System.out.println("Sports Uniform category is added in Categories section");
			} else {
				System.out.println("Sports Uniform category is not added in Categories section");
			}*/
            
			// Discount Tab
			driver.findElement(By.xpath("//a[contains(text(),'Discount')]")).click();
			driver.findElement(By.xpath("//table[@id='discount']//button[@type='button']")).click();
			if (driver.findElement(By.xpath("//button[@title='Remove']")).isDisplayed()) {
				System.out.println("Add Discount fields are displayed.");
			} else {
				System.out.println("Add Discount fields are not displayed.");
			}

			driver.findElement(By.xpath("//td[@class='text-right']//input[@placeholder='Quantity']")).sendKeys(Quantity);
			driver.findElement(By.xpath("//td[@class='text-right']//input[@placeholder='Price']")).sendKeys(Price1);
			driver.findElement(By.xpath("//input[@placeholder='Date Start']")).sendKeys("2019-03-03");
			driver.findElement(By.xpath("//input[@placeholder='Date End']")).sendKeys("2019-03-04");
			Thread.sleep(1000);
			
			// Reward points Tab
			driver.findElement(By.xpath("//a[@href='#tab-reward']")).click();
			driver.findElement(By.xpath("//input[@id='input-points']")).sendKeys(Points);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			String SuccessMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			System.out.println("Success Message: " + SuccessMessage);
			String ExpectedSuccessMessage = "Success: You have modified products!";
			if (SuccessMessage.contains(ExpectedSuccessMessage)) {
				System.out.println("Success: You have modified products! Message is displayed in Product List page");
			} else {
				System.out
						.println("Success: You have modified products! Message is not displayed in Product List page");
			}

		}

	}

	@AfterClass
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
