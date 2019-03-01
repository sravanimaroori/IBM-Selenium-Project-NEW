package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.training.pom.base;
import com.training.pom.UNF_041POM;

 
public class UNF_041 extends base{

	 private UNF_041POM unf_041POM; 
	 
@Test

 public void f() throws InterruptedException {

  WebDriver driver=base.initiateDriver();

  // login as admin in base.java POM File
  base.login(driver);
  
  unf_041POM = PageFactory.initElements(driver, UNF_041POM.class);
  
  System.out.println("Catalog list:");

  // go to menu options
  unf_041POM.getCatalogList();
  unf_041POM.selectProductLink();
  unf_041POM.getTitle();
  
  System.out.println("Products List:");

  //filtering the product by entering each text field
  unf_041POM.getProductsList();
  unf_041POM.setProductName("Full");
  unf_041POM.clickFilter();
  
  Thread.sleep(1000);
  
  unf_041POM.setPrice("995");
  unf_041POM.clickFilter();
  
  Thread.sleep(1000);
  
  unf_041POM.setStatus("Enabled");
  unf_041POM.clickFilter();
  
  Thread.sleep(1000);
  
  unf_041POM.setModel("TBS");
  unf_041POM.clickFilter();
  
  Thread.sleep(1000);
  
  unf_041POM.setQuantity("50");
  unf_041POM.clickFilter();
  
  Thread.sleep(2000);

  unf_041POM.closeDriver();
  
}


}
