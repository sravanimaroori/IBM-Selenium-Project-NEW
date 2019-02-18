package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.testng.Assert;

 

public class Product {

WebDriver driver;

public Product(WebDriver driver)

{

this.driver=driver;

}

@FindBy(how=How.XPATH, using="//nav[@id='column-left']/ul/li[2]") WebElement Catalog_link;

@FindAll(@FindBy(how=How.XPATH, using="//nav[@id='column-left']/ul/li[2]/ul/li")) List<WebElement> Catalog_list;

@FindBy(how=How.XPATH, using="//nav[@id='column-left']/ul/li[2]/ul/li[2]") WebElement Product_link;

@FindBy(how=How.XPATH, using="//input[@placeholder='Product Name']") WebElement ProductName_textbox;

@FindBy(how=How.XPATH, using="//button[@id='button-filter']") WebElement Filter_button;

@FindAll(@FindBy(how=How.XPATH, using="//form[@id='form-product']/div/table/tbody/tr")) List<WebElement> Products_list;

@FindBy(how=How.XPATH, using="//button[@class='btn btn-danger']") WebElement Delete_link;

    public void getCatalogList()

    {

      Catalog_link.click();

      int size=Catalog_list.size();

    for(int i=0;i<size;i++)

    {

    System.out.println(driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[2]/ul/li["+i+"+1]/a")).getText());

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

      int j=Products_list.size();

    for(int k=0;k<j;k++)

    {

    System.out.println(driver.findElement(By.xpath("//form[@id='form-product']/div/table/tbody/tr["+k+"+1]/td[3]")).getText());

    } 

    }

    

    public void searchProduct(String productName)

    {

     ProductName_textbox.sendKeys(productName);

     Filter_button.click();

    

    }

    public void deleteProduct(String cat)

    {

     driver.findElement(By.xpath("//td[text()='"+cat+"']//preceding-sibling::td/input[@type='checkbox']")).click();

     Delete_link.click();

     Alert alert=driver.switchTo().alert();

      System.out.println(alert.getText());

      alert.accept();

      Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText().contains("Success: You have modified products!"));

      System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());

    }

    

    public void closeDriver() {

    driver.close();

    }

 

}