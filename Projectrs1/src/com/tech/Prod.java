package com.tech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Prod {
	
	@Test 
	//public static void main (String[]args)
	public  void setUp (){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// String url = "http://uk.rs-online.com";
		String baseUrl = "http://uk.rs-online.com";
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
       
		
		String expectedTitle = "RS Components | Electronic and Electrical Components";
		String actualTitle = "";
		
		actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)){
			System.out.println("passed");
		}
		else {System.out.println("fail");
		}
		
		//2 x – End to End Tests – Homepage to checkout (do not purchase)  All Products
		
		WebElement allproductLink = driver.findElement(By.linkText("All Products"));
		allproductLink.click();
		
		WebElement batteryLink = driver.findElement(By.linkText("Batteries"));
		batteryLink.click();
		
		WebElement batteryHydrometerLink = driver.findElement(By.linkText("Battery Hydrometers"));
		batteryHydrometerLink.click();
		
		WebElement addHydrometerButton = driver.findElement(By.xpath("//*/div[2]/div/div/div[2]/div[3]/span"));
		addHydrometerButton.click();
		
		WebElement basketLink = driver.findElement(By.id("js-basketAmt"));
		basketLink.click();
		
		
		
		//Then verify the order and the item in the basket

		String basketAmountText = driver.findElement(By.xpath("//*[@id='js-basketAmt']")).getText();
		
		Assert.assertTrue(basketAmountText.contains("£20.32"));
		
		System.out.println("Amount of product" +basketAmountText); 
		
		
		// Switching to Alert        //*[@id="js-basketAmt"]
       // Alert alert = driver.switchTo().alert();		
        // Accepting alert		
       // alert.dismiss();
		//  //*[@id="PDO0021aboveFold"]/div[2]/div/div/div[2]/div[3]/span
		//Select ddpAllProduct = new Select(driver.findElement(By.cssSelector(".menu.product-menu")));
		//  js-basketAmt
	
	}

}
