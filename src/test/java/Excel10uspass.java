import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel10uspass {
	public static void main(String[] args) throws IOException {
		List<String> list1 = new LinkedList<String>();

		list1.add("karthi");
		list1.add("keyan");
		list1.add("karthik");
		list1.add("kk");

		List<String> list2 = new LinkedList<String>();

		list2.add("123");
		list2.add("456");
		list2.add("789");
		list2.add("357");

		File excel = new File("C:\\Users\\VISHALI\\OneDrive\\Desktop\\karthi\\kk.xlsx");

		Workbook book = new XSSFWorkbook();
		Sheet createSheet = book.createSheet("kn");

		for (int i = 0; i < 4; i++) {

			book.getSheet("kn").createRow(i).createCell(0).setCellValue(list1.get(i));
			book.getSheet("kn").getRow(i).createCell(1).setCellValue(list2.get(i));
		}

		FileOutputStream stream = new FileOutputStream(excel);
		book.write(stream);
	}

}
