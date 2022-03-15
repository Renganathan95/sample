package FrameMavenS.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {

		File F = new File("C:\\Users\\Renganathan\\eclipse-workspace\\BaseClaseSession\\File\\Hotel.xlsx");
		FileInputStream fis = new FileInputStream("D:\\Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		System.out.println("Conflict- Raj");

		
		
	}
}
