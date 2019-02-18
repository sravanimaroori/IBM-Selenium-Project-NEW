package com.training.sanity.tests;

 

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.training.pom.base;

import com.training.pom.Order;

 

public class UNF_015 extends base {

  @Test

  public void f() throws InterruptedException {

 

 WebDriver driver=base.initiateDriver();

  base.login(driver);

  Order or;

  or = PageFactory.initElements(driver, Order.class);

  System.out.println("Sales list:");

  or.getSalesList();

  or.selectOrderLink();

  or.getTitle();
  
  or.searchOrders("2019-02-12");
  
  or.searchOrdersByOrderStatus("Pending");
  
  Thread.sleep(5000);
  
  or.closeDriver();

  }

}

 