
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
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

public class BaseClass {
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

	public static void launch(String url) {
		driver.get(url);
	}

	public static WebElement locatorId(String attributename, String attributevalue) {
		if (attributename.equalsIgnoreCase("id")) {
			WebElement findElement = driver.findElement(By.id(attributevalue));
			return findElement;
		} else if (attributename.equalsIgnoreCase("name")) {
			WebElement findElement = driver.findElement(By.name(attributevalue));
			return findElement;
		} else if (attributename.equalsIgnoreCase("xpath")) {
			WebElement findElement = driver.findElement(By.xpath(attributevalue));
			return findElement;
		} else {
			WebElement findElement = driver.findElement(By.tagName(attributevalue));
			return findElement;
		}
	}

	public static void sendtext(WebElement findelement, String keysToSend) {
		findelement.sendKeys(keysToSend);
	}

 	public static void button(WebElement findelement) {
		findelement.click();
	}

	public static void screenshot(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;

		File source = tk.getScreenshotAs(OutputType.FILE);

		File desn = new File("C:\\Users\\VISHALI\\OneDrive\\Desktop\\karthi\\" + name + ".png");

		FileUtils.copyFile(source, desn);
		String string = source.toString();

		System.out.println(string);
	}

	public static void selectby(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static void selectby(WebElement element, String select, String value) {
		Select s = new Select(element);

		if (select.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		} else if (select.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		}
	}

	public static String getfile(int rowdata, int celldata, String sheetname) throws IOException {
		File f = new File("C:\\Users\\VISHALI\\OneDrive\\Desktop\\karthi.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowdata);
		Cell cell = row.getCell(celldata);
		String stringCellValue = cell.getStringCellValue();
		return stringCellValue;
	}

	public static void WriteData(int rownum, int cellnum, String sheetname) throws IOException {
		File f = new File("C:\\Users\\VISHALI\\OneDrive\\Desktop\\karthi.xlsx");
		// FileInputStream stream = new FileInputStream(f);
		Workbook book1 = new XSSFWorkbook();
		Sheet createSheet = book1.createSheet();
		Row createRow = createSheet.createRow(rownum);
		Cell createCell = createRow.createCell(cellnum);
		createCell.setCellValue(sheetname);
		FileOutputStream stream1 = new FileOutputStream(f);
		book1.write(stream1);
	}
}
