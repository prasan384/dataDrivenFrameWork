package TEST.Excel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateAndWriteExcel {

	public static void main(String[] args) throws Exception {
		HSSFWorkbook Workbook= new HSSFWorkbook();
        HSSFSheet sheet = Workbook.createSheet();
        sheet.createRow(0);
        sheet.getRow(0).getCell(0).setCellValue("hello");
        sheet.getRow(0).getCell(1).setCellValue("world");
        sheet.createRow(1);
        sheet.getRow(1).getCell(0).setCellValue("hyr");
        sheet.getRow(1).getCell(1).setCellValue("tutorials");
        File file = new File("C:\\Eclipse\\Automation\\javaforselinium\\MyMavenProject\\src\\test\\java\\TEST\\Excel\\excel\\Text.xls");
        Workbook.write(file);
        Workbook.close();


        
        
        
		

	}

}
