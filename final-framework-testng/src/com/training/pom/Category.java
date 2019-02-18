package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.testng.annotations.BeforeMethod;

import org.testng.Assert;

public class Category {

	WebDriver driver;

	public Category(WebDriver driver)

	{

		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//nav[@id='column-left']/ul/li[2]")
	WebElement Catalog_link;

	@FindAll(@FindBy(how = How.XPATH, using = "//nav[@id='column-left']/ul/li[2]/ul/li"))
	List<WebElement> Catalog_list;

	@FindBy(how = How.XPATH, using = "//nav[@id='column-left']/ul/li[2]/ul/li[1]")
	WebElement Category_link;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-danger']")
	WebElement Delete_link;

	@FindAll(@FindBy(how = How.XPATH, using = "//form[@id='form-category']/div/table/tbody/tr"))
	List<WebElement> Category_list;

	public void getCatalogList()

	{

		Catalog_link.click();

		int size = Catalog_list.size();

		for (int i = 0; i < size; i++)

		{

			System.out.println(
					driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]/ul/li[" + i + "+1]/a")).getText());

		}

	}

	public void selectCategoryLink()

	{

		Category_link.click();

		Assert.assertTrue(driver.getTitle().contains("Categories"));

	}

	public String getTitle()

	{

		return driver.getTitle();

	}

	public void getCategoryList()

	{

		int size = Category_list.size();

		for (int i = 0; i < size; i++)

		{

			System.out.println(
					driver.findElement(By.xpath("//form[@id='form-category']/div/table/tbody/tr[" + i + "+1]/td[2]"))
							.getText());

		}

	}

	public void deleteCategory(String cat)

	{

		driver.findElement(By.xpath("//td[text()='" + cat + "']//preceding-sibling::td/input[@type='checkbox']"))
				.click();

		Delete_link.click();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText()
				.contains("Success: You have modified categories!"));

		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());

	}

	public void closeDriver() {

		driver.close();

	}

}
