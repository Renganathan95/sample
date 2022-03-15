package FrameMavenS.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	 WebDriver driver;


	public void browserConfigChrome() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public void OpenUrl(String url) {
		driver.get(url);

	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public WebElement locatedById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public WebElement locatedByname(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	public WebElement locatedByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	public WebElement locatedByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public WebElement locatedByTagName(String tagName) {
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}

	public WebElement locatedByLinkText(String linkText) {
		WebElement element = driver.findElement(By.linkText(linkText));
		return element;
	}

	public WebElement locatedByPartialLinkText(String partialLinkText) {
		WebElement element = driver.findElement(By.partialLinkText(partialLinkText));
		return element;
	}

	public WebElement locatedByCssSelector(String cssSelector) {
		WebElement element = driver.findElement(By.cssSelector(cssSelector));
		return element;
	}

	public void textInput(WebElement element, String inputData) {
		element.sendKeys(inputData);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void OpenUrlNavigate(String url) {
		driver.navigate().to(url);
	}

	public void back() {
		driver.navigate().back();
	}

	public void forward() {
		driver.navigate().forward();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void sleep(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}

	public String getText(WebElement element) {

		String data = element.getText();
		return data;

	}

	public void printGetText(String data) {
		System.out.println(data);
	}

	public String getAttribute(WebElement element) {

		String data = element.getAttribute("value");
		return data;

	}

	public void MouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void DragAndDrop(WebElement element) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element).perform();
	}

	public void RightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void DoubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void simpleAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void ConfirmAlert() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public void PromptAlert(String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(text);
		al.dismiss();
	}

	public void Screenshot(String FILE, String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File(path);
		FileUtils.copyFile(s, d);
	}

	public void javaScriptESetAttribute(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arugument[0].setAttribute('value',text)", element);

	}

	public void javaScriptEGetAttribute(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object name = executor.executeScript("arugument[0].setAttribute('value',text)", element);
		System.out.println(name);

	}

	public void javaScriptEClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arugument[0].click()", element);
	}

	public void javaScriptEScrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arugument[0].scrollIntoView(true)", element);
	}

	public void javaScriptEScrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arugument[0].scrollIntoView(false)", element);
	}

	@SuppressWarnings("deprecation")
	public void implicitWait(int time, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time, unit);
	}

	@SuppressWarnings("deprecation")
	public void explicitWait(int num, String id) {
		WebDriverWait w = new WebDriverWait(driver, num);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
	}

	public void ddnByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void ddnByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void ddnByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void ddnGetOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
	}

	public void ddnGetAllSelectedOption(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
	}

	public void ddnGetFirstSelectedOption(WebElement element, String text) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
	}

	public void ddnIsMultiple(WebElement element, String text) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		System.out.println(multiple);
	}

	public void ddnDeselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void ddnDeselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	public void ddnDeselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public void ddnDeselectAll(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void frameSwitchId(String framename) {
		driver.switchTo().frame(framename);

	}

	public void frameSwitchElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);

	}

	public void frameSwitchIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void frameSwitchParent() {
		driver.switchTo().parentFrame();
	}

	public void frameSwitchDefault() {
		driver.switchTo().defaultContent();
	}

	public String getData(String SheetName, int rowIndex, int cellIndex) throws IOException {

		File F = new File("C:\\Users\\Renganathan\\eclipse-workspace\\BaseClaseSession\\File\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(F);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(SheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		return SheetName;

	}

	public String updateData(String SheetName, int rowIndex, int cellIndex, String data1, String data2)
			throws IOException {

		File F = new File("C:\\Users\\Renganathan\\eclipse-workspace\\BaseClaseSession\\File\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(F);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(SheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		String data = cell.getStringCellValue();
		if (data.equals(data1)) {
			cell.setCellValue(data2);
		}
		FileOutputStream out = new FileOutputStream(F);
		w.write(out);
		return data;

	}

	public String writeData(String SheetName, int rowIndex, int cellIndex, String data) throws IOException {

		File F = new File("C:\\Users\\Renganathan\\eclipse-workspace\\BaseClaseSession\\File\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(F);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(SheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.createCell(cellIndex);
		cell.setAsActiveCell();
		FileOutputStream out = new FileOutputStream(F);
		w.write(out);
		return data;
	}

	public String insertNewValue(String SheetName, int rowIndex, int cellIndex, String data) throws IOException {

		File F = new File("C:\\Users\\Renganathan\\eclipse-workspace\\BaseClaseSession\\File\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(F);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(SheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.createCell(cellIndex);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(F);
		w.write(out);
		return null;
	}

	public String readNewData(String sheetname, int rowno, int cellno) throws IOException {

		File file = new File("C:\\Users\\Renganathan\\eclipse-workspace\\BaseClaseSession\\File\\Hotel.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.getRow(rowno);

		Cell cell = row.getCell(cellno);

		CellType type = cell.getCellType();

		String res = null;
		switch (type) {
		case STRING:

			res = cell.getStringCellValue();
			System.out.println(res);
			break;

		case NUMERIC:
			double d = cell.getNumericCellValue();
			BigDecimal b = BigDecimal.valueOf(d);
			res = b.toString();
			System.out.println(res);
			break;

		default:
			break;
		}

		return res;
	}
	

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public String getData(WebElement orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
