package FrameMavenS.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FbTestMaven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		WebElement txtusername = driver.findElement(By.xpath("//input[@id='email']"));
		txtusername.sendKeys("Renga");

		WebElement txtpassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		txtpassword.sendKeys("xxxxxx");

		WebElement btnlogin = driver.findElement(By.xpath("//button[@type='submit']"));
		btnlogin.click();

		driver.close();
		txtpassword.sendKeys("xxxxxx");

	}
}
