package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.openqa.selenium.support.ui.Select;



import org.testng.Assert;

 

public class Order {

WebDriver driver;

public Order(WebDriver driver)

{

this.driver=driver;

}

@FindBy(how=How.XPATH, using="//nav[@id='column-left']/ul/li[5]") WebElement Sales_link;

@FindAll(@FindBy(how=How.XPATH, using="//nav[@id='column-left']/ul/li[5]/ul/li")) List<WebElement> Sales_list;

@FindBy(how=How.XPATH, using="//nav[@id='column-left']/ul/li[5]/ul/li[1]") WebElement Orders_link;

@FindBy(how=How.XPATH, using="//input[@name='filter_date_added']") WebElement Dateadded_textbox;

@FindBy(how=How.XPATH, using="//button[@id='button-filter']") WebElement Filter_button;

@FindBy(how=How.ID, using="input-order-status") WebElement OrderStatus_dropdown;

@FindAll(@FindBy(how=How.XPATH, using="//form[@id='form-order']/div/table/tbody/tr")) List<WebElement> Orders_list;

    public void getSalesList()

    {

      Sales_link.click();

      int size=Sales_list.size();

    for(int i=0;i<size;i++)

    {

    System.out.println(driver.findElement(By.xpath("//nav[@id='column-left']/ul/li[5]/ul/li["+i+"+1]/a")).getText());

    }  

    }

    

    public void selectOrderLink()

    {

       Orders_link.click();

       Assert.assertTrue(driver.getTitle().contains("Orders"));

    }

    

    public String getTitle()

    {

     return driver.getTitle();

    }

    

    public void searchOrders(String dateAdded)

    {

      

      Dateadded_textbox.sendKeys(dateAdded);

      Filter_button.click();

    int j=Orders_list.size();

    for(int k=0;k<j;k++)

    {

    System.out.println("Order ID:"+driver.findElement(By.xpath("//form[@id='form-order']/div/table/tbody/tr["+k+"+1]/td[2]")).getText()+" Date Added:"+driver.findElement(By.xpath("//form[@id='form-order']/div/table/tbody/tr["+k+"+1]/td[6]")).getText());

    } 

      

    }

    

    

    public void searchOrdersByOrderStatus(String status)

    {

     Select s=new Select(OrderStatus_dropdown);

     s.selectByVisibleText(status);

     Filter_button.click();

      int j=Orders_list.size();

      for(int k=0;k<j;k++)

      {

      System.out.println("Order ID:"+driver.findElement(By.xpath("//form[@id='form-order']/div/table/tbody/tr["+k+"+1]/td[2]")).getText()+" Date Added:"+driver.findElement(By.xpath("//form[@id='form-order']/div/table/tbody/tr["+k+"+1]/td[6]")).getText()+"Status:"+driver.findElement(By.xpath("//form[@id='form-order']/div/table/tbody/tr["+k+"+1]/td[4]")).getText());

      } 

    }

    

    public void closeDriver() {

    driver.close();

    }

}