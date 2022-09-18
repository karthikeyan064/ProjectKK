import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel10unpass2 {
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i <4 ; i++) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			
			File karthi = new File("C:\\Users\\VISHALI\\OneDrive\\Desktop\\karthi\\kk.xlsx");
			FileInputStream stream = new FileInputStream(karthi);
			Workbook book = new XSSFWorkbook(stream);
			Sheet sheet = book.getSheet("kn");
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			String stringCellValue = cell.getStringCellValue();
			WebElement name = driver.findElement(By.id("email"));
			name.sendKeys(stringCellValue);
			
			File karthi1 = new File("C:\\Users\\VISHALI\\OneDrive\\Desktop\\karthi\\kk.xlsx");
			FileInputStream stream1 = new FileInputStream(karthi1);
			Workbook book1 = new XSSFWorkbook(stream1);
			Sheet sheet1 = book1.getSheet("kn");
			Row row1 = sheet1.getRow(i);
			Cell cell1 = row1.getCell(1);
			String stringCellValue1 = cell1.getStringCellValue();
			WebElement pass = driver.findElement(By.id("pass"));
			pass.sendKeys(stringCellValue1,Keys.ENTER);
			
			
			
		}
	}

}
