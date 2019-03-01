package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class UNF_041POM {
	private WebDriver driver; 
	
	public UNF_041POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='column-left']/ul/li[2]")
	private WebElement Catalog_link;

	@FindAll(@FindBy(how = How.XPATH, using = "//nav[@id='column-left']/ul/li[2]/ul/li"))
	private List<WebElement> Catalog_list;

	@FindBy(how = How.XPATH, using = "//nav[@id='column-left']/ul/li[2]/ul/li[2]")
	private WebElement Product_link;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Product Name']")
	private WebElement ProductName_textbox;

	@FindBy(how = How.ID, using = "input-price")
	private WebElement Price_textbox;

	@FindBy(how = How.ID, using = "input-status")
	private WebElement Status_dropdown;

	@FindBy(how = How.ID, using = "input-model")
	private WebElement Model_textbox;

	@FindBy(how = How.ID, using = "input-quantity")
	private WebElement Quantity_textbox;

	@FindBy(how = How.XPATH, using = "//button[@id='button-filter']")
	private WebElement Filter_button;

	@FindAll(@FindBy(how = How.XPATH, using = "//form[@id='form-product']/div/table/tbody/tr"))
	private List<WebElement> Products_list;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-danger']")
	private WebElement Delete_link;

    @FindBy(how = How.XPATH, using = "//div[@class='col-sm-10']//input[@id='input-category']")
	private WebElement Category;

	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-10']//input[@id='input-category']//ul//li//a")
	private WebElement Category1;



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

	public void selectProductLink()

	{

		Product_link.click();

		Assert.assertTrue(driver.getTitle().contains("Products"));

	}

	public String getTitle()

	{

		return driver.getTitle();

	}

	public void getProductsList()

	{

		int j = Products_list.size();

		for (int k = 0; k < j; k++)

		{

			System.out.println(
					driver.findElement(By.xpath("//form[@id='form-product']/div/table/tbody/tr[" + k + "+1]/td[3]"))
							.getText());

		}

	}

	public void setProductName(String productName)

	{

		ProductName_textbox.clear();

		ProductName_textbox.sendKeys(productName);

	}

	public void setPrice(String price)

	{

		Price_textbox.clear();

		Price_textbox.sendKeys(price);

	}

	public void setStatus(String status)

	{

		Select s = new Select(Status_dropdown);

		s.selectByVisibleText(status);

	}

	public void clickFilter()

	{

		Filter_button.click();

	}

	public void setModel(String model)

	{

		Model_textbox.clear();

		Model_textbox.sendKeys(model);

	}

	public void setQuantity(String quantity)

	{

		Quantity_textbox.clear();

		Quantity_textbox.sendKeys(quantity);

	}

	public void deleteProduct(String cat)

	{

		driver.findElement(By.xpath("//td[text()='"+cat+"']//preceding-sibling::td/input[@type='checkbox']")).click();

		Delete_link.click();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText()
				.contains("Success: You have modified products!"));

		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());

	}


	public void closeDriver() {

		driver.close();

	}

}