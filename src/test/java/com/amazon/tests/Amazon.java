package com.amazon.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
static WebDriver driver;
static long startTime; 
static String oldPower;
	@BeforeClass
	public static void launch() {
		WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	@AfterClass
	public static void quit() {
	driver.quit();	
	}
	
    @Before
    public void startTime() {
    	long startTime = System.currentTimeMillis();
    }
    
    @After
    public void endTime() {
    	long endTime = System.currentTimeMillis();
    	long time = endTime - startTime;
    	System.out.println("The Time Taken is " +time);
    	
    }
    
    @Test

    public void test1() throws InterruptedException {
    	Thread.sleep(3000);
    	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    	searchBox.click();
    	searchBox.sendKeys("powerbank",Keys.ENTER);
    	
    }
    
    @Test
    public void test2() {
    WebElement powerBank = driver.findElement(By.xpath("(//span[contains(text(),'Ambrane 27000mAh')])[3]"));
   String oldPower = powerBank.getText();
   System.out.println(oldPower);
    powerBank.click();
    
    }
    @Test
    public void test3() {
    String parentWindow = driver.getWindowHandle();
    Set<String> childWindow = driver.getWindowHandles();
    for (String newWindow : childWindow) {
		if(!newWindow.equals(parentWindow)) {
			driver.switchTo().window(newWindow);
		}
		}
    }
    @Test
    public void test4() {
    	WebElement newPowerBank = driver.findElement(By.xpath("(//span[contains(text(), 'Ambrane 27000mAh')])[1]"));
    	String newPower = newPowerBank.getText();
    	System.out.println(newPower);
  Assert.assertTrue(newPower.equals(oldPower));
    }
	@Test
	public void test5() throws InterruptedException {
		Thread.sleep(5000);
		WebElement buyNow = driver.findElement(By.id("buy-now-button"));
		buyNow.click();
	}
		
		
		
    	
		
		
		
		
		
		
		
		
		
		
		
	
    }
    


