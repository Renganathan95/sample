package FrameMavenS.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();

		WebElement lstSkills = driver.findElement(By.id("//option[text()='Select Skills']"));
		
		Select select = new Select(lstSkills);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();

		for (WebElement element : allSelectedOptions) {
			String text = element.getText();
			System.out.println(text);

		}

	}
}