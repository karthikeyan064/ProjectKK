import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static void main(String[] args) throws IOException {
		File file = new File ("C:\\Users\\VISHALI\\OneDrive\\Desktop\\excel for eg.xlsx");
		
		 FileInputStream stream = new FileInputStream(file);
		 
		 Workbook book = new XSSFWorkbook(stream);
		 
	    Sheet sheet = book.getSheet("kk");
	    
	    //Row row = sheet.getRow(2);
	    //Cell cell = row.getCell(0);
	    //double numericCellValue = cell.getNumericCellValue();
	    //System.out.println(numericCellValue);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
			switch (cellType) {
			case STRING:
				String stringCellValue = cell.getStringCellValue();
				System.out.print(stringCellValue+ " ");
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd/MMMM/yyyy");
					String format = s.format(dateCellValue);
					System.out.println(format);
					
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long)numericCellValue;
					System.out.print(l+ " ");
				}
			default:
				break;
			}	
			}
			System.out.println();
		}
	}

}
