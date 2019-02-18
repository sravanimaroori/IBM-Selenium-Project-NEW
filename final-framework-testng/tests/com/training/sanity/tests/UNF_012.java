package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.training.pom.base;

import com.training.pom.Category;

 

public class UNF_012 extends base{

@Test

 public void f() throws InterruptedException {

  WebDriver driver=base.initiateDriver();

  base.login(driver);

  Category cg;

  cg = PageFactory.initElements(driver, Category.class);

  System.out.println("Catalog list:");

  cg.getCatalogList();

  cg.selectCategoryLink();

  cg.getTitle();

  System.out.println("Before deleting category");

  cg.getCategoryList();

  cg.deleteCategory("New School Uniforms Test");
 
  Thread.sleep(5000);
  
  System.out.println("After deleting category");

  cg.getCategoryList();

  cg.closeDriver();

 }

}

 