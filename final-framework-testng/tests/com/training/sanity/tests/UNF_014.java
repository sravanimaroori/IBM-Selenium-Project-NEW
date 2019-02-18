package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.training.pom.base;

import com.training.pom.Product;

 

public class UNF_014 extends base{

 

 @Test

 public void f() {

  WebDriver driver=base.initiateDriver();

  base.login(driver);

  Product pt;

  pt = PageFactory.initElements(driver, Product.class);

  System.out.println("Catalog list:");

  pt.getCatalogList();

  pt.selectProductLink();

  pt.getTitle();

  System.out.println("Before deleting Product:");

  pt.getProductsList();

  pt.deleteProduct("Blazer-BoysNew");

  System.out.println("After deleting Product:");

  pt.getProductsList();

  pt.closeDriver();

 }

}