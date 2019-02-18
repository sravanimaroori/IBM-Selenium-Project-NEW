package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.training.pom.base;

import com.training.pom.Product;

 

public class UNF_013 extends base{

 

 @Test

 public void f() throws InterruptedException {

  WebDriver driver=base.initiateDriver();

  base.login(driver);

  Product pt;

  pt = PageFactory.initElements(driver, Product.class);

  System.out.println("Catalog list:");

  pt.getCatalogList();

  pt.selectProductLink();

  pt.getTitle();
  
  System.out.println("Products List:");

  pt.getProductsList();
  
  pt.searchProduct("Blazer Girls(7-8)");
  
  Thread.sleep(5000);

  pt.closeDriver();

 }

}

 