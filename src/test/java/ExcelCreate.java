import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCreate {
	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\VISHALI\\OneDrive\\Desktop\\karthi\\keyan.xlsx");
		
		Workbook book = new XSSFWorkbook();
		
		Sheet createSheet = book.createSheet("arthi");
		
		Row createRow = createSheet.createRow(4);
		
		Cell createCell = createRow.createCell(0);
		
		createCell.setCellValue("kk");
		
		FileOutputStream out = new FileOutputStream(f);
		
		book.write(out);
	}

}
