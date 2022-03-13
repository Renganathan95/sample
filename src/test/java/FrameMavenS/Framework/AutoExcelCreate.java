package FrameMavenS.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

public class AutoExcelCreate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");

		WebElement skills = driver.findElement(By.id("Skills"));
		Select select = new Select(skills);

		List<WebElement> options = select.getOptions();

		File file = new File("C:\\Users\\Renganathan\\eclipse-workspace\\Framework\\File\\Test1.xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet();

		int i = 0;

		for (WebElement x : options) {
			String text = x.getText();
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(text);
			i++;
		}
		
		FileOutputStream out = new FileOutputStream(file);
		book.write(out);
	}

}