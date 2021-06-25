package com.Launch;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
public class assmntcls {
	WebDriver driver;
  @Test(dataProvider = "GivenData")
  public void assignmnt(String n, String s,String t,String q) throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 // driver.findElement(By.id("tabButton")).click(); //new tab
	  //driver.findElement(By.id("windowButton")).click(); //new window
	  //driver.findElement(By.id("messageWindowButton")).click(); //new msg wind btn
	  driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]")).click();
	  driver.findElement(By.id("item-0")).click();
	  driver.findElement(By.id("userName")).sendKeys(n);
	  driver.findElement(By.id("userEmail")).sendKeys(s);
	  driver.findElement(By.id("currentAddress")).sendKeys(t);
	  driver.findElement(By.id("permanentAddress")).sendKeys(q);
	  Thread.sleep(3000);
	  //driver.findElement(By.xpath("//button[@id='submit']")).click();
	  driver.findElement(By.id("item-1")).click();
	  WebElement wb = driver.findElement(By.className("rct-checkbox")); 
		
	 // String l,String f,String em,String i,String sal,String dept
		if(wb.isDisplayed() && wb.isEnabled() && wb.isSelected() == false)
		{
			wb.click();
		}
		
		driver.findElement(By.id("item-2")).click();
		WebElement radio1 = driver.findElement(By.xpath("//label[contains(text(),'Yes')]"));
		radio1.click();
		driver.findElement(By.id("item-0")).click();
		driver.findElement(By.id("addNewRecordButton")).click();
		//driver.findElement(By.id("firstName")).sendKeys(l);
		//driver.findElement(By.id("lastName")).sendKeys(f);
		//driver.findElement(By.id("userEmail")).sendKeys(em);
		//driver.findElement(By.id("age")).sendKeys(i);
		//driver.findElement(By.id("salary")).sendKeys(sal);
		//driver.findElement(By.id("department")).sendKeys(dept);
		//driver.findElement(By.className("btn btn-primary")).click();
  }
  		

  @DataProvider
  public Object [] [] GivenData() 
  {
	  Object [] [] data = new Object[1] [4];
	  data[0][0]="Samruddhi Shukla";
	  data[0][1]="samruddhishukla@gmail.com";
	  data[0][2]="flat no.9,sunjyot society,shrinagar,pune";
	  data[0][3]="flat no.7,sunjyot society,shrinagar,nashik";
	  //data[0][4]="Nilam";
	  //data[0][5]="Singh";
	  //data[0][6]="prajakta.shukla@gmail.com";
	  //data[0][7]="19";
	  //data[0][8]="12000";
	  //data[0][9]="Electronics and Telecommunication";
	  return data;
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\College\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://demoqa.com/browser-windows");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
