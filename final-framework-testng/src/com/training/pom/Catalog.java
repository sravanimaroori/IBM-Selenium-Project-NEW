package com.training.pom;

import org.testng.annotations.Test;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.AfterTest;

public class Catalog {

	WebDriver driver;

	@Test(priority = 1)

	public void UNF_011() {

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]")).click();

		List<WebElement> categories = driver.findElements(By.xpath("//nav[@id='column-left']/ul/li[2]/ul/li"));

		int size = categories.size();

		for (int i = 0; i < size; i++)

		{

			System.out.println(
					driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]/ul/li[" + i + "+1]/a")).getText());

		}

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]")).click();

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]/ul/li[1]")).click();

		Assert.assertEquals("Categories page is displayed", "Categories", driver.getTitle());

	}

	@Test(priority = 2)

	public void UNF_012() throws InterruptedException {

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]")).click();

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]/ul/li[1]")).click();

		Assert.assertEquals("Categories page is displayed", "Categories", driver.getTitle());

		driver.findElement(By.xpath("//td[text()='New Uniforms1']//preceding-sibling::td/input[@type='checkbox']"))
				.click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

		// System.out.println(driver.findElement(By.xpath("//div[@class='alert
		// alert-success']/i")).getText());

		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());

	}

	@Test(priority = 3)

	public void UNF_013() throws InterruptedException {

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]")).click();

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]/ul/li[2]")).click();

		Assert.assertEquals("Products page is displayed", "Products", driver.getTitle());

		driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys("Blazer-Boys");

		driver.findElement(By.xpath("//button[@id='button-filter']")).click();

		List<WebElement> products = driver.findElements(By.xpath("//form[@id='form-product']/div/table/tbody/tr"));

		int j = products.size();

		for (int k = 0; k < j; k++)

		{

			System.out.println(
					driver.findElement(By.xpath("//form[@id='form-product']/div/table/tbody/tr[" + k + "+1]/td[3]"))
							.getText());

		}

	}

	@Test(priority = 4)

	public void UNF_014() throws InterruptedException {

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]")).click();

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]/ul/li[2]")).click();

		Assert.assertEquals("Products page is displayed", "Products", driver.getTitle());

		driver.findElement(By.xpath("//td[text()='Blazer-Boys']//preceding-sibling::td/input[@type='checkbox']"))
				.click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

// System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']/i")).getText());

		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());

	}

	@Test(priority = 5)

	public void UNF_015() throws InterruptedException {

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[5]")).click();

		driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[5]/ul/li[1]")).click();

		Assert.assertEquals("Orders page is displayed", "Orders", driver.getTitle());

		driver.findElement(By.xpath("//input[@name='filter_date_added']")).sendKeys("2019-02-12");

		driver.findElement(By.xpath("//button[@id='button-filter']")).click();

		List<WebElement> orders = driver.findElements(By.xpath("//form[@id='form-order']/div/table/tbody/tr"));

		int j = orders.size();

		for (int k = 0; k < j; k++)

		{

			System.out.println("Order ID:"
					+ driver.findElement(By.xpath("//form[@id='form-order']/div/table/tbody/tr[" + k + "+1]/td[2]"))
							.getText()
					+ " Date Added:"
					+ driver.findElement(By.xpath("//form[@id='form-order']/div/table/tbody/tr[" + k + "+1]/td[6]"))
							.getText());

		}

	}

	@BeforeMethod

	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://uniform.upskills.in/admin/");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("admin");

		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("admin@123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@AfterMethod

	public void afterMethod() {

		driver.close();

	}

}
