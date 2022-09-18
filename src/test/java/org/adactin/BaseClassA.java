package org.adactin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassA {

	public static WebDriver driver;

	public static void driver(String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static WebElement locatorId(String attributename, String attributevalue) {
		if (attributename.equalsIgnoreCase("id")) {
			WebElement findElement = driver.findElement(By.id(attributevalue));
			return findElement;
		} else if (attributename.equalsIgnoreCase("name")) {
			WebElement findElement = driver.findElement(By.name(attributename));
			return findElement;
		} else if (attributename.equalsIgnoreCase("xpath")) {
			WebElement findElement = driver.findElement(By.xpath(attributevalue));
			return findElement;
		} else {
			WebElement findElement = driver.findElement(By.tagName(attributevalue));
			return findElement;
		}
	}

	public static void sendText(WebElement findElement, String keysToSend) {
		findElement.sendKeys(keysToSend);

	}

	public static void btnClick(WebElement finElement) {
		finElement.click();

	}
public static void screenShot(String name) throws IOException {
	TakesScreenshot tk = (TakesScreenshot) driver;
	File source = tk.getScreenshotAs(OutputType.FILE);
	File dest = new File ("C:\\Users\\VISHALI\\OneDrive\\Desktop\\karthi\\" + name + ".png");
	FileUtils.copyFile(source, dest);
	String string = source.toString();
	System.out.println(string);
}
public static void selectByIndex(WebElement element,int index) {
	Select s = new Select (element);
	s.selectByIndex(index);
}
public static void selectByText (WebElement element, String text) {
	Select s = new Select (element);
	s.selectByVisibleText(text);
}
public static void selectByValue (WebElement element , String value) {
	Select s = new Select (element);
	s.selectByValue(value);
}
public static void clear(WebElement element) {
	element.clear();
}
public static void waitelement (long time) throws InterruptedException {
	Thread.sleep(time);
}
public static String getExcelDatas(int row, int cell,String sheetname) throws IOException {
	File f = new File("C:\\Users\\VISHALI\\OneDrive\\Desktop\\karthi.xlsx");
	FileInputStream stream = new FileInputStream(f);
	Workbook book = new XSSFWorkbook(stream);
	Sheet sheet = book.getSheet(sheetname);
	Row row2 = sheet.getRow(row);
	Cell cell2 = row2.getCell(cell);
	CellType cellType = cell2.getCellType();
	
	String value= "";
	 switch (cellType) {
	case STRING:
		value = cell2.getStringCellValue();
		System.out.println(value);
		break;
		
	case NUMERIC:
	if (DateUtil.isCellDateFormatted(cell2)) {
		Date dateCellValue = cell2.getDateCellValue();
		SimpleDateFormat simple = new SimpleDateFormat();
		value= simple.format(dateCellValue);
		System.out.println(value);
	}else {
		double numericCellValue = cell2.getNumericCellValue();
		long l = (long)numericCellValue;
		BigDecimal valueOf = BigDecimal.valueOf(l);
		value = valueOf.toString();
		System.out.println(value);
	}

	default:
		System.out.println();
		break;
	}
	return value;
	
}




}
