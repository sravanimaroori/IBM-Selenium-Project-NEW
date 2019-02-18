package com.training.pom;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.sql.Driver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;

public class base {

	static WebDriver driver;

	public static WebDriver initiateDriver()

	{

		System.setProperty("webdriver.chrome.driver", "C:\\IBM_Selenium_CMD\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		return driver;

	}

	public static void login(WebDriver driver) {

		driver.get("http://uniform.upskills.in/admin/");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("admin");

		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("admin@123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}