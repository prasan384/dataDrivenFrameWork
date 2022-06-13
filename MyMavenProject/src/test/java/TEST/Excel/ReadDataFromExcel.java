package TEST.Excel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		File Excelfile = new File("./src/test/resources/myexcel.xlsx");
		FileInputStream fis = new FileInputStream(Excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int numofrows = sheet.getPhysicalNumberOfRows();
		int numofcoloumns = sheet.getRow(0).getLastCellNum();
		for (int i = 1; i < numofrows; i++) {
			for (int j = 0; j < numofcoloumns; j++) {
				DataFormatter df = new DataFormatter();// it will convert any type of data into string
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));

			}
			System.out.println();
		}
		workbook.close();
		fis.close();

	}

}
